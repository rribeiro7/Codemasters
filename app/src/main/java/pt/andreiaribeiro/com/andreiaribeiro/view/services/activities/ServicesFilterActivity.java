package pt.andreiaribeiro.com.andreiaribeiro.view.services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;

public class ServicesFilterActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_filter);

        Toast.makeText(this, "Welcome to the services filter screen.", Toast.LENGTH_SHORT).show();

        btnServices = (Button) findViewById(R.id.button_services);
        btnServices.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ServicesListActivity.class);
        startActivity(intent);
    }
}
