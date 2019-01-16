package pt.andreiaribeiro.com.andreiaribeiro.view.schedule.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ScheduleActionsModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SchedulerEventModel;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    private Context context;
    private List<ScheduleActionsModel> scheduleActionList;

    public ScheduleAdapter(Context context, List<ScheduleActionsModel> scheduleActionList) {
        this.context = context;
        this.scheduleActionList = scheduleActionList;
    }

    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule_list, parent, false);
        ScheduleAdapter.ScheduleViewHolder pvh = new ScheduleAdapter.ScheduleViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ScheduleViewHolder holder, int position) {
        holder.description.setText(scheduleActionList.get(position).getUserName());
        holder.data.setText(scheduleActionList.get(position).getDate());
        holder.status.setText(scheduleActionList.get(position).getStateName());
        /*holder.professional.setText(messagesList.get(position).getProfessional());
        holder.date.setText(messagesList.get(position).getDate());
        Picasso.with(context).load(messagesList.get(position).getImage()).into(holder.photo);
        */
    }

    @Override
    public int getItemCount() {
        return scheduleActionList.size();
    }

    static class ScheduleViewHolder extends RecyclerView.ViewHolder {

        TextView description;
        TextView data;
        TextView status;

        ScheduleViewHolder(View itemView) {
            super(itemView);

            description = (TextView) itemView.findViewById(R.id.schitem_name);
            data = (TextView) itemView.findViewById(R.id.schitem_date);
            status = (TextView) itemView.findViewById(R.id.schitem_status);
        }
    }

}