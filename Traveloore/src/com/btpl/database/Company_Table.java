package com.btpl.database;

import android.provider.BaseColumns;

public class Company_Table {
	public static final String company_id = BaseColumns._ID;
	public static final String company = "company";
	public static final String industry = "industry";
	public static final String owner = "owner";
	public static final String email_id = "email_id";
	public static final String phone_no = "phone_no";
	public static final String website = "website";
	public static final String address = "address";
	public static final String region_code = "region_code";
	public static final String country = "country";
	public static final String facebook = "facebook";
	public static final String twitter = "twitter";
	public static final String linked_in = "liked_in";
	public static final String skype = "skype";
	public static final String description = "description";
	public static final String table_type = "table_type";
	
	public static final String TABLE_NAME = "company_table";
	
	public static final String my_company_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ company_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + company
			+ " TEXT, " + industry + " TEXT, " + owner
			+ " TEXT, " + email_id + " TEXT, " + phone_no + " TEXT, " 
			+ website + " TEXT, " + address + " TEXT, " 
			+ region_code + " TEXT, " + country + " TEXT, " 
			+ facebook + " TEXT, " + twitter + " TEXT, " 
			+ linked_in + " TEXT, " + skype + " TEXT,"+ description +" TEXT,"+ table_type +" TEXT);";

}
