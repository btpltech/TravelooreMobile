package com.btpl.database;

import android.provider.BaseColumns;

public class ContactServerSynchTIme {
	public static final String contact_synch_id = BaseColumns._ID;
	public static final String Contact_ServersynchId = "Id";
	public static final String signinEmail="signin";
	
	public static final String TABLE_NAME = "server_synchronize_table";
	
	public static final String synchronize_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ contact_synch_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Contact_ServersynchId
			+ " TEXT ," + signinEmail + " TEXT);";

}
