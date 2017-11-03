package pt.andreiaribeiro.com.andreiaribeiro.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.LoginFilter;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pt.andreiaribeiro.com.andreiaribeiro.R;
import pt.andreiaribeiro.com.andreiaribeiro.view.services.ServicesFilterActivity;
import pt.andreiaribeiro.com.andreiaribeiro.utils.LoginMock;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private AutoCompleteTextView txtEmail;
    private EditText txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        txtEmail = (AutoCompleteTextView) findViewById(R.id.text_email);
        txtPassword = (EditText) findViewById(R.id.text_password);
        btnLogin = (Button) findViewById(R.id.email_sign_in_button);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (LoginMock.doLogin(txtEmail.getText().toString(), txtPassword.getText().toString())) {
            Toast.makeText(this, "Login with success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ServicesFilterActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login error!", Toast.LENGTH_SHORT).show();
        }
    }

}
