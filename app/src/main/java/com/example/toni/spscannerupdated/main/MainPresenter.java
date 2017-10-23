package com.example.toni.spscannerupdated.main;

public interface MainPresenter {

    void startScan();
    void readFile(String result);
    void storeResultsToDatabase(String barcode, String value);
}
