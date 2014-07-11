package com.alexrs95.slidingmenuandviewpager;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import android.widget.TextView;
import android.widget.TimePicker;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.AddTask_Table;
import com.btpl.database.MyDatabaseClass;


public class Edit_Task extends SherlockActivity implements OnClickListener {

	Button btnDate;
	Button btnTime;
	int hour1, minute1;
	TextView lblDateAndTime;
	EditText et_Description;
	DateFormat fmtDateAndTime = DateFormat.getDateTimeInstance();
	Calendar myCalendar = Calendar.getInstance();
	DatePickerDialog.OnDateSetListener d;
	TimePickerDialog.OnTimeSetListener t;
	Spinner assignedTo,associatedWith,choice;
	Dialog dialog1;
	ArrayList<String> list,list1,list2,list3;
	String text_change,ddes;
	private int mYear;
	private int mMonthOfYear;
	private int mDay_Of_Month;
int rowId;
MyDatabaseClass mdc;
TextView text;
String[] storeValue;
String description,date,time,assigned_To;
String user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);
		getSherlock().getActionBar().setIcon(R.drawable.data_edit);
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		user=getIntent().getStringExtra("extra");
		setContentView(R.layout.edit_task);
		rowId=getIntent().getIntExtra("id",1);
		et_Description=(EditText)findViewById(R.id.et_Description);
		associatedWith=(Spinner)findViewById(R.id.associated_with);
		//assignedTo=(Spinner)findViewById(R.id.assignedTo);
		choice=(Spinner)findViewById(R.id.choose);
		btnDate = (Button) findViewById(R.id.btnDate);
		btnTime = (Button) findViewById(R.id.btnTime);
	    text=(TextView)findViewById(R.id.text_change);
mdc=new MyDatabaseClass(this);
mdc.open();

storeValue=mdc.getValueToEditTask(rowId,user);

		//setTitle("Edit Task");
		
	description=storeValue[0];
	//date=storeValue[1];
	//time=storeValue[2];
	//assigned_To=storeValue[3];
	
		
	
	et_Description.setText(description);

		//String []cities=getResources().getStringArray(R.array.app_name);
		//final Spinner s1=(Spinner)findViewById(R.id.spinner1);
		///ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.app_name, android.R.layout.simple_dropdown_item_1line);
	//android.R.layout.simple_spinner_item);
	//adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	//associatedwith.setAdapter(adapter);
	
	
	String []name=getResources().getStringArray(R.array.app_name1);
	ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(this,R.array.app_name1, android.R.layout.simple_dropdown_item_1line);
	//android.R.layout.simple_spinner_item);
	adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	assignedTo.setAdapter(adapter1);
	
	String []resource=getResources().getStringArray(R.array.app_name2);
	ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.app_name2,android.R.layout.simple_dropdown_item_1line);
	adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	associatedWith.setAdapter(adapter2);
	associatedWith.setOnItemSelectedListener(new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
				long id) {
			// TODO Auto-generated method stub
			switch(position)
			{
			case 0:
				text.setText("Deals list");
				MyDatabaseClass dbc=new MyDatabaseClass(getBaseContext());
				dbc.open();
				ArrayList<String> deal=dbc.getAllDeals(user);
				list1=new ArrayList<String>();
				list1.addAll(deal);
				dbc.close();
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						Edit_Task.this,android.R.layout.simple_dropdown_item_1line,list1);
				choice.setAdapter(adapter);
				break;
			
			case 1:	
				text.setText("Contacts List");
				MyDatabaseClass dbc1=new MyDatabaseClass(getBaseContext());
				dbc1.open();
				ArrayList<String> contact =dbc1.getFirstName(user);
				list1=new ArrayList<String>();
				list1.addAll(contact);
				dbc1.close();
				ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
						Edit_Task.this,android.R.layout.simple_dropdown_item_1line,list1);
				choice.setAdapter(adapter1);
				break;
				
			case 2:
				text.setText("Leads List");
				MyDatabaseClass dbc2=new MyDatabaseClass(getBaseContext());
				dbc2.open();
				ArrayList<String> lead =dbc2.getfirstNameLead(user);
				list1=new ArrayList<String>();
				list1.addAll(lead);
				dbc2.close();
				ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
						Edit_Task.this,android.R.layout.simple_dropdown_item_1line,list1);
				choice.setAdapter(adapter2);
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			
		}
	});

		


		//ArrayAdapter<String> adaptor =new ArrayAdapter<String>(this,R.layout.addtask,R.id.taskassociatedto);
		//associatedwith.setAdapter(adaptor);
		
		//ArrayAdapter<String> adaptor1 = new ArrayAdapter<String>(this,R.layout.addtask,R.id.taskassignedto);
		//assignedTo.setAdapter(adaptor1);
		
		
		
		d = new DatePickerDialog.OnDateSetListener() 
		{

			public void onDateSet(DatePicker view, int year, int monthOfYear,int dayOfMonth) 
			{
				myCalendar.set(Calendar.YEAR, year);
				myCalendar.set(Calendar.MONTH, monthOfYear);
				myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

				mYear = year;
				mMonthOfYear = monthOfYear;
				mDay_Of_Month = dayOfMonth;

				btnDate.setText(mDay_Of_Month + "/" + mMonthOfYear + "/"
						+ mYear);

			}

		};

		btnDate.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new DatePickerDialog(Edit_Task.this, d, myCalendar
						.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
						myCalendar.get(Calendar.DAY_OF_MONTH)).show();
			}
		});
		t = new TimePickerDialog.OnTimeSetListener() {
			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
				myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
				myCalendar.set(Calendar.MINUTE, minute);
				hour1 = hourOfDay;
				minute1 = minute;

				// btnTime.setText(mhour_Of_Day+":"+mMinute);

				if (hour1 > 12) {

					btnTime.setText(String.valueOf(hour1 - 12) + ":"
							+ (String.valueOf(minute1) + " pm"));
				}
				if (hour1 == 12) {
					btnTime.setText("12" + ":"
							+ (String.valueOf(minute1) + " pm"));
				}
				if (hour1 == 24) {
					btnTime.setText("12" + ":"
							+ (String.valueOf(minute1) + " am"));

				}
				if (hour1 < 12) {
					btnTime.setText(String.valueOf(hour1) + ":"
							+ (String.valueOf(minute1) + " am"));
				}

			}

		};

		btnTime.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new TimePickerDialog(Edit_Task.this, t, myCalendar
						.get(Calendar.HOUR_OF_DAY), myCalendar
						.get(Calendar.MINUTE), true).show();
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.edit_task_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			Edit_Task.this.finish();
			break;
			
		case R.id.task_edit :
			ddes= et_Description.getText().toString();
			if (TextUtils.isEmpty(ddes)) {
				 
				 Toast toast1=Toast.makeText(this, "Some fields are not valid", Toast.LENGTH_SHORT);
					TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();
					et_Description.setError("Content can not be empty");
				
				//focusView = first_name;
				//cancel = true;
				return false;
			}
			ContentValues cv2 =new ContentValues();
			cv2.put(AddTask_Table.description, ddes);
			cv2.put(AddTask_Table.date, btnDate.getText().toString());
			cv2.put(AddTask_Table.time, btnTime.getText().toString());
			cv2.put(AddTask_Table.associatedwith, associatedWith.getSelectedItem().toString());
			//cv2.put(AddTask_Table.assignedto, assignedTo.getSelectedItem().toString());
			cv2.put(AddTask_Table.tabletype,"addtask");
			String where =AddTask_Table.addtask_id + " = " + rowId;
			Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/addtask_table/" + rowId);
			getContentResolver().update(uri, cv2, where, null);
			Toast.makeText(getApplicationContext(),"Task Edited", Toast.LENGTH_SHORT)
					.show();
				Edit_Task.this.finish();
				 	 	 
			break;			
			
		case R.id.cancel:
			Edit_Task.this.finish();
			break;
		case R.id.addTask:
			Edit_Task.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}

}