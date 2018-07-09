package com.example.toni.spscanner.presentation;

import android.util.Log;

import com.example.toni.spscanner.interaction.RoomInteractor;
import com.example.toni.spscanner.model.Scan;
import com.example.toni.spscanner.ui.history.RoomCallback;
import com.example.toni.spscanner.view.HistoryView;

import java.util.List;

public class HistoryPresenterImpl implements HistoryPresenter, RoomCallback{

    private RoomInteractor interactor;
    private HistoryView view;

    public HistoryPresenterImpl(RoomInteractor interactor){
        this.interactor = interactor;
    }

    @Override
    public void setView(HistoryView historyView) {
        this.view = historyView;
    }

    @Override
    public void readScansFromDatabase() {
        interactor.getResultsFromDatabase(this);
    }

    @Override
    public void deleteAllScansFromDatabase() {
        interactor.deleteAllScans(this);
    }

    @Override
    public void onScansDeleted(List<Scan> scans) {
        view.showScansListView(scans);
        view.showOnDeleteSuccess();
        view.showNoScansTextView();
    }

    @Override
    public void onScansRead(List<Scan> scans) {
        if (scans.isEmpty()){
            view.showNoScansTextView();
        }
        view.showScansListView(scans);
    }
}
