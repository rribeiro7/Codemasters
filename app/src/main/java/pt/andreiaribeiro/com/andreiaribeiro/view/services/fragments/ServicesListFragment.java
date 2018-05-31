package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Fade;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ProfessionalModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.Service;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesFilterActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesListActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesListFragment extends Fragment implements RecyclerViewOnItemClickListener.OnItemClickListener, Callback<BaseListResponse<SearchProfessionals>> {

    RecyclerView rv;
    List<Service> servicesList;

    public ServicesListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_list, container, false);

        ServicesListActivity sla = new ServicesListActivity();

        servicesList = new ArrayList<>();
        servicesList = getValidServices();

        rv = (RecyclerView) view.findViewById(R.id.rv_services);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setAdapter(new ServicesAdapter(getActivity(), servicesList));
        rv.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getActivity(), this));

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), servicesList.get(position).getDescription() + "", Toast.LENGTH_SHORT).show();
        //LiberiixApplication.getApiRepositoryInstance(getActivity()).listProfessional("", 0,0,"",0,0,0, this);

//para ficar para sempre comentado
//        ServicesDetailFragment details = new ServicesDetailFragment();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            details.setSharedElementEnterTransition(new ServicesDetailFragment());
//            details.setEnterTransition(new Fade());
//            setExitTransition(new Fade());
//            details.setSharedElementReturnTransition(nmew ServicesDetailFragment());
//        }


        ImageView serviceImage = (ImageView) view.findViewById(R.id.iv_service_photo) ;
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                //.addSharedElement(serviceImage, "service_image")
                .replace(R.id.container_services, new ServicesDetailFragment(), ServicesDetailFragment.class.getSimpleName())
                .addToBackStack(ServicesDetailFragment.class.getSimpleName())
                .commit();

    }

    private List<Service> getValidServices() {
        List<Service> servicesList = new ArrayList<>();

        servicesList.add(new Service("Canalização", "Joao Maria", "10-10-2017",
                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
        servicesList.add(new Service("Instalação Software", "Paulo Maria", "20-10-2017",
                "http://netsolutionsny.com/sites/default/files/IT-Guy_5.png"));
        servicesList.add(new Service("Advogado", "Nuno Maria", "10-11-2017",
                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));
        servicesList.add(new Service("Assistente Pessoal", "Hugo Maria", "01-10-2017",
                "http://imagens1.ne10.uol.com.br/blogsjconline/havagas/2016/07/pa21-700x360.jpg"));
        servicesList.add(new Service("Personal Trainer", "Diogo Maria", "07-11-2017",
                "http://aquadrenalina.com/wp-content/uploads/2016/12/PT2-1024x645.jpg"));
        servicesList.add(new Service("Motorista", "Tomás Maria", "30-10-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Canalização", "Carlos Maria", "30-10-2017",
                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
        servicesList.add(new Service("Motorista", "Bernardo Maria", "25-11-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Motorista", "José Maria", "17-11-2017",
                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
        servicesList.add(new Service("Advogado", "Manel Maria", "19-10-2017",
                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));

        return servicesList;
    }


    @Override
    public void onResponse(@NonNull Call<BaseListResponse<SearchProfessionals>> call, @NonNull Response<BaseListResponse<SearchProfessionals>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseListResponse<SearchProfessionals>> call, Throwable t) {
        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
    }

}
