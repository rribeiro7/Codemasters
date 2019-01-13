package pt.andreiaribeiro.com.andreiaribeiro.view.services.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
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
import java.util.List;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.mocks.ObjSpinner;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseKeyValue;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.KeyValueModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesFilterActivity extends AppCompatActivity {

    Button btnServices, btnClean;
    Spinner sActivity;
    Spinner sServices;
    //Spinner sCountry;
    Spinner sDistrict;
    Spinner sCouncil;
    private AutoCompleteTextView txtGeneric;
    private EditText txtName;

    ObjSpinner objSActivity;
    ObjSpinner objSServices;
    //ObjSpinner objSCountry;
    ObjSpinner objSDistrict;
    ObjSpinner objSCouncil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_filter);
        setLayout();
        loadSpinnerActivity();

        loadSpinnerDistrict();

        btnServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFilters();
                Intent intent = new Intent(ServicesFilterActivity.this, ServicesListActivity.class);
                intent.putExtra(Constants.FILTER_GENERIC, txtGeneric.getText().toString());
                intent.putExtra(Constants.FILTER_NAME, txtName.getText().toString());
                intent.putExtra(Constants.FILTER_ACTIVITY, objSActivity != null ? objSActivity.getId() : -1);
                intent.putExtra(Constants.FILTER_SERVICE, objSServices != null ? objSServices.getId() : -1);
                //intent.putExtra(Constants.FILTER_COUNTRY, sCountry.getSelectedItemId());
                intent.putExtra(Constants.FILTER_DISTRICT, objSDistrict != null ? objSDistrict.getId() : -1);
                intent.putExtra(Constants.FILTER_COUNCIL, objSCouncil != null ? objSCouncil.getId() : -1);
                startActivity(intent);
            }
        });
        btnClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtGeneric.setText("");
                txtName.setText("");
                sActivity.setSelection(0);
                cleanServices();
                //sCountry.setSelection(0);
                sDistrict.setSelection(0);
                cleanCouncil();
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_shop:

                        return true;
                    case R.id.navigation_gifts:

                        return true;
                    case R.id.navigation_cart:

                        return true;
                }
                return false;
            }
        };
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void cleanServices(){
        sServices.setSelection(0);
        sServices.setAdapter(null);
        objSServices = null;
    }

    private void cleanCouncil(){
        sCouncil.setSelection(0);
        sCouncil.setAdapter(null);
        objSCouncil = null;
    }

    private void setLayout() {
        txtGeneric = (AutoCompleteTextView) findViewById(R.id.filter_genericsearch);
        txtName = (EditText) findViewById(R.id.filter_name);
        btnServices = (Button) findViewById(R.id.filter_btnSearch);
        btnClean = (Button) findViewById(R.id.filter_btnClean);
        sActivity = (Spinner) findViewById(R.id.filter_activity);
        sServices = (Spinner) findViewById(R.id.filter_service);
        //sCountry = (Spinner) findViewById(R.id.filter_country);
        sDistrict = (Spinner) findViewById(R.id.filter_district);
        sCouncil = (Spinner) findViewById(R.id.filter_council);
    }

    private void loadSpinnerActivity(){
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        spinnerArray.add(new ObjSpinner(-1, "---"));
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("activity.json"));
            JSONArray m_jArry = obj.getJSONArray("d");
            //ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            //HashMap<String, String> m_li;

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
                    //loadSpinnerServices(FiltersMock.fillServices(objSActivity.getId()));
                    if (objSActivity.getId()!=-1) {
                        callServices(objSActivity.getId());
                    }
                    else{
                        cleanServices();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void callServices(int idAct){
        Call<BaseKeyValue<KeyValueModel>> call1 = LiberiixApplication.getApiRepositoryInstance(this).getServiceByActivityId(idAct);
        call1.enqueue(new Callback<BaseKeyValue<KeyValueModel>>(){
            @Override
            public void onResponse(Call<BaseKeyValue<KeyValueModel>> call, Response<BaseKeyValue<KeyValueModel>> response) {
                if (response.body() != null && response.errorBody() == null && response.body().getLstKeyValue() != null) {
                    List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
                    for( KeyValueModel objKeyValue : response.body().getLstKeyValue()){
                        spinnerArray.add(new ObjSpinner(Integer.parseInt(objKeyValue.getKey()), objKeyValue.getValue()));
                    }

                    ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                            getApplication(), android.R.layout.simple_spinner_item, spinnerArray);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sServices.setAdapter(adapter);
                    sServices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view,
                                                   int position, long id) {

                            if(sServices.getSelectedItem() != null)
                            {
                                objSServices = (ObjSpinner) sServices.getSelectedItem();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } else {
                    cleanServices();
                    Toast.makeText(ServicesFilterActivity.this, "Não foram encontrados serviços", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseKeyValue<KeyValueModel>> call, Throwable t) {
                cleanServices();
                Toast.makeText(ServicesFilterActivity.this, "Falha no pedido de serviços", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callCouncil(int idDis){
        Call<BaseKeyValue<KeyValueModel>> call1 = LiberiixApplication.getApiRepositoryInstance(this).getCouncilsByDistrict(idDis);
        call1.enqueue(new Callback<BaseKeyValue<KeyValueModel>>(){
            @Override
            public void onResponse(Call<BaseKeyValue<KeyValueModel>> call, Response<BaseKeyValue<KeyValueModel>> response) {
                if (response.body() != null && response.errorBody() == null && response.body().getLstKeyValue() != null) {
                    List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
                    for( KeyValueModel objKeyValue : response.body().getLstKeyValue()){
                        spinnerArray.add(new ObjSpinner(Integer.parseInt(objKeyValue.getKey()), objKeyValue.getValue()));
                    }

                    ArrayAdapter<ObjSpinner> adapter = new ArrayAdapter<ObjSpinner>(
                            getApplication(), android.R.layout.simple_spinner_item, spinnerArray);

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    sCouncil.setAdapter(adapter);
                    sCouncil.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view,
                                                   int position, long id) {

                            if(sCouncil.getSelectedItem() != null)
                            {
                                objSCouncil = (ObjSpinner) sCouncil.getSelectedItem();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                } else {
                    cleanCouncil();
                    Toast.makeText(ServicesFilterActivity.this, "Não foram encontrados Concelhos", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BaseKeyValue<KeyValueModel>> call, Throwable t) {
                cleanCouncil();
                Toast.makeText(ServicesFilterActivity.this, "Falha no pedido de concelhos", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadSpinnerDistrict() {
        List<ObjSpinner> spinnerArray =  new ArrayList<ObjSpinner>();
        spinnerArray.add(new ObjSpinner(-1, "---"));
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset("distrito.json"));
            JSONArray m_jArry = obj.getJSONArray("d");
            //ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            //HashMap<String, String> m_li;

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
        sDistrict.setAdapter(adapter);
        sDistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {

                if(sDistrict.getSelectedItem() != null)
                {
                    objSDistrict = (ObjSpinner) sDistrict.getSelectedItem();
                    if (objSDistrict.getId()!=-1) {
                        callCouncil(objSDistrict.getId());
                    }
                    else{
                        cleanCouncil();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
/*
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
    */

    public String loadJSONFromAsset(String strFilename) {
        String json = null;
        try {
            InputStream is = this.getAssets().open(strFilename);
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
        /*if (  sCountry.getSelectedItem()!=null){
        Log.i("RUI", "Country: "+ sCountry.getSelectedItem().toString());
        }*/
        if ( sDistrict.getSelectedItem()!=null){
            Log.i("RUI", "District: "+ sDistrict.getSelectedItem().toString());
        }
        if ( sCouncil.getSelectedItem()!=null){
            Log.i("RUI", "Council: "+ sCouncil.getSelectedItem().toString());
        }
    }
}
