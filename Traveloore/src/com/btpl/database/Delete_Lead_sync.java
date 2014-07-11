package com.btpl.database;

import android.provider.BaseColumns;

public class Delete_Lead_sync {
	
	public  static final String id= BaseColumns._ID;
	public static final String unique_code="unique_code";
	public static final String delete_status="delete_status";
	public static final String signinEmail = "signin";
	
public static final String TABLE_NAME = "sync_delete_lead";
	
	public static final String my_sync_delete = "CREATE TABLE " + TABLE_NAME
			+ "( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + unique_code + " TEXT, " + delete_status + " TEXT ," 
			+ signinEmail + " TEXT);";

}


