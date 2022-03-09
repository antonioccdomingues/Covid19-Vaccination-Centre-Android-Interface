package android.example.covid19app.Warnings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.example.covid19app.MailAPI;
import android.example.covid19app.R;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

public class LembreteWarning extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("INFO")
                .setMessage("Deseja notificar os pacientes que não responderam?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sendMail();
                        Toast.makeText(getActivity(), R.string.notif_enviada, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        return builder.create();
    }

    private void sendMail() {
        String message = "Olá, relembramos que está apto a ser vacinado, por favor responda se está interessado";
        String[] mail = {"antonioccdomingues@gmail.com", "diogoreisvicente@gmail.com", "quiquemsilva@gmail.com"};
        String subject = "Vacinação Covid-19";

        for(String i : mail) {
            MailAPI mailAPI = new MailAPI(getActivity()/*getApplicationContext()/getContext()*/, i, subject, message);
            mailAPI.execute();
        }
    }


}