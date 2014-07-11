package com.btpl.database;

import android.provider.BaseColumns;

public class SynchronizationTable {

	public static final String company_id = BaseColumns._ID;
	public static final String SynchronizationId = "Id";
	
	
	public static final String TABLE_NAME = "synchronize_table";
	
	public static final String synchronize_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ company_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SynchronizationId
			+ " TEXT);";

}
