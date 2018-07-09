package com.example.toni.spscanner;

import android.app.Application;

import com.example.toni.spscanner.database.ScanDao;
import com.example.toni.spscanner.database.ScanRoomDatabase;
import com.example.toni.spscanner.interaction.RoomInteractor;
import com.example.toni.spscanner.interaction.RoomInteractorImpl;

public class App extends Application{

    private static RoomInteractor scanInteractor;

    @Override
    public void onCreate() {
        super.onCreate();

        final ScanRoomDatabase database = ScanRoomDatabase.getDatabase(this);
        final ScanDao scanDao = database.scanDao();
        scanInteractor = new RoomInteractorImpl(scanDao);

    }

    public static RoomInteractor getScanInteractor() {
        return scanInteractor;
    }

}
