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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.mocks.ObjSpinner;
import pt.andreiaribeiro.com.andreiaribeiro.mocks.FiltersMock;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;

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
    private EditText txtName;

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
                intent.putExtra(Constants.FILTER_GENERIC, txtGeneric.getText().toString());
                intent.putExtra(Constants.FILTER_NAME, txtName.getText().toString());
                intent.putExtra(Constants.FILTER_ACTIVITY, sActivity.getSelectedItemId());
                intent.putExtra(Constants.FILTER_SERVICE, sServices.getSelectedItemId());
                intent.putExtra(Constants.FILTER_COUNTRY, sCountry.getSelectedItemId());
                intent.putExtra(Constants.FILTER_DISTRICT, sDistrict.getSelectedItemId());
                intent.putExtra(Constants.FILTER_COUNCIL, sCouncil.getSelectedItemId());
                startActivity(intent);
            }
        });
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGeneric.setText("");
                txtName.setText("");
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
        btnServices = (Button) findViewById(R.id.filter_btnSearch);
        btnClean = (Button) findViewById(R.id.filter_btnClean);
        sActivity = (Spinner) findViewById(R.id.filter_activity);
        sServices = (Spinner) findViewById(R.id.filter_service);
        sCountry = (Spinner) findViewById(R.id.filter_country);
        sDistrict = (Spinner) findViewById(R.id.filter_district);
        sCouncil = (Spinner) findViewById(R.id.filter_council);
    }

    private void loadSpinnerActivity(){
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        spinnerArray.add(new ObjSpinner(-1, "---"));
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("d");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                int key_value = Integer.parseInt(jo_inside.getString("Key"));
                String value_value = jo_inside.getString("Value");

                spinnerArray.add(new ObjSpinner(key_value, value_value));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

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

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("activity.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
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
