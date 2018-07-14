package com.example.toni.spscanner.presentation;

import com.example.toni.spscanner.interaction.RoomInteractor;
import com.example.toni.spscanner.ui.scan.helpers.FileHelper;
import com.example.toni.spscanner.ui.scan.helpers.FileReadFinishedListener;
import com.example.toni.spscanner.ui.scan.helpers.POIHandler;
import com.example.toni.spscanner.view.ScanView;

public class ScanPresenterImpl implements ScanPresenter{

    private ScanView view;
    private RoomInteractor interactor;
    private POIHandler poiHandler;
    private FileHelper helper;

    public ScanPresenterImpl(RoomInteractor scanInteractor, POIHandler poiHandler, FileHelper helper) {
        this.interactor = scanInteractor;
        this.poiHandler = poiHandler;
        this.helper = helper;
    }

    @Override
    public void setView(ScanView scanView) {
        this.view = scanView;
    }


    @Override
    public void readFile(final String scannedValue) {
        helper.readFile(scannedValue, poiHandler, new FileReadFinishedListener() {

            @Override
            public void onSuccess(String result) {
                view.onReadFileFinished(result);
                interactor.storeResultsToDatabase(scannedValue, result);
            }

            @Override
            public void resultsNotFound() {
                view.showNoResultsErrorMessage();
            }

            @Override
            public void unableToOpenFile() {
                view.showUnableToOpenFileErrorMessage();
            }

            @Override
            public void unableToFindFile() {
                view.showUnableToFindFileErrorMessage();
            }

        });
    }

}
