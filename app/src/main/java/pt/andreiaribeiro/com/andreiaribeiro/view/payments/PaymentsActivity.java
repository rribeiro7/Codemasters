package pt.andreiaribeiro.com.andreiaribeiro.view.payments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.settings.SettingsActivity;

public class PaymentsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);

        Toast.makeText(this, "Welcome to the payments screen.", Toast.LENGTH_SHORT).show();

        btnSettings = (Button) findViewById(R.id.button_settings);
        btnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
