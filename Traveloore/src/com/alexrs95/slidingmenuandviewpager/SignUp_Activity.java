package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.btpl.database.MyDatabaseClass;
import com.btpl.database.Signup_Table;
import com.btpl.database.MyDatabaseProvider;


public class SignUp_Activity extends Activity implements OnClickListener {
	EditText editText1,editText3,editText4,editText5,editText7,editText8;
	ImageButton imagebutton;
	static String namevalue;
	String passwordvalue;
	String confpasswordvalue;
	String emailvalue;
	String cityvalue;
	String mobileNovalue;
	String username;
	ArrayList<String> emailChecker;
	int passUser;
	ArrayList<Integer> statusUser=new ArrayList<Integer>(); 
	List<ArrayList<String>> passUsersValues=new ArrayList<ArrayList<String>>();
	Boolean exception=false;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up_);
		TextView next = (TextView)findViewById(R.id.textnotAnAccount);
		next.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
	
				Intent myIntent = new Intent(SignUp_Activity.this, signin.class);
				startActivity(myIntent);
				
			}
		});
		

		editText1 = (EditText)findViewById(R.id.editTextName);
		editText3 = (EditText)findViewById(R.id.editTextPassword);
		editText4 = (EditText)findViewById(R.id.editTextConfirmPassword);
		editText5 = (EditText)findViewById(R.id.editTextEmailAddress);
		editText7 = (EditText)findViewById(R.id.editTextContactNumber);
		editText8=  (EditText)findViewById(R.id.editTextUsername);
		imagebutton=(ImageButton)findViewById(R.id.buttonCreateAccount);
		imagebutton.setOnClickListener(this);
		namevalue = editText1.getText().toString();
		passwordvalue=editText3.getText().toString();
		confpasswordvalue=editText4.getText().toString();
		emailvalue=editText5.getText().toString();
		
		mobileNovalue=editText7.getText().toString();
			
	}
	
	@Override
	public void onBackPressed() {
	}
	
	@Override
	public void onClick(View arg0) 
	
	{
		
		editText1.setError(null);
		editText3.setError(null);
		editText4.setError(null);
		editText5.setError(null);
		editText7.setError(null);
		
		
		
		String namevalue = editText1.getText().toString();
		String passwordvalue=editText3.getText().toString();
		String confpasswordvalue=editText4.getText().toString();
		String emailvalue=editText5.getText().toString();
		String mobileNovalue=editText7.getText().toString();
		String username=editText8.getText().toString();
		boolean cancel = false;
		View focusView = null;
		
		
		if (TextUtils.isEmpty(namevalue)) {
			editText1.setError(getString(R.string.error_field_required));
			focusView = editText1;
			cancel = true;
			return;
		} else if (namevalue.length() < 4) {
			editText1.setError("At least 4 char long name required");
			focusView = editText1;
			cancel = true;
			return;
		}
		
		

		
		//if(namevalue.equals("")||userNamevalue.equals("")||cityvalue.equals("")||mobileNovalue.equals(""))
		//{
			//	Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
				//return;
		//}
		
		
		if (TextUtils.isEmpty(passwordvalue)) {
			editText3.setError(getString(R.string.error_field_required));
			focusView = editText3;
			cancel = true;
			return;
		} else if ((passwordvalue.length() < 4)) {
			editText3.setError(getString(R.string.error_invalid_password));
			focusView = editText3;
			cancel = true;
			return;
		}
		
		
		
		if(!passwordvalue.equals(confpasswordvalue))
		{
			Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
			return;
		}
		
		
		boolean emailChecker=isEmailValid(emailvalue);
		if(emailChecker==false)
		{
			Toast toast1 = Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();			return;		
		}
		
		boolean valueBoolean=validationOfEmail(emailvalue);
		if(valueBoolean==true)
		{
			Toast toast1 = Toast.makeText(this, "User already exists. SignUp with different Email id", Toast.LENGTH_LONG);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();			return;		
		}
		

		
				
		if (TextUtils.isEmpty(mobileNovalue)) {
			editText7.setError(getString(R.string.error_field_required));
			focusView = editText7;
			cancel = true;
			return;
		} else if (mobileNovalue.length() < 10) {
			editText7.setError("At least 10 char long number required");
			focusView = editText7;
			cancel = true;
			return;
		}
		
				
			
		ContentValues cvalues = new ContentValues();
		cvalues.put(Signup_Table.name, namevalue);
		cvalues.put(Signup_Table.username,username);
		cvalues.put(Signup_Table.password, passwordvalue);
		cvalues.put(Signup_Table.confirmpassword, confpasswordvalue);
		cvalues.put(Signup_Table.emailAddress, emailvalue);
		cvalues.put(Signup_Table.mobileNumber, mobileNovalue);
		cvalues.put(Signup_Table.tabletype,"signup");
		cvalues.put(Signup_Table.status,1);
        // Toast.makeText(SignUp_Activity.this, "Successful Inserted Data", Toast.LENGTH_LONG).show();
         Uri uri = getContentResolver().insert(
					MyDatabaseProvider.SIGNUP_CONTENT_URI, cvalues);
			 //Toast.makeText(getApplicationContext(),
				//"return is " + uri.toString(), Toast.LENGTH_SHORT)
		   		//.show();
       /*  Boolean connected=haveNetworkConnection();
        if(connected==true)
        {
         Thread thread = new Thread()
 		{
        	
 			Synchronization syn = new Synchronization();
 		public void run(){
 		try{
 			MyDatabaseClass mdc=new MyDatabaseClass(getApplicationContext());
			mdc.open();
			passUser=mdc.getotalUsers();
			 statusUser=mdc.statusUsers();
			passUsersValues=mdc.valueForUserCreation();
			mdc.close();
		
 			System.out.println("i am in user thread");
 			for(int i=0;i<passUser;i++)
 			{
 				System.out.println("i am in user thread");
 				if(statusUser.get(i)==1)// && (statusLead.get(i).get(0)==3 || statusLead.get(i).get(0)==1))
 				{
 					//exception=true;
 			syn.passUsersValueToServer(passUser, statusUser,passUsersValues,"54.251.186.100","traveloore","admin","1234");
			exception=true;
			break; 
 				}
 			}
 			}catch(Exception e)
 		{
 			System.out.println("exception in user creation");
 		}
 		}};
 		thread.start();
        }
 		if(exception==true && connected==true)
 		{
 		for(int i=1;i<=passUser;i++)
		{
			System.out.println("to update uer");
			ContentValues cv = new ContentValues();
			cv.put(Signup_Table.status,2);
	        String where = Signup_Table.signup_id + "=" + i;
	        Uri uri1 = Uri.parse("content://com.btpl.database.MyDbProvider/signup_table/" + i);
	        getContentResolver().update(uri, cv, where, null);
		
	}
 		}*/
         Toast toast1 = Toast.makeText(this, "Your account has been created", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();
//Synchronization sync=new Synchronization(username,passwordvalue,emailvalue);
		Intent intent = new Intent(this,signin.class);
		startActivity(intent);
		
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

	public boolean validationOfEmail(String emailvalue)
	{
		boolean b=false;
		String check =emailvalue;
		MyDatabaseClass mdc = new MyDatabaseClass(this);
		mdc.open();
		emailChecker=mdc.checkUser();
		b=emailChecker.contains(check);
		return b;
	}
	@SuppressWarnings("static-access")
	private boolean haveNetworkConnection() {
	    boolean haveConnectedWifi = false;
	    boolean haveConnectedMobile = false;

	    ConnectivityManager cm = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
	    NetworkInfo[] netInfo = cm.getAllNetworkInfo();
	    for (NetworkInfo ni : netInfo) {
	        if (ni.getTypeName().equalsIgnoreCase("WIFI"))
	            if (ni.isConnected())
	                haveConnectedWifi = true;
	        if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
	            if (ni.isConnected())
	                haveConnectedMobile = true;
	    }
	    return haveConnectedWifi || haveConnectedMobile;
	}

}
	


