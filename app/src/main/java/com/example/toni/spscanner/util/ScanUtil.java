package com.example.toni.spscanner.util;

import android.app.Activity;

import com.google.zxing.integration.android.IntentIntegrator;

public class ScanUtil {

    public static void initiateScan(Activity activity) {
        IntentIntegrator intentIntegrator = new IntentIntegrator(activity);
        intentIntegrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
        intentIntegrator.setPrompt("");
        intentIntegrator.setCameraId(0);
        intentIntegrator.setBeepEnabled(false);
        intentIntegrator.initiateScan();
    }
}
