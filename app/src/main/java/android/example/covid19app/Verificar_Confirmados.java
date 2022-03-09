package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Verificar_Confirmados extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_confirmados);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button bGrupo1, bGrupo2, bGrupo3;

        bGrupo1 = (Button) findViewById(R.id.btGrupo1);
        bGrupo2 = (Button) findViewById(R.id.btGrupo2);
        bGrupo3 = (Button) findViewById(R.id.btGrupo3);

        bGrupo1.setOnClickListener(this);
        bGrupo2.setOnClickListener(this);
        bGrupo3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.btGrupo1:
                //fazer aqui um if, caso o utilizador tenha notificado o grupo, senão nao deixa ir
                Intent i = new Intent(Verificar_Confirmados.this, Pessoas_grupo.class);
                startActivity(i);
                break;

            case R.id.btGrupo2:
                Intent i2 = new Intent(Verificar_Confirmados.this, Pessoas_grupo2.class);
                startActivity(i2);
                break;

            case R.id.btGrupo3:
                Intent i3 = new Intent(Verificar_Confirmados.this, Pessoas_grupo3.class);
                startActivity(i3);
                break;
        }
    }
}