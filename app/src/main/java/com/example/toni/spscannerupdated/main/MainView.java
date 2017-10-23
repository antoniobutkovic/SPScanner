package com.example.toni.spscannerupdated.main;


public interface MainView {

    void showResultsDialog(String barcode, String result);
    void showNoResultsDialog();
    void showErrorMessage(String message);
}
