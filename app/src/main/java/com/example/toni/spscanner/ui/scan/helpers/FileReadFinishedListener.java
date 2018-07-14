package com.example.toni.spscanner.ui.scan.helpers;

public interface FileReadFinishedListener {


    void onSuccess(String result);

    void resultsNotFound();

    void unableToOpenFile();

    void unableToFindFile();

}
