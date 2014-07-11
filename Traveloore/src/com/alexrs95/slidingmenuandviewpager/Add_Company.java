package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Company_Table;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;

public class Add_Company extends SherlockActivity implements OnClickListener {

	EditText company_name, industry_name, owner_name, email_address, phone_number,
			website, address,region_code,country, facebook_id,
			twitter_id, linkedin_id, skype_id, description;
	LinearLayout basic_layout, contact_layout, social_layout,
			description_layout;

	Button basic_button, contact_button, social_button, description_button;
	String EXTRA,namvalue,emaivalue,numbevalue,addvalue,regvalue;
    String [] countries;
	Spinner s1;
	ArrayList<String> getOwner,getCompany,getAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_new_contacts);
		countries=getResources().getStringArray(R.array.countries);
		s1=(Spinner)findViewById(R.id.spcountry);
		ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.countries, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		s1.setAdapter(adapter);

		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);
		
		//EXTRA = getIntent().getStringExtra("extra");

		//if (EXTRA.contains("contact")) {
		//	this.setTitle("ADD Contact");
		//} else {
		//	this.setTitle("ADD Lead");
		//}

		create();
		initialize1();
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
	}

	private void initialize1() {

		company_name = (EditText) findViewById(R.id.et_company);
		industry_name = (EditText) findViewById(R.id.et_industry);
		//owner_name = (EditText) findViewById(R.id.et_ownername);
		email_address = (EditText) findViewById(R.id.et_email);
		phone_number = (EditText) findViewById(R.id.et_phoneno);
		website = (EditText) findViewById(R.id.et_website);
		address = (EditText) findViewById(R.id.et_address);
		region_code = (EditText) findViewById(R.id.et_rcode);
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

		//hide(basic_layout);
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
		inflater.inflate(R.menu.add_company_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case android.R.id.home:
			Add_Company.this.finish();
			break;
		case R.id.ok_company:
			//created by shikha singh
			namvalue = company_name.getText().toString();
			emaivalue=email_address.getText().toString();
			numbevalue=phone_number.getText().toString();
			addvalue=address.getText().toString();
			//regvalue=region_code.getText().toString();
		
			
			if (TextUtils.isEmpty(namvalue)) {
				 
				 Toast toast1=Toast.makeText(this, "Please enter the Company name", Toast.LENGTH_SHORT);
					TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();
					company_name.setError("This field can not be empty");
				
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			/*else if (namvalue.length() < 4) {
				company_name.setError("At least 2 char long name required");
				//focusView = editText1;
				//cancel = true;
				return false;
			}*/
			boolean emailChecker=isEmailValid(emaivalue);
			if(emailChecker==false)
			{
				Toast toast1 = Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT);
				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
				v.setTextColor(Color.GREEN);
				toast1.show();
            return false;		
			}
			
			if (TextUtils.isEmpty(numbevalue)) {
				
				 Toast toast1=Toast.makeText(this, "Please enter the Phone Number", Toast.LENGTH_SHORT);
					TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.GREEN);
					toast1.show();
			
				//focusView = editText7;
				//cancel = true;
				return false;
			} 
			else if (numbevalue.length() < 10) {
				phone_number.setError("Mobile Number Should be of 10 digit");
				//focusView = phone_no;
				//cancel = true;
				return false;
			}
/*
			if (TextUtils.isEmpty(addvalue)) {
				 Toast toast1=Toast.makeText(this, "Please enter the Address", Toast.LENGTH_SHORT);
				 TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.GREEN);
					toast1.show();  
				
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			
			
			
			boolean avoidRepition=checkCompanyExist(namvalue, addvalue,owner_name.getText().toString());
			if(avoidRepition==true)
			{
				Toast toast1 = Toast.makeText(this, "Company already registered", Toast.LENGTH_LONG);
				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
				v.setTextColor(Color.GREEN);
				toast1.show();
 return false;		
			}
			*/
			else
			{
				ContentValues cv = new ContentValues();
				cv.put(Company_Table.company, company_name.getText().toString());
				cv.put(Company_Table.industry, industry_name.getText().toString());
				//cv.put(Company_Table.owner, owner_name.getText().toString());
				///cv.put(Contact_table.emailid, email_address.getText().toString());
				///cv.put(Contact_table.phone_no, phone_number.getText()
				//		.toString());
				///cv.put(Contact_table.website, website.getText()
				//		.toString());
				//cv.put(Contact_table.address, address.getText().toString());
				////cv.put(Company_Table.region_code, region_code.getText().toString());
				//cv.put(Company_Table.country, s1.getSelectedItem().toString());
				//cv.put(Contact_table.facebook, facebook_id.getText().toString());
				///cv.put(Contact_table.twitter, twitter_id.getText().toString());
				//cv.put(Contact_table.linked_in, linkedin_id.getText()
				//		.toString());
				//cv.put(Contact_table.skype, skype_id.getText().toString());
				//cv.put(Contact_table.description, description.getText()
				//		.toString());
				//cv.put(Contact_table.table_type,"contact");
				//cv.put(Contact_table.status, 1);
				//cv.put(Contact_table.modified_status, 1);


				getContentResolver().insert(
						MyDatabaseProvider.ADD_COMPANY_CONTENT_URI, cv);
				//Toast.makeText(getApplicationContext(),
					//	"return is " + uri.toString(), Toast.LENGTH_SHORT)
						//.show();
				Toast.makeText(this, "Company Saved", Toast.LENGTH_LONG).show();

			Add_Company.this.finish();
			}
			break;
		case R.id.cancel_company:
			Add_Company.this.finish();
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
	
	/*
	public boolean checkCompanyExist(String company,String address,String owner)
	{
		//boolean check1,check2;
		boolean check3;
		MyDatabaseClass mdc = new MyDatabaseClass(Add_Company.this);
		mdc.open();
		getCompany = new ArrayList<String>();
		getAddress = new ArrayList<String>();
		getOwner = new ArrayList<String>();
		
		getCompany=mdc.checkCompanyTable_CompanyName();
		getAddress=mdc.checkCompanyTable_Address();
		getOwner=mdc.checkCompanyTable_OwnerName();
		mdc.close();
		//check1=getCompany.contains(company);
		//check2=getAddress.contains(address);
		check3=getOwner.contains(owner);
		//if(check1==true && check2==true && check3==true)
			//check4=true;
		return check3;
	}
*/
}