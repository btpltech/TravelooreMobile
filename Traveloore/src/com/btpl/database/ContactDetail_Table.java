package com.btpl.database;

import android.provider.BaseColumns;

public class ContactDetail_Table {

	public static final String id = BaseColumns._ID;
	public static final String content = "content";
	public static final String content_type = "content_type";
	public static final String contact_rowid = "contact_rowid";
	public static final String date = "date";
	
	public static final String TABLE_NAME = "ContactDetail_Table";
	
	public static final String contactdetail_sql_query = "CREATE TABLE " + TABLE_NAME
			+ "( " + id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + content
			+ " TEXT, " + content_type + " TEXT, "
			+ contact_rowid + " TEXT NOT NULL, " + date + " DATE);";
}
