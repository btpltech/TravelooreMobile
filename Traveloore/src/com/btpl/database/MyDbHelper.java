package com.btpl.database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

	Context context;
	private static final String DATABASE_NAME = "DATABASECRM.db";
	public static final String DATABASE_TABLE_NAME = "package";
	private static final int DATABASE_VERSION = 22;

	public MyDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(NLead_Table.my_lead_sql);
		db.execSQL(Contact_table.my_contact_sql);
		db.execSQL(Deal_Table.my_deal_sql);
		db.execSQL(AddTask_Table.my_addtask_sql);
		db.execSQL(Package_Table.my_package_sql);
     	db.execSQL(Contact_table.my_contact_note_sql);
     	db.execSQL(Signup_Table.my_sigup_sql);
		db.execSQL(Company_Table.my_company_sql);
		db.execSQL(SynchronizationTable.synchronize_sql);
		db.execSQL(Delete_Lead_sync.my_sync_delete);
		db.execSQL(Delete_contact_sync.my_sync_delete_contact);
		db.execSQL(ServerSynchTime.synchronize_sql);
		db.execSQL(DealServerSyncTime.deal_synchronize_sql);
		db.execSQL(Contact_table.my_lead_note_sql);
		db.execSQL(Hotel_Table.my_hotel_sql);
		db.execSQL(Stay_Table.my_stay_sql);
		db.execSQL(Travel_Table.my_travel_sql);
		db.execSQL(Booking_Table.my_booking_sql);
		db.execSQL(Traveller_Details_Table.my_traveller_sql);
		db.execSQL(Booking_Stay_Details.my_booking_stay_sql);
		db.execSQL(Booking_Travel_Details_Table.my_booking_travel_sql);
		db.execSQL(Booking_Hotel_Details_Table.my_booking_hotel_sql);
		db.execSQL(Booking_Meal_Details_Table.my_booking_meal_sql);
		db.execSQL(Booking_Room_Details_Table.my_booking_room_sql);
		db.execSQL(Booking_Amenity_Details_Table.my_booking_amenity_sql);
		

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		if (newVersion > oldVersion) {
			//db.execSQL("DROP TABLE IF EXISTS " + Login_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS " + Contact_table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS " + Contact_table.NOTE_TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS " + NLead_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS " + Company_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS " + Signup_Table.TABLE_NAME);
			db.execSQL(" DROP TABLE IF EXISTS " +AddTask_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Deal_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Package_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + SynchronizationTable.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Delete_Lead_sync.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Delete_contact_sync.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + ServerSynchTime.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + DealServerSyncTime.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Contact_table.NOTE_TABLE_NAME_LEAD);
			db.execSQL("DROP TABLE IF EXISTS" + Hotel_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Stay_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Travel_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Traveller_Details_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Stay_Details.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Travel_Details_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Hotel_Details_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Room_Details_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Amenity_Details_Table.TABLE_NAME);
			db.execSQL("DROP TABLE IF EXISTS" + Booking_Meal_Details_Table.TABLE_NAME);

			onCreate(db);
		}
	}
}