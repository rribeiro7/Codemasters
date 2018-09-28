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
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesListFragment extends Fragment implements RecyclerViewOnItemClickListener.OnItemClickListener, Callback<BaseListResponse<SearchProfessionals>>
{
    RecyclerView rv;
    List<SearchProfessionals> servicesList;
    RelativeLayout linlaHeaderProgress;
    ServicesAdapter servicesAdapter;

    public ServicesListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services_list, container, false);
        linlaHeaderProgress = (RelativeLayout) view.findViewById(R.id.linlaHeaderProgress);
        linlaHeaderProgress.setVisibility(View.VISIBLE);
        Bundle bundle = getArguments();
        String strGeneric = bundle.getString(Constants.FILTER_GENERIC);
        String strName = bundle.getString(Constants.FILTER_NAME);
        int iActivity = bundle.getInt(Constants.FILTER_ACTIVITY, 0);
        int iService = bundle.getInt(Constants.FILTER_SERVICE, 0);
        int iGeoTwo = bundle.getInt(Constants.FILTER_DISTRICT, 0);
        int iGeoThree = bundle.getInt(Constants.FILTER_COUNCIL, 0);
        LiberiixApplication.getApiRepositoryInstance(this.getActivity()).listProfessional(strGeneric, iActivity,iService,strName,0,iGeoTwo,iGeoThree, this);

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

        ServicesDetailFragment frag = new ServicesDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("iduser", servicesList.get(position).getId());
        frag.setArguments(bundle);

        ImageView serviceImage = (ImageView) view.findViewById(R.id.iv_service_photo) ;
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                //.addSharedElement(serviceImage, "service_image")
                .replace(R.id.container_services, frag, ServicesDetailFragment.class.getSimpleName())
                .addToBackStack(ServicesDetailFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onResponse(@NonNull Call<BaseListResponse<SearchProfessionals>> call, @NonNull Response<BaseListResponse<SearchProfessionals>> response) {
        linlaHeaderProgress.setVisibility(View.GONE);
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            //Toast.makeText(getActivity(), "DEU CERTO CARA", Toast.LENGTH_SHORT).show();
            servicesList = response.body().getBodyResponse().getObj();
            rv.setAdapter(new ServicesAdapter(getActivity(), servicesList));

            servicesAdapter.notifyDataSetChanged();

        } else {
            Toast.makeText(getActivity(), "Não foram encontrados resultados.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseListResponse<SearchProfessionals>> call, Throwable t) {
        Toast.makeText(getActivity(), "Não foi possivel retornar resultados.", Toast.LENGTH_SHORT).show();
        linlaHeaderProgress.setVisibility(View.VISIBLE);
    }
}
