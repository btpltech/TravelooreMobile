package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Hotel_Details_Table {

	
	public static final String id = BaseColumns._ID;
	public static final String hotel_id = "hotel_id";
	public static final String hotel_name = "hotel_name";
	public static final String city_name = "city_name";
	public static final String address = "address";
	public static final String stars = "stars";
	public static final String hotel  = "hotel";
	public static final String synchId  = "synchId";
	


	public static final String TABLE_NAME = "booking_hotel_table";
	
	public static final String my_booking_hotel_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + hotel_id
			+ " TEXT, " + hotel_name + " TEXT, " + city_name
			+ " TEXT, " + address + " TEXT, " + stars + " TEXT, " 
			+ hotel + " TEXT, " + synchId + " TEXT);";

}
