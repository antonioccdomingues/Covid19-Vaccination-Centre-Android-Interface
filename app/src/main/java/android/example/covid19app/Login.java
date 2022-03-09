package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.covid19app.Warnings.LoginWarning;
import android.example.covid19app.Warnings.nopassword_warning;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button bLogin;
    EditText etEmail, etPassword;
    String stEmail, stPassword;
    TextView tvRegisterLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail =(EditText) findViewById(R.id.etEmail);
        etPassword =(EditText) findViewById(R.id.etPassword);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvRegisterLink= (TextView) findViewById(R.id.tvRegisterLink);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.bLogin:

                String emailregisto="";
                String passRegisto="";
                try {
                    emailregisto = getIntent().getExtras().getString("emailRegisto");
                    passRegisto = getIntent().getExtras().getString("passwordRegisto");
                    if(etEmail.getText().toString().equals(emailregisto) && etPassword.getText().toString().equals(passRegisto) ){
                        Intent i = new Intent(Login.this, Menu.class);
                        stEmail = etEmail.getText().toString();
                        stPassword= etPassword.getText().toString();
                        i.putExtra("ValueEmail", stEmail);
                        i.putExtra("ValuePassword", stPassword);
                        i.putExtra("Flag", "1");
                        startActivity(i);
                    }else{
                        openNoPassWarning();
                    }
                }catch (Exception e){
                    openWarning();
                }
                if(etEmail.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                    Intent i = new Intent(Login.this, Menu.class);
                    stEmail = etEmail.getText().toString();
                    stPassword= etPassword.getText().toString();
                    i.putExtra("ValueEmail", stEmail);
                    i.putExtra("ValuePassword", stPassword);
                    i.putExtra("Flag", "1");
                    startActivity(i);
                }else{
                    openNoPassWarning();
                }
                break;

            case R.id.tvRegisterLink:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }

    public void openWarning(){
        LoginWarning loginWarning = new LoginWarning();
        loginWarning.show(getSupportFragmentManager(), "login Warning"); // "login warning" = tag
    }
    public void openNoPassWarning(){
        nopassword_warning loginWarning = new nopassword_warning();
        loginWarning.show(getSupportFragmentManager(), "no pass Warning"); // "login warning" = tag
    }
}