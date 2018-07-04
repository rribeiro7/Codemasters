package pt.andreiaribeiro.com.andreiaribeiro.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.LiberiixApplication;
import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.BaseResponse;
import pt.andreiaribeiro.com.andreiaribeiro.repositories.model.UserAuthInfoModel;
import pt.andreiaribeiro.com.andreiaribeiro.utils.Constants;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.ChatActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.chat.MessageListActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.register.RegisterActivity;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.activities.ServicesFilterActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Callback<BaseResponse<UserAuthInfoModel>> {

    private AutoCompleteTextView txtEmail;
    private EditText txtPassword;
    private Button btnLogin, btnRegister;
    private RadioGroup radioType;
    private RadioButton radioButton;
    private RadioButton radioUserLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        txtEmail = (AutoCompleteTextView) findViewById(R.id.text_email);
        txtPassword = (EditText) findViewById(R.id.text_password);
        btnLogin = (Button) findViewById(R.id.email_sign_in_button);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button) findViewById(R.id.login_goRegister);
        btnRegister.setOnClickListener(this);
        radioType = (RadioGroup) findViewById(R.id.radio_login_type);
        radioUserLogin = (RadioButton) findViewById(R.id.radioUser);
    }

    @Override
    public void onClick(View v) {
        int selectedId = radioType.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);

        switch (v.getId()) {
            case R.id.email_sign_in_button:
                if (isLoginValid(txtEmail.getText().toString(), txtPassword.getText().toString())) {
                    LiberiixApplication.getApiRepositoryInstance(this).authenticate(radioButton.getTag().toString(), txtEmail.getText().toString(), txtPassword.getText().toString(), this);
                } else {
                    Toast.makeText(this, "Please fill both username and password fields!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.login_goRegister:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
            default:
                break;
        }

    }

    @Override
    public void onResponse(@NonNull Call<BaseResponse<UserAuthInfoModel>> call, @NonNull Response<BaseResponse<UserAuthInfoModel>> response) {
        if (response.body() != null && response.errorBody() == null && response.body().getBodyResponse() != null
                && response.body().getBodyResponse().getObj() != null) {
            Toast.makeText(this, "Login with success.", Toast.LENGTH_SHORT).show();
            if (radioUserLogin.isChecked()) {
                Intent intent = new Intent(this, ServicesFilterActivity.class);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, MessageListActivity.class);
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, "There was an error with the Login. Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure(@NonNull Call<BaseResponse<UserAuthInfoModel>> call, Throwable t) {
        Toast.makeText(this, "There was an error with the Login. Please try again.", Toast.LENGTH_SHORT).show();
    }

    private boolean isLoginValid(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }
}
