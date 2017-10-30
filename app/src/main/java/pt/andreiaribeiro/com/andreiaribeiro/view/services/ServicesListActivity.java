package pt.andreiaribeiro.com.andreiaribeiro.view.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;

public class ServicesListActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        btnPayments = (Button) findViewById(R.id.button_payments);
        btnPayments.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, PaymentsActivity.class);
        startActivity(intent);
    }
}
