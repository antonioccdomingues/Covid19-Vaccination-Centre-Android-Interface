package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.covid19app.Warnings.LoginWarning;
import android.example.covid19app.Warnings.logOutWarning;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    Button bLogout, bConfirmados, bElegiveis, bEstatisticas;
    String temp;
    TextView tvEmail;
    String GlobalEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bLogout = (Button) findViewById(R.id.bLogout);
        bLogout.setOnClickListener(this);

        bElegiveis = (Button) findViewById(R.id.bElegiveis);
        bElegiveis.setOnClickListener(this);

        bConfirmados = (Button) findViewById(R.id.bConfirmados);
        bConfirmados.setOnClickListener(this);

        tvEmail = findViewById(R.id.tvEmailmedico); //esquerda o desta classe, direita o do xml desta classe
        try{
            if(getIntent().getExtras().getString("Flag").equals("1")){
                GlobalEmail = getIntent().getExtras().getString("ValueEmail");
            }
        }catch(Exception a){}

        bEstatisticas = (Button) findViewById(R.id.bEstatisticas);
        bEstatisticas.setOnClickListener(this);

        temp = GlobalEmail;
        tvEmail.setText(GlobalEmail);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.bLogout:
                openLogoutWarning();
                break;

            case R.id.bConfirmados:
                Intent i = new Intent(Menu.this, Verificar_Confirmados.class); //TEM QUE VIR PARA AQUI UMA FLAG A DIZER QUE GRUPOS FORAM SELECIONADOS(VINDO DO VALOR DO BOTAO)
                //stEmail = etEmail.getText().toString();
                //stPassword= etPassword.getText().toString();
                //i.putExtra("ValueEmail", stEmail);
                //i.putExtra("ValuePassword", stPassword);
                startActivity(i);
                break;
            case R.id.bElegiveis:
                Intent u = new Intent(Menu.this, Selecionar_grupo.class); //TEM QUE VIR PARA AQUI UMA FLAG A DIZER QUE GRUPOS FORAM SELECIONADOS(VINDO DO VALOR DO BOTAO)
                //stEmail = etEmail.getText().toString();
                //stPassword= etPassword.getText().toString();
                //i.putExtra("ValueEmail", stEmail);
                //i.putExtra("ValuePassword", stPassword);
                startActivity(u);
                break;

            case R.id.bEstatisticas:
                Intent x = new Intent(Menu.this, Vacinas.class);
                startActivity(x);
                break;
        }
    }

    public void openLogoutWarning(){
        logOutWarning logOutWarning = new logOutWarning();
        logOutWarning.show(getSupportFragmentManager(), "logout Warning"); // "login warning" = tag
    }
}