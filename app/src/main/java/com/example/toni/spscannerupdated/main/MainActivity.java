package com.example.toni.spscannerupdated.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.toni.spscannerupdated.R;
import com.example.toni.spscannerupdated.history.HistoryActivity;
import com.google.zxing.integration.android.IntentIntegrator;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this, this);

    }

    @OnClick(R.id.scan_btn)
    public void startScan(){
        presenter.startScan();
    }

    @OnClick(R.id.history_btn)
    public void navigateToHistoryActivity(){
        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
    }

    @Override
    public void showResultsDialog(String barcode, String result) {

        presenter.storeResultsToDatabase(barcode, result);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        TextView resultTv = view.findViewById(R.id.result_tv);
        resultTv.setText(result);

        builder.setNegativeButton("Poništi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setPositiveButton("Nastavi skenirati", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                presenter.startScan();
            }
        });
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showNoResultsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.blank_dialog, null);

        builder.setNegativeButton("Poništi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.setPositiveButton("Nastavi skenirati", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                presenter.startScan();
            }
        });
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data).getContents();

        if(result == null) {
            showErrorMessage("Skeniranje je prekinuto.");
        }else if(result.equals("")){
            showNoResultsDialog();
        } else{
            presenter.readFile(result);
        }
    }
}