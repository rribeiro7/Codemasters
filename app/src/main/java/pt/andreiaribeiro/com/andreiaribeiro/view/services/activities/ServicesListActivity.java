package pt.andreiaribeiro.com.andreiaribeiro.view.services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.payments.PaymentsActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.fragments.ServicesListFragment;

public class ServicesListActivity extends AppCompatActivity{ //implements View.OnClickListener {

String generic="";
String name="";
int iActivity, iService, iDistrict, iCouncil =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_list);

        Bundle extras = getIntent().getExtras();
        /*if (savedInstanceState == null) {

            if(extras != null) {
                generic = "";
                name="";
                iActivity=0;
                iService=0;
                iDistrict=0;
                iCouncil=0;
            } else {
                generic= extras.getString(Constants.FILTER_GENERIC, "");
                name=extras.getString(Constants.FILTER_NAME, "");
                iActivity=extras.getInt(Constants.FILTER_GENERIC,0);
                iService=0;
                iDistrict=0;
                iCouncil=0;
            }
        }*/

        ServicesListFragment frag = new ServicesListFragment();
        frag.setArguments(extras);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_services, frag, ServicesListFragment.class.getSimpleName())
                .commit();

    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(this, PaymentsActivity.class);
//        startActivity(intent);
//    }


}
