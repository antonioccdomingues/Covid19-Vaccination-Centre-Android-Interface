package android.example.covid19app;

import androidx.appcompat.app.AppCompatActivity;

import android.example.covid19app.Warnings.NotificacaoWarning;
import android.example.covid19app.Warnings.PrioridadeWarning;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Objects;

public class Selecionar_grupo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_grupo);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    public void notifyGroup(View view) {
        if (view.getId() == R.id.bGrupo1 || view.getId() == R.id.bGrupo2) {
            Toast toast = Toast.makeText(this, "R.string.toast_message", Toast.LENGTH_SHORT);
            NotificacaoWarning warn = new NotificacaoWarning();
            warn.show(getSupportFragmentManager(), "notificaçao Warning");
        } else {
            PrioridadeWarning warn = new PrioridadeWarning();
            warn.show(getSupportFragmentManager(), "prioridade Warning");
        }
    }


}