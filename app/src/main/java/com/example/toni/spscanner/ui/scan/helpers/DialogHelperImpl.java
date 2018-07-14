package com.example.toni.spscanner.ui.scan.helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

import com.example.toni.spscanner.R;
import com.example.toni.spscanner.ui.scan.DialogCallback;

public class DialogHelperImpl implements DialogHelper{

    @Override
    public void showDialog(Activity activity, String result, final DialogCallback callback) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.results_dialog, null);
        TextView resultTv = view.findViewById(R.id.result_tv);
        resultTv.setText(result);

        builder.setNegativeButton(R.string.dialog_negative_btn_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(R.string.dialog_positive_btn_text, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                callback.onDialogPositiveButtonClicked();
            }
        });
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
