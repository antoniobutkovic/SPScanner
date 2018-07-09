package com.example.toni.spscanner.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.UUID;

@Entity(tableName = "scan_table")
public class Scan {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    private String scannedValue;
    private String time;
    private String result;

    public Scan() {
    }

    public Scan(String scannedValue, String time, String result) {
        this.id = UUID.randomUUID().toString();
        this.scannedValue = scannedValue;
        this.time = time;
        this.result = result;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public String getScannedValue() {
        return scannedValue;
    }

    public String getTime() {
        return time;
    }

    public String getResult() {
        return result;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public void setScannedValue(String scannedValue) {
        this.scannedValue = scannedValue;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
