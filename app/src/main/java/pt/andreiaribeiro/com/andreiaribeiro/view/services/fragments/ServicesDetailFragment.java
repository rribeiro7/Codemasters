package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseProfissional;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.GeoModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ServicesModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.utils.StringUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.ChatActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ViewPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesDetailFragment extends Fragment implements Callback<BaseProfissional> {

    private TextView txtTitle, txtActivity, txtGeos, txtDescription, txtExperience, txtFormation, txtAvPrice, txtService, txtYoutube;
    private Button btnMessage;
    //ImageView serviceDetailPhoto;
    ViewPager viewPager;
    int idUser=0;

    public ServicesDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_detail, container, false);
        setLayout(view);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idUser = bundle.getInt("iduser", 0);
        }

        LiberiixApplication.getApiRepositoryInstance(getActivity()).detailProfessional(idUser, this);

        btnMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), ChatActivity.class);
                intent.putExtra("iduser", idUser);
                startActivity(intent);
            }
        } );
        return view;
    }

    private void setLayout(View view){
        //serviceDetailPhoto = (ImageView) view.findViewById(R.id.iv_service_image_detail);
        viewPager = view.findViewById(R.id.details_gallery);
        txtTitle = (TextView)view.findViewById(R.id.details_txtTitle);
        txtActivity = (TextView)view.findViewById(R.id.details_txtActivity);
        txtGeos = (TextView)view.findViewById(R.id.details_txtGeos);
        txtDescription = (TextView)view.findViewById(R.id.details_txtDescription);
        //txtEmail = (TextView)view.findViewById(R.id.details_txtEmail);
        txtExperience = (TextView)view.findViewById(R.id.details_txtExperience);
        txtFormation = (TextView)view.findViewById(R.id.details_txtFormation);
        txtAvPrice = (TextView)view.findViewById(R.id.details_txtAvPrice);
        txtService = (TextView)view.findViewById(R.id.details_txtService);
        txtYoutube = (TextView) view.findViewById(R.id.details_txtYoutube);
        txtYoutube.setMovementMethod(LinkMovementMethod.getInstance());
        btnMessage = (Button)view.findViewById(R.id.details_btnMessage);
    }

    private void loadData(ProfessionalModel prof){
        //Picasso.with(getActivity()).load(Constants.BASE_PHOTO + prof.getMainPhoto()).into(serviceDetailPhoto);
        int iGallSize=1;
        if (prof.getOtherPhotos()!=null) {
            iGallSize +=  prof.getOtherPhotos().size();
        }
        String[] arrGallery = new String[iGallSize];
        arrGallery[0] = Constants.BASE_PHOTO + prof.getMainPhoto();

        if (prof.getOtherPhotos()!=null) {
            for (int i = 1; i < iGallSize; i++) {
                arrGallery[i] = Constants.BASE_PHOTO + prof.getOtherPhotos().get(i-1);
            }
        }
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(getContext(), arrGallery);
        viewPager.setAdapter(vpAdapter);

        txtTitle.setText(prof.getName());
        txtDescription.setText(prof.getDescription());
        txtFormation.setText(prof.getFormation());
        //txtActivity.setText(prof.getDistinctActivity().get(0));
        txtService.setText(getService(prof.getServices()));
        txtGeos.setText(getGeos(prof.getGeos()));
        txtAvPrice.setText(prof.getAvgPrice());
        txtExperience.setText(prof.getExperience());
        txtYoutube.setText(prof.getVideo());
    }

    private String getGeos(List<GeoModel> geos) {
        String strLocation = "";
        for (GeoModel geo: geos){
            if (geo != null&&geo.getGeo2()!= null){
                strLocation += geo.getGeo2().getValue() + StringUtils.COMMA;
            }
            if (geo != null&&geo.getGeo3()!= null){
                strLocation += geo.getGeo3().getValue() + StringUtils.DOT ;
            }
        }
        return strLocation ;
    }

    private String getService(List<ServicesModel> services) {
        String strServiceName="";
        for (ServicesModel sModel : services){
            strServiceName+=sModel.getServiceName() + StringUtils.COMMA;
        }

        return strServiceName.substring(0, strServiceName.length()-1);
    }

    @Override
    public void onResponse(Call<BaseProfissional> call, Response<BaseProfissional> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getProfessionalModel() != null) {
            //Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
            loadData(response.body().getProfessionalModel());
        } else {
            Toast.makeText(getActivity(), "Não existem resultados.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<BaseProfissional> call, Throwable t) {
        Toast.makeText(getActivity(), "Não foi possivel efectuar o pedido.", Toast.LENGTH_SHORT).show();
    }
}
