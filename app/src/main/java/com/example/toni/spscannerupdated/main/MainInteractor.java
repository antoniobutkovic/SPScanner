package com.example.toni.spscannerupdated.main;


/**
 * Created by Toni on 12.10.2017..
 */

public interface MainInteractor {

    interface onReadFileFinishedListener{
        void onSuccess(String barcode, String result);
        void onFailure();
    }
    void readFile(String result, onReadFileFinishedListener listener);
}
