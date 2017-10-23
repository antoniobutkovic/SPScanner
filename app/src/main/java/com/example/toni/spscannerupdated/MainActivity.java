package com.example.toni.spscannerupdated;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private POIReadExcelFile poiReadExcelFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick (R.id.scan_btn)
    public void startScan(){
        IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.initiateScan();
    }

    @OnClick (R.id.history_btn)
    public void startHistoryActivity(){
        startActivity(new Intent(getApplicationContext(), HistoryActivity.class));
    }


    public void showResult(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.custom_dialog, null);
        final TextView resultTv = view.findViewById(R.id.result_tv);
        if (poiReadExcelFile.getSn() == null || poiReadExcelFile.getInv() == null || poiReadExcelFile.getMpp() == null || poiReadExcelFile.getString() == null ){
            view = getLayoutInflater().inflate(R.layout.blank_dialog, null);
        }else{
            resultTv.setText("SN: " + poiReadExcelFile.getSn() + "\n" + "INV: " + poiReadExcelFile.getInv() + "\n" + "MPP: " + poiReadExcelFile.getMpp() + "\n" + "STRING: " + poiReadExcelFile.getString());
        }

        builder.setNegativeButton("Poništi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setPositiveButton("Nastavi skenirati", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startScan();
            }
        });
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null){
            if(result.getContents() == null){
                Toast.makeText(this, "Skeniranje je prekinuto", Toast.LENGTH_LONG).show();

            }else{

                poiReadExcelFile = new POIReadExcelFile(result.getContents());
                poiReadExcelFile.readExcelFile("zavrsni.xls");

                if (poiReadExcelFile.getSn() == null || poiReadExcelFile.getInv() == null || poiReadExcelFile.getMpp() == null || poiReadExcelFile.getString() == null){
                    showResult();
                }else{
                    showResult();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                    String timestamp = sdf.format(new Date());
                    databaseHandler = new DatabaseHandler(MainActivity.this);
                    databaseHandler.storeToDatabase(result.getContents(),"SN: " + poiReadExcelFile.getSn() + "\n" + "INV: " + poiReadExcelFile.getInv() + "\n" + "MPP: " + poiReadExcelFile.getMpp() + "\n" + "STRING: " + poiReadExcelFile.getString(), timestamp);
                }
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
