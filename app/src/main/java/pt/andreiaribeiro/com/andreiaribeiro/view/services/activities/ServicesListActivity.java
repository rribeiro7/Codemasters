package pt.andreiaribeiro.com.andreiaribeiro.view.services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments.ServicesListFragment;

public class ServicesListActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        Toast.makeText(this, "Welcome to the services screen.", Toast.LENGTH_SHORT).show();

        btnPayments = (Button) findViewById(R.id.button_payments);
        btnPayments.setOnClickListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_services_list, new ServicesListFragment(), ServicesListFragment.class.getSimpleName())
                .commit();

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PaymentsActivity.class);
        startActivity(intent);
    }


}
