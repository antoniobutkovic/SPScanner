package com.example.toni.spscanner.ui.scan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.toni.spscanner.App;
import com.example.toni.spscanner.Constants;
import com.example.toni.spscanner.R;
import com.example.toni.spscanner.ui.history.HistoryActivity;
import com.example.toni.spscanner.presentation.ScanPresenter;
import com.example.toni.spscanner.presentation.ScanPresenterImpl;
import com.example.toni.spscanner.ui.scan.helpers.DialogHelper;
import com.example.toni.spscanner.ui.scan.helpers.DialogHelperImpl;
import com.example.toni.spscanner.ui.scan.helpers.FileHelperImpl;
import com.example.toni.spscanner.ui.scan.helpers.POIHandlerImpl;
import com.example.toni.spscanner.util.FileUtil;
import com.example.toni.spscanner.util.ScanUtil;
import com.example.toni.spscanner.util.SharedPrefsUtil;
import com.example.toni.spscanner.view.ScanView;
import com.google.zxing.integration.android.IntentIntegrator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ScanActivity extends AppCompatActivity implements ScanView{

    private DialogHelper dialogHelper;
    private ScanPresenter presenter;
    private String filePath;

    @BindView(R.id.selectBtn)
    Button selectBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
        dialogHelper = new DialogHelperImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpFilePath();
        setUpFileName();
        setUpPresenter();
    }

    private void setUpFileName() {
        String fileName = SharedPrefsUtil.getPreferencesField(this, Constants.FILE_NAME);
        if (fileName != null){
            changeSelectBtnName(fileName);
        }
    }

    private void setUpFilePath() {
        filePath = SharedPrefsUtil.getPreferencesField(this, Constants.FILE_PATH);
    }

    private void setUpPresenter() {
        presenter = new ScanPresenterImpl(App.getScanInteractor(), new POIHandlerImpl(filePath), new FileHelperImpl());
        presenter.setView(this);
    }

    @OnClick(R.id.scanBtn)
    public void startScan(){
        if (filePath == null){
            showUnableToFindFileErrorMessage();
        }else {
            ScanUtil.initiateScan(this);
        }
    }

    @OnClick(R.id.historyBtn)
    public void navigateToHistoryActivity(){
        startActivity(new Intent(this, HistoryActivity.class));
    }

    @OnClick(R.id.selectBtn)
    public void selectFile(){
        FileUtil.selectFile(this);
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
        if (resultCode == RESULT_OK){
            if (requestCode == Constants.PICKFILE_RESULT_CODE){
                filePath = data.getData().getPath();
                String fileName = data.getData().getLastPathSegment();
                changeSelectBtnName(fileName);
                saveSelectedFileNameAndPath(fileName, filePath);
                setUpPresenter();
            }else {
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
    }

    private void saveSelectedFileNameAndPath(String fileName, String filePath) {
        SharedPrefsUtil.storePreferencesField(this, Constants.FILE_NAME, fileName);
        SharedPrefsUtil.storePreferencesField(this, Constants.FILE_PATH, filePath);
    }

    private void changeSelectBtnName(String fileName) {
        selectBtn.setText(fileName);
    }
}