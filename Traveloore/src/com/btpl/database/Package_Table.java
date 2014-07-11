package com.btpl.database;

import android.provider.BaseColumns;

public class Package_Table {

	public static final String id = BaseColumns._ID;
	public static final String package_id = "package_id";
	public static final String package_name = "package_name";
	public static final String adults = "adults";
	public static final String children = "children";
	public static final String package_description = "description";
	public static final String date = "date";

	public static final String table_type = "package";
	
	public static final String TABLE_NAME = "package_table";
	
	public static final String my_package_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + package_id
			+ " TEXT, " + package_name + " TEXT, " + adults
			+ " TEXT, " + children + " TEXT, " + package_description + " TEXT, " + date + " TEXT);";
	









}
