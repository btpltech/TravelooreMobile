package com.btpl.database;

import android.provider.BaseColumns;

public class Deal_Table {

	public static String deal_id = BaseColumns._ID;
	public static final String dealName = "deal_name";
	public static final String  priority= "priority";
    public static final String association = "association";
    public static final String value = "value";
    public static final String refferal = "refferal";
	public static final String tabletype="tabeType";
	public static final String cdate = "date";
	public static final String ctime="time";
	public static final String status="status";
	public static final String modified_date="modified_status";
	public static final String signinEmail="signin";
	
	
	public static final String TABLE_NAME = "deal_table";
	
	public static final String my_deal_sql = "CREATE TABLE " + TABLE_NAME
			+ "( " + deal_id + " INTEGER  PRIMARY KEY AUTOINCREMENT, " + dealName
			+ " TEXT,"+ priority +" TEXT,"+ association +" STRING,"+ value +" INTEGER NOT NULL,"+refferal+" TEXT,"
			+ cdate +" TEXT,"+ ctime +" TEXT,"+ tabletype +" TEXT,"+ status +" TEXT,"+ modified_date +" TEXT ," + signinEmail + " TEXT);";
}

