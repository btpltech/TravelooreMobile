/*modified by shikha*/
package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
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
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.Package_Table;


public class AddPackage extends SherlockActivity implements OnClickListener {

	EditText package_name, package_description, package_validity,
			package_no_of_persons,source,destination,meal,hotel_name;
	TextView validity;
	AutoCompleteTextView city1;
	DatePickerDialog.OnDateSetListener d,t;
	Calendar date1=Calendar.getInstance();
	Calendar date2=Calendar.getInstance();
	//Date d1=date1.getTime();
	//Date d2=date2.getTime();
	//Calendar my=Calendar.getInstance();
	//private int m_year;
	//private int month_of_year;
	//private int day_of_month;
	
	int hour1,minute1;
	MyDatabaseClass database;
	View view;
	String[] cities,meals1;
	String EXTRA,dname,dval,dpersons,dsource,ddestination,dcity,dhname,dmeals,st;
	Spinner ccity,csource,cdestination,cmeal;
	 private int s_month,s_day,s_year,e_year,e_day,e_month;
	 int cit;
	LinearLayout mymenu,mymenu2;
	Button travel_package_button, addbtn, donebtn,start_time,end_time,stay_package_button,b;

	View rowView;
	List<Integer> list;
	static int position;
	private LinearLayout mContainerView;
	// The "Add new" button
	private Button mAddButton;

	// There always should be only one empty row, other empty rows will
	// be removed.
	private View mExclusiveEmptyView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_package);
		cities=getResources().getStringArray(R.array.cities);
		final Spinner s1=(Spinner)findViewById(R.id.choosecity);
		ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		s1.setAdapter(adapter);
		cities=getResources().getStringArray(R.array.cities);
		final Spinner s2=(Spinner)findViewById(R.id.source);
		ArrayAdapter<CharSequence> adapter1 =ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		s2.setAdapter(adapter1);
		cities=getResources().getStringArray(R.array.cities);
		final Spinner s3=(Spinner)findViewById(R.id.destination);
		ArrayAdapter<CharSequence> adapter2 =ArrayAdapter.createFromResource(this,R.array.cities, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		s3.setAdapter(adapter2);
		meals1=getResources().getStringArray(R.array.meals);
		final Spinner s4=(Spinner)findViewById(R.id.meal);
		ArrayAdapter<CharSequence> adapter3 =ArrayAdapter.createFromResource(this,R.array.meals, android.R.layout.simple_list_item_1);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		s4.setAdapter(adapter3);
	
		
	
		
		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);
		setTitle("Add Package");
		initialize();
		 create();
		

		mymenu.setVisibility(View.GONE);

		position = 0;
		list = new ArrayList<Integer>();

		mContainerView = (LinearLayout) findViewById(R.id.travel_package_layout);
		

		

		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
	}
	

     private void initialize() {
		// TODO Auto-generated method stub
		package_name=(EditText)findViewById(R.id.package_name);
		package_description=(EditText)findViewById(R.id.package_description);
		package_validity=(EditText)findViewById(R.id.package_validity);
		package_no_of_persons=(EditText)findViewById(R.id.package_noofpersons);
		csource=(Spinner)findViewById(R.id.source);
		cdestination=(Spinner)findViewById(R.id.destination);
		ccity=(Spinner)findViewById(R.id.choosecity);
		
		hotel_name=(EditText)findViewById(R.id.hotelname);
		validity=(TextView)findViewById(R.id.validity);
		cmeal=(Spinner)findViewById(R.id.meal);
		start_time=(Button)findViewById(R.id.start_time);
		end_time=(Button)findViewById(R.id.end_time);
		
		

		start_time.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new DatePickerDialog(AddPackage.this, d, date1
						.get(Calendar.YEAR), date1.get(Calendar.MONTH), date1
						.get(Calendar.DAY_OF_MONTH)).show();
				d = new DatePickerDialog.OnDateSetListener() {

					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						s_year = year;
						s_month = monthOfYear + 1;
						s_day = dayOfMonth;
						date1.set(s_year, s_month, s_day);
						start_time.setText(s_day + "/" + s_month
								+ "/" + s_year);

					}

				};
			}
		});

		end_time.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new DatePickerDialog(AddPackage.this, t, date2
						.get(Calendar.YEAR), date2.get(Calendar.MONTH), date2
						.get(Calendar.DAY_OF_MONTH)).show();
				t = new DatePickerDialog.OnDateSetListener() {
					
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						e_year = year;
						e_day = monthOfYear + 1;
						e_month = dayOfMonth;
						
						
						date2.set(e_year, e_month, e_day);
						
						end_time.setText(e_month + "/" + e_day
								+ "/" + e_year);

						long days = checkDateDiff(s_day, s_month, s_year,e_month , e_day, e_year);
						validity.setText(Long.toString(days));
						System.out.println(days);
					}

				};
			}
		});
	}

	private long checkDateDiff(int s_day, int s_month, int s_year, int e_day,
			int e_month, int e_year) {

		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		//
		// Set the date for both of the calendar instance
		//
		cal1.set(s_year, s_month, s_day);
		cal2.set(e_year, e_month, e_day);

		//
		// Get the represented date in milliseconds
		//
		long milis1 = cal1.getTimeInMillis();
		long milis2 = cal2.getTimeInMillis();

		//
		// Calculate difference in milliseconds
		//
		long diff = milis2 - milis1;

		//
		// Calculate difference in seconds
		//
		long diffSeconds = diff / 1000;

		//
		// Calculate difference in minutes
		//
		long diffMinutes = diff / (60 * 1000);

		//
		// Calculate difference in hours
		//
		long diffHours = diff / (60 * 60 * 1000);

		//
		// Calculate difference in days
		//
		long diffDays = diff / (24 * 60 * 60 * 1000);

		return diffDays;
		
	}	

	public void create() {
		// TODO Auto-generated method stub
		mymenu = (LinearLayout) findViewById(R.id.travel_package_layout);
		mymenu2=(LinearLayout)findViewById(R.id.stay_package_layout);
		travel_package_button = (Button) findViewById(R.id.addpackage);
		stay_package_button=(Button)findViewById(R.id.stay_package_button);
		stay_package_button.setOnClickListener(this);
		travel_package_button.setOnClickListener(this);
		hide(mymenu);
		hide(mymenu2);
	}

	private void hide(LinearLayout mymenu2) {
		// TODO Auto-generated method stub
		mymenu2.setVisibility(View.GONE);
	}
	
	public void show(LinearLayout id)
	{
		id.setVisibility(View.VISIBLE);
	}
	public void onAddNewClicked(View v) {
		// Inflate a new row and hide the button self.
		inflateEditRow();
		v.setVisibility(View.GONE);
	}

	int tagposition;

	public void onDeleteClicked(View v) {
		// remove the row by calling the getParent on button
		tagposition = (Integer) v.getTag();
		mContainerView.removeView((View) v.getParent());
		System.out.println("deleted position is " + tagposition);
		for (int l = 0; l < list.size(); l++) {
			if (tagposition == list.get(l)) {
				list.remove(l);
			}
		}
	}

	private void inflateEditRow() {

		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		rowView = inflater.inflate(R.layout.container_row, null);
		final ImageButton deleteButton = (ImageButton) rowView
				.findViewById(R.id.buttonDelete);

		AutoCompleteTextView autoSource = (AutoCompleteTextView) rowView
				.findViewById(R.id.source);
		AutoCompleteTextView autoDestination = (AutoCompleteTextView) rowView
				.findViewById(R.id.desti);

		autoSource.setTag("source" + position);
		autoDestination.setTag("destination" + position);
		deleteButton.setTag(position);

		list.add(position++);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, new String[] { "Kanpur",
						"Kolkata", "Varanasi" });
		autoSource.setAdapter(adapter);
		autoDestination.setAdapter(adapter);

		// A TextWatcher to control the visibility of the "Add new" button and
		// handle the exclusive empty view.
		autoSource.addTextChangedListener(new TextWatcher() {

			@SuppressLint("NewApi")
			@Override
			public void afterTextChanged(Editable s) {

				if (s.toString().length() == 0) {
					mAddButton.setVisibility(View.GONE);
					deleteButton.setVisibility(View.INVISIBLE);

					if (mExclusiveEmptyView != null
							&& mExclusiveEmptyView != rowView) {
						mContainerView.removeView(mExclusiveEmptyView);
					}
					mExclusiveEmptyView = rowView;
				} else {

					if (mExclusiveEmptyView == rowView) {
						mExclusiveEmptyView = null;
					}

					mAddButton.setVisibility(View.VISIBLE);
					deleteButton.setVisibility(View.VISIBLE);
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});

		// Inflate at the end of all rows but before the "Add new" button
		mContainerView.addView(rowView, mContainerView.getChildCount() - 1);
	}

	

	@Override
	public void onClick(View v) {
		/*switch (v.getId()) {
		case R.id.addpackage:
			if (mymenu.getVisibility() == View.GONE
					&& donebtn.getVisibility() == View.GONE) {
				mymenu.setVisibility(View.VISIBLE);
				donebtn.setVisibility(View.VISIBLE);
				//inflateEditRow();

			} else {
				mymenu.setVisibility(View.GONE);
				donebtn.setVisibility(View.GONE);
			}

			break;*/
		Button myButton=(Button)v;
		
   String text=(String)myButton.getText();
       if(text==travel_package_button.getText())
       {
    	   if(mymenu.getVisibility()==View.VISIBLE)
    	   {
    		   travel_package_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(mymenu);
			} else 
			{
				travel_package_button.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(mymenu);
    	   }
		}
       if(text==stay_package_button.getText())
       {
    	   if(mymenu2.getVisibility()==View.VISIBLE)
    	   {
    		   stay_package_button.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(mymenu2);
			} else 
			{
				stay_package_button.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(mymenu2);
   	        }
          }
       }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.package_adder, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId()){
		case android.R.id.home :
			AddPackage.this.finish();
			break;
			
		case R.id.p_adder_ok:
			dname = package_name.getText().toString();
			dval=package_validity.getText().toString();
			dpersons=package_no_of_persons.getText().toString();
			dhname=hotel_name.getText().toString();
			dcity= ccity.getSelectedItem().toString();
			dsource= csource.getSelectedItem().toString();
			ddestination= cdestination.getSelectedItem().toString();
			dmeals= cmeal.getSelectedItem().toString();
			
			if (TextUtils.isEmpty(dname)) {
				 Toast toast1=Toast.makeText(this, "Please enter the Package Name", Toast.LENGTH_SHORT);
				 TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();  
				
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			else if (dname.length() < 4) {
				package_name.setError("At least 4 char long name required");
				//focusView = editText1;
				//cancel = true;
				return false;
			}
			if (TextUtils.isEmpty(dval)) {
				 Toast toast1=Toast.makeText(this, "Please enter the Package Validity", Toast.LENGTH_SHORT);
				 TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();  
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			else if (dval.length() < 1) {
				package_validity.setError("At least 1 value is required");
				//focusView = editText1;
				//cancel = true;
				return false;
			}
			if (TextUtils.isEmpty(dpersons)) {
				 Toast toast1=Toast.makeText(this, "Please enter the No. of Persons", Toast.LENGTH_SHORT);
				 TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();  
				
				//focusView = first_name;
				//cancel = true;
				return false;
			} 
			else if (dpersons.length() < 1) {
				package_no_of_persons.setError("At least 1 person is required");
				//focusView = editText1;
				//cancel = true;
				return false;
			}
		
			 String st1=csource.getSelectedItem().toString();
				int sou=csource.getSelectedItemPosition();
				if (sou!=0)
				{
					dsource = csource.getSelectedItem().toString();  
				}
				else
				{
					Toast toast1 = Toast.makeText(this, "Choose source station", Toast.LENGTH_SHORT);
					TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
					v.setTextColor(Color.WHITE);
					toast1.show();  
		              
		                return false;  
		  
				}
				 if(!st1.equals(""))  
		         {  
		             dsource = csource.getSelectedItem().toString();  
		                        }  
		                        else{  
		                        	Toast toast1 = Toast.makeText(this, "Choose source station", Toast.LENGTH_SHORT);
		            				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
		            				v.setTextColor(Color.WHITE);
		            				toast1.show();  
		            	              
		                            return false; 
		                        }
				 String st2=cdestination.getSelectedItem().toString();
					int des=cdestination.getSelectedItemPosition();
					if (des!=0)
					{
						ddestination = cdestination.getSelectedItem().toString();  
					}
					else
					{
						Toast toast1 = Toast.makeText(this, "Choose destination station", Toast.LENGTH_SHORT);
						TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
						v.setTextColor(Color.WHITE);
						toast1.show();  
			              
			                return false;  
			  
					}
					 if(!st2.equals(""))  
			         {  
			             ddestination = cdestination.getSelectedItem().toString();  
			                        }  
			                        else{  
			                            Toast.makeText(AddPackage.this,  
			                                    "Choose destination station", Toast.LENGTH_LONG)  
			                                    .show();  
			                            return false; 
			                        }
					 st=ccity.getSelectedItem().toString();
						cit=ccity.getSelectedItemPosition();
						if (cit!=0)
						{
							dcity = ccity.getSelectedItem().toString();  
						}
						else
						{
							Toast toast1 = Toast.makeText(this, "Choose stay city", Toast.LENGTH_SHORT);
							TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
							v.setTextColor(Color.WHITE);
							toast1.show();  
				                return false;  
				  
						}
						 if(!st.equals(""))  
				         {  
				             dcity = ccity.getSelectedItem().toString();  
				                        }  
				                        else{  
				                        	Toast toast1 = Toast.makeText(this, "Choose stay city", Toast.LENGTH_SHORT);
				            				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
				            				v.setTextColor(Color.WHITE);
				            				toast1.show();  
				            	              
				                            return false; 
				                        }
						
					
					 String st3=cmeal.getSelectedItem().toString();
						int mea=cmeal.getSelectedItemPosition();
						if (mea!=0)
						{
							dmeals = cmeal.getSelectedItem().toString();  
						}
						else
						{
				               
				                Toast toast1 = Toast.makeText(this, "Please Select a Meal", Toast.LENGTH_SHORT);
								TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
								v.setTextColor(Color.WHITE);
								toast1.show();  
				                return false;  
				  
						}
						 if(!st3.equals(""))  
				         {  
				             dmeals = cmeal.getSelectedItem().toString();  
				                        }  
				                        else{  
				                            Toast.makeText(AddPackage.this,  
				                                    "Please select a Meal !!", Toast.LENGTH_LONG)  
				                                    .show();  
				                            return false; 
				                        }
							
							
				
		
		
				/*ContentValues values=new ContentValues();
				values.put(Package_Table.package_name,package_name.getText().toString());
				values.put(Package_Table.package_description,package_description.getText().toString());
				values.put(Package_Table.validity,package_validity.getText().toString());
				values.put(Package_Table.person,package_no_of_persons.getText().toString());
				values.put(Package_Table.source,csource.getSelectedItem().toString());
				values.put(Package_Table.destination,cdestination.getSelectedItem().toString());
				values.put(Package_Table.startTime,start_time.getText().toString());
				values.put(Package_Table.endTime,end_time.getText().toString());
				values.put(Package_Table.city,ccity.getSelectedItem().toString());
				values.put(Package_Table.hotel,hotel_name.getText().toString());
				values.put(Package_Table.statvalidity,validity.getText().toString());
				values.put(Package_Table.meals,cmeal.toString());
				values.put(Package_Table.tabletype,"packages");
				
				getContentResolver().insert(
				MyDatabaseProvider.ADDPACKAGE_CONTENT_URI,values);
				//Toast.makeText(getApplicationContext(),
					//	"return is " + uri.toString(), Toast.LENGTH_SHORT)
						//.show();
				Toast.makeText(this, "Package Saved", Toast.LENGTH_LONG).show();*/
				AddPackage.this.finish();
			
			break;
			
		case R.id.p_adder_cancel:
			AddPackage.this.finish();
		}		
		
		return super.onOptionsItemSelected(item);
	}

}
