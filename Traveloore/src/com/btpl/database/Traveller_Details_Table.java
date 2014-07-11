package com.btpl.database;

import android.provider.BaseColumns;

public class Traveller_Details_Table {

	public static final String id = BaseColumns._ID;
	public static final String traveller_id = "traveller_id";
	public static final String t_salutation = "salutation";
	public static final String t_gender = "gender";
	public static final String t_address = "address";
	public static final String t_country = "country";
	public static final String t_m_no = "mobile_no";
	public static final String t_id_type = "id_type";
	public static final String t_city_name = "city_name";
	public static final String t_zipcode = "zip_code";
	public static final String traveller_name = "traveller_name";
	public static final String t_email = "email";
	public static final String t_id_num = "id_num";
	public static final String t_state_name = "state_name";
	public static final String synch_Id = "synch_id";
	public static final String traveller = "traveller";
	public static final String synchPerti= "combo";

	

	
	public static final String TABLE_NAME = "traveller_table";
	
	public static final String my_traveller_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + traveller_id
			+ " TEXT, " + t_salutation + " TEXT, " + t_gender
			+ " TEXT, " + t_address + " TEXT, " + t_country + " TEXT, " 
			+ t_m_no + " TEXT, " + t_id_type + " TEXT, " 
			+ t_city_name + " TEXT, " + t_zipcode + " TEXT, " 
			+ traveller_name + " TEXT, " + t_email + " TEXT, " 
			+ t_id_num + " TEXT, " + t_state_name + " TEXT, " + synch_Id + " TEXT, " + traveller + " TEXT , " + synchPerti + " TEXT);";

}
