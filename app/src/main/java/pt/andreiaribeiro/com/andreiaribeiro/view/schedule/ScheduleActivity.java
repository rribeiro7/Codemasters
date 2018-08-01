package pt.andreiaribeiro.com.andreiaribeiro.view.schedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import pt.andreiaribeiro.com.andreiaribeiro.R;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Toast.makeText(this, "Welcome to the schedule screen.", Toast.LENGTH_SHORT).show();
    }
}
