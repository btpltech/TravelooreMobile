package com.btpl.database;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.provider.BaseColumns;

public class MyDatabaseClass {
	

	Context ourContext;
	int totalDeals;

	public MyDatabaseClass(Context context) {
		this.ourContext = context;
	}

	MyDbHelper helper;
	SQLiteDatabase database;

	// open database
	public MyDatabaseClass open() throws SQLiteException {
		helper = new MyDbHelper(ourContext);
		database = helper.getWritableDatabase();
		return this;
	}

	// close database
	public void close() {
		database.close();
		helper.close();
	}

	// insert into package table
	public long insert_item(String user_name, String password, String emailid,
			String phoneno) {
		ContentValues cv = new ContentValues();

		cv.put(Login_Table.username, user_name);
		cv.put(Login_Table.password, password);
		cv.put(Login_Table.emailid, emailid);
		cv.put(Login_Table.phoneno, phoneno);

		return database.insert(Login_Table.TABLE_NAME, null, cv);
	}

	public long insert_into_dashboard_table(String activity) {
		ContentValues cv = new ContentValues();
		cv.put(Dashboard_Table.activity, activity);
		String string = (String) android.text.format.DateFormat.format(
				"dd-MM-yyyy hh:mm:ss", new java.util.Date());
		cv.put(Dashboard_Table.date, string);
		return database.insert(Dashboard_Table.TABLE_NAME, null, cv);
	}

	public long insert_contact_table(String firstname, String lastname,
			String company, String title, String industry, String emailid,
			String phoneno, String website, String address, String facebook,
			String twitter, String linkedin, String skype, String description,
			String table_type) {

		ContentValues cv = new ContentValues();
		cv.put(Contact_table.firstname, firstname);
		cv.put(Contact_table.lastname, lastname);
		cv.put(Contact_table.company, company);
		cv.put(Contact_table.title, title);
		cv.put(Contact_table.industry, industry);
		cv.put(Contact_table.emailid, emailid);
		cv.put(Contact_table.phone_no, phoneno);
		cv.put(Contact_table.website, website);
		cv.put(Contact_table.address, address);
		cv.put(Contact_table.facebook, facebook);
		cv.put(Contact_table.twitter, twitter);
		cv.put(Contact_table.linked_in, linkedin);
		cv.put(Contact_table.skype, skype);
		cv.put(Contact_table.description, description);
		cv.put(Contact_table.table_type, table_type);
		return database.insert(Contact_table.TABLE_NAME, null, cv);
	}

	public Cursor getCursorfromContactTable(String table_name) {
		String[] columns = new String[] { Contact_table.contact_id,
				Contact_table.firstname, Contact_table.lastname,
				Contact_table.company, Contact_table.title,
				Contact_table.address, Contact_table.emailid,
				Contact_table.table_type };
		return database.query(Contact_table.TABLE_NAME, columns,
				Contact_table.table_type + " = " + " '" + table_name + "'",
				null, null, null, null);
	}

	// fetch cursor object of package table
	public Cursor getCursor() {
		String[] columns = new String[] { Login_Table.login_id,
				Login_Table.username, Login_Table.password,
				Login_Table.emailid, Login_Table.phoneno };
		return database.query(Login_Table.TABLE_NAME, columns, null, null,
				null, null, null);
	}

		
	public int delete_row(int row_no) {
		//int row = database.delete(MyDbHelper.DATABASE_TABLE_NAME, null, null);
		return 0;
	}

	public String getPassword(String username) {
		String[] columns = new String[] { Login_Table.login_id,
				Login_Table.username, Login_Table.password,
				Login_Table.emailid, Login_Table.phoneno };
		Cursor cursor = database
				.query(Login_Table.TABLE_NAME, columns, Login_Table.username
						+ " = " + username, null, null, null, null);
		if (cursor != null) {
			cursor.moveToFirst();
			return cursor
					.getString(cursor.getColumnIndex(Login_Table.password));
		}
		return null;
	}

	/*public void insertIntoPackageTable(String p_name, String description,
			String package_validity, String package_no_of_persons) {
		// TODO Auto-generated method stub
		ContentValues cv = new ContentValues();
		cv.put(Package_Table.name, p_name);
		cv.put(Package_Table.meta_description, description);
		cv.put(Package_Table.package_validity, package_validity);
		cv.put(Package_Table.package_no_of_persons, package_no_of_persons);
		database.insertOrThrow(Package_Table.TABLE_NAME, null, cv);
	}*/

	public Cursor getCursorFromDashboardTable(String user) {
		// TODO Auto-generated method stub
		 String where=Deal_Table.signinEmail + " = '" + user + "'";
		String[] columns = new String[] {Deal_Table.deal_id,
				Deal_Table.dealName,Deal_Table.priority,Deal_Table.value,Deal_Table.cdate,Deal_Table.ctime};
		Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns,where,null,null,null,null);
		//String select = "SELECT" +(Deal_Table.dealName,Deal_Table.priority,Contact_table.firstname,Contact_table.lastname) +"FROM" +(Deal_Table.TABLE_NAME, Contact_table.TABLE_NAME) +"WHERE" +(Deal_Table.deal_id=Contact_table.contact_id);
		//Cursor cursor =database.rawQuery(select, null);
		return cursor;
	}

	
	public Cursor getCursorFromDashboardTable3() {
		// TODO Auto-generated method stub
		String[] columns = new String[] {NLead_Table.lead_id,
				NLead_Table.firstname,NLead_Table.lastname,NLead_Table.emailAddress};
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns,null,null,null,null,null);
		//String select = "SELECT" +(Deal_Table.dealName,Deal_Table.priority,Contact_table.firstname,Contact_table.lastname) +"FROM" +(Deal_Table.TABLE_NAME, Contact_table.TABLE_NAME) +"WHERE" +(Deal_Table.deal_id=Contact_table.contact_id);
		//Cursor cursor =database.rawQuery(select, null);
		return cursor;
	}
	
	public Cursor getCursorFromDashboardTable1() {
		// TODO Auto-generated method stub
		String[] columns = new String[] {Deal_Table.deal_id,
				Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.cdate,Deal_Table.ctime};
		Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns,null,null,null,null,null);
		//String select = "SELECT" +(Deal_Table.dealName,Deal_Table.priority,Contact_table.firstname,Contact_table.lastname) +"FROM" +(Deal_Table.TABLE_NAME, Contact_table.TABLE_NAME) +"WHERE" +(Deal_Table.deal_id=Contact_table.contact_id);
		//Cursor cursor =database.rawQuery(select, null);
		return cursor;
	}
	
	
	/*public Cursor getCursorFromPackageTable() {
		// TODO Auto-generated method stub
		String[] columns = new String[] { Package_Table.package_id
				Package_Table.name, Package_Table.meta_description,
				Package_Table.package_validity,
				Package_Table.package_no_of_persons };

		return database.query(Package_Table.TABLE_NAME, columns, null, null,
				null, null, null);
	}*/

	int i = 0;
	ArrayList<String> str = new ArrayList<String>();
	public ArrayList<String> getFirstName(String user)
	{
		String where=Contact_table.signinEmail +  " = '" + user + "'"; 
		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname};
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			str = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				str.add(cursor.getString(1));
				cursor.moveToNext();
				i++;
			}
		    return str;
		}
		return null;
}

	int j = 0;
	ArrayList<String> str1 = new ArrayList<String>();
	
	public ArrayList<String> getOwner(String user)
	{

		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname};
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			str1 = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				str1.add(cursor.getString(1));
				cursor.moveToNext();
				j++;
			}
		    return str1;
		}
		return null;
}
	
	
	int a=0;
	ArrayList<String> str2=new ArrayList<String>();
	public ArrayList<String> getAllDeals(String user)
	{
		String[] columns=new String[] {Deal_Table.deal_id,Deal_Table.dealName};
		Cursor cursor=database.query(Deal_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			str2=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			str2.add(cursor.getString(1));
			cursor.moveToNext();
			a++;
		}
		return str2;
		}
		return null;
     	
}
	
	int b=0;
	ArrayList<String> str3=new ArrayList<String>();
	public ArrayList<String> getfirstNameLead(String user)
	{
		String[] columns=new String[] {NLead_Table.lead_id,NLead_Table.firstname};
		Cursor cursor=database.query(NLead_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			str2=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			str2.add(cursor.getString(1));
			cursor.moveToNext();
			a++;
		}
		return str2;
		}
		return null;
     	
}
	
	//int p=0;
	//String =new ArrayList<String>();
	
	
	
	
	/*
	int y=0;
	ArrayList<String> getEmail=new ArrayList<String>();
	public ArrayList<String> checkEmail()
	{
		String[] columns=new String[] {Signup_Table.signup_id,Signup_Table.name,Signup_Table.password,Signup_Table.confirmpassword,Signup_Table.emailAddress};
		Cursor cursor=database.query(Signup_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			getEmail=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			getEmail.add(cursor.getString(4));
			cursor.moveToNext();
			y++;
		}
		return getEmail;
		}
		return null;
     	
}
*/
	int y=0;
	ArrayList<String> getEmail=new ArrayList<String>();
	public ArrayList<String> checkUser()
	{
		String[] columns=new String[] {Signup_Table.signup_id,Signup_Table.name,Signup_Table.username,Signup_Table.password,Signup_Table.confirmpassword,Signup_Table.emailAddress};
		Cursor cursor=database.query(Signup_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			getEmail=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			getEmail.add(cursor.getString(2));
			cursor.moveToNext();
			y++;
		}
		return getEmail;
		}
		return null;
	}	
	int z=0;
	ArrayList<String> contactKeLiye=new ArrayList<String>();
	public ArrayList<String> checkContactPhone(String user)
	{
		String[] columns=new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no};
		Cursor cursor=database.query(Contact_table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			contactKeLiye=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			contactKeLiye.add(cursor.getString(6));
			cursor.moveToNext();
			z++;
		}
		return contactKeLiye;
		}
		return null;
     	
}
	
	int e=0;
	ArrayList<String> companyKeLiye=new ArrayList<String>();
	public ArrayList<String> checkCompanyTable_CompanyName(String user)
	{
		String[] columns=new String[] {Company_Table.company_id,Company_Table.company};
		Cursor cursor=database.query(Company_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			companyKeLiye=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			companyKeLiye.add(cursor.getString(1));
			cursor.moveToNext();
			e++;
		}
		return companyKeLiye;
		}
		return null;
     	
}
	
	int f=0;
	ArrayList<String> ownerKeLiye=new ArrayList<String>();
	public ArrayList<String> checkCompanyTable_OwnerName(String user)
	{
		String[] columns=new String[] {Company_Table.company_id,Company_Table.company,Company_Table.industry,Company_Table.owner};
		Cursor cursor=database.query(Company_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			ownerKeLiye=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			ownerKeLiye.add(cursor.getString(3));
			cursor.moveToNext();
			f++;
		}
		return ownerKeLiye;
		}
		return null;
     	
}
	
	int g=0;
	ArrayList<String> addressKeLiye=new ArrayList<String>();
	public ArrayList<String> checkCompanyTable_Address(String user)
	{
		String[] columns=new String[] {Company_Table.company_id,Company_Table.company,Company_Table.industry,Company_Table.owner,Company_Table.email_id,Company_Table.phone_no,Company_Table.website,Company_Table.address};
		Cursor cursor=database.query(Company_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			addressKeLiye=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			addressKeLiye.add(cursor.getString(7));
			cursor.moveToNext();
			g++;
		}
		return addressKeLiye;
		}
		return null;
     	
}
	
	
	int h=0;
	ArrayList<String> leadPhone=new ArrayList<String>();
	public ArrayList<String> checkLeadPhoneNumber(String user)
	{
		String[] columns=new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no};
		Cursor cursor=database.query(NLead_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			leadPhone=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			leadPhone.add(cursor.getString(6));
			cursor.moveToNext();
			h++;
		}
		return leadPhone;
		}
		return null;
     	
}
	
	int l=0;
	ArrayList<String> leadEmail=new ArrayList<String>();
	public ArrayList<String> checkLeadEmail(String user)
	{
		String[] columns=new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,NLead_Table.emailAddress};
		Cursor cursor=database.query(NLead_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			leadEmail=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			leadEmail.add(cursor.getString(7));
			cursor.moveToNext();
			l++;
		}
		return leadEmail;
		}
		return null;
     	
}
	
	
	int d=0;
	ArrayList<String> contactKeLiyeEmail=new ArrayList<String>();
	public ArrayList<String> checkContactEmailAddress(String user)
	{
		String[] columns=new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
										Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,Contact_table.skype,Contact_table.address,Contact_table.emailid};
		Cursor cursor=database.query(Contact_table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			contactKeLiyeEmail=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			contactKeLiyeEmail.add(cursor.getString(12));
			cursor.moveToNext();
			d++;
		}
		return contactKeLiyeEmail;
		}
		return null;
     	
}

	int m=0;
	ArrayList<String> checkAssociation=new ArrayList<String>();
	public ArrayList<String> checkDealAssociation(String user)
	{
		String[] columns=new String[] {Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,Deal_Table.association};
		Cursor cursor=database.query(Deal_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			checkAssociation=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			checkAssociation.add(cursor.getString(3));
			cursor.moveToNext();
			m++;
		}
		return checkAssociation;
		}
		return null;
     	
}
	
	int n=0;
	ArrayList<String> checkOwner=new ArrayList<String>();
	public ArrayList<String> checkDealOwner(String user)
	{
		String[] columns=new String[] {Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.value,Deal_Table.refferal};
		Cursor cursor=database.query(Deal_Table.TABLE_NAME, columns,null,null,null,null,null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
			checkOwner=new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast())
			{
			checkOwner.add(cursor.getString(6));
			cursor.moveToNext();
			n++;
		}
		return checkOwner;
		}
		return null;
     	
}
	
	public String getSinlgeEntry(String userName)
	{
		//Cursor cursor=database.query("LOGIN", null, " USERNAME=?", new String[]{userName}, null, null, null);
        Cursor cursor =database.query(Signup_Table.TABLE_NAME, null, "username=?", new String[]{userName}, null, null, null);
        if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		String password= cursor.getString(cursor.getColumnIndex("Signup_Table.password"));
		cursor.close();
		return password;				
	}
	
	public String getCursorForEditContact(String id,String user) {
		// TODO Auto-generated method stub
		//String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,NLead_Table.industry,
		//		 NLead_Table.phone_no,NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,NLead_Table.twitter,
		///		 NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description};
		String where=NLead_Table.signinEmail +  " = '" + user + "'";
		Cursor cursor = database.query(NLead_Table.TABLE_NAME,null,where, new String[]{id},null,null,null);
		if(cursor.getCount()<1) // UserName Not Exist
        {
        	cursor.close();
        	return "NOT EXIST";
        }
	    cursor.moveToFirst();
		
		String firstName=cursor.getString(cursor.getColumnIndex("NLead_Table.firstname"));
		//String select = "SELECT" +(Deal_Table.dealName,Deal_Table.priority,Contact_table.firstname,Contact_table.lastname) +"FROM" +(Deal_Table.TABLE_NAME, Contact_table.TABLE_NAME) +"WHERE" +(Deal_Table.deal_id=Contact_table.contact_id);
		//Cursor cursor =database.rawQuery(select, null);
		return firstName;
	}

	
	
	public Cursor getContactsCount(String user) {
		// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
		 //SQLiteDatabase db = this.getReadableDatabase();
		  String count="SELECT" + "count"+(Deal_Table.deal_id) +"FROM" +Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			// Cursor cursor = database.rawQuery(count, null);
			// cursor.close();

			 // return count
			// return cursor;

		 Cursor cursor = database.rawQuery(count, null);
		// cursor.close();

		 // return count
		 return cursor;
		    }	
	
	public String[] getValueToEdit(int id) {
	String value[] = new String[14];
	
		// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
		 //SQLiteDatabase db = this.getReadableDatabase();
		 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String column[]=new String[] {Contact_table.firstname,Contact_table.lastname,Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,Contact_table.facebook,
				Contact_table.twitter,Contact_table.linked_in,Contact_table.skype,Contact_table.address,Contact_table.emailid,
				Contact_table.website,Contact_table.description};
		String where=Contact_table.contact_id + " = " + id ;
		Cursor cursor = database.query(Contact_table.TABLE_NAME,column,where,null,null,null,null);
		if(cursor!=null && cursor.moveToFirst())
		{
		 value[0]=cursor.getString(cursor.getColumnIndex(Contact_table.firstname));
		 value[1]=cursor.getString(cursor.getColumnIndex(Contact_table.lastname));
		 value[2]=cursor.getString(cursor.getColumnIndex(Contact_table.company));
		 value[3]=cursor.getString(cursor.getColumnIndex(Contact_table.title));
		 value[4]=cursor.getString(cursor.getColumnIndex(Contact_table.industry));
		 value[5]=cursor.getString(cursor.getColumnIndex(Contact_table.phone_no));
		 value[6]=cursor.getString(cursor.getColumnIndex(Contact_table.facebook));
		 value[7]=cursor.getString(cursor.getColumnIndex(Contact_table.twitter));
		 value[8]=cursor.getString(cursor.getColumnIndex(Contact_table.linked_in));
		 value[9]=cursor.getString(cursor.getColumnIndex(Contact_table.skype));
		 value[10]=cursor.getString(cursor.getColumnIndex(Contact_table.address));
		 value[11]=cursor.getString(cursor.getColumnIndex(Contact_table.emailid));
		 value[12]=cursor.getString(cursor.getColumnIndex(Contact_table.website));
		 value[13]=cursor.getString(cursor.getColumnIndex(Contact_table.description));
		 
		 cursor.close();
		}
		 // return count
		 return value;
		    	
	}
	
	public String[] getValueToEdit1(int id) {
		String valueLead[] = new String[14];
		
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
			String column[]=new String[] {};
			String where=NLead_Table.lead_id + " = " + id;
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,column,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
			 valueLead[0]=cursor.getString(cursor.getColumnIndex(NLead_Table.firstname));
			 valueLead[1]=cursor.getString(cursor.getColumnIndex(NLead_Table.lastname));
			 valueLead[2]=cursor.getString(cursor.getColumnIndex(NLead_Table.company));
			 valueLead[3]=cursor.getString(cursor.getColumnIndex(NLead_Table.title));
			 valueLead[4]=cursor.getString(cursor.getColumnIndex(NLead_Table.industry));
			 valueLead[5]=cursor.getString(cursor.getColumnIndex(NLead_Table.phone_no));
			 valueLead[6]=cursor.getString(cursor.getColumnIndex(NLead_Table.website));
			 valueLead[7]=cursor.getString(cursor.getColumnIndex(NLead_Table.address));
			 valueLead[8]=cursor.getString(cursor.getColumnIndex(NLead_Table.emailAddress));
			 valueLead[9]=cursor.getString(cursor.getColumnIndex(NLead_Table.facebook));
			 valueLead[10]=cursor.getString(cursor.getColumnIndex(NLead_Table.twitter));
			 valueLead[11]=cursor.getString(cursor.getColumnIndex(NLead_Table.linked_in));
			 valueLead[12]=cursor.getString(cursor.getColumnIndex(NLead_Table.skype));
			 valueLead[13]=cursor.getString(cursor.getColumnIndex(NLead_Table.description));
			 
			 cursor.close();
			}
			 // return count
			 return valueLead;
			    	
		}
		
	public String[] getValueToEditDeal(int id) {
		String valueDeal[] = new String[2];
		
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
			String column[]=new String[] {};
			String where=Deal_Table.deal_id + " = " + id ;
			Cursor cursor = database.query(Deal_Table.TABLE_NAME,column,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
			 valueDeal[0]=cursor.getString(cursor.getColumnIndex(Deal_Table.dealName));
			 valueDeal[1]=cursor.getString(cursor.getColumnIndex(Deal_Table.value));
			 
			 cursor.close();
			}
			 // return count
			 return valueDeal;
			    	
		}
	
	ArrayList<String> countCompany;
	public int getotalCompany(String user)
	{
		int k = 0;
		String[] columns  = new  String[]{Company_Table.company_id,Company_Table.company};
		
		Cursor cursor = database.query(Company_Table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countCompany = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countCompany.add(cursor.getString(1));
				cursor.moveToNext();
				k++;
			}
		    return k;
		}
		return k;
}
	
	public int getotalContact(String user)
	{
		ArrayList<String> countContact;
		int k = 0;
		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname};
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countContact = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countContact.add(cursor.getString(1));
				cursor.moveToNext();
				k++;
			}
		    return k;
		}
		return k;
}
	
	public Cursor joinerCheck() {
		//String valueDeal[] = new String[1];
		//ArrayList<String> valueCompany = new ArrayList<String>();
		///ArrayList<String> valueContact= new ArrayList<String>();
		//List<ArrayList<String>> totalCompanyContact = new ArrayList<ArrayList<String>>();
		//int totalCompany=getotalCompany();	
		//int totalContact=getotalContact1();
		//int totalLead=getotalLeads();
		// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		 final String MY_QUERY = "SELECT company_table.company,company_table.email_id,company_table.phone_no,contact_table.firstname,contact_table.phone_no,contact_table.emailid FROM company_table INNER JOIN contact_table";
         //String select = Contact_table.firstname
		Cursor cursor= database.rawQuery(MY_QUERY, null);	
		///String column[]=new String[] {};
		//	String where=Deal_Table.deal_id + " = " + id;
		//	Cursor cursor = database.query(Deal_Table.TABLE_NAME,column,where,null,null,null,null);
			/*if(cursor!=null && cursor.moveToFirst())
			{
			 for(int i=0;i<totalCompany;i++)
				{
			valueCompany.add(cursor.getString(0));
			valueCompany.add(cursor.getString(1));
			valueCompany.add(cursor.getString(2));
			cursor.moveToNext();
			}
			}
			
			if(cursor!=null && cursor.moveToFirst())
			{
		    for(int i=0;i<totalContact;i++){
				
				 ///valueContact.add(cursor.getString(0));
		    	 valueContact.add(cursor.getString(3));
		    	 valueContact.add(cursor.getString(4));
		    	 valueContact.add(cursor.getString(5));
		    	 cursor.moveToNext();
				}
				}
		    totalCompanyContact.add(valueCompany);
			totalCompanyContact.add(valueContact);	
			
			
			cursor.close();
			//else valueDeal[0]="check"; 
			// return count*/
			 return cursor;
			    	
		}
	
	
	
	
	public String[] getValueToEditTask(int id,String user)
	{
		String valueTask[]=new String[1];
		String column[]=new String[] {};
		String where=AddTask_Table.addtask_id + " = " + id ;
		Cursor cursor=database.query(AddTask_Table.TABLE_NAME,column,where,null,null,null,null);
		if(cursor!=null && cursor.moveToFirst())
		{
			valueTask[0]=cursor.getString(cursor.getColumnIndex(AddTask_Table.description));
			cursor.close();
		}
		return valueTask;
	}
	
	public Cursor getCursorfromContactdatail() {
		// TODO Auto-generated method stub
		
		String[] columns = new String[] { ContactDetail_Table.contact_rowid,
				ContactDetail_Table.content, ContactDetail_Table.content_type,
				ContactDetail_Table.id, ContactDetail_Table.date };
		
		return database.query(ContactDetail_Table.TABLE_NAME, columns, null, null, null, null, null);
	}

	
	String c;
	ArrayList<String> countDeals;
	public int getotalDeals(String user)
	{
		int k = 0;
		String where=Deal_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{Deal_Table.deal_id,Deal_Table.dealName};
		Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns, where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countDeals = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countDeals.add(cursor.getString(1));
				cursor.moveToNext();
				k++;
			}
		    return k;
		}
		return k;
}

	
	public int dealsInPipeline(String user)
	{
		ArrayList<String> dealsInPipeline;
		int k = 0;
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname};
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			dealsInPipeline = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				dealsInPipeline.add(cursor.getString(1));
				cursor.moveToNext();
				k++;
			}
		    return k;
		}
		return k;
}
	
	
	
	int x = 0;
	//String c;
	ArrayList<Integer> countDealsWorth;
	public ArrayList<Integer> countDealsWorth(String user)
	{
		String where=Deal_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.value};
		Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countDealsWorth = new ArrayList<Integer>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countDealsWorth.add(cursor.getInt(4));
				cursor.moveToNext();
				x++;
			}
		    return countDealsWorth;
		}
		return null;
}

	int o = 0;
	String p;
	ArrayList<String> getDate;
	public ArrayList<String> getTotalDate(String user)
	{
        
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
		NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
		NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
		NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.table_type,
		NLead_Table.date_time};
		
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			getDate = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				getDate.add(cursor.getString(16));
				cursor.moveToNext();
				o++;
			}
		    return getDate ;
		}
		return null;
	
}
	
	
	
	String w;
	ArrayList<String> countLeads;
	public int getotalLeads(String user)
	{
		int q = 0;
		String where=NLead_Table.signinEmail+ " = '" + user + "'";
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname};
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countLeads = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countLeads.add(cursor.getString(1));
				cursor.moveToNext();
				q++;
			}
		    return q;
		}
		return q;
}

	
	ArrayList<String> countTask;
	public int getotalTask(String user)
	{
		//String w;
		int q = 0;
		String where=AddTask_Table.signinEmail + " = '" + user + "'";
		String[] columns  = new  String[]{AddTask_Table.addtask_id,AddTask_Table.description};
		Cursor cursor = database.query(AddTask_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countTask = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countTask.add(cursor.getString(1));
				cursor.moveToNext();
				q++;
			}
		    return q;
		}
		return q;
}

	
	public int getotalContact1(String user)
	{
		ArrayList<String> countContact;
		//String w;
		int q = 0;

		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname};
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countContact = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countContact.add(cursor.getString(1));
				cursor.moveToNext();
				q++;
			}
		    return q;
		}
		return q;
}

	
	int r = 0;
	//String w;
	ArrayList<String> countSynchIndex;
	public int getIndex(String user)
	{
		int index=0;
		String indexChar;
		String[] columns  = new  String[]{SynchronizationTable.company_id,SynchronizationTable.SynchronizationId};
		Cursor cursor = database.query(SynchronizationTable.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countSynchIndex = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countSynchIndex.add(cursor.getString(1));
				cursor.moveToNext();
				r++;
			}
			if(r>=1)
		    indexChar=countSynchIndex.get(r-1);
			else indexChar="0";
		    index=Integer.parseInt(indexChar);
		    return index;
		}
		return index;
}
	int s = 0;
	//String w;
	
    List<ArrayList<String>> listOfList =new ArrayList<ArrayList<String>>();
	public List<ArrayList<String>> valueForLeadServer(String user)
	{
		//int index=0;
		//String indexChar;
		String where=NLead_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
				NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
				NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
				NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.modified_date_time,
				NLead_Table.generated_code};
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			
			while(!cursor.isAfterLast()){
				ArrayList<String> valueServer = new ArrayList<String>();
				valueServer.add(cursor.getString(1));
				valueServer.add(cursor.getString(2));
				valueServer.add(cursor.getString(3));
				valueServer.add(cursor.getString(6));
				valueServer.add(cursor.getString(7));
				valueServer.add(cursor.getString(8));
				valueServer.add(cursor.getString(9));
				valueServer.add(cursor.getString(10));
				valueServer.add(cursor.getString(12));
				valueServer.add(cursor.getString(14));
				valueServer.add(cursor.getString(16));
				//listOfList.add(new ArrayList<String>());
				listOfList.add(valueServer);
				//listOfList.add(new ArrayList<String>());
				cursor.moveToNext();
				r++;
			}
			return listOfList;
		}
		return listOfList;
}
	 List<ArrayList<String>> listOfListDeal =new ArrayList<ArrayList<String>>();
		public List<ArrayList<String>> valueForDealServer(String user)
		{
			//int index=0;
			//String indexChar;
			String where=Deal_Table.signinEmail +  " = '" + user + "'";
			String[] columns  = new  String[]{Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.value};
			Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns,where, null, null, null, null);
			
			if(cursor !=  null){
				cursor.moveToFirst();
				
				while(!cursor.isAfterLast()){
					ArrayList<String> valueServer = new ArrayList<String>();
					valueServer.add(cursor.getString(1));
					valueServer.add(cursor.getString(4));
					//listOfList.add(new ArrayList<String>());
					listOfListDeal.add(valueServer);
					//listOfList.add(new ArrayList<String>());
					cursor.moveToNext();
					r++;
				}
				return listOfListDeal;
			}
			return listOfListDeal;
	}

		 List<ArrayList<String>> listOfListTask =new ArrayList<ArrayList<String>>();
			public List<ArrayList<String>> valueForTaskServer(String user)
			{
				//int index=0;
				//String indexChar;
				String where=AddTask_Table.signinEmail +  " = '" + user + "'";
				String[] columns  = new  String[]{AddTask_Table.addtask_id,AddTask_Table.description};
				Cursor cursor = database.query(AddTask_Table.TABLE_NAME, columns,where, null, null, null, null);
				
				if(cursor !=  null){
					cursor.moveToFirst();
					
					while(!cursor.isAfterLast()){
						ArrayList<String> valueServer = new ArrayList<String>();
						valueServer.add(cursor.getString(1));
						//listOfList.add(new ArrayList<String>());
						listOfListTask.add(valueServer);
						//listOfList.add(new ArrayList<String>());
						cursor.moveToNext();
						r++;
					}
					return listOfListTask;
				}
				return listOfListTask;
		}

			List<ArrayList<String>> listOfListContact =new ArrayList<ArrayList<String>>();
			public List<ArrayList<String>> valueForContactServer(String user)
			{
				//int index=0;
				//String indexChar;
				String where=Contact_table.signinEmail +  " = '" + user + "'";
				String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
						Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
						Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
						Contact_table.skype,Contact_table.address,Contact_table.emailid,
						Contact_table.website,Contact_table.description,Contact_table.table_type,
						Contact_table.generated_code};
				Cursor cursor = database.query(Contact_table.TABLE_NAME, columns,where, null, null, null, null);
				
				if(cursor !=  null){
					cursor.moveToFirst();
					while(!cursor.isAfterLast()){
						ArrayList<String> valueServer = new ArrayList<String>();
						valueServer.add(cursor.getString(1));
						valueServer.add(cursor.getString(3));
						valueServer.add(cursor.getString(6));
						valueServer.add(cursor.getString(7));
						valueServer.add(cursor.getString(11));
						valueServer.add(cursor.getString(12));
						valueServer.add(cursor.getString(13));
						valueServer.add(cursor.getString(14));
						valueServer.add(cursor.getString(16));
						
						//listOfList.add(new ArrayList<String>());
						listOfListContact.add(valueServer);
						
						//listOfList.add(new ArrayList<String>());
						cursor.moveToNext();
						r++;
					}
					return listOfListContact;
				}
				return listOfListContact;
		}
			
	
	//String w;
	List<ArrayList<Integer>> statusLead;
	public List<ArrayList<Integer>> statusLead(String user)
	{
		//int t = 0;
		//int index=0;
		//String indexChar;
		String where=NLead_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
				NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
				NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
				NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.modified_date_time,
				NLead_Table.generated_code,NLead_Table.status};
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			statusLead = new ArrayList<ArrayList<Integer>>();
			while(!cursor.isAfterLast()){
				ArrayList<Integer> values = new ArrayList<Integer>();
				values.add(cursor.getInt(15));
				values.add(cursor.getInt(17));
			    statusLead.add(values);
				cursor.moveToNext();
				//t++;
			}
			return statusLead;
		}
		return statusLead;
}

	
	public ArrayList<Integer> statusDeleteLead(String user)
	{
		ArrayList<Integer> statusDeleteLead= new ArrayList<Integer>();
		int id=1;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String[] columns = new String[] {Delete_Lead_sync.id,Delete_Lead_sync.unique_code,Delete_Lead_sync.delete_status,Delete_Lead_sync.signinEmail};
			String where=Delete_Lead_sync.delete_status + " = " + id + " AND " + Delete_Lead_sync.signinEmail + " = 'user'";
			Cursor cursor = database.query(Delete_Lead_sync.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				statusDeleteLead.add(cursor.getInt(2));
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return statusDeleteLead;
	
}
	
	;
	public ArrayList<Integer> statusDeleteContact(String user)
	{
		ArrayList<Integer> statusDeleteContact= new ArrayList<Integer>();
		int id=1;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String[] columns = new String[] {Delete_contact_sync.id,Delete_contact_sync.unique_code,Delete_contact_sync.delete_status,Delete_contact_sync.signinEmail};
			String where=Delete_contact_sync.delete_status + " = " + id + " AND " + Delete_contact_sync.signinEmail + " = 'user'";
			Cursor cursor = database.query(Delete_contact_sync.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				statusDeleteContact.add(cursor.getInt(2));
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return statusDeleteContact;
	
}

	ArrayList<String> dBUniqueCodesLead;
	public ArrayList<String> getDeletedDBUniqueCodeLead(String user)
	{

		String[] columns  = new  String[]{Delete_Lead_sync.id,Delete_Lead_sync.unique_code};
		String where=Delete_Lead_sync.signinEmail + " = '" + user + "'" ;	
		Cursor cursor = database.query(Delete_Lead_sync.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			dBUniqueCodesLead = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				dBUniqueCodesLead.add(cursor.getString(1));
			
				
				cursor.moveToNext();
			}
		    return dBUniqueCodesLead ;
		}
		return null;
	
}

	
	
	
	
	
	ArrayList<String> dBUniqueCodesContact;
	public ArrayList<String> getDeletedDBUniqueCodeContact(String user)
	{

		String[] columns  = new  String[]{Delete_contact_sync.id,Delete_contact_sync.unique_code};
		String where=Delete_contact_sync.signinEmail +  " = '" + user + "'";	
		Cursor cursor = database.query(Delete_contact_sync.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			dBUniqueCodesContact = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				dBUniqueCodesContact.add(cursor.getString(1));
				cursor.moveToNext();
			}
		    return dBUniqueCodesContact ;
		}
		return null;
	}

	List<ArrayList<Integer>> statusDeal;
	public List<ArrayList<Integer>> statusDeal(String user)
	{
		//int t = 0;
		//int index=0;
		//String indexChar;
		String where=Deal_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,
				Deal_Table.association,Deal_Table.value,Deal_Table.refferal,Deal_Table.tabletype,
				Deal_Table.cdate,Deal_Table.ctime,Deal_Table.status,Deal_Table.modified_date};
		Cursor cursor = database.query(Deal_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			statusDeal = new ArrayList<ArrayList<Integer>>();
			while(!cursor.isAfterLast()){
				ArrayList<Integer> value = new ArrayList<Integer>();
				value.add(cursor.getInt(9));
				value.add(cursor.getInt(10));
				statusDeal.add(value);
				cursor.moveToNext();
				//t++;
			}
			return statusDeal;
		}
		return statusDeal;
}
	
	ArrayList<Integer> statusTask;
	public ArrayList<Integer> statusTask(String user)
	{
		//int t = 0;
		//int index=0;
		//String indexChar;
		String where=AddTask_Table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{AddTask_Table.addtask_id,AddTask_Table.description,AddTask_Table.date,
										 AddTask_Table.time,AddTask_Table.assignedto,AddTask_Table.tabletype,AddTask_Table.status};
		Cursor cursor = database.query(AddTask_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			statusTask = new ArrayList<Integer>();
			while(!cursor.isAfterLast()){
				statusTask.add(cursor.getInt(6));
				cursor.moveToNext();
			//	t++;
			}
			return statusTask;
		}
		return statusTask;
}
	
	List<ArrayList<Integer>> statusContact;
	public List<ArrayList<Integer>> statusContact(String user)
	{
		//int t = 0;
		//int index=0;
		//String indexChar;
		String where=Contact_table.signinEmail +  " = '" + user + "'";
		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
				Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
				Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
				Contact_table.skype,Contact_table.address,Contact_table.emailid,
				Contact_table.website,Contact_table.description,Contact_table.table_type,
				Contact_table.generated_code,Contact_table.status,Contact_table.modified_status};
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			statusContact = new ArrayList<ArrayList<Integer>>();
			while(!cursor.isAfterLast()){
				ArrayList<Integer> value = new ArrayList<Integer>();
				value.add(cursor.getInt(17));
				value.add(cursor.getInt(18));
				//value.add(18);
				statusContact.add(value);
				cursor.moveToNext();
				///t++;
			}
			return statusContact;
		}
		return statusContact;
}
	
	public String[] passValuetoServer(int id,String user) {
		String value[] = new String[11];
		
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String[] columns = new String[] {NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,
				NLead_Table.phone_no,NLead_Table.emailAddress,
				NLead_Table.website,NLead_Table.address,NLead_Table.facebook,NLead_Table.linked_in,
				NLead_Table.skype,NLead_Table.description};
			String where=NLead_Table.lead_id + " = " + id + " AND " + NLead_Table.signinEmail +  " = 'user'";
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
			 //value[0]=cursor.getString(cursor.getColumnIndex(NLead_Table.lead_id));
			 value[0]=cursor.getString(cursor.getColumnIndex(NLead_Table.firstname));
			 value[1]=cursor.getString(cursor.getColumnIndex(NLead_Table.lastname));
			 value[2]=cursor.getString(cursor.getColumnIndex(NLead_Table.company));
			 value[3]=cursor.getString(cursor.getColumnIndex(NLead_Table.phone_no));
			 value[4]=cursor.getString(cursor.getColumnIndex(NLead_Table.emailAddress));
			 value[5]=cursor.getString(cursor.getColumnIndex(NLead_Table.website));
			 value[6]=cursor.getString(cursor.getColumnIndex(NLead_Table.address));
			 value[7]=cursor.getString(cursor.getColumnIndex(NLead_Table.facebook));
			 value[8]=cursor.getString(cursor.getColumnIndex(NLead_Table.linked_in));
			 value[9]=cursor.getString(cursor.getColumnIndex(NLead_Table.skype));
			 value[10]=cursor.getString(cursor.getColumnIndex(NLead_Table.description));
			// value[12]=cursor.getString(cursor.getColumnIndex(NLead_Table.date_time));
			
			 
			 cursor.close();
			}
			 // return count
			 return value;
			    	
		}
	
	public List<ArrayList<String>> leadValueToUpdate1(String user) {
		
		List<ArrayList<String>> codeTwoD = new ArrayList<ArrayList<String>>();
		
		//int id=2;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String where=NLead_Table.signinEmail +  " = '" + user + "'";
		String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
				NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
				NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
				NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.modified_date_time,
				NLead_Table.generated_code};
			//String where=NLead_Table.table_type + " = " + "'forlead'";
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> codeList= new ArrayList<String>();
			    codeList.add(cursor.getString(0));
			    codeList.add(cursor.getString(16)); 
			    codeTwoD.add(codeList);
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return codeTwoD;
			    	
		}
	public ArrayList<String> contactValueToUpdate1(String user) {
		ArrayList<String> codeList= new ArrayList<String>();
		int id=2;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String where=Contact_table.contact_id + "=" +id + " AND " + Contact_table.signinEmail +   " = '" + user + "'";
		String[] columns = new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
				Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
				Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
				Contact_table.skype,Contact_table.address,Contact_table.emailid,
				Contact_table.website,Contact_table.description,Contact_table.table_type,
				Contact_table.generated_code,Contact_table.status,Contact_table.modified_status};
			//String where=Contact_table.table_type + " = " + "'contact'";
			Cursor cursor = database.query(Contact_table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				
			    codeList.add(cursor.getString(16)); 
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return codeList;
			    	
		}
	
	
	public List<ArrayList<String>> leadValueToUpdate(String user) {
		List<ArrayList<String>> codeTwoD = new ArrayList<ArrayList<String>>();
		
		int id=2;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		//String where=DealServerSyncTime.signinEmail +  " = '" + user + "'";	
		String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
				NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
				NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
				NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.modified_date_time,
				NLead_Table.generated_code};
			String where=NLead_Table.modified_date_time + " = " + id + " AND " + NLead_Table.signinEmail +  " = '" + user + "'";
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> codeList= new ArrayList<String>();
			    codeList.add(cursor.getString(1));
			    codeList.add(cursor.getString(2));
			    codeList.add(cursor.getString(3));
			    codeList.add(cursor.getString(6));
			    codeList.add(cursor.getString(7));
			    codeList.add(cursor.getString(8));
			    codeList.add(cursor.getString(9));
			    codeList.add(cursor.getString(10));
			    codeList.add(cursor.getString(12));
			    codeList.add(cursor.getString(14));
			    codeList.add(cursor.getString(16)); 
			    codeTwoD.add(codeList);
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return codeTwoD;
			    	
		}
	
	
	public List<ArrayList<String>> DealValueToUpdate(String user) {
		List<ArrayList<String>> codeTwoD = new ArrayList<ArrayList<String>>();
		
		int id=2;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String[] columns = new String[] {Deal_Table.deal_id,Deal_Table.dealName,
				                         Deal_Table.priority,Deal_Table.association,Deal_Table.value };
			String where=Deal_Table.modified_date + " = " + id;
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> codeList= new ArrayList<String>();
			   codeList.add(cursor.getString(1));
			   codeList.add(cursor.getString(4));
				codeTwoD.add(codeList);
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return codeTwoD;
			    	
		}
	public List<ArrayList<String>> contactValueToUpdate(String user) {
		List<ArrayList<String>> codeTwoD = new ArrayList<ArrayList<String>>();
		
		int id=2;
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String[] columns = new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
				Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
				Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
				Contact_table.skype,Contact_table.address,Contact_table.emailid,
				Contact_table.website,Contact_table.description,Contact_table.table_type,
				Contact_table.generated_code,Contact_table.status,Contact_table.modified_status};
			String where=Contact_table.modified_status + " = " + id  + " AND "+ Contact_table.signinEmail +  " = '" + user + "'";
			Cursor cursor = database.query(Contact_table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> value= new ArrayList<String>();
				value.add(cursor.getString(1));
				value.add(cursor.getString(3));
				value.add(cursor.getString(6));
				value.add(cursor.getString(7));
				value.add(cursor.getString(11));
				value.add(cursor.getString(12));
				value.add(cursor.getString(13));
				value.add(cursor.getString(14));
				value.add(cursor.getString(16));
				codeTwoD.add(value);
				cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return codeTwoD;
			    	
		}
	
	
	
	public int getIndexForServer(String date,String user)
	{
		String indexChar=null;
		int indexInt;
	String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
			NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
			NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
			NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.table_type,
			NLead_Table.date_time};
			
	//String where = "Select * from" + NLead_Table.TABLE_NAME + "where" + NLead_Table.date_time +"="+ date_time;
	Cursor cursor=database.query(NLead_Table.TABLE_NAME, columns,
			NLead_Table.firstname + " = " + " '" + date + "'",
			null, null, null, null);
	if(cursor!=null && cursor.moveToFirst())
	{
	 indexChar=cursor.getString(cursor.getColumnIndex(NLead_Table.lead_id));
	}
	indexInt=Integer.parseInt(indexChar);
	return indexInt;
	}

	public String[] getValuesForSyncDeleteLead(long id)
	{
		String[] values=new String[1];
		String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
				NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
				NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
				NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.table_type,
				NLead_Table.date_time,NLead_Table.generated_code};
			String where=NLead_Table.lead_id + " = " + id ;
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
			 values[0]=cursor.getString(cursor.getColumnIndex(NLead_Table.generated_code));
			// values[1]=cursor.getString(cursor.getColumnIndex(NLead_Table.date_time));
			 cursor.close();
			}
		return values;
	//public void joiner 
}
	
	public String[] getValuesForSyncDeleteContact(long id) {
		// TODO Auto-generated method stub
		String[] values=new String[1];
		String[] columns = new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
				Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
				Contact_table.emailid,Contact_table.website,Contact_table.address,Contact_table.facebook,
				Contact_table.twitter,Contact_table.linked_in,Contact_table.skype,Contact_table.description,Contact_table.table_type,
				Contact_table.generated_code};
			String where=Contact_table.contact_id + " = " + id ;
			Cursor cursor = database.query(Contact_table.TABLE_NAME,columns,where,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
			 values[0]=cursor.getString(cursor.getColumnIndex(Contact_table.generated_code));
			// values[1]=cursor.getString(cursor.getColumnIndex(NLead_Table.date_time));
			 cursor.close();
			}
		return values;
	}
	
	public List<ArrayList<String>> getLeadValuesFromLocalDB(String user)
	{
		
		List<ArrayList<String>> leadValue2D=new ArrayList<ArrayList<String>>();
		
		String where=NLead_Table.signinEmail +   " = '" + user + "'";
			String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,
					NLead_Table.company,NLead_Table.title,NLead_Table.industry,NLead_Table.phone_no,
					NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,
					NLead_Table.twitter,NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description,NLead_Table.table_type,
					NLead_Table.date_time,NLead_Table.generated_code};
				//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(NLead_Table.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					while(!cursor.isAfterLast())
					{
						ArrayList<String> leadValues=new ArrayList<String>();
						leadValues.add(cursor.getString(1));
						leadValues.add(cursor.getString(2));
						leadValues.add(cursor.getString(3));
						leadValue2D.add(leadValues);
						cursor.moveToNext();
					
					}
					cursor.close();
				}
				return leadValue2D;
		
	}
	/*public List<ArrayList<String>> getLocalContact() {
		List<ArrayList<String>> leadList=new ArrayList<ArrayList<String>>();
		
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
			String column[]=new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
					Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
					Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
					Contact_table.skype,Contact_table.address,Contact_table.emailid,
					Contact_table.website,Contact_table.description,Contact_table.table_type,
					Contact_table.generated_code,Contact_table.status};
			String where=Contact_table.table_type + " = " + " 'contact'"; 
			Cursor cursor = database.query(Contact_table.TABLE_NAME,column,where,null,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
					ArrayList<String> value=new ArrayList<String>();
				value.add(cursor.getString(0));
				value.add(cursor.getString(1));
				value.add(cursor.getString(3));
				value.add(cursor.getString(16));
				leadList.add(value);
			 cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return leadList;
			    	
		}*/
	public ArrayList<String> getLeadServerSyncTime(String user)
	{
		
	
		ArrayList<String> leadValues=new ArrayList<String>();
		//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
		String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
		String[] columns = new String[] {ServerSynchTime.synch_id,ServerSynchTime.ServersynchId,ServerSynchTime.signinEmail};
				//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(ServerSynchTime.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					while(!cursor.isAfterLast())
					{
						
						leadValues.add(cursor.getString(1));
						
				
						
						cursor.moveToNext();
					
					}
					cursor.close();
				}
				return leadValues;
		
	}
	public ArrayList<String> getContactServerSyncTime(String user)
	{
		
	
		ArrayList<String> contactValues=new ArrayList<String>();
		String where=ContactServerSynchTIme.signinEmail +  " = '" + user + "'";	
			String[] columns = new String[] {ContactServerSynchTIme.contact_synch_id,ContactServerSynchTIme.Contact_ServersynchId,ContactServerSynchTIme.signinEmail};
				//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(ContactServerSynchTIme.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					while(!cursor.isAfterLast())
					{
						
						contactValues.add(cursor.getString(1));
						
				
						
						cursor.moveToNext();
					
					}
					cursor.close();
				}
				return contactValues;
		
	}
	public ArrayList<String> getDealServerSyncTime(String user)
	{
		
	
		ArrayList<String> dealValues=new ArrayList<String>();
		
			String[] columns = new String[] {DealServerSyncTime.deal_synch_id,DealServerSyncTime.deal_ServersynchId,DealServerSyncTime.signinEmail};
			String where=DealServerSyncTime.signinEmail +  " = '" + user + "'";	
			//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(DealServerSyncTime.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					while(!cursor.isAfterLast())
					{
						
						dealValues.add(cursor.getString(1));
						
				
						
						cursor.moveToNext();
					
					}
					cursor.close();
				}
				return dealValues;
	}
	//public void joiner 
	
	public List<ArrayList<String>> getLocalLeads(String user) {
		List<ArrayList<String>> leadList=new ArrayList<ArrayList<String>>();
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
			String column[]=new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,
					NLead_Table.industry,NLead_Table.phone_no,NLead_Table.facebook,NLead_Table.twitter,NLead_Table.linked_in,
					NLead_Table.skype,NLead_Table.address,NLead_Table.emailAddress,NLead_Table.website,NLead_Table.description,NLead_Table.modified_date_time,
					NLead_Table.generated_code,NLead_Table.table_type};
			String where=NLead_Table.signinEmail +  " = '" + user + "'";
			//String where=NLead_Table.table_type + " = " + " 'forlead'"; 
			Cursor cursor = database.query(NLead_Table.TABLE_NAME,column,where,null,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> value = new ArrayList<String>();
				value.add(cursor.getString(0));
				value.add(cursor.getString(16));
				leadList.add(value);
			 cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return leadList;
			    	
		}
	
	public List<ArrayList<String>> getLocalContact(String user) {
		List<ArrayList<String>> leadList=new ArrayList<ArrayList<String>>();
		
			// String countQuery = "SELECT  * FROM " + Deal_Table.TABLE_NAME;
			 //SQLiteDatabase db = this.getReadableDatabase();
			 // String getFirstName="SELECT * FROM" +Contact_table.TABLE_NAME +"WHERE" +Contact_table.contact_id + "=" +id;
		String where=Contact_table.signinEmail +  " = '" + user + "'";
			String column[]=new String[] {Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
					Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
					Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
					Contact_table.skype,Contact_table.address,Contact_table.emailid,
					Contact_table.website,Contact_table.description,Contact_table.table_type,
					Contact_table.generated_code,Contact_table.status};
			//String where=Contact_table.table_type + " = " + "'contact'"; 
			Cursor cursor = database.query(Contact_table.TABLE_NAME,column,where,null,null,null,null,null);
			if(cursor!=null && cursor.moveToFirst())
			{
				while(!cursor.isAfterLast())
				{
				ArrayList<String> value=new ArrayList<String>();
				value.add(cursor.getString(0));
				value.add(cursor.getString(16));
				leadList.add(value);
			 cursor.moveToNext();
				}
			 cursor.close();
			}
			 // return count
			 return leadList;
			    	
		}
	
	
	public ArrayList<String> getUniqueCodeLead(String user)
	{

		ArrayList<String> dBUniqueCodesLead;
		String where=NLead_Table.signinEmail +  " = '" + user + "'";	
		String[] columns  = new  String[]{NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,
				NLead_Table.industry,NLead_Table.phone_no,NLead_Table.facebook,NLead_Table.twitter,NLead_Table.linked_in,
				NLead_Table.skype,NLead_Table.address,NLead_Table.emailAddress,NLead_Table.website,NLead_Table.description,NLead_Table.modified_date_time,
				NLead_Table.generated_code,NLead_Table.table_type};
		
		Cursor cursor = database.query(NLead_Table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			dBUniqueCodesLead = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				dBUniqueCodesLead.add(cursor.getString(16));
			
				
				cursor.moveToNext();
			}
		    return dBUniqueCodesLead ;
		}
		return null;
	
}
	public ArrayList<String> getUniqueCodeContact(String user)
	{

		ArrayList<String> dBUniqueCodesLead;
		String where=Contact_table.signinEmail +  " = '" + user + "'";	
		String[] columns  = new  String[]{Contact_table.contact_id,Contact_table.firstname,Contact_table.lastname,
				Contact_table.company,Contact_table.title,Contact_table.industry,Contact_table.phone_no,
				Contact_table.facebook,Contact_table.twitter,Contact_table.linked_in,
				Contact_table.skype,Contact_table.address,Contact_table.emailid,
				Contact_table.website,Contact_table.description,Contact_table.table_type,
				Contact_table.generated_code,Contact_table.status};
		
		Cursor cursor = database.query(Contact_table.TABLE_NAME, columns,where, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			dBUniqueCodesLead = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				dBUniqueCodesLead.add(cursor.getString(16));
			
				
				cursor.moveToNext();
			}
		    return dBUniqueCodesLead ;
		}
		return null;
	
}

	
	public int getotalUsers()
	{
		int q = 0;
		String w;
		String[] columns  = new  String[]{Signup_Table.signup_id,Signup_Table.name};
		Cursor cursor = database.query(Signup_Table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			countLeads = new ArrayList<String>(cursor.getCount());
			while(!cursor.isAfterLast()){
				countLeads.add(cursor.getString(1));
				cursor.moveToNext();
				q++;
			}
		    return q;
		}
		return q;
	}
	
	public ArrayList<Integer> statusUsers()
	{
		//List<ArrayList<Integer>> statusLead = null;
		ArrayList<Integer> values = new ArrayList<Integer>();
		int t = 0;
		//int index=0;
		//String indexChar;
		String[] columns  = new  String[]{Signup_Table.signup_id,Signup_Table.name,Signup_Table.password,Signup_Table.confirmpassword,
				                           Signup_Table.emailAddress,Signup_Table.mobileNumber,Signup_Table.tabletype,Signup_Table.status
		};
		Cursor cursor = database.query(Signup_Table.TABLE_NAME, columns, null, null, null, null, null);
		
		if(cursor !=  null){
			cursor.moveToFirst();
			
			while(!cursor.isAfterLast()){
				
				values.add(cursor.getInt(7));
				cursor.moveToNext();
				//t++;
			}
			return values;
		}
		return values;
	}
		
		public List<ArrayList<String>> valueForUserCreation()
		{
			List<ArrayList<String>> listOfList =new ArrayList<ArrayList<String>>();
			//int index=0;
			//String indexChar;
			String[] columns  = new  String[]{Signup_Table.signup_id,Signup_Table.name,Signup_Table.username,Signup_Table.password,Signup_Table.confirmpassword,
					                           Signup_Table.emailAddress};
			Cursor cursor = database.query(Signup_Table.TABLE_NAME, columns, null, null, null, null, null);
			
			if(cursor !=  null){
				cursor.moveToFirst();
				
		
				while(!cursor.isAfterLast()){
					ArrayList<String> valueServer = new ArrayList<String>();
					valueServer.add(cursor.getString(1));
					valueServer.add(cursor.getString(2));
					valueServer.add(cursor.getString(3));
				
					listOfList.add(valueServer);
				
					cursor.moveToNext();
					r++;
				}
				return listOfList;
			}
			return listOfList;
	}
	
		public int getotalLeadUniqueCode(String user)
		{
			//String w;
			ArrayList<String> countLeads;
			
			int q = 0;
			String where=Delete_Lead_sync.signinEmail +  " = '" + user + "'";
			String[] columns  = new  String[]{Delete_Lead_sync.id,Delete_Lead_sync.unique_code,Delete_Lead_sync.signinEmail};
			Cursor cursor = database.query(Delete_Lead_sync.TABLE_NAME, columns,where, null, null, null, null);
			
			if(cursor !=  null){
				cursor.moveToFirst();
				countLeads = new ArrayList<String>(cursor.getCount());
				while(!cursor.isAfterLast()){
					countLeads.add(cursor.getString(1));
					cursor.moveToNext();
					q++;
				}
			    return q;
			}
			return q;
	}

		public int getotalContactUniqueCode(String user)
		{
			//String w;
			ArrayList<String> countLeads;
			
			int q = 0;
			String where=Delete_contact_sync.signinEmail +  " = '" + user + "'";
			String[] columns  = new  String[]{Delete_contact_sync.id,Delete_contact_sync.unique_code,Delete_contact_sync.signinEmail};
			
			Cursor cursor = database.query(Delete_contact_sync.TABLE_NAME, columns,where, null, null, null, null);
			
			if(cursor !=  null){
				cursor.moveToFirst();
				countLeads = new ArrayList<String>(cursor.getCount());
				while(!cursor.isAfterLast()){
					countLeads.add(cursor.getString(1));
					cursor.moveToNext();
					q++;
				}
			    return q;
			}
			return q;
	}

public ArrayList<String> packageDetails()
{
	//ArrayList<String> dBUniqueCodesLead;
	//String where=Contact_table.signinEmail +  " = '" + user + "'";	
	String[] columns  = new  String[]{Package_Table.id,Package_Table.package_id,Package_Table.package_name,
			                          Package_Table.adults,Package_Table.children,Package_Table.package_description,
			                          };
	
	Cursor cursor = database.query(Contact_table.TABLE_NAME, columns,null, null, null, null, null);
	
	if(cursor !=  null){
		cursor.moveToFirst();
		dBUniqueCodesLead = new ArrayList<String>(cursor.getCount());
		while(!cursor.isAfterLast()){
			dBUniqueCodesLead.add(cursor.getString(16));
		
			
			cursor.moveToNext();
		}
	    return dBUniqueCodesLead ;
	}
	return null;	
}

public ArrayList<Integer> getPackageDetails()
{
	
	//List<ArrayList<String>> leadValue2D=new ArrayList<ArrayList<String>>();
	ArrayList<Integer> packageValues=new ArrayList<Integer>();
    int t=0;
	//String where=NLead_Table.signinEmail +   " = '" + user + "'";
		String[] columns = new String[] {Package_Table.id,Package_Table.package_id,Package_Table.package_name};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Package_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					packageValues.add(cursor.getInt(0));
					//t++;
					cursor.moveToNext();
				
				}
				cursor.close();
			}
				
			return packageValues;
	
}

public ArrayList<Integer> getHotelDetails()
{
	
	//List<ArrayList<String>> leadValue2D=new ArrayList<ArrayList<String>>();
	ArrayList<Integer> packageValues=new ArrayList<Integer>();

	String[] columns = new String[] {Hotel_Table.id};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Hotel_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					packageValues.add(cursor.getInt(0));
					//t++;
					cursor.moveToNext();
				
				}
				cursor.close();
			}
				
			return packageValues;
	
}

public ArrayList<Integer> getStayDetails()
{
	
	//List<ArrayList<String>> leadValue2D=new ArrayList<ArrayList<String>>();
	ArrayList<Integer> packageValues=new ArrayList<Integer>();

	String[] columns = new String[] {Stay_Table.id};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Stay_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					packageValues.add(cursor.getInt(0));
					//t++;
					cursor.moveToNext();
				
				}
				cursor.close();
			}
				
			return packageValues;
	
}

public ArrayList<Integer> getTravelDetails()
{
	
	//List<ArrayList<String>> leadValue2D=new ArrayList<ArrayList<String>>();
	ArrayList<Integer> packageValues=new ArrayList<Integer>();

	String[] columns = new String[] {Travel_Table.id};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Travel_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					packageValues.add(cursor.getInt(0));
					//t++;
					cursor.moveToNext();
				
				}
				cursor.close();
			}
				
			return packageValues;
	
}


public ArrayList<String> getBookingSyncTime()
{
	
	

	ArrayList<String> bookingValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Table._id,Booking_Table.booking_id,Booking_Table.booking_number};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Booking_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					bookingValues.add(cursor.getString(2));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return bookingValues;
	
}

public ArrayList<String> getPackageSychTime()
{
	
	

	ArrayList<String> bookingValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Package_Table.id,Package_Table.package_id,Package_Table.package_name,
			Package_Table.adults,Package_Table.children,Package_Table.package_description,Package_Table.date};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Package_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					bookingValues.add(cursor.getString(6));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return bookingValues;
	
}

public ArrayList<String> getTravellerId()
{
	
	

	ArrayList<String> bookingValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	
	String[] columns = new String[] {Traveller_Details_Table.id,Traveller_Details_Table.traveller_id,Traveller_Details_Table.t_salutation,
			                         Traveller_Details_Table.t_gender,Traveller_Details_Table.t_address,
			                         Traveller_Details_Table.t_country,Traveller_Details_Table.t_m_no,
			                         Traveller_Details_Table.t_id_type,Traveller_Details_Table.t_city_name,
			                         Traveller_Details_Table.t_zipcode,Traveller_Details_Table.traveller_name,
			                         Traveller_Details_Table.t_email,Traveller_Details_Table.t_id_num,
			                         Traveller_Details_Table.t_state_name,Traveller_Details_Table.synch_Id};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Traveller_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					bookingValues.add(cursor.getString(14));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return bookingValues;
	
}
public ArrayList<String> getBookingStayId()
{
	
	

	ArrayList<String> bookingValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	
	String[] columns = new String[] {Booking_Stay_Details.id,Booking_Stay_Details.stay_id,
			Booking_Stay_Details.day_seq,Booking_Stay_Details.name,Booking_Stay_Details.city,
			Booking_Stay_Details.desc,Booking_Stay_Details.synch_Id,Booking_Stay_Details.stay};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Booking_Stay_Details.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					bookingValues.add(cursor.getString(7));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return bookingValues;
	
}
public ArrayList<String> getStaySyncId()
{
	ArrayList<String> stayValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Stay_Table.id,Stay_Table.stay_id,Stay_Table.stay_city,Stay_Table.days,
			Stay_Table.desc,Stay_Table.staySyncId};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Stay_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					stayValues.add(cursor.getString(5));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return stayValues;
	
}

public ArrayList<String> getTravelSyncId()
{
	ArrayList<String> travelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Travel_Table.id,Travel_Table.travel_id,Travel_Table.travel_mode,
			Travel_Table.source,Travel_Table.destination,Travel_Table.travel,Travel_Table.day_seq,Travel_Table.price,
			Travel_Table.travelSyncId};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Travel_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					travelValues.add(cursor.getString(8));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return travelValues;
	
}

public ArrayList<String> getHotelSyncId()
{
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Hotel_Table.id,Hotel_Table.hotel_id,Hotel_Table.hotel,Hotel_Table.hotel_address,
			Hotel_Table.hotel_city,Hotel_Table.stars,Hotel_Table.hotelSyncId};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Hotel_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(6));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}

public ArrayList<String> getBookingTravelId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Travel_Details_Table.id,Booking_Travel_Details_Table.synch_id};
			//String where=NLead_Table.status + " = " + 2;
			Cursor cursor = database.query(Booking_Travel_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(1));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}

public ArrayList<String> getBookingHotelId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Hotel_Details_Table.id,Booking_Hotel_Details_Table.hotel_id,
			Booking_Hotel_Details_Table.hotel_name,Booking_Hotel_Details_Table.city_name,
			Booking_Hotel_Details_Table.address,Booking_Hotel_Details_Table.stars,Booking_Hotel_Details_Table.hotel,
			Booking_Hotel_Details_Table.synchId};
			//String where=NLead_Table.status + " = " + 2;
			
	Cursor cursor = database.query(Booking_Hotel_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(7));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}

public ArrayList<String> getBookingRoomId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Room_Details_Table.id,Booking_Room_Details_Table.synchId};
			//String where=NLead_Table.status + " = " + 2;
			
	Cursor cursor = database.query(Booking_Room_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(1));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}
public ArrayList<String> getBookingMealId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Meal_Details_Table.id,Booking_Meal_Details_Table.synchId};
			//String where=NLead_Table.status + " = " + 2;
			
	Cursor cursor = database.query(Booking_Meal_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(1));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}
public ArrayList<String> getBookingAmenityId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Amenity_Details_Table.id,Booking_Amenity_Details_Table.synchId};
			//String where=NLead_Table.status + " = " + 2;
			
	Cursor cursor = database.query(Booking_Amenity_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(1));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}

public ArrayList<String> getContactServerId() {
	// TODO Auto-generated method stub
	ArrayList<String> hotelValues=new ArrayList<String>();
	//String where=ServerSynchTime.signinEmail +  " = '" + user + "'";
	//String where =ServerSynchTime.signinEmail +  " = '" + user + "'";
	String[] columns = new String[] {Booking_Amenity_Details_Table.id,Booking_Amenity_Details_Table.synchId};
			//String where=NLead_Table.status + " = " + 2;
			
	Cursor cursor = database.query(Booking_Amenity_Details_Table.TABLE_NAME,columns,null,null,null,null,null);
			
				if(cursor !=  null)
				{
			
				cursor.moveToFirst();
				while(!cursor.isAfterLast())
				{
					
					hotelValues.add(cursor.getString(1));
					
			
					
					cursor.moveToNext();
				
				}
				cursor.close();
			}
			return hotelValues;
	
}


public int stayRegardingBooking(int booking_no) {
	// TODO Auto-generated method stub
	String where =Booking_Stay_Details.stay +  " = " +booking_no;
	int hotelValue = 0;	
	String[] columns = new String[] {Booking_Stay_Details.id,Booking_Stay_Details.stay_id,Booking_Stay_Details.day_seq,
			Booking_Stay_Details.name,Booking_Stay_Details.city,Booking_Stay_Details.desc,
			Booking_Stay_Details.synch_Id,Booking_Stay_Details.stay};
		//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(Booking_Stay_Details.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					
						hotelValue=cursor.getInt(0);					
					
					cursor.close();
				}
				return hotelValue;
		
}

public int stayRegardingPackage(int booking_no) {
	// TODO Auto-generated method stub
	String where =Stay_Table.staySyncId +  " = " +booking_no;
	int hotelValue = 0;	
	String[] columns = new String[] {Stay_Table.id,Stay_Table.stay_id,Stay_Table.stay_city,Stay_Table.days,
			Stay_Table.desc,Stay_Table.staySyncId};
		
	//String where=NLead_Table.status + " = " + 2;
				Cursor cursor = database.query(Stay_Table.TABLE_NAME,columns,where,null,null,null,null);
				
					if(cursor !=  null)
					{
				
					cursor.moveToFirst();
					
						hotelValue=cursor.getInt(5);					
					
					cursor.close();
				}
				return hotelValue;
		
}


}
