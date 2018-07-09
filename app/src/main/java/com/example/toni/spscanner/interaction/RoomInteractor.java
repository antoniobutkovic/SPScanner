package com.example.toni.spscanner.interaction;


import com.example.toni.spscanner.model.Scan;
import com.example.toni.spscanner.ui.history.RoomCallback;

import java.util.List;

/**
 * Created by Toni on 12.10.2017..
 */

public interface RoomInteractor {

    void storeResultsToDatabase(String scannedValue, String result);

    void getResultsFromDatabase(RoomCallback callback);

    void deleteAllScans(RoomCallback callback);

}
