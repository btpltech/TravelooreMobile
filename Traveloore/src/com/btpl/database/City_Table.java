package com.btpl.database;

import android.provider.BaseColumns;

public class City_Table {

	public static final String id = BaseColumns._ID;
	public static final String source_city = "source_city";
	public static final String destination_city = "destination_city";
	public static final String package_ids = "package_ids";

	public static final String TABLE_NAME = "Travel_City";

	public static final String my_city_sql = "CREATE TABLE " + TABLE_NAME
			+ "( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + source_city
			+ " TEXT NOT NULL, " + destination_city + " TEXT NOT NULL, "
			+ package_ids + " TEXT NOT NULL);";
}
