package pt.andreiaribeiro.com.andreiaribeiro.view.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.StringUtils;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesFilterActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rui on 01/12/2017.
 */

public class RegisterActivity extends AppCompatActivity implements Callback<BaseResponse<UserModel>> {

    private EditText txtName, txtEmail, txtPassword, txtConfirmPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Set up the login form.
        txtName = (EditText) findViewById(R.id.rs_txtName);
        txtEmail = (EditText) findViewById(R.id.rs_txtEmail);
        txtPassword = (EditText) findViewById(R.id.rs_txtPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.rs_txtConfirmPassword);
        btnLogin = (Button) findViewById(R.id.rs_btnRegister);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()){
                    saveInfo();
                }
            }
        });
    }

    private boolean validation() {
        if ( StringUtils.isNullOrEmpty(txtName.getText().toString()) &&
                StringUtils.isNullOrEmpty(txtEmail.getText().toString()) &&
                StringUtils.isNullOrEmpty(txtPassword.getText().toString()) &&
                StringUtils.isNullOrEmpty(txtConfirmPassword.getText().toString()) &&
                ! (txtConfirmPassword.getText().toString().equals(txtPassword.getText().toString()))
                ){
                    return false;
        }else{
            return true;
        }
    }

    private void saveInfo() {
        LiberiixApplication.getApiRepositoryInstance(this).registerUser("user", txtName.getText().toString(), txtEmail.getText().toString(),
                txtPassword.getText().toString(), txtConfirmPassword.getText().toString(), "en", this);
    }

    @Override
    public void onResponse(Call<BaseResponse<UserModel>> call, Response<BaseResponse<UserModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            Toast.makeText(this, "Register with success.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "There was an error with the Register. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(Call<BaseResponse<UserModel>> call, Throwable t) {
        Toast.makeText(this, "There was an error with the Register. Please try again.", Toast.LENGTH_SHORT).show();
    }
}
