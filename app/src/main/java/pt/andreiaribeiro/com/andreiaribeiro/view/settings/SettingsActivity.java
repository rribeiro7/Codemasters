package pt.andreiaribeiro.com.andreiaribeiro.view.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Toast.makeText(this, "Welcome to the settings screen.", Toast.LENGTH_SHORT).show();
    }
}
