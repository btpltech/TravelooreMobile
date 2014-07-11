package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Amenity_Details_Table {

	public static final String id = BaseColumns._ID;
	public static final String synchId = "synch_Id";
	public static final String amount = "amount";
	public static final String description = "description";
	public static final String amenity_name = "amenity";
	


	public static final String TABLE_NAME = "booking_amenity_table";
	
	public static final String my_booking_amenity_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + synchId
			+ " TEXT, " + amount + " TEXT, " + description
			+ " TEXT, " + amenity_name + " TEXT);";

}
