package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Contact_table;
import com.btpl.database.MyDatabaseClass;

@SuppressLint("ValidFragment")
public class Add_Contact_Which_Is_Lead_Edit extends SherlockFragmentActivity implements OnClickListener
{

	EditText first_name, last_name, company_name, title, industry_name,
			phone_no, email_address, website, postal_address, facebook_id,
			twitter_id, linkedin_id, skype_id, description;
	LinearLayout basic_layout, contact_layout, social_layout,
			description_layout;
	ArrayList<String> getPhone,getEamil,combine;
	//private LoaderManager.LoaderCallbacks<Cursor> mCallbacks;

	Button basic_button, contact_button, social_button, description_button;
	String EXTRA,namvalue,emaivalue,numbevalue;
    int rowId;
	String name;
	//String[] value;
	//Cursor cursor;
	MyDatabaseClass mdc;
	//SimpleCursorAdapter adapter;
	//String mCurFilter;
	SimpleCursorAdapter adapter;
	ListView list;
	String first,last,company,titleValue,industry,phone,facebook,twitter,linkedin,skype,address,email,
	websiteValue,descriptionValue;
	Cursor cursor;
	String storeValue[];
	String user;
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.lead_list_edit);
        ActionBar bar = getSupportActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		getSherlock().getActionBar().setIcon(R.drawable.data_edit);
user=getIntent().getStringExtra("extra");
		rowId=getIntent().getIntExtra("id",1);
		System.out.println("Value is" +rowId);
		//rowId=Integer.parseInt(name);
		//Toast.makeText(this,name,Toast.LENGTH_LONG).show();
		mdc= new MyDatabaseClass(this);
		mdc.open();
		//cursor=mdc.getValueToEdit(rowId);
		storeValue=mdc.getValueToEdit(rowId);
		first=storeValue[0];
		last=storeValue[1];
		company=storeValue[2];
		titleValue=storeValue[3];
		industry=storeValue[4];
		phone=storeValue[5];
		facebook=storeValue[6];
		twitter=storeValue[7];
		linkedin=storeValue[8];
		skype=storeValue[9];
		address=storeValue[10];
		email=storeValue[11];
		websiteValue=storeValue[12];
		descriptionValue=storeValue[13];
		
		
		
		//String[] FROM_LEAD = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.lastname,NLead_Table.company,NLead_Table.title,NLead_Table.industry,
		//		 NLead_Table.phone_no,NLead_Table.emailAddress,NLead_Table.website,NLead_Table.address,NLead_Table.facebook,NLead_Table.twitter,
		//		 NLead_Table.linked_in,NLead_Table.skype,NLead_Table.description};
		//int[] TO_LEAD = new int[] {R.id.lead_id,R.id.et_firstname,R.id.et_lastname,R.id.et_companyname,R.id.et_title,R.id.et_industry,R.id.et_phoneno,
		//		R.id.et_email,R.id.et_website,R.id.et_adress,R.id.et_facebook,R.id.et_twitter,R.id.et_linkedin,R.id.et_skype,R.id.et_description};
		//adapter = new SimpleCursorAdapter(this,
				//R.layout.lead_list_edit, null, FROM_LEAD, TO_LEAD, 0);
		//list = (ListView) findViewById(android.R.id.list);
		//list.setEmptyView(findViewById(R.id.empty));
		create();
		initialize1();
		//first =(cursor.getString(cursor.getColumnIndex(NLead_Table.firstname)));
       // last =(cursor.getString(cursor.getColumnIndex(NLead_Table.lastname)));
        first_name.setText(first);
        last_name.setText(last);
		company_name.setText(company);
		title.setText(titleValue);
		industry_name.setText(industry);
		phone_no.setText(phone);
		email_address.setText(email);
		website.setText(websiteValue);
		postal_address.setText(address);
		facebook_id.setText(facebook);
		twitter_id.setText(twitter);
		linkedin_id.setText(linkedin);
		skype_id.setText(skype);
		description.setText(descriptionValue);
        //last_name.setText(last);
        
	//list.setAdapter(adapter);
	    
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
        
    	//getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		

       
    }
	
		private void initialize1() {

		first_name = (EditText) findViewById(R.id.et_firstname);
		last_name = (EditText) findViewById(R.id.et_lastname);
		company_name = (EditText) findViewById(R.id.et_companyname);
		title = (EditText) findViewById(R.id.et_title);
		industry_name = (EditText) findViewById(R.id.et_industry);
		phone_no = (EditText) findViewById(R.id.et_phoneno);
		email_address = (EditText) findViewById(R.id.et_email);
		website = (EditText) findViewById(R.id.et_website);
		postal_address = (EditText) findViewById(R.id.et_adress);
		facebook_id = (EditText) findViewById(R.id.et_facebook);
		twitter_id = (EditText) findViewById(R.id.et_twitter);
		linkedin_id = (EditText) findViewById(R.id.et_linkedin);
		skype_id = (EditText) findViewById(R.id.et_skype);
		description = (EditText) findViewById(R.id.et_description);
	}

	public void create() {

		basic_layout = (LinearLayout) findViewById(R.id.basic_layout);
		contact_layout = (LinearLayout) findViewById(R.id.contact_layout);
		social_layout = (LinearLayout) findViewById(R.id.social_layout);
		description_layout = (LinearLayout) findViewById(R.id.description_layout);

		basic_button = (Button) findViewById(R.id.button);
		contact_button = (Button) findViewById(R.id.button2);
		social_button = (Button) findViewById(R.id.button3);
		description_button = (Button) findViewById(R.id.button4);

		basic_button.setOnClickListener(this);
		social_button.setOnClickListener(this);
		contact_button.setOnClickListener(this);
		description_button.setOnClickListener(this);

		show(basic_layout);
		hide(social_layout);
		hide(description_layout);
		hide(contact_layout);

	}

	public void hide(LinearLayout id) {

		id.setVisibility(View.GONE);

	}

	public void show(LinearLayout id) {

		id.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View arg0) {

		Button myButton = (Button) arg0;

		String text = (String) myButton.getText();

		if (text == basic_button.getText()) {
			if (basic_layout.getVisibility() == View.VISIBLE) {
				basic_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(basic_layout);
			} else {
				basic_button.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(basic_layout);
			}

		} else if (text == contact_button.getText()) {
			if (contact_layout.getVisibility() == View.VISIBLE) {
				contact_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(contact_layout);
			} else {
				contact_button.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(contact_layout);
			}

		} else if (text == social_button.getText()) {
			if (social_layout.getVisibility() == View.VISIBLE) {
				social_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(social_layout);
			} else {
				social_button.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(social_layout);
			}

		} else if (text == description_button.getText()) {
			if (description_layout.getVisibility() == View.VISIBLE) {
				description_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(description_layout);
			} else {
				description_button.setBackgroundColor(this.getResources()
						.getColor(R.color.traveloore_green_theme));
				show(description_layout);
			}

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.lead_edit_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Add_Contact_Which_Is_Lead_Edit.this.finish();
			break;
		case R.id.lead_edit:
			namvalue = first_name.getText().toString();
			//emaivalue=email_address.getText().toString();
			//numbevalue=phone_no.getText().toString();
			if (TextUtils.isEmpty(namvalue)) {
				Toast toast1=Toast.makeText(this, "Some Fields are not valid", Toast.LENGTH_SHORT);
				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
				v.setTextColor(Color.WHITE);
				toast1.show();	
				first_name.setError("This Field can not be empty");
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			
			
				ContentValues cv = new ContentValues();
				cv.put(Contact_table.firstname, first_name.getText().toString());
				cv.put(Contact_table.lastname, last_name.getText().toString());
				cv.put(Contact_table.company, company_name.getText().toString());
				cv.put(Contact_table.title, title.getText().toString());
				cv.put(Contact_table.industry, industry_name.getText()
						.toString());
				cv.put(Contact_table.emailid, email_address.getText()
						.toString());
				cv.put(Contact_table.phone_no, phone_no.getText().toString());
				cv.put(Contact_table.website, website.getText().toString());
				cv.put(Contact_table.address, postal_address.getText()
						.toString());
				cv.put(Contact_table.facebook, facebook_id.getText().toString());
				cv.put(Contact_table.twitter, twitter_id.getText().toString());
				cv.put(Contact_table.linked_in, linkedin_id.getText()
						.toString());
				cv.put(Contact_table.skype, skype_id.getText().toString());
				cv.put(Contact_table.description, description.getText()
						.toString());
				cv.put(Contact_table.table_type,"contact");
				cv.put(Contact_table.modified_status, 2);
				String where = Contact_table.contact_id + "=" + rowId;
				Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/contact_table/" + rowId);
				getContentResolver().update(uri, cv, where, null);
				
				//Uri uri = getContentResolver().insert(
				//		MyDatabaseProvider.CONTENT_URI, cv);
				Toast.makeText(getApplicationContext(),"Contact Edited", Toast.LENGTH_SHORT)
						.show();
				//Toast.makeText(this, "Contact Saved", Toast.LENGTH_LONG).show();

			Add_Contact_Which_Is_Lead_Edit.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	public static boolean isEmailValid(String emailvalue) {
	    boolean isValid = false;

	    String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	    CharSequence inputStr = emailvalue;

	    Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(inputStr);
	    if (matcher.matches()) {
	        isValid = true;
	    }
	    return isValid;
	}

		}

