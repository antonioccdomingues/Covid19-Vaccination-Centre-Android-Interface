package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.example.covid19app.Warnings.LoginWarning;
import android.example.covid19app.Warnings.Register_Nocontent;
import android.example.covid19app.Warnings.passDiferentrepeatpass;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etEmail, etPassword, etRepeatPassword;
    String stEmail, stPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = (EditText) findViewById(R.id.etEmail);

        bRegister= (Button) findViewById(R.id.bRegister);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.bRegister:
                etPassword = (EditText) findViewById(R.id.etPassword);
                etRepeatPassword = (EditText) findViewById(R.id.etRepeatpassword);
                if(etEmail.getText().toString() == null || etEmail.getText().toString().length() ==0 || etPassword.getText().toString() == null || etRepeatPassword.getText().toString().length() ==0){
                    openNoContentWarning();
                }else{
                    if(etPassword.getText().toString().equals(etRepeatPassword.getText().toString())){
                        Intent i = new Intent(Register.this, Login.class);
                        stEmail = etEmail.getText().toString();
                        stPassword= etPassword.getText().toString();
                        i.putExtra("emailRegisto", stEmail);
                        i.putExtra("passwordRegisto", stPassword);
                        startActivity(i);
                    }else{
                        openNotCorrespondent();
                    }
                }
                break;
        }
    }

    public void openNoContentWarning(){
        Register_Nocontent register_nocontent = new Register_Nocontent();
        register_nocontent.show(getSupportFragmentManager(), "register nocontent"); // "login warning" = tag
    }

    public void openNotCorrespondent(){
        passDiferentrepeatpass passDiferentrepeatpass = new passDiferentrepeatpass();
        passDiferentrepeatpass.show(getSupportFragmentManager(), "no compatible pass"); // "login warning" = tag
    }
}