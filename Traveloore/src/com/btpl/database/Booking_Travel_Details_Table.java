package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Travel_Details_Table {

	public static final String id = BaseColumns._ID;
	public static final String synch_id = "synch_id";
	public static final String day_seq = "day_seq";
	public static final String mode = "mode";
	public static final String source = "source";
	public static final String destination = "destination";
	public static final String itinerary_id = "itinerary_id";
	public static final String synchPerti= "combo";



	public static final String TABLE_NAME = "booking_travel_table";
	
	public static final String my_booking_travel_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + synch_id
			+ " TEXT, " + day_seq + " TEXT, " + mode
			+ " TEXT, " + source + " TEXT, " + destination + " TEXT, " 
			+ itinerary_id + " TEXT, " + synchPerti + " TEXT);";

}
