package com.example.toni.spscanner.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.toni.spscanner.model.Scan;

@Database(entities = {Scan.class}, version = 1)
public abstract class ScanRoomDatabase extends RoomDatabase {

    public abstract ScanDao scanDao();

    private static ScanRoomDatabase INSTANCE;

    public static ScanRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ScanRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ScanRoomDatabase.class, "scan_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

