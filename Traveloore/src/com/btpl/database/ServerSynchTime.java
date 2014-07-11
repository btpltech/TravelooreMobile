package com.btpl.database;

import android.provider.BaseColumns;

public class ServerSynchTime {
	public static final String synch_id = BaseColumns._ID;
	public static final String ServersynchId = "Id";
	public static final String signinEmail = "signin";
	
	
	public static final String TABLE_NAME = "server_synchronize_table";
	
	public static final String synchronize_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ synch_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ServersynchId
			+ " TEXT ," + signinEmail + " TEXT);";

}
