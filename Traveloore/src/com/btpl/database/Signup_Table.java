package com.btpl.database;

import android.provider.BaseColumns;

public class Signup_Table {

	public static final String signup_id = BaseColumns._ID;
	public static final String name = "name";
	public static final String username="username";
    public static final String password = "password";
    public static final String confirmpassword = "confirmpassword";
    public static final String emailAddress = "emailAddress";
    public static final String mobileNumber = "mobileNumber";
	public static final String tabletype="signup";
	public static final String status="status";
	
	public static final String TABLE_NAME = "signup_table";
	
	public static final String my_sigup_sql = "CREATE TABLE " + TABLE_NAME
			+ "( " + signup_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + name
			+ " TEXT NOT NULL," + username + " TEXT NOT NULL ,"+ password +" TEXT NOT NULL,"+ confirmpassword +" TEXT NOT NULL,"+ emailAddress +" TEXT NOT NULL,"
			+mobileNumber+ " TEXT NOT NULL,"+ tabletype +" TEXT NOT NULL," + status + " TEXT);";
}

