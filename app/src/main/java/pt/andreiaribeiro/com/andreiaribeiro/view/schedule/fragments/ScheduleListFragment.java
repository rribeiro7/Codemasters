package pt.andreiaribeiro.com.andreiaribeiro.view.schedule.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.ScheduleActionsModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SchedulerEventModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.SchedulerInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.PreferencesUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.RecyclerViewOnItemClickListener;
import pt.andreiaribeiro.com.andreiaribeiro.view.schedule.adapters.ScheduleAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleListFragment  extends Fragment implements RecyclerViewOnItemClickListener.OnItemClickListener, Callback<BaseResponse<SchedulerInfoModel>> {

    RecyclerView rv;
    List<ScheduleActionsModel> scheduleActionList;

    public ScheduleListFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedule_list, container, false);
        String cookie = PreferencesUtils.getPreferencesString(this.getContext(), "cookie");
        LiberiixApplication.getApiRepositoryInstance(getActivity()).getAllSchedules(cookie,  this);

        scheduleActionList = new ArrayList<>();

        rv = (RecyclerView) view.findViewById(R.id.rv_schedules);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setAdapter(new ScheduleAdapter(getActivity(), scheduleActionList));
        rv.addOnItemTouchListener(new RecyclerViewOnItemClickListener(getActivity(), this));

        calendarComponent(view);
        return view;
    }

    private void calendarComponent(View v) {

        final CalendarView calendarView=(CalendarView) v.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                List<ScheduleActionsModel> lstSchedulesDay = new ArrayList<>();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

                for (int i =0 ; i < scheduleActionList.size(); i++ ){
                    try {
                        Date dtCalendar = sdf.parse(dayOfMonth + "-"+(month+1)+"-"+year);
                        Date dtAux = sdf.parse(scheduleActionList.get(i).getDate());
                        if (dtCalendar.equals(dtAux)) {
                            lstSchedulesDay.add(scheduleActionList.get(i));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                rv.setAdapter(new ScheduleAdapter(getActivity(), lstSchedulesDay));
            }
        });

        calendarView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
            @Override
            public void onGlobalLayout()
            {
                //your code here
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        //messagesList.get(position).getId();
        /*Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        intent.putExtra("iduser", schedulerInfoList.get(position).getId());
        startActivity(intent);*/
    }

    @Override
    public void onResponse(@NonNull Call<BaseResponse<SchedulerInfoModel>> call, @NonNull Response<BaseResponse<SchedulerInfoModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            scheduleActionList = response.body().getBodyResponse().getObj().getActions();

        } else {
            Toast.makeText(getActivity(), "DEU CERTO MAS SEM RESPOSTA", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseResponse<SchedulerInfoModel>> call, Throwable t) {
        Toast.makeText(getActivity(), "ERRO NO DOWNLOAD", Toast.LENGTH_SHORT).show();
    }


}

