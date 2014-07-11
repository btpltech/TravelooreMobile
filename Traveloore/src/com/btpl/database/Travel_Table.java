package com.btpl.database;

import android.provider.BaseColumns;

public class Travel_Table {

	public static final String id = BaseColumns._ID;
	public static final String travel_id="travel_id";
	public static final String travel_mode = "travel_mode";
	public static final String source = "source_city";
	public static final String destination = "destination_city";
	public static final String travel = "travel";

	public static final String day_seq = "day_seq";
	public static final String price = "price";
	public static final String travelSyncId="SyncId";

	
	public static final String table_type = "travel";
	
	public static final String TABLE_NAME = "travel_table";
	
	public static final String my_travel_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + travel_id
			+ " TEXT, " + travel_mode + " TEXT, " + source
			+ " TEXT, " + destination + " TEXT, " + travel + " TEXT, " + day_seq + " TEXT, " + price + " TEXT ,"
			+ travelSyncId + " TEXT);";
	

	
}
