package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesListFragment extends Fragment implements RecyclerViewOnItemClickListener.OnItemClickListener, Callback<BaseListResponse<SearchProfessionals>>
{
    RecyclerView rv;
    List<SearchProfessionals> servicesList;
    LinearLayout linlaHeaderProgress;
    ServicesAdapter servicesAdapter;

    public ServicesListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_list, container, false);
        linlaHeaderProgress = (LinearLayout) view.findViewById(R.id.linlaHeaderProgress);
        linlaHeaderProgress.setVisibility(View.VISIBLE);
        LiberiixApplication.getApiRepositoryInstance(this.getActivity()).listProfessional("", 0,0,"",0,0,0, this);
/*        LiberiixApplication.getApiRepositoryInstance(getActivity()).listProfessional("", 0,
                0,"",0,0,0,
                new RetrofitCallbacks<BaseListResponse<SearchProfessionals>>() {
                    @Override
                    public void onResponse(Call<BaseListResponse<SearchProfessionals>> call, Response<BaseListResponse<SearchProfessionals>> response) {
                        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                                && response.body().getBodyResponse().getObj() != null) {
                            Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
                            servicesList = response.body().getBodyResponse().getObj();
                            servicesAdapter.notifyDataSetChanged();

                        } else {
                            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseListResponse<SearchProfessionals>> call, Throwable t) {
                        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
                    }
                });
*/

        rv = (RecyclerView) view.findViewById(R.id.rv_services);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        servicesAdapter = new ServicesAdapter(this.getContext(), servicesList);
        rv.setAdapter(servicesAdapter);
        rv.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getActivity(), this));

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
//para ficar para sempre comentado
//        ServicesDetailFragment details = new ServicesDetailFragment();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            details.setSharedElementEnterTransition(new ServicesDetailFragment());
//            details.setEnterTransition(new Fade());
//            setExitTransition(new Fade());
//            details.setSharedElementReturnTransition(nmew ServicesDetailFragment());
//        }
        servicesList.get(position).getId();

        ImageView serviceImage = (ImageView) view.findViewById(R.id.iv_service_photo) ;
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                //.addSharedElement(serviceImage, "service_image")
                .replace(R.id.container_services, new ServicesDetailFragment(), ServicesDetailFragment.class.getSimpleName())
                .addToBackStack(ServicesDetailFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onResponse(@NonNull Call<BaseListResponse<SearchProfessionals>> call, @NonNull Response<BaseListResponse<SearchProfessionals>> response) {
        linlaHeaderProgress.setVisibility(View.GONE);
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
            servicesList = response.body().getBodyResponse().getObj();
            rv.setAdapter(new ServicesAdapter(getActivity(), servicesList));

            servicesAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseListResponse<SearchProfessionals>> call, Throwable t) {
        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
        linlaHeaderProgress.setVisibility(View.VISIBLE);
    }


//    private List<Service> getValidServices() {
//        List<Service> servicesList = new ArrayList<>();
//
//        servicesList.add(new Service("Canalização", "Joao Maria", "10-10-2017",
//                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
//        servicesList.add(new Service("Instalação Software", "Paulo Maria", "20-10-2017",
//                "http://netsolutionsny.com/sites/default/files/IT-Guy_5.png"));
//        servicesList.add(new Service("Advogado", "Nuno Maria", "10-11-2017",
//                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));
//        servicesList.add(new Service("Assistente Pessoal", "Hugo Maria", "01-10-2017",
//                "http://imagens1.ne10.uol.com.br/blogsjconline/havagas/2016/07/pa21-700x360.jpg"));
//        servicesList.add(new Service("Personal Trainer", "Diogo Maria", "07-11-2017",
//                "http://aquadrenalina.com/wp-content/uploads/2016/12/PT2-1024x645.jpg"));
//        servicesList.add(new Service("Motorista", "Tomás Maria", "30-10-2017",
//                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
//        servicesList.add(new Service("Canalização", "Carlos Maria", "30-10-2017",
//                "http://casavivaobras.pt/foto-especialidade/canalizacao/trabalhos-de-canalizacao-022.jpg"));
//        servicesList.add(new Service("Motorista", "Bernardo Maria", "25-11-2017",
//                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
//        servicesList.add(new Service("Motorista", "José Maria", "17-11-2017",
//                "https://1.bp.blogspot.com/-LkzPHdzGvI4/V3wRq9TyDiI/AAAAAAAADTw/-8hDbaw_UOAoL4dVdb3Q7Chimee0Uyk2gCLcB/s1600/motorista-uber.jpg"));
//        servicesList.add(new Service("Advogado", "Manel Maria", "19-10-2017",
//                "https://media.licdn.com/mpr/mpr/AAEAAQAAAAAAAA1HAAAAJDQzYmQ4YzY2LWI0MzctNDIxYS05Y2ZiLWNkY2JiZGZjNTgzNg.jpg"));
//
//        return servicesList;
//    }

}
