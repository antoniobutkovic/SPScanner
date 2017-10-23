package com.example.toni.spscannerupdated.main;

import com.example.toni.spscannerupdated.history.DatabaseHandler;
import com.google.zxing.integration.android.IntentIntegrator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainPresenterImpl implements MainPresenter, MainInteractor.onReadFileFinishedListener {

    private MainView view;
    private MainActivity mainActivity;
    private MainInteractor mainInteractor;
    private DatabaseHandler databaseHandler;

    public MainPresenterImpl(MainView view, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.view = view;
        mainInteractor = new MainInteractorImpl();
        databaseHandler = new DatabaseHandler(mainActivity);
    }

    @Override
    public void startScan() {
        IntentIntegrator intentIntegrator = new IntentIntegrator(mainActivity);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.initiateScan();
    }

    @Override
    public void readFile(String result) {
        mainInteractor.readFile(result, this);
    }

    @Override
    public void storeResultsToDatabase(String barcode, String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        String timestamp = sdf.format(new Date());
        databaseHandler.storeToDatabase(barcode, value, timestamp);
    }

    @Override
    public void onSuccess(String barcode, String result) {
        view.showResultsDialog(barcode, result);
    }

    @Override
    public void onFailure() {
        view.showNoResultsDialog();
    }
}
