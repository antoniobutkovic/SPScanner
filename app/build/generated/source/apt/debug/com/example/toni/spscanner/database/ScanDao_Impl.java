package com.example.toni.spscanner.database;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.example.toni.spscanner.model.Scan;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class ScanDao_Impl implements ScanDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfScan;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public ScanDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfScan = new EntityInsertionAdapter<Scan>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `scan_table`(`id`,`scannedValue`,`time`,`result`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Scan value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getScannedValue() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getScannedValue());
        }
        if (value.getTime() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTime());
        }
        if (value.getResult() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getResult());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM scan_table";
        return _query;
      }
    };
  }

  @Override
  public void insert(Scan scan) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfScan.insert(scan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public List<Scan> getAllResults() {
    final String _sql = "SELECT * from scan_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
      final int _cursorIndexOfScannedValue = _cursor.getColumnIndexOrThrow("scannedValue");
      final int _cursorIndexOfTime = _cursor.getColumnIndexOrThrow("time");
      final int _cursorIndexOfResult = _cursor.getColumnIndexOrThrow("result");
      final List<Scan> _result = new ArrayList<Scan>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Scan _item;
        _item = new Scan();
        final String _tmpId;
        _tmpId = _cursor.getString(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpScannedValue;
        _tmpScannedValue = _cursor.getString(_cursorIndexOfScannedValue);
        _item.setScannedValue(_tmpScannedValue);
        final String _tmpTime;
        _tmpTime = _cursor.getString(_cursorIndexOfTime);
        _item.setTime(_tmpTime);
        final String _tmpResult;
        _tmpResult = _cursor.getString(_cursorIndexOfResult);
        _item.setResult(_tmpResult);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
