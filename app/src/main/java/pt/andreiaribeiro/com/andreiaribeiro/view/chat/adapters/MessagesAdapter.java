package pt.andreiaribeiro.com.andreiaribeiro.view.chat.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.Service;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters.ServicesAdapter;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder> {

    private Context context;
    private List<MessagesModel> messagesList;

    public MessagesAdapter(Context context, List<MessagesModel> messagesList) {
        this.context = context;
        this.messagesList = messagesList;
    }

    @Override
    public MessagesAdapter.MessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_messages_list, parent, false);
        MessagesAdapter.MessagesViewHolder pvh = new MessagesAdapter.MessagesViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(MessagesAdapter.MessagesViewHolder holder, int position) {
        holder.description.setText(messagesList.get(position).getName());
        /*holder.professional.setText(messagesList.get(position).getProfessional());
        holder.date.setText(messagesList.get(position).getDate());
        Picasso.with(context).load(messagesList.get(position).getImage()).into(holder.photo);
        */
    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    static class MessagesViewHolder extends RecyclerView.ViewHolder {

        TextView description;

        MessagesViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.msgitem_name);

        }
    }

}