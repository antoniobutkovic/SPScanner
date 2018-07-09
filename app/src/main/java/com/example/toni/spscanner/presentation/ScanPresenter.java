package com.example.toni.spscanner.presentation;

import com.example.toni.spscanner.view.ScanView;

public interface ScanPresenter extends BasePresenter<ScanView>{

    void readFile(String scannedValue);

}
