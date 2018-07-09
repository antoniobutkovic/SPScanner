package com.example.toni.spscanner.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.toni.spscanner.model.Scan;

import java.util.List;

@Dao
public interface ScanDao {

    @Insert
    void insert(Scan scan);

    @Query("SELECT * from scan_table")
    List<Scan> getAllResults();

    @Query("DELETE FROM scan_table")
    void delete();

}
