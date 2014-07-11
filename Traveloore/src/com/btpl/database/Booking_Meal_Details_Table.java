package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Meal_Details_Table {

	public static final String id = BaseColumns._ID;
	public static final String synchId = "synch_Id";
	public static final String mealtype_id = "meal_id";
	public static final String mealtype_name = "meal_name";
	public static final String price = "price";
	


	public static final String TABLE_NAME = "booking_meal_table";
	
	public static final String my_booking_meal_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + synchId
			+ " TEXT, " + mealtype_id + " TEXT, " + mealtype_name
			+ " TEXT, " + price + " TEXT);";

	
}
