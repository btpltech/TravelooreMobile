package com.btpl.database;

import android.provider.BaseColumns;

public class ContactActivity_Table {

	public static final String contact_detail_activity_id= BaseColumns._ID;
	public static final String contact_detail_activities= "contact_activities";
	public static final String contact_detail_activity_date= "activity_date";
	public static final String contact_detail_activity_contact_table_id= "conact_table_id";
	
	public static final String ACTIVITY_TABLE_NAME = "contact_Activity_table";
	
	public static final String my_contact_activity_sql = "CREATE TABLE " + ACTIVITY_TABLE_NAME + "( "
			+ contact_detail_activity_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + contact_detail_activities
			+ " TEXT, " + contact_detail_activity_date + " DATE, " 
			+ contact_detail_activity_contact_table_id + " NUMERIC NOT NULL);";
}
