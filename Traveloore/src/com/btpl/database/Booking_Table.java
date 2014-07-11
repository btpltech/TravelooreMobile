package com.btpl.database;

import android.provider.BaseColumns;

public class Booking_Table
{
public static final String _id = BaseColumns._ID;
public static final String booking_id="booking_id";
public static final String booking_number = "booking_number";
public static final String booking_date = "booking_date";
public static final String start_date = "start_date";
public static final String end_date = "end_date";
public static final String advance_amount = "advance_amount";
//public static final String owner = "owner";
public static final String salutation="salutation";
public static final String total_amount = "total_amount";
public static final String customer_id = "customer_id";

public static final String customer_name="customer_name";
public static final String gender = "gender";
//public static final String fax = "fax";

public static final String address = "address";
public static final String city = "city";
public static final String state = "state";
public static final String country = "country";
public static final String zip_code = "zip_code";
public static final String phone="phone";
public static final String email = "email";
public static final String id_type="id_type";
public static final String id_number="id_number";
public static final String package_id = "package_id";
public static final String package_name= "package_name";
public static final String adults = "adults";
public static final String child = "child";
public static final String description="description";
public static final String synchId= "synch_Id";
public static final String perticularBooking= "perti_book";
public static final String synchPerti= "combo";


public static final String TABLE_NAME = "booking_table";

public static final String my_booking_sql = "CREATE TABLE " + TABLE_NAME + "( "
		+ _id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + booking_id
		+ " TEXT, " + booking_number + " TEXT, " + booking_date
		+ " TEXT, " + start_date + " TEXT, " + end_date + " TEXT, " + advance_amount + " TEXT, "  + salutation +" TEXT ,"
		+ total_amount + " TEXT, " + customer_id + " TEXT, " + customer_name + " TEXT, " + gender + " TEXT, " 
		+ address + " TEXT, " + city + " TEXT, " + state + " TEXT," + country +" TEXT, " + zip_code + " TEXT, "
		+ phone + " TEXT ,"+ email + " TEXT ," + id_type + " TEXT ," + id_number + " TEXT ,"+package_id + " TEXT ,"+ package_name + " TEXT ,"+ adults + " TEXT ,"+child+ " TEXT ,"
		+description + " TEXT , " + synchId + " TEXT , " + perticularBooking + " TEXT , " + synchPerti + " TEXT);";
}
