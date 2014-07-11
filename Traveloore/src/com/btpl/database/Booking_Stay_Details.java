package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Stay_Details {

	public static final String id = BaseColumns._ID;
	public static final String stay_id = "stay_id";
	public static final String day_seq = "day_seq";
	public static final String name = "name";
	public static final String city = "city";
	public static final String desc = "desc";
	public static final String synch_Id = "synch_Id";
	public static final String stay = "stay";
	public static final String synchPerti= "combo";



	public static final String TABLE_NAME = "booking_stay_table";
	
	public static final String my_booking_stay_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + stay_id
			+ " TEXT, " + day_seq + " TEXT, " + name
			+ " TEXT, " + city + " TEXT, " + desc + " TEXT, " 
			+ synch_Id + " TEXT, " + stay + " TEXT, " + synchPerti + " TEXT);";

}
