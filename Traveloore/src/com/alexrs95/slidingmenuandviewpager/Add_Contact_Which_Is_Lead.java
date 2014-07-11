package com.alexrs95.slidingmenuandviewpager;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.NLead_Table;

public class Add_Contact_Which_Is_Lead extends SherlockActivity implements OnClickListener {

	EditText first_name, last_name, company, title, industry,
	phone, email_address,website,address, facebook_id,
	twitter_id, linkedin_id, skype_id, description;
LinearLayout basic_layout, contact_layout, social_layout,
	description_layout;
Object result;

Button basic_button, contact_button, social_button, description_button;
String EXTRA,namvalue,emaivalue,numbevalue,companyvalue,lastvalue,uniqueKey;
String loginValue;
@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
setContentView(R.layout.add_company_which_is_lead);

ActionBar bar = getSupportActionBar();
bar.setHomeButtonEnabled(true);

loginValue=getIntent().getStringExtra("extra");
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

first_name = (EditText) findViewById(R.id.et_firstname);
last_name = (EditText) findViewById(R.id.et_lastname);
company = (EditText) findViewById(R.id.et_companyname);
title = (EditText) findViewById(R.id.et_title);
industry = (EditText) findViewById(R.id.et_industry);
phone = (EditText) findViewById(R.id.et_phoneno);
email_address = (EditText) findViewById(R.id.et_email);
website = (EditText) findViewById(R.id.et_website);
address = (EditText) findViewById(R.id.et_adress);
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

@SuppressLint("ResourceAsColor")
@Override
public boolean onOptionsItemSelected(MenuItem item) {
// TODO Auto-generated method stub
switch (item.getItemId()) {

case android.R.id.home:
	Add_Contact_Which_Is_Lead.this.finish();
	break;
case R.id.ok_company:
	namvalue = first_name.getText().toString();
	companyvalue=company.getText().toString();
	numbevalue=phone.getText().toString();
	lastvalue=last_name.getText().toString();
	Calendar c = Calendar.getInstance();
    System.out.println("Current time => "+c.getTime());

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = df.format(c.getTime());
    uniqueKey=namvalue + " " + lastvalue + " " + companyvalue + " " + formattedDate;
    //System.out.println("concatenate..c.." +uniqueKey);
    
    if (TextUtils.isEmpty(namvalue)) {
		 
		 Toast toast1=Toast.makeText(this, "Please enter the first name", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();
			first_name.setError("This field can not be empty");
		
		//focusView = first_name;
		//cancel = true;
		return false;
	} 
	
	if (TextUtils.isEmpty(lastvalue ) && (TextUtils.isEmpty(companyvalue))) {
		 
		 Toast toast1=Toast.makeText(this, "Some fields are not valid", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();
			last_name.setError("Either Last name or company name must be filled");
			company.setError("Either Last name or company name must be filled");
		
			
			
		//focusView = first_name;
		//cancel = true;
		return false;
	} 
	
	
	
	/*else if (namvalue.length() < 4) {
		first_name.setError("Atleast 4 char long name required");
		//focusView = editText1;
		//cancel = true;
		return false;*/
	
/*else if (TextUtils.isEmpty(companyvalue)) {
		 
		 Toast toast1=Toast.makeText(this, "Please enter the Company Name", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.GREEN);
			toast1.show();
		
		//focusView = first_name;
		//cancel = true;
		return false;
	} 
	else if (companyvalue.length() < 1) {
		company.setError("Atleast 1 char long name required");
		//focusView = editText1;
		//cancel = true;
		return false;
	}*/
	
	
	/*if (TextUtils.isEmpty(numbevalue)) {
		 
		 Toast toast1=Toast.makeText(this, "Please enter the Phone Number", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.GREEN);
			toast1.show();
		
		//focusView = first_name;
		//cancel = true;
		return false;
	} 
	else if (numbevalue.length() < 10) {
		phone.setError("Mobile No. should be of 10 digits");
		//focusView = editText1;
		//cancel = true;
		return false;
	}
	
	
	
	boolean contactChecker=checkUserExist(emaivalue, numbevalue);
    if(contactChecker==true)
	{
		Toast toast1 = Toast.makeText(this, "Lead already exists", Toast.LENGTH_LONG);
		TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
		v.setTextColor(R.color.traveloore_green_theme);
		toast1.show();return false;		
	}*/
		ContentValues cv = new ContentValues();
		cv.put(NLead_Table.firstname, first_name.getText().toString());
		cv.put(NLead_Table.lastname, last_name.getText().toString());
		cv.put(NLead_Table.company, company.getText().toString());
		cv.put(NLead_Table.title, title.getText().toString());
		cv.put(NLead_Table.industry, industry.getText()
				.toString());
		cv.put(NLead_Table.phone_no, phone.getText()
				.toString());
		cv.put(NLead_Table.emailAddress, email_address.getText().toString());
		cv.put(NLead_Table.website, website.getText().toString());
		cv.put(NLead_Table.address, address.getText()
				.toString());
		cv.put(NLead_Table.facebook, facebook_id.getText().toString());
		cv.put(NLead_Table.twitter, twitter_id.getText().toString());
		cv.put(NLead_Table.linked_in, linkedin_id.getText()
				.toString());
		cv.put(NLead_Table.skype, skype_id.getText().toString());
		cv.put(NLead_Table.description, description.getText()
				.toString());
		cv.put(NLead_Table.table_type,"forlead");
		cv.put(NLead_Table.date_time, formattedDate);
		cv.put(NLead_Table.modified_date_time,1);
		cv.put(NLead_Table.generated_code,uniqueKey);
		cv.put(NLead_Table.status,1);
		cv.put(NLead_Table.signinEmail,loginValue);
		 getContentResolver().insert(
				MyDatabaseProvider.LEAD_CONTENT_URI, cv);
		//Toast.makeText(getApplicationContext(),
			//	"return is " + uri.toString(), Toast.LENGTH_SHORT)
				//.show();
		Toast.makeText(this, "Lead Saved", Toast.LENGTH_LONG).show();

		Add_Contact_Which_Is_Lead.this.finish();
	break;
  case R.id.cancel_company:
	Add_Contact_Which_Is_Lead.this.finish();
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



public boolean checkUserExist(String email,String phone)
{
boolean check1,check2,check3=false;
MyDatabaseClass mdc = new MyDatabaseClass(Add_Contact_Which_Is_Lead.this);
mdc.open();
ArrayList<String>getEamil = new ArrayList<String>();
ArrayList<String>getPhone = new ArrayList<String>();
//combine = new ArrayList<String>();
getPhone=mdc.checkLeadPhoneNumber(loginValue);
getEamil=mdc.checkLeadEmail(loginValue);
mdc.close();
//combine.addAll(getFirstName);
//combine.addAll(getEamil);
check1=getPhone.contains(phone);
check2=getEamil.contains(email);
if(check1==true && check2==true)
	check3=true;
return check3;
}
}

/*public void login()
{
	//final Object result=null;

	Vector params=new Vector();
	params.addElement("traveloore");
	params.addElement("admin");
	params.addElement("1234");
	
	
	XmlRpcClient xmlrpcLogin = new XmlRpcClient();
	XmlRpcClientConfigImpl xmlrpcConfigLogin = new XmlRpcClientConfigImpl();
	xmlrpcConfigLogin.setEnabledForExtensions(true);
	try {
		xmlrpcConfigLogin.setServerURL(new URL("http", "54.251.186.100", 8069, "/xmlrpc/common"));
	} catch (MalformedURLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	xmlrpcLogin.setConfig(xmlrpcConfigLogin);


	try {
	  result =xmlrpcLogin.execute("login", params);

		System.out.println("Login Id : " + result);
	} catch (XmlRpcException e) {
		// TODO Auto-generated catch block
		System.out.println("Virus in login");
	}
	
}
*/



