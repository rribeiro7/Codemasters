package pt.andreiaribeiro.com.andreiaribeiro.view.schedule;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.MessagesModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.PreferencesUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.register.RegisterActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesFilterActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScheduleActivity extends AppCompatActivity implements View.OnClickListener, Callback<BaseResponse<MessagesModel>> {
    private SimpleDateFormat mSimpleDateFormat;
    private Calendar mCalendar;
    private Activity mActivity;
    private TextView tvDate, tvUser, tvService;
    private Button btnSave;
    private EditText etPrice, etDuration,etLocation, etObservations;

    private static final String LANGUARGE = "en";

    private void mockData(){
        tvUser.setText("6");
        tvService.setText("2087");
        //etPrice.setText("20.0");
        //etDuration.setText("1");
        //etLocation.setText("Rua da avenida, na Cidade");
        //etObservations.setText("verificar se o servico ficou bem gravado na base de dados");
        //tvDate.setText("24-08-2018 12:00");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        Intent intent = getIntent();
        String idUser = intent.getExtras().getString("id");

        mActivity = this;
        mSimpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());

        defineLayout();
        tvUser.setText(idUser);
    }

    private void defineLayout(){
        btnSave = (Button) findViewById(R.id.sch_btnSave);
        btnSave.setOnClickListener(this);
        tvDate = (TextView) findViewById(R.id.sch_dateTime);
        tvDate.setOnClickListener(this);

        tvUser = (TextView) findViewById(R.id.sch_txtUser);
        tvService = (TextView) findViewById(R.id.sch_txtService);
        etPrice = (EditText) findViewById(R.id.sch_txtPrice);
        etDuration = (EditText) findViewById(R.id.sch_txtDuration);
        etLocation = (EditText) findViewById(R.id.sch_txtLocation);
        etObservations = (EditText) findViewById(R.id.sch_txtObservations);
    }

    /* After user decided on a date, store those in our calendar variable and then start the TimePickerDialog immediately */
    private final DatePickerDialog.OnDateSetListener mDateDataSet = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            new TimePickerDialog(mActivity, mTimeDataSet, mCalendar.get(Calendar.HOUR_OF_DAY), mCalendar.get(Calendar.MINUTE), true).show();
        }
    };

    /* After user decided on a time, save them into our calendar instance, and now parse what our calendar has into the TextView */
    private final TimePickerDialog.OnTimeSetListener mTimeDataSet = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
            mCalendar.set(Calendar.MINUTE, minute);
            tvDate.setText(mSimpleDateFormat.format(mCalendar.getTime()));
        }
    };

    @Override
    public void onResponse(@NonNull Call<BaseResponse<MessagesModel>> call, @NonNull Response<BaseResponse<MessagesModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().isOk()) {
            Toast.makeText(this, "Schedule sucess.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "There was an error with the Login. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseResponse<MessagesModel>> call, Throwable t) {
        Toast.makeText(this, "There was an error with the Schedule. Please try again.", Toast.LENGTH_SHORT).show();
    }

    private void saveInfo(){

        String cookie = PreferencesUtils.getPreferencesString(mActivity, "cookie");
        LiberiixApplication.getApiRepositoryInstance(mActivity).addScheduleEvent(cookie,Integer.parseInt(tvUser.getText().toString()),Integer.parseInt(tvService.getText().toString()),Double.parseDouble(etPrice.getText().toString()),tvDate.getText().toString(),Integer.parseInt(etDuration.getText().toString()),etLocation.getText().toString(),etObservations.getText().toString(), LANGUARGE, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sch_dateTime:
                mCalendar = Calendar.getInstance();
                new DatePickerDialog(mActivity, mDateDataSet, mCalendar.get(Calendar.YEAR),
                        mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show();
                break;
            case R.id.sch_btnSave:
                mockData();
                if (validateInfo()) {
                    saveInfo();
                }
            default:
                break;
        }
    }

    private boolean validateInfo(){
        try {
            int aux = Integer.parseInt(etDuration.getText().toString());
            double auxD = Double.parseDouble(etPrice.getText().toString());
        }
        catch (Exception ex){
            return false;
        }
        return true;
    }

}
