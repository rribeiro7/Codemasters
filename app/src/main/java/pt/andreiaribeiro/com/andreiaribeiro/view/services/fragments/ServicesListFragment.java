package pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.Service;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;

public class ServicesListFragment extends Fragment {


    RecyclerView rv;

    public ServicesListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_list, container, false);


        rv = (RecyclerView) view.findViewById(R.id.rv_services);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        rv.setAdapter(new ServicesAdapter(getActivity(), getValidServices()));
        return view;
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
}
