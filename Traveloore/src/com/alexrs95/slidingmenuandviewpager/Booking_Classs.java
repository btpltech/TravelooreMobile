package com.alexrs95.slidingmenuandviewpager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Contact_table;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;

public class Booking_Classs extends SherlockActivity implements OnClickListener {

	LinearLayout package_layout,booking_layout,customer_layout;
	
    TextView package_id,package_name,advance_amount,total_amount; 
    Spinner city,state,country,identification,gender;
    EditText customer_id,customer_name,address,contact,email,adults,children,description,id_no;
	Button start_date,end_date,customer_details,booking_details,package_details;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.booking__fragment);

		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);
		
		create();
		initialize1();
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
	}

	private void initialize1() {
        package_id = (TextView) findViewById(R.id.package_id);
		package_name = (TextView) findViewById(R.id.package_name);
		advance_amount = (TextView) findViewById(R.id.advance_amount);
		total_amount = (TextView) findViewById(R.id.total_amount);
		city=(Spinner)findViewById(R.id.city);
		state=(Spinner)findViewById(R.id.state);
		country=(Spinner)findViewById(R.id.country);
		identification=(Spinner)findViewById(R.id.id_type);
		gender=(Spinner)findViewById(R.id.gender);
		customer_id=(EditText)findViewById(R.id.customer_id);
		customer_name=(EditText)findViewById(R.id.customer_name);
		address=(EditText)findViewById(R.id.address);
		contact=(EditText)findViewById(R.id.mobile_no);
		email=(EditText)findViewById(R.id.email);
		adults=(EditText)findViewById(R.id.no_of_adults);
		children=(EditText)findViewById(R.id.no_of_children);
		description=(EditText)findViewById(R.id.description);
        id_no=(EditText)findViewById(R.id.id_no);
		
		
		
	}

	public void create() {

		package_layout = (LinearLayout) findViewById(R.id.package_layout);
		 booking_layout= (LinearLayout) findViewById(R.id.booking_layout);
		 customer_layout=(LinearLayout)findViewById(R.id.customer_layout);
		
		package_details = (Button) findViewById(R.id.package_details);
		customer_details=(Button)findViewById(R.id.customer_details);
		booking_details=(Button)findViewById(R.id.booking_details);

		package_details.setOnClickListener(this);
		customer_details.setOnClickListener(this);
booking_details.setOnClickListener(this);
		//hide(basic_layout);
		hide(package_layout);
		hide(customer_layout);

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

		if (text == booking_details.getText()) {
			if (booking_layout.getVisibility() == View.VISIBLE) {
				booking_details.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(booking_layout);
			} else {
				booking_details.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(booking_layout);
			}

		} else if (text == customer_details.getText()) {
			if (customer_layout.getVisibility() == View.VISIBLE) {
				customer_details.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(customer_layout);
			} else {
				customer_details.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(customer_layout);
			}

		} 
		else if (text == package_details.getText()) {
			if (package_layout.getVisibility() == View.VISIBLE) {
				package_details.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(package_layout);
			} else {
				package_details.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(package_layout);
			}

		} 
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.booking_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.ok:
			Booking_Classs.this.finish();
		
			break;
		case R.id.cancel:
			Booking_Classs.this.finish();
			break;
	case R.id.book_now:
		Intent intentPackage = new Intent(this,Booking_Classs.class);
		startActivity(intentPackage);
		break;
	}
		
		return super.onOptionsItemSelected(item);
	}

	
}


