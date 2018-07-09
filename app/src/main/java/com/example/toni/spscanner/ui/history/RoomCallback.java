package com.example.toni.spscanner.ui.history;

import com.example.toni.spscanner.model.Scan;

import java.util.List;

public interface RoomCallback {

    void onScansDeleted(List<Scan> scans);

    void onScansRead(List<Scan> scans);

}
