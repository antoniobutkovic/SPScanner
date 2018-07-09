package com.example.toni.spscanner.view;


public interface ScanView {

    void onReadFileFinished(String result);

    void showNoResultsErrorMessage();

    void showScanInterruptedErrorMessage();

    void showUnableToOpenFileErrorMessage();

    void showUnableToFindFileErrorMessage();
}
