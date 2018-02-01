package pt.andreiaribeiro.com.andreiaribeiro.view.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.StringUtils;

/**
 * Created by Rui on 01/12/2017.
 */

public class RegisterActivity extends AppCompatActivity {

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
                StringUtils.isNullOrEmpty(txtConfirmPassword.getText().toString())){
                    return true;
        }else{
            return false;
        }
    }

    private void saveInfo() {
        UserModel user = new UserModel();
        user.setName(txtName.getText().toString());
        user.setEmail(txtEmail.getText().toString());
        //TODO falta password
//        "type": "pro",
//                "name": "user",
//                "email": "teste@test.com",
//                "password": "teste",
//                "confirmpass": "teste",
//                "lang":"en"

    }
}
