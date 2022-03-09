package android.example.covid19app.Warnings;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.example.covid19app.Login;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class logOutWarning extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("INFO")
                .setMessage("Tem a certeza que pretende terminar sessão?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(((Dialog)dialog).getContext(),Login.class));
                    }
                })
                .setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        return builder.create();
    }
}
