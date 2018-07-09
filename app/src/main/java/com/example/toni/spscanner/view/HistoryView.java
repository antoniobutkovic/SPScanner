package com.example.toni.spscanner.view;

import com.example.toni.spscanner.model.Scan;

import java.util.List;

public interface HistoryView {

    void showNoScansTextView();

    void showScansListView(List<Scan> scans);

    void showOnDeleteSuccess();

}
