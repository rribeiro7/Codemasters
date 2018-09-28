package pt.andreiaribeiro.com.andreiaribeiro.view.services.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SearchProfessionals;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ServicesModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.utils.StringUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.Service;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {

    private Context context;
    private List<SearchProfessionals> servicesList;
    String strActServices="";

    public ServicesAdapter(Context context, List<SearchProfessionals> serviceList) {
        this.context = context;
        this.servicesList = serviceList;
    }

    @Override
    public ServicesAdapter.ServicesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_services_list, parent, false);
        ServicesViewHolder pvh = new ServicesViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ServicesAdapter.ServicesViewHolder holder, int position) {
        holder.description.setText(servicesList.get(position).getDescription());
        holder.professional.setText(servicesList.get(position).getName());
        strActServices="";
        for (ServicesModel sModel : servicesList.get(position).getServices()){
            strActServices+=sModel.getServiceName() + StringUtils.COMMA;
        }
        holder.date.setText(strActServices.substring(0, strActServices.length()-1));
        Picasso.with(context).load(Constants.BASE_PHOTO + servicesList.get(position).getMainPhoto()).into(holder.photo);
    }

    @Override
    public int getItemCount() {
        int size =0;
        if (servicesList!=null)
        {
            size=servicesList.size();
        }
        return size;
    }

    static class ServicesViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        TextView professional;
        TextView date;
        ImageView photo;

        ServicesViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.tv_service_description);
            professional = (TextView) itemView.findViewById(R.id.tv_service_professional);
            date = (TextView) itemView.findViewById(R.id.service_date);
            photo = (ImageView) itemView.findViewById(R.id.iv_service_photo);
        }
    }

}