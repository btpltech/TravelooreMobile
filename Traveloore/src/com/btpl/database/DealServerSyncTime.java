package com.btpl.database;

import android.provider.BaseColumns;

public class DealServerSyncTime {

	public static final String deal_synch_id = BaseColumns._ID;
	public static final String deal_ServersynchId = "Id";
	public static final String signinEmail = "signin";
	
	public static final String TABLE_NAME = "deal_server_synchronize_table";
	
	public static final String deal_synchronize_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ deal_synch_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + deal_ServersynchId
			+ " TEXT ," + signinEmail + " TEXT);";

}
