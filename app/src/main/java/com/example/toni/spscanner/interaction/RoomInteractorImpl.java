package com.example.toni.spscanner.interaction;


import android.util.Log;

import com.example.toni.spscanner.database.ScanDao;
import com.example.toni.spscanner.model.Scan;
import com.example.toni.spscanner.ui.history.RoomCallback;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RoomInteractorImpl implements RoomInteractor {

    private ScanDao scanDao;

    public RoomInteractorImpl(ScanDao scanDao){
        this.scanDao = scanDao;
    }

    @Override
    public void storeResultsToDatabase(String scannedValue, String result) {
        Scan scan = new Scan(scannedValue, getTimestamp(), result);
        scanDao.insert(scan);
    }

    @Override
    public void getResultsFromDatabase(RoomCallback callback) {
        callback.onScansRead(scanDao.getAllResults());
    }


    @Override
    public void deleteAllScans(RoomCallback callback) {
        scanDao.delete();
        callback.onScansDeleted(scanDao.getAllResults());
    }


    String getTimestamp(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return sdf.format(new Date());
    }
}
