package com.btpl.database;

import android.provider.BaseColumns;

public class Stay_Table {

	public static final String id = BaseColumns._ID;
	public static final String stay_id="stay_id";
	public static final String stay_city = "stay_city";
	public static final String days = "validity";
	public static final String desc = "description";
	public static final String staySyncId="syncId";
	public static final String table_type = "stay";
	
	
	public static final String TABLE_NAME = "stay_table";
	
	public static final String my_stay_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + stay_id
			+ " TEXT, " + stay_city + " TEXT, " + days
			+ " TEXT, " + desc + " TEXT ," + staySyncId + " TEXT);";
	
}