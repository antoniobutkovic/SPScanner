package com.example.toni.spscannerupdated;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "scanhistory.db";
    private static final String TABLE_BARCODE = "BARCODE";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_BARCODE_NUM = "BARCODE_NUM";
    private static final String COLUMN_DATE = "TIMESTAMP";
    private static final String COLUMN_BARCODE_VALUE = "VALUE";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_BARCODE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BARCODE_NUM + " BIGINT, "
                + COLUMN_BARCODE_VALUE + " TEXT, "
                + COLUMN_DATE + " DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BARCODE);
        onCreate(db);
    }

    public void storeToDatabase(String barcode, String value, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_BARCODE_NUM, barcode);
        values.put(COLUMN_BARCODE_VALUE, value);
        values.put(COLUMN_DATE, date);
        db.insert(TABLE_BARCODE, null, values);
        db.close();
    }

    public Cursor getRecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_BARCODE, null);
    }

    public void clearHistory(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARCODE, null, null);
        db.close();
    }
}