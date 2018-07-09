package com.example.toni.spscanner.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.HashSet;

public class ScanRoomDatabase_Impl extends ScanRoomDatabase {
  private volatile ScanDao _scanDao;

  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `scan_table` (`id` TEXT NOT NULL, `scannedValue` TEXT, `time` TEXT, `result` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"220a593a855284d5daeb4179907208bd\")");
      }

      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `scan_table`");
      }

      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsScanTable = new HashMap<String, TableInfo.Column>(4);
        _columnsScanTable.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsScanTable.put("scannedValue", new TableInfo.Column("scannedValue", "TEXT", false, 0));
        _columnsScanTable.put("time", new TableInfo.Column("time", "TEXT", false, 0));
        _columnsScanTable.put("result", new TableInfo.Column("result", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysScanTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesScanTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoScanTable = new TableInfo("scan_table", _columnsScanTable, _foreignKeysScanTable, _indicesScanTable);
        final TableInfo _existingScanTable = TableInfo.read(_db, "scan_table");
        if (! _infoScanTable.equals(_existingScanTable)) {
          throw new IllegalStateException("Migration didn't properly handle scan_table(com.example.toni.spscanner.model.Scan).\n"
                  + " Expected:\n" + _infoScanTable + "\n"
                  + " Found:\n" + _existingScanTable);
        }
      }
    }, "220a593a855284d5daeb4179907208bd");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "scan_table");
  }

  @Override
  public ScanDao scanDao() {
    if (_scanDao != null) {
      return _scanDao;
    } else {
      synchronized(this) {
        if(_scanDao == null) {
          _scanDao = new ScanDao_Impl(this);
        }
        return _scanDao;
      }
    }
  }
}
