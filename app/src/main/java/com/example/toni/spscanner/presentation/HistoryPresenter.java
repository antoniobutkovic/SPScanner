package com.example.toni.spscanner.presentation;

import com.example.toni.spscanner.view.HistoryView;

public interface HistoryPresenter extends BasePresenter<HistoryView>{

    void readScansFromDatabase();

    void deleteAllScansFromDatabase();


}
