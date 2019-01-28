package pt.andreiaribeiro.com.andreiaribeiro.view.schedule.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.BaseActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.schedule.fragments.ScheduleListFragment;

public class ScheduleListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_services_list);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_services, new ScheduleListFragment(), ScheduleListFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_services_list;
    }

    @Override
    public int getNavigationMenuItemId() {
        return R.id.navigation_calendar;
    }

}
