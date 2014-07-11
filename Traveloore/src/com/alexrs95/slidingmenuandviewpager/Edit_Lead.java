package com.alexrs95.slidingmenuandviewpager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.NLead_Table;

public class Edit_Lead extends SherlockFragmentActivity implements OnClickListener
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
	String first,last,company,titleValue,industry,phone,email,websiteValue,address,facebook,twitter,linkedin,skype,descriptionValue;
	Cursor cursor;
	String storeValue[];
	String user;
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // We'll define a custom screen layout here (the one shown above), but
        // typically, you could just use the standard ListActivity layout.
        setContentView(R.layout.lead_list_edit);
        final ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
		rowId=getIntent().getIntExtra("id",1);
		user=getIntent().getStringExtra("extra");
		System.out.println("Value is"+rowId);
		getSherlock().getActionBar().setIcon(R.drawable.data_edit);
		//rowId=Integer.parseInt(name);
		//Toast.makeText(this,name,Toast.LENGTH_LONG).show();
		mdc= new MyDatabaseClass(this);
		mdc.open();
		//cursor=mdc.getValueToEdit1(rowId);
		storeValue=mdc.getValueToEdit1(rowId);
		first=storeValue[0];
		last=storeValue[1];
		company=storeValue[2];
		titleValue=storeValue[3];
		industry=storeValue[4];
		phone=storeValue[5];
		websiteValue=storeValue[6];
		address=storeValue[7];
		email=storeValue[8];
		facebook=storeValue[9];
		twitter=storeValue[10];
		linkedin=storeValue[11];
		skype=storeValue[12];
		descriptionValue=storeValue[13];
		
		create();
		initialize1();
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
		case android.R.id.home :
			Edit_Lead.this.finish();
			break;
		
		case R.id.lead_edit:
			namvalue = first_name.getText().toString();
			Calendar c = Calendar.getInstance();
		    System.out.println("Current time => "+c.getTime());

		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String formattedDate = df.format(c.getTime());

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
			
				ContentValues cv = new ContentValues();
				cv.put(NLead_Table.firstname, first_name.getText().toString());
				cv.put(NLead_Table.lastname, last_name.getText().toString());
				cv.put(NLead_Table.company, company_name.getText().toString());
				cv.put(NLead_Table.title, title.getText().toString());
				cv.put(NLead_Table.industry, industry_name.getText()
						.toString());
				cv.put(NLead_Table.phone_no, phone_no.getText()
						.toString());
				cv.put(NLead_Table.emailAddress, email_address.getText().toString());
				cv.put(NLead_Table.website, website.getText().toString());
				cv.put(NLead_Table.address, postal_address.getText()
						.toString());
				cv.put(NLead_Table.facebook, facebook_id.getText().toString());
				cv.put(NLead_Table.twitter, twitter_id.getText().toString());
				cv.put(NLead_Table.linked_in, linkedin_id.getText()
						.toString());
				cv.put(NLead_Table.skype, skype_id.getText().toString());
				cv.put(NLead_Table.description, description.getText().toString());
				cv.put(NLead_Table.description, description.getText().toString());

				cv.put(NLead_Table.modified_date_time, 2);
				String where = NLead_Table.lead_id + "=" + rowId;
				Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/" + rowId);
				getContentResolver().update(uri, cv, where, null);
				
				//Uri uri = getContentResolver().insert(
				//		MyDatabaseProvider.CONTENT_URI, cv);
				//Toast.makeText(getApplicationContext(),
					//	"return is " + uri.toString(), Toast.LENGTH_SHORT)
						//.show();
				Toast.makeText(this, "Lead Edited", Toast.LENGTH_LONG).show();

			Edit_Lead.this.finish();
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

