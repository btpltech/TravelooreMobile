package com.btpl.database;

import android.provider.BaseColumns;

public class NLead_Table
{
public static final String lead_id = BaseColumns._ID;
public static final String firstname = "firstname";
public static final String lastname = "lastname";
public static final String company = "company";
public static final String title = "title";
public static final String industry = "industry";
//public static final String owner = "owner";

public static final String phone_no = "phone_no";
public static final String emailAddress = "email_address";

public static final String website = "webiste";
public static final String address = "postal_address";
//public static final String fax = "fax";

public static final String facebook = "facebook";
public static final String twitter = "twitter";
public static final String linked_in = "linked_in";
public static final String skype = "skype";
public static final String description = "description";
public static final String modified_date_time = "modified_date";
public static final String generated_code = "code";
public static final String status = "status";
public static final String signinEmail="signin";




//public static final String street = "street";
//public static final String city = "city";
//public static final String region = "industry";
//public static final String postal_code = "postal_address";

public static final String table_type = "table_type";
public static final String date_time= "date_time";
public static final String TABLE_NAME = "add_lead_table";

public static final String my_lead_sql = "CREATE TABLE " + TABLE_NAME + "( "
		+ lead_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + firstname
		+ " TEXT, " + lastname + " TEXT, " + company
		+ " TEXT, " + title + " TEXT, " + industry + " TEXT, " + emailAddress + " TEXT, " 
		+ phone_no + " TEXT, " + website + " TEXT, " 
		+ address + " TEXT, " 
		+ facebook + " TEXT, " + twitter + " TEXT, " 
		+ linked_in + " TEXT, " + skype + " TEXT," + description +" TEXT, " + table_type + " TEXT, " + date_time + " TEXT, " 
		+ modified_date_time + " TEXT, " + generated_code + " TEXT, " + status + " TEXT , " + signinEmail + " TEXT);";
}