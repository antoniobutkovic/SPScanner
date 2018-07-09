package com.example.toni.spscanner.ui.scan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.toni.spscanner.App;
import com.example.toni.spscanner.R;
import com.example.toni.spscanner.ui.history.HistoryActivity;
import com.example.toni.spscanner.presentation.ScanPresenter;
import com.example.toni.spscanner.presentation.ScanPresenterImpl;
import com.example.toni.spscanner.ui.scan.helpers.DialogHelper;
import com.example.toni.spscanner.ui.scan.helpers.DialogHelperImpl;
import com.example.toni.spscanner.ui.scan.helpers.FileHelperImpl;
import com.example.toni.spscanner.ui.scan.helpers.POIHandlerImpl;
import com.example.toni.spscanner.ui.scan.helpers.ScanHelper;
import com.example.toni.spscanner.ui.scan.helpers.ScanHelperImpl;
import com.example.toni.spscanner.view.ScanView;
import com.google.zxing.integration.android.IntentIntegrator;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ScanActivity extends AppCompatActivity implements ScanView{

    private ScanHelper scanHelper;
    private DialogHelper dialogHelper;
    private ScanPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dialogHelper = new DialogHelperImpl();
        scanHelper = new ScanHelperImpl();
        presenter = new ScanPresenterImpl(App.getScanInteractor(), new POIHandlerImpl(), new FileHelperImpl());
        presenter.setView(this);
    }

    @OnClick(R.id.scan_btn)
    public void startScan(){
        scanHelper.initiateScan(this);
    }

    @OnClick(R.id.history_btn)
    public void navigateToHistoryActivity(){
        startActivity(new Intent(this, HistoryActivity.class));
    }

    @Override
    public void onReadFileFinished(String result) {
        showResultsDialog(result);
    }

    private void showResultsDialog(String result) {
        dialogHelper.showDialog(this, result, new DialogCallback() {
            @Override
            public void onDialogPositiveButtonClicked() {
                startScan();
            }
        });
    }

    @Override
    public void showNoResultsErrorMessage() {
        Toast.makeText(this, getString(R.string.no_results_found_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showScanInterruptedErrorMessage() {
        Toast.makeText(this, getString(R.string.scanning_interrupted_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUnableToOpenFileErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_open_file_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUnableToFindFileErrorMessage() {
        Toast.makeText(this, getString(R.string.unable_to_find_file_text), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String scannedValue = IntentIntegrator.parseActivityResult(requestCode, resultCode, data).getContents();
        if(scannedValue == null) {
            showScanInterruptedErrorMessage();
        }else if(scannedValue.equals("")){
            showNoResultsErrorMessage();
        } else{
            presenter.readFile(scannedValue);
        }
    }

}