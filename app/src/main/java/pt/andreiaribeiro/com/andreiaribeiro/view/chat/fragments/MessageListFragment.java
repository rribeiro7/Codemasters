package pt.andreiaribeiro.com.andreiaribeiro.view.chat.fragments;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseListResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.utils.PreferencesUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.ChatActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.adapters.MessagesAdapter;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.Service;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesFilterActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesListActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments.ServicesDetailFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageListFragment extends Fragment implements RecyclerViewOnItemClickListener.OnItemClickListener, Callback<BaseListResponse<MessagesModel>> {

    RecyclerView rv;
    List<MessagesModel> messagesList;

    public MessageListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_messages_list, container, false);
        String cookie = PreferencesUtils.getPreferencesString(this.getContext(), "cookie");
        LiberiixApplication.getApiRepositoryInstance(getActivity()).getAllMessages(cookie,  this);

        messagesList = new ArrayList<>();

        rv = (RecyclerView) view.findViewById(R.id.rv_messages);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setAdapter(new MessagesAdapter(getActivity(), messagesList));
        rv.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getActivity(), this));

        return view;
    }

    @Override
    public void onItemClick(View view, int position) {
        messagesList.get(position).getId();
        Toast.makeText(getActivity(), "Pressing: " + messagesList.get(position).getId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        startActivity(intent);
    }

    /*private List<MessageObj> getValidMessages() {
        List<MessageObj> servicesList = new ArrayList<>();

        servicesList.add(new MessageObj(1, "Maria Albertina", null));
        servicesList.add(new MessageObj(2, "Rui Ribeiro", null));
        servicesList.add(new MessageObj(3, "Teste", null));
        return servicesList;
    }*/


    @Override
    public void onResponse(@NonNull Call<BaseListResponse<MessagesModel>> call, @NonNull Response<BaseListResponse<MessagesModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            messagesList = response.body().getBodyResponse().getObj();
            rv.setAdapter(new MessagesAdapter(this.getContext(), messagesList));
        } else {
            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseListResponse<MessagesModel>> call, Throwable t) {
        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
    }

}
