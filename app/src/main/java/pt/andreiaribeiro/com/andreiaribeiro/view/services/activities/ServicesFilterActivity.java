package pt.andreiaribeiro.com.andreiaribeiro.view.services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;
import java.util.logging.Logger;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.mocks.ObjSpinner;
import pt.andreiaribeiro.com.andreiaribeiro.mocks.FiltersMock;

/**
 * TODO:
 * 1- Enable or disabled dos spinners por causa da dependencia
 * 2- Garantir que limpam os spinners caso se mude o item do spinner de hierarquia superior
 */



public class ServicesFilterActivity extends AppCompatActivity {

    Button btnServices, btnClean;
    Spinner sActivity;
    Spinner sServices;
    Spinner sCountry;
    Spinner sDistrict;
    Spinner sCouncil;
    private AutoCompleteTextView txtGeneric;
    private EditText txtName, txtEmail;

    ObjSpinner objSActivity;
    ObjSpinner objSServices;
    ObjSpinner objSCountry;
    ObjSpinner objSDistrict;
    ObjSpinner objSCouncil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_filter);
        setLayout();
        loadSpinnerActivity();

        loadSpinnerCountry();
//        Toast.makeText(this, "Welcome to the services filter screen.", Toast.LENGTH_SHORT).show();

        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFilters();
                Intent intent = new Intent(ServicesFilterActivity.this, ServicesListActivity.class);
                startActivity(intent);
            }
        });
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGeneric.setText("");
                txtName.setText("");
                txtEmail.setText("");
                sActivity.setSelection(0);
                sServices.setSelection(0);
                sCountry.setSelection(0);
                sDistrict.setSelection(0);
                sCouncil.setSelection(0);
            }
        });
    }

    private void setLayout() {
        txtGeneric = (AutoCompleteTextView) findViewById(R.id.filter_genericsearch);
        txtName = (EditText) findViewById(R.id.filter_name);
        txtEmail = (EditText) findViewById(R.id.filter_email);
        btnServices = (Button) findViewById(R.id.filter_btnSearch);
        btnClean = (Button) findViewById(R.id.filter_btnClean);
        sActivity = (Spinner) findViewById(R.id.filter_activity);
        sServices = (Spinner) findViewById(R.id.filter_service);
        sCountry = (Spinner) findViewById(R.id.filter_country);
        sDistrict = (Spinner) findViewById(R.id.filter_district);
        sCouncil = (Spinner) findViewById(R.id.filter_council);
    }

    private void loadSpinnerActivity(){
        ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                this, android.R.layout.simple_spinner_item, FiltersMock.fillActivities());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sActivity.setAdapter(adapter);

        sActivity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                if(sActivity.getSelectedItem() != null)
                {
                    objSActivity = (ObjSpinner) sActivity.getSelectedItem();
                    loadSpinnerServices(FiltersMock.fillServices(objSActivity.getId()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadSpinnerServices(List<String> lstServices){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, lstServices);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sServices.setAdapter(adapter);
    }

    private void loadSpinnerCountry(){
        ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                this, android.R.layout.simple_spinner_item, FiltersMock.fillCountry());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCountry.setAdapter(adapter);

        sCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                if(sCountry.getSelectedItem() != null)
                {
                    objSCountry = (ObjSpinner) sCountry.getSelectedItem();
                    loadSpinnerDistrict(FiltersMock.fillDistrict(objSCountry.getId()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadSpinnerDistrict(List<ObjSpinner> objSpinners) {
        ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                this, android.R.layout.simple_spinner_item, objSpinners);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sDistrict.setAdapter(adapter);

        sDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                if(sDistrict.getSelectedItem() != null)
                {
                    objSDistrict = (ObjSpinner) sDistrict.getSelectedItem();
                    loadSpinnerCouncil(FiltersMock.fillCouncil(objSDistrict.getId()));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadSpinnerCouncil(List<ObjSpinner> objSpinners) {
        ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                this, android.R.layout.simple_spinner_item, objSpinners);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sCouncil.setAdapter(adapter);

        sCouncil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                if(sCouncil.getSelectedItem() != null)
                {
                    objSCouncil = (ObjSpinner) sCouncil.getSelectedItem();
                    objSCouncil.getId();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void saveFilters(){
        if ( txtGeneric.getText()!=null){
        Log.i("RUI", "Generic: "+ txtGeneric.getText().toString());
        }
        if (sActivity.getSelectedItem() !=null){
        Log.i("RUI", "Activity: "+ sActivity.getSelectedItem().toString());
        }
        if ( sServices.getSelectedItem()!=null){
        Log.i("RUI", "ServicesModel: "+ sServices.getSelectedItem().toString());
        }
        if (txtName.getText() !=null){
        Log.i("RUI", "Nome: "+ txtName.getText().toString());
        }
        if ( txtEmail.getText()!=null){
        Log.i("RUI", "Email: "+ txtEmail.getText().toString());
        }
        if (  sCountry.getSelectedItem()!=null){
        Log.i("RUI", "Country: "+ sCountry.getSelectedItem().toString());
        }
        if ( sDistrict.getSelectedItem()!=null){
        Log.i("RUI", "District: "+ sDistrict.getSelectedItem().toString());
        }
        if ( sCouncil.getSelectedItem()!=null){
        Log.i("RUI", "Council: "+ sCouncil.getSelectedItem().toString());
        }
    }
}
