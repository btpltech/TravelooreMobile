package com.btpl.database;

import android.provider.BaseColumns;

public class Dashboard_Table {

		public static final String dashBoard_id = BaseColumns._ID;
		public static final String activity = "activity";
		public static final String date = "date";
		
		public static final String TABLE_NAME = "dashboard_table";
		
		public static final String my_dashboard_sql = "CREATE TABLE " + TABLE_NAME
				+ "( " + dashBoard_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + activity
				+ " TEXT NOT NULL, " 
				+ date + " DATE);";
	}

