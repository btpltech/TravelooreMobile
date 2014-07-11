package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Room_Details_Table {

	public static final String id = BaseColumns._ID;
	public static final String synchId = "synch_Id";
	public static final String roomtype_id = "room_id";
	public static final String roomtype_name = "room_name";
	public static final String price = "price";
	


	public static final String TABLE_NAME = "booking_room_table";
	
	public static final String my_booking_room_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + synchId
			+ " TEXT, " + roomtype_id + " TEXT, " + roomtype_name
			+ " TEXT, " + price + " TEXT);";


}
