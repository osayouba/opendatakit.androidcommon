package org.opendatakit.common.android.provider;

import android.provider.BaseColumns;

public class TableDefinitionsColumns implements BaseColumns {

  public static final String TABLE_ID = "table_id";
  public static final String TABLE_KEY = "table_key";
  public static final String DB_TABLE_NAME = "db_table_name";
  // DB_TYPE entries must be one of the types defined in TableType.
  public static final String TYPE = "type";
  public static final String TABLE_ID_ACCESS_CONTROLS = "table_id_access_controls";
  public static final String SYNC_TAG = "sync_tag";
  public static final String LAST_SYNC_TIME = "last_sync_time";
  public static final String SYNC_STATE = "sync_state";
  public static final String TRANSACTIONING = "transactioning";

  // This class cannot be instantiated
  private TableDefinitionsColumns() {
  }

  public static String getTableCreateSql(String tableName) {
    //@formatter:off
    String create = "CREATE TABLE IF NOT EXISTS " + tableName + "("
				+ TABLE_ID + " TEXT NOT NULL PRIMARY KEY, "
				+ TABLE_KEY	+ " TEXT NOT NULL UNIQUE, "
				+ DB_TABLE_NAME + " TEXT NOT NULL UNIQUE, "
				+ TYPE + " TEXT NOT NULL, "
				+ TABLE_ID_ACCESS_CONTROLS + " TEXT NULL, "
				+ SYNC_TAG + " TEXT NULL,"
				// TODO last sync time should probably become an int?
				+ LAST_SYNC_TIME + " TEXT NOT NULL, "
				+ SYNC_STATE + " TEXT NOT NULL, "
				+ TRANSACTIONING + " INTEGER NOT NULL" + ")";
    //@formatter:on
    return create;
  }

}
