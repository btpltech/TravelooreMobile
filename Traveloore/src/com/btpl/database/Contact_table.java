package com.btpl.database;

import android.provider.BaseColumns;

public class Contact_table {

	public static String contact_id = BaseColumns._ID;
	public static final String firstname = "firstname";
	public static final String lastname = "lastname";
	public static final String company = "company";
	public static final String title = "title";
	public static final String industry = "industry";
	public static final String phone_no = "phone_no";
	public static final String facebook = "facebook";
	public static final String twitter = "twitter";
	public static final String linked_in = "linked_in";
	public static final String skype = "skype";
	public static final String address = "address";
	public static final String emailid = "emailid";
	public static final String website = "website";
	public static final String description = "description";
	public static final String table_type = "table_type";
	public static final String generated_code = "code";
	public static final String status = "status";
	public static final String modified_status="modified_status";
	
	public static final String signinEmail = "signin";
	public static final String synchId = "synchId";
	
	public static final String TABLE_NAME = "contact_table";
	
	
	public static final String my_contact_sql = "CREATE TABLE " + TABLE_NAME + "( "
			+ contact_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + firstname
			+ " TEXT, " + lastname + " TEXT, " + company
			+ " TEXT, " + title + " TEXT, " + industry + " TEXT, " 
			+ phone_no + " TEXT, " + facebook + " TEXT, " 
			+ twitter + " TEXT, " + linked_in + " TEXT, " 
			+ skype + " TEXT, " + address + " TEXT, " 
			+ emailid + " TEXT, " + website + " TEXT, " 
			+ description + " TEXT, " + table_type + " TEXT, " + generated_code + " TEXT, " + status + " TEXT, "
			+ modified_status + " TEXT ," + signinEmail + " TEXT , " + synchId + " TEXT);";




	// ------------ for note table , columns are following ---------
	
		public static final String contact_detail_notes_id= BaseColumns._ID;
		public static final String contact_detail_notes= "contact_notes";
		public static final String contact_detail_notes_date= "note_date";
		public static final String contact_detail_notes_contact_table_id= "conact_table_id";
		public static final String contact_detail_notes_table_type= "deal_type";

		
		public static final String NOTE_TABLE_NAME = "contact_Note_table";
		
		public static final String my_contact_note_sql = "CREATE TABLE " + NOTE_TABLE_NAME + "( "
				+ contact_detail_notes_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + contact_detail_notes
				+ " TEXT, " + contact_detail_notes_date + " DATE, " 
				+ contact_detail_notes_contact_table_id + " TEXT NOT NULL," + contact_detail_notes_table_type
				+ " TEXT);";

		
		public static final String contact__notes_id= BaseColumns._ID;
		public static final String contact__notes= "contact_notes_lead";
		public static final String contact__notes_table_type= "lead_type";

		
		public static final String NOTE_TABLE_NAME_LEAD = "lead_Note_table";
		
		public static final String my_lead_note_sql = "CREATE TABLE " + NOTE_TABLE_NAME_LEAD + "( "
				+ contact__notes_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + contact__notes
				+ " TEXT," + contact__notes_table_type
				+ " TEXT);";

		
	}
