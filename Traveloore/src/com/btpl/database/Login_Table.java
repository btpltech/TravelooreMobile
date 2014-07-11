package com.btpl.database;

import android.provider.BaseColumns;

public class Login_Table {

	public static final String login_id = BaseColumns._ID;
	public static final String username = "username";
	public static final String password = "password";
	public static final String emailid = "emailid";
	public static final String phoneno = "phoneno";

	public static final String TABLE_NAME = "login_table";

	public static final String my_login_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ login_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + username
			+ " TEXT NOT NULL, " + password + " TEXT NOT NULL, " + emailid
			+ " TEXT NOT NULL, " + phoneno + " NUMERIC);";
}
