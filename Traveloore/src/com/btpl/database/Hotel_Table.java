package com.btpl.database;

import android.provider.BaseColumns;

public class Hotel_Table {

	public static final String id = BaseColumns._ID;
	public static final String hotel_id="hotel_id";
	public static final String hotel = "hotel_name";
	public static final String hotel_address = "address";
	public static final String hotel_city="hotel_city";
	public static final String stars = "stars";
	public static final String hotelSyncId="id";
	public static final String hotel_package  = "hotel_package";
	
	public static final String TABLE_NAME = "hotel_table";
	
	public static final String my_hotel_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + hotel_id
			+ " TEXT, " + hotel + " TEXT, " + hotel_address
			+ " TEXT, " + hotel_city + " TEXT, " + stars + " TEXT , " + hotelSyncId + " TEXT , " + hotel_package + " TEXT);";
	
}