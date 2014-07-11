package com.btpl.database;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.provider.BaseColumns;
import android.widget.Toast;

public class MyDatabaseProvider extends ContentProvider {

	private static final String AUTHORITY = "com.btpl.database.MyDbProvider";
	private static final String BASEPATH = "contact_table";
	
	
	public static final Uri DASHBOARD_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + "dashBOARD_TABLE");
	//public static final Uri NOTES_CONTENT_URI = Uri.parse("content://"
			//+ AUTHORITY + "/" + "contact_Note_table");
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			+ "/" + BASEPATH);
	public static final Uri DEAL_CONTENT_URI = Uri.parse("content://" +AUTHORITY + "/" +"deal_table");
	public static final Uri ADDTASK_CONTENT_URI = Uri.parse("content://" +AUTHORITY+ "/" +"addtask_table");
	//public static final Uri ACTIVITY_CONTENT_URI = Uri.parse("content://"
			//+ AUTHORITY + "/contact_Activity_table");
	public static final Uri SIGNUP_CONTENT_URI = Uri.parse("content://" +AUTHORITY + "/" +"signup_table");
	
	public static final Uri NOTES_CONTENT_URI = Uri.parse("content://"
			+ AUTHORITY + "/" + "contact_notes");
	//public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
			//+ "/" + "contact_table");
	public static final Uri ACTIVITY_CONTENT_URI = Uri.parse("content://"
			+ AUTHORITY + "/contact_Activity_table");
	public static final Uri ADDPACKAGE_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "package_table");
	public static final Uri STAY_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "stay_table");
	public static final Uri HOTEL_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "hotel_table");
	public static final Uri TRAVEL_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "travel_table");
	public static final Uri TRAVELLER_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "traveller_table");
	public static final Uri BOOKING_STAY_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_stay_table");

	
	public static final Uri ADD_COMPANY_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "company_table");
	//public static final Uri CONTACT_REGARDING_DEAL_CONTENT_URI=Uri.parse("content://" + AUTHORITY
	//		+ "/" + BASEPATH);
	public static final Uri LEAD_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "add_lead_table");
	public static final Uri SYNCH_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "synchronize_table");
	public static final Uri DELETE_LEAD_SYNC_URI=Uri.parse("content://" + AUTHORITY+"/" + "sync_delete_lead");
	public static final Uri DELETE_CONTACT_SYNC_URI=Uri.parse("content://"+AUTHORITY+"/" + "sync_delete_contact");

	public static final Uri LEAD_SERVER_SYNC=Uri.parse("content://"+AUTHORITY+"/" + "server_synchronize_table");
	public static final Uri DEAL_SERVER_SYNC=Uri.parse("content://"+AUTHORITY+"/" + "deal_server_synchronize_table");
	public static final Uri NOTES_CONTENT_URI_LEAD = Uri.parse("content://"
			+ AUTHORITY + "/" + "contact_notes_lead");
	public static final Uri BOOKING_TRAVEL_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_travel_table");
	public static final Uri BOOKING_HOTEL_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_hotel_table");
	public static final Uri BOOKING_MEAL_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_meal_table");
	public static final Uri BOOKING_ROOM_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_room_table");
	public static final Uri BOOKING_AMENITY_CONTENT_URI=Uri.parse("content://"+AUTHORITY+"/" + "booking_amenity_table");
	
	public static final Uri BOOKING_CONTENT_URI = Uri.parse("content://"
			+ AUTHORITY + "/" + "booking_table");
	private static final int contact_id = 2;
	private static final int contacts = 3;
	private static final int dashboard_id = 11;
	private static final int dashboards = 12;
	private static final int deal= 2;
	private static final int addTask=4;
	private static final int task_id=5;
	//private static final int activity_id = 31;
	//private static final int activities = 32;
	private static final int company_activity=7;
	private static final int signup_activity=6;
	//private static final int notepad_activity=7;
	private static final int notes_id = 21;
	private static final int notes = 22;
	private static final int activity_id = 31;
	private static final int activities = 32;
	private static final int add_package=54;
	private static final int add_hotel=55;
	private static final int add_stay=56;
	private static final int lead_entry=8;
	private static final int lead_id=9;
	private static final int deal_id=10;
	private static final int synch = 13;
	private static final int synch_id = 14;
	private static final int sync_delete=44;
    private static final int sync_delete_contact=45;
    private static final int sync_delete_id=46;
    private static final int synch_delete_contact_id=47;
    private static final int server_lead_id=49;
    private static final int server_deal_id=50;
    private static final int sign_up_id=51;
    private static final int notes_lead=52;
    private static final int notes_lead_id=53;
    private static final int booking=77;
    private static final int add_travel =57;
    private static final int add_traveller =58;
    private static final int add_booking_stay =59;
    private static final int add_booking_travel =60;
    private static final int add_booking_hotel =61;
    private static final int add_booking_room =62;
    private static final int add_booking_meal =63;
    private static final int add_booking_amenity =64;


	private static final UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(AUTHORITY, BASEPATH + "/#", contact_id);
		uriMatcher.addURI(AUTHORITY, BASEPATH, contacts);
		uriMatcher.addURI(AUTHORITY, "dashBOARD_TABLE" + "/#", dashboard_id);
		uriMatcher.addURI(AUTHORITY, "dashBOARD_TABLE", dashboards);
		uriMatcher.addURI(AUTHORITY,"deal_table", deal);
		uriMatcher.addURI(AUTHORITY, "addtask_table", addTask);
		uriMatcher.addURI(AUTHORITY, "addtask_table" + "/#", task_id);
		uriMatcher.addURI(AUTHORITY, "contact_Activity_table/#", activity_id);
		uriMatcher.addURI(AUTHORITY, "contact_Activity_table", activities);
		//uriMatcher.addURI(AUTHORITY, "contact_Note_table", note_activity);
		uriMatcher.addURI(AUTHORITY, "signup_table", signup_activity);
		uriMatcher.addURI(AUTHORITY, "signup_table" + "/#", sign_up_id);

		//uriMatcher.addURI(AUTHORITY,"contact_Note_table", notepad_activity);
		uriMatcher.addURI(AUTHORITY, "contact_notes" + "/#", notes_id);
		uriMatcher.addURI(AUTHORITY, "contact_notes", notes);
		
		uriMatcher.addURI(AUTHORITY, "contact_Activity_table/#", activity_id);
		uriMatcher.addURI(AUTHORITY, "contact_Activity_table", activities);
		uriMatcher.addURI(AUTHORITY, "package_table", add_package);
		uriMatcher.addURI(AUTHORITY, "hotel_table", add_hotel);
		uriMatcher.addURI(AUTHORITY, "stay_table", add_stay);
		
		uriMatcher.addURI(AUTHORITY, "company_table", company_activity);
		uriMatcher.addURI(AUTHORITY, "add_lead_table", lead_entry);
		uriMatcher.addURI(AUTHORITY, "add_lead_table" + "/#", lead_id);
		uriMatcher.addURI(AUTHORITY, "deal_table" + "/#", deal_id);
		uriMatcher.addURI(AUTHORITY, "synchronize_table", synch);

		uriMatcher.addURI(AUTHORITY, "synchronize_table" + "/#", synch_id);
		uriMatcher.addURI(AUTHORITY, "sync_delete_lead", sync_delete);
        uriMatcher.addURI(AUTHORITY,"sync_delete_contact",sync_delete_contact);
		uriMatcher.addURI(AUTHORITY, "sync_delete_lead" + "/#", sync_delete_id);
		uriMatcher.addURI(AUTHORITY, "sync_delete_contact" + "/#", synch_delete_contact_id);
		uriMatcher.addURI(AUTHORITY, "server_synchronize_table", server_lead_id);
		uriMatcher.addURI(AUTHORITY, "deal_server_synchronize_table", server_deal_id);
		uriMatcher.addURI(AUTHORITY, "contact_notes_lead" + "/#", notes_lead_id);
		uriMatcher.addURI(AUTHORITY, "contact_notes_lead", notes_lead);
		uriMatcher.addURI(AUTHORITY, "booking_table",booking);
		uriMatcher.addURI(AUTHORITY, "traveller_table",add_traveller);
		uriMatcher.addURI(AUTHORITY, "booking_stay_table",add_booking_stay);
		uriMatcher.addURI(AUTHORITY, "booking_travel_table",add_booking_travel);
		uriMatcher.addURI(AUTHORITY, "booking_hotel_table",add_booking_hotel);
		uriMatcher.addURI(AUTHORITY, "booking_room_table",add_booking_room);
		uriMatcher.addURI(AUTHORITY, "booking_meal_table",add_booking_meal);
		uriMatcher.addURI(AUTHORITY, "booking_amenity_table",add_booking_amenity);

	}	
	
	
	MyDbHelper dbHelper;
	
	
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		int my_uri = uriMatcher.match(uri);
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		
		long id = 0;
		String table_name;
		switch(my_uri) {
		case contacts:
			id = database.insert(Contact_table.TABLE_NAME, null, values);
			table_name="contact_table";
			break;
		case dashboard_id :
			break;
		case dashboards :
			id = database.insert(Contact_table.TABLE_NAME, null, values);
			break;
		case deal :
			id= database.insert(Deal_Table.TABLE_NAME, null, values);
			break;
		case addTask :
			id = database.insert(AddTask_Table.TABLE_NAME, null, values);
			break;
			
		case signup_activity :
			id = database.insert(Signup_Table.TABLE_NAME, null, values);
			break;
			
		case notes:
			id = database.insert(Contact_table.NOTE_TABLE_NAME, null, values);
			table_name = "contact_note";
			break;
		
		case notes_lead:
			id = database.insert(Contact_table.NOTE_TABLE_NAME_LEAD, null, values);
			table_name = "contact_notes_lead";
			break;
			
			
		case activities :
			id = database.insert(ContactActivity_Table.ACTIVITY_TABLE_NAME, null, values);
			table_name = "activity_table";
			break;
			
		case add_package:
			id=database.insert(Package_Table.TABLE_NAME, null, values);
			break;	
		
		case add_hotel:
			id=database.insert(Hotel_Table.TABLE_NAME, null, values);
			break;	
		
		case add_stay:
			id=database.insert(Stay_Table.TABLE_NAME, null, values);
			break;	
			
		case add_travel:
			id=database.insert(Travel_Table.TABLE_NAME, null, values);
			break;	
		
			
		case company_activity :
			id=database.insert(Company_Table.TABLE_NAME, null, values);
			break;
		case lead_entry :
			id=database.insert(NLead_Table.TABLE_NAME, null, values);
			break;
		
		case synch :
			id=database.insert(SynchronizationTable.TABLE_NAME, null, values);
			break;
			
		case sync_delete:
			id=database.insert(Delete_Lead_sync.TABLE_NAME, null, values);
			break;
		
		case sync_delete_contact:
			id=database.insert(Delete_contact_sync.TABLE_NAME, null, values);
			break;
			
		case server_lead_id:
			id=database.insert(ServerSynchTime.TABLE_NAME, null, values);
			break;
			
		case server_deal_id:
			id=database.insert(DealServerSyncTime.TABLE_NAME, null, values);
			break;
			
		case booking:
			id = database.insert(Booking_Table.TABLE_NAME, null, values);
			break;	
		
		case add_traveller:
			id = database.insert(Traveller_Details_Table.TABLE_NAME, null, values);
			break;	
		
		case add_booking_stay:
			id = database.insert(Booking_Stay_Details.TABLE_NAME, null, values);
			break;	
		case add_booking_travel:
			id = database.insert(Booking_Travel_Details_Table.TABLE_NAME, null, values);
			break;	
		
		case add_booking_hotel:
			id = database.insert(Booking_Hotel_Details_Table.TABLE_NAME, null, values);
			break;	
		
		case add_booking_room:
			id = database.insert(Booking_Room_Details_Table.TABLE_NAME, null, values);
			break;	
		case add_booking_meal:
			id = database.insert(Booking_Meal_Details_Table.TABLE_NAME, null, values);
			break;	
		
		case add_booking_amenity:
			id = database.insert(Booking_Amenity_Details_Table.TABLE_NAME, null, values);
			break;	
		
		}
		
		return uri.parse(AUTHORITY + "/" + id);
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		int my_uri = uriMatcher.match(uri);
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		
		int id = 0;
		//String table_name;
		switch(my_uri) {
		case contacts:
			id = database.delete(Contact_table.TABLE_NAME,selection,null);
			break;
		case deal:
			id=database.delete(Deal_Table.TABLE_NAME,selection,null);
			break;
		case addTask:
			id=database.delete(AddTask_Table.TABLE_NAME,selection,null);
			break;
		
		case lead_entry :
			id=database.delete(NLead_Table.TABLE_NAME, selection, null);
			break;
			
		case add_package :
			id=database.delete(Package_Table.TABLE_NAME, selection, null);
			break;	
		case add_hotel :
			id=database.delete(Hotel_Table.TABLE_NAME, selection, null);
			break;
		case add_stay :
			id=database.delete(Stay_Table.TABLE_NAME, selection, null);
			break;	
			
		case add_travel :
			id=database.delete(Travel_Table.TABLE_NAME, selection, null);
			break;	
		
		}
		return id;
	
	}

	

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		dbHelper = new MyDbHelper(getContext());
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Cursor c;
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
		//Toast.makeText(getContext(), "provider", Toast.LENGTH_LONG).show();
		int m_uri = uriMatcher.match(uri);
		switch (m_uri) {
		case contacts :
			//Toast.makeText(getContext(), "Real", Toast.LENGTH_LONG).show();
			builder.setTables(Contact_table.TABLE_NAME);
			c = builder.query(database, new String[] { Contact_table.contact_id,
					Contact_table.firstname,Contact_table.phone_no,Contact_table.emailid }, selection, null, null,null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);			
			break;			
		
		case deal :
			builder.setTables(Deal_Table.TABLE_NAME);
			//builder.appendWhere(Deal_Table.TABLE_NAME + " = "	+ uri.getLastPathSegment());
			c = builder.query(database,new String[] { Deal_Table.deal_id,
					Deal_Table.dealName, Deal_Table.priority,Deal_Table.association}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
		
		case addTask :
			builder.setTables(AddTask_Table.TABLE_NAME);
			c = builder.query(database, new String[] { AddTask_Table.addtask_id,
					AddTask_Table.description, AddTask_Table.date,AddTask_Table.time,AddTask_Table.fetch_task_lead,AddTask_Table.assignedto}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);			
			break;			
		
		case notes_lead :
			builder.setTables(Contact_table.NOTE_TABLE_NAME_LEAD);
			c = builder.query(database, new String[] {Contact_table.contact__notes_id,Contact_table.contact__notes}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);			
			break;			
				
			
		case notes:
			builder.setTables(Contact_table.NOTE_TABLE_NAME);
		    c = builder.query(database, projection, selection, null, null,null, null);
		    c.setNotificationUri(getContext().getContentResolver(), uri);
		    break;
		    
		case add_package:
			builder.setTables(Package_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Package_Table.id, Package_Table.package_id,
			Package_Table.package_name,Package_Table.adults, Package_Table.children,
			Package_Table.package_description}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
		
		case add_hotel:
			builder.setTables(Hotel_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Hotel_Table.id,Hotel_Table.hotel_id,Hotel_Table.hotel,
					                                 Hotel_Table.hotel_address,Hotel_Table.hotel_city,Hotel_Table.stars,Hotel_Table.hotelSyncId,Hotel_Table.hotel_package}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
			
		case add_stay:
			builder.setTables(Stay_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Stay_Table.id,Stay_Table.stay_id,Stay_Table.stay_city,Stay_Table.days}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
		
		
		case add_travel:
			builder.setTables(Travel_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Travel_Table.id,Travel_Table.travel_id,Travel_Table.travel_mode,
					Travel_Table.source,Travel_Table.destination}, selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
			
			
		case lead_entry:
			builder.setTables(NLead_Table.TABLE_NAME);
			c = builder.query(database,new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,NLead_Table.industry,
					 NLead_Table.phone_no,NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,NLead_Table.twitter,
					 NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
			
		case booking:
			builder.setTables(Booking_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Table._id,Booking_Table.booking_id,Booking_Table.booking_number,Booking_Table.booking_date,
					Booking_Table.start_date,Booking_Table.end_date,Booking_Table.advance_amount,Booking_Table.total_amount,
					Booking_Table.customer_id,Booking_Table.customer_name,Booking_Table.gender,Booking_Table.address,Booking_Table.city,
					Booking_Table.state,Booking_Table.country,Booking_Table.zip_code,Booking_Table.phone,Booking_Table.email,Booking_Table.package_id,
					Booking_Table.package_name,Booking_Table.adults,Booking_Table.child,Booking_Table.description,Booking_Table.synchId,
					Booking_Table.perticularBooking,Booking_Table.synchPerti},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
		
		case add_traveller:
			builder.setTables(Traveller_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Traveller_Details_Table.id,Traveller_Details_Table.traveller_id,
					Traveller_Details_Table.t_salutation,Traveller_Details_Table.t_gender,Traveller_Details_Table.t_address,
					Traveller_Details_Table.t_country,Traveller_Details_Table.t_m_no,Traveller_Details_Table.t_id_type,
					Traveller_Details_Table.t_city_name,Traveller_Details_Table.t_zipcode,Traveller_Details_Table.traveller_name,
					Traveller_Details_Table.t_email,Traveller_Details_Table.t_id_num,Traveller_Details_Table.t_state_name,
					Traveller_Details_Table.synch_Id,Traveller_Details_Table.traveller,Traveller_Details_Table.synchPerti},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;
		
			
		case add_booking_stay:
			builder.setTables(Booking_Stay_Details.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Stay_Details.id,Booking_Stay_Details.stay_id,
					Booking_Stay_Details.day_seq,Booking_Stay_Details.name,Booking_Stay_Details.city,Booking_Stay_Details.desc,
					Booking_Stay_Details.synch_Id,Booking_Stay_Details.stay,Booking_Stay_Details.synchPerti},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
			
		case add_booking_travel:
			builder.setTables(Booking_Travel_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Travel_Details_Table.id,Booking_Travel_Details_Table.synch_id,
					Booking_Travel_Details_Table.day_seq,Booking_Travel_Details_Table.mode,Booking_Travel_Details_Table.source,
					Booking_Travel_Details_Table.destination,Booking_Travel_Details_Table.itinerary_id,
					Booking_Travel_Details_Table.synchPerti},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
		
		case add_booking_hotel:
			builder.setTables(Booking_Hotel_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Hotel_Details_Table.id,
					Booking_Hotel_Details_Table.hotel_id,Booking_Hotel_Details_Table.hotel_name,
					Booking_Hotel_Details_Table.city_name,Booking_Hotel_Details_Table.address,
					Booking_Hotel_Details_Table.stars,Booking_Hotel_Details_Table.hotel,Booking_Hotel_Details_Table.synchId},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
		
		case add_booking_room:
			builder.setTables(Booking_Room_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Room_Details_Table.id,
					Booking_Room_Details_Table.synchId,Booking_Room_Details_Table.roomtype_id,
					Booking_Room_Details_Table.roomtype_name,Booking_Room_Details_Table.price},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
			
		case add_booking_meal:
			builder.setTables(Booking_Meal_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Meal_Details_Table.id,Booking_Meal_Details_Table.synchId,
					Booking_Meal_Details_Table.mealtype_id,Booking_Meal_Details_Table.mealtype_name,
					Booking_Meal_Details_Table.price},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
		
		case add_booking_amenity:
			builder.setTables(Booking_Amenity_Details_Table.TABLE_NAME);
			c = builder.query(database,new String[] {Booking_Amenity_Details_Table.id,Booking_Amenity_Details_Table.synchId,
					Booking_Amenity_Details_Table.amount,Booking_Amenity_Details_Table.description,Booking_Amenity_Details_Table.amenity_name},selection, null, null, null, null);
			c.setNotificationUri(getContext().getContentResolver(), uri);
			break;				
		
		default:
			throw new IllegalArgumentException("Unknown URI" + uri);
		}
			
		return c;
	}
	
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		switch (uriMatcher.match(uri)) {

		case notes_id:
			database.update(Contact_table.NOTE_TABLE_NAME, values, selection,
					null);
			break;
		
		case notes_lead_id:
			database.update(Contact_table.NOTE_TABLE_NAME_LEAD, values, selection,
					null);
			break;
				
			
		case contact_id:
			database.update(Contact_table.TABLE_NAME, values, selection,
					null);
			break;
			
		case lead_id :
			database.update(NLead_Table.TABLE_NAME, values, selection,
					null);
			break;
		
		case deal_id :
			database.update(Deal_Table.TABLE_NAME, values, selection,
					null);
			break;
		
		case task_id:
			database.update(AddTask_Table.TABLE_NAME, values,selection,null);
			break;
			
		case sync_delete_id :
			database.update(Delete_Lead_sync.TABLE_NAME, values,selection,null);
			break;
		
		case synch_delete_contact_id : 
			database.update(Delete_contact_sync.TABLE_NAME, values, selection, null);
	        break;
			
		case sign_up_id : 
			database.update(Signup_Table.TABLE_NAME, values, selection, null);
	        break;
		  
		default:
			throw new IllegalArgumentException("Unknown Uri " + uri);
		}
		getContext().getContentResolver().notifyChange(uri, null);
		return 0;
	}

}
