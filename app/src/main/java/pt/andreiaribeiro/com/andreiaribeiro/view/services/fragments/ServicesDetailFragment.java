package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseProfissional;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.ChatActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ServicesDetailFragment extends Fragment implements Callback<BaseProfissional> {

    private TextView txtTitle, txtActivity, txtDateBirth, txtDescription, txtEmail, txtExperience, txtFormation, txtLocation, txtService;
    private Button btnSchedule, btnMessage;
    ImageView serviceDetailPhoto;

    public ServicesDetailFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_detail, container, false);

        setLayout(view);
        LiberiixApplication.getApiRepositoryInstance(getActivity()).detailProfessional(1, this);

        btnSchedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), PaymentsActivity.class);
                startActivity(intent);
            }
        } );

        btnMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), ChatActivity.class);
                startActivity(intent);
            }
        } );
        return view;
    }

    private void setLayout(View view){
        serviceDetailPhoto = (ImageView) view.findViewById(R.id.iv_service_image_detail);
        txtTitle = (TextView)view.findViewById(R.id.details_txtTitle);
        txtActivity = (TextView)view.findViewById(R.id.details_txtActivity);
        txtDateBirth = (TextView)view.findViewById(R.id.details_txtDateBirth);
        txtDescription = (TextView)view.findViewById(R.id.details_txtDescription);
        txtEmail = (TextView)view.findViewById(R.id.details_txtEmail);
        txtExperience = (TextView)view.findViewById(R.id.details_txtExperience);
        txtFormation = (TextView)view.findViewById(R.id.details_txtFormation);
        txtLocation = (TextView)view.findViewById(R.id.details_txtLocation);
        txtService = (TextView)view.findViewById(R.id.details_txtService);
        btnSchedule = (Button)view.findViewById(R.id.details_btnSchedule);
        btnMessage = (Button)view.findViewById(R.id.details_btnMessage);
    }

    private void loadData(ProfessionalModel prof){
        Picasso.with(getActivity()).load(Constants.BASE_PHOTO + prof.getMainPhoto()).into(serviceDetailPhoto);

        txtTitle.setText(prof.getName());
        txtDateBirth.setText(prof.getBirthdate());
        txtDescription.setText(prof.getDescription());
        txtFormation.setText(prof.getFormation());
        //txtActivity.setText(prof.getDistinctActivity().get(0));
        txtService.setText("");
    }

    @Override
    public void onResponse(Call<BaseProfissional> call, Response<BaseProfissional> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getProfessionalModel() != null) {
            Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
            loadData(response.body().getProfessionalModel());
        } else {
            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<BaseProfissional> call, Throwable t) {
        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
    }
}
