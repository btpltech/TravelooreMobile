package com.alexrs95.slidingmenuandviewpager;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import com.alexrs95.slidingmenuandviewpager.SyncFragment.Operation1;
import com.btpl.database.Booking_Amenity_Details_Table;
import com.btpl.database.Booking_Hotel_Details_Table;
import com.btpl.database.Booking_Meal_Details_Table;
import com.btpl.database.Booking_Room_Details_Table;
import com.btpl.database.Booking_Stay_Details;
import com.btpl.database.Booking_Table;
import com.btpl.database.Booking_Travel_Details_Table;
import com.btpl.database.Hotel_Table;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.Package_Table;
import com.btpl.database.Signup_Table;
import com.btpl.database.Stay_Table;
import com.btpl.database.Travel_Table;
import com.btpl.database.Traveller_Details_Table;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class signin extends Activity implements OnClickListener{
	
	Button signin,signup,test;
	EditText userName,password;
	String getUser,getPassword;
	String usr;
	SessionManager session;
	ProgressDialog pd;
	Object result;
	XmlRpcClient xmlrpcLogin;
	XmlRpcClientConfigImpl xmlrpcConfigLogin;
	String date_time;
	MyDatabaseClass mdc;
	int indexSynch,passIndexSynch;
	int passLead;
	Thread thread;
	Curd curd;
	Context context;
	InputStream in;
	String convert,serverIP,database,ip,port;
	List<ArrayList<String>> check = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> valuesPackageTotal  = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> valuesHotelTotal  = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> valuesStayTotal  = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> valuesTravelTotal = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> travellerDetails = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> bookingStayDetails = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> bookingTravelDetails = new ArrayList<ArrayList<String>>(); 
    List<ArrayList<String>> bookingHotelDetails = new ArrayList<ArrayList<String>>(); 
    List<ArrayList<String>> bookingRoomDetails = new ArrayList<ArrayList<String>>();
    List<ArrayList<String>> bookingMealDetails = new ArrayList<ArrayList<String>>(); 
    List<ArrayList<String>> bookingAmenityDetails = new ArrayList<ArrayList<String>>(); 


	ArrayList<String> packageDetails = new ArrayList<String>();
    Boolean checker=false;
	String user,pass;
	ArrayList<String> testing;
	Operation1 mytask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signin);
		curd = new Curd();
		
	//	//String check=mdc.getIndexForServer();
		//System.out.println("index value"+check);
        session = new SessionManager(getApplicationContext());                
     //   test= (Button)findViewById(R.id.check);
        
     //   test.setOnClickListener(new OnClickListener() {
			
			//@Override
		//	public void onClick(View arg0) {
				// TODO Auto-generated method stub
					//System.out.println("check it....");
			// mdc= new MyDatabaseClass(getApplicationContext());	
			//mdc.open();
			//List<ArrayList<String>> check = new ArrayList<ArrayList<String>>();
			//check=mdc.joinerCheck();
			//for(int i=0;i<check.size();i++)
			//System.out.println("value "+check.get(0));
			//System.out.println("value "+check.get(1).get(0));
			//System.out.println("value "+check.get(1).get(1));
			//System.out.println("value "+check[1]);
			//mdc.close();
		//	}
		//});
		signin = (Button)findViewById(R.id.button_signin);
		signin.setOnClickListener(this);
		//signup = (Button)findViewById(R.id.button_signup);
		//signup.setOnClickListener(this);
		userName=(EditText)findViewById(R.id.et_username);
		password=(EditText)findViewById(R.id.et_password);
		
		/*Handler handler = new Handler() {
			Operation1 mytask = new Operation1();
	        @Override
	        public void handleMessage(Message msg) {
	            mytask.cancel(true);
	            if (user.contains(getUser)) {
	            Toast.makeText(signin.this,"Hi toast",Toast.LENGTH_LONG).show();

	            }
	     }};*/
		
	}
	
	/*
	public class Operation extends AsyncTask<String,Void,String>
	{
			
			Synchronization syn  = new Synchronization();
			//Curd curd = new Curd();
		@Override
		protected String doInBackground(String... arg0) {
			
			// TODO Auto-generated method stub
			thread=new Thread()
			{
				//@SuppressWarnings("static-access")
				public void run() {
					try {
						//syn.getValueFromServer();
					//System.out.println("catched values "+serverValues);
					} catch (Exception e) {
						// TODO Auto-generated catch block
				System.out.println("errorrr..");
					}
				}
			};
				thread.start();
			
			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			  pd=new ProgressDialog(signin.this);
				pd.setIndeterminate(true);
				pd.setCancelable(true);
				pd.setMessage("Connecting with server.....please wait");
				pd.show();
			//super.onPreExecute();
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		//	Toast.makeText(getApplicationContext(), "sync with server",Toast.LENGTH_LONG).show();
			
			pd.dismiss();
		}
	}
	
*/			
		
		
		//public int getIndexToSynch()
		//{
			//String indexChar=null;
			//int indexInt;
			//SQLiteDatabase db=null;
			
			//indexInt=Integer.parseInt(indexChar);
			//return indexInt;
		//}
		
	@Override
	public void onBackPressed() {
	//	Intent intent = new Intent(Intent.ACTION_MAIN);
		//   intent.addCategory(Intent.CATEGORY_HOME);
		//   intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		//   startActivity(intent);
	}
	
	// Created by Himanshu Srivastava Dated : 17-July-2013
	@Override
	public void onClick(View item) {
		// TODO Auto-generated method stub
		
		
		if(item.getId() == R.id.button_signin)
		{
			curd = new Curd();
			
            
		 // curd.login();
			///mdc = new MyDatabaseClass(this);
			//mdc.open();
			//ArrayList<String> values = new ArrayList<String>();
			//values=mdc.valueForServer();
			//for(int i=0;i<22;i++)
			//	System.out.println("array consist "+values.get(i));
			//new Operation().execute("");
			getUser=userName.getText().toString();
			getPassword=password.getText().toString();
			//int getIntPassword=Integer.parseInt(getPassword);
			MyDatabaseClass mdc= new MyDatabaseClass(this);
			mdc.open();
			//packageDetails=mdc.getPackageDetails();
		String storedPassword = mdc.getSinlgeEntry(getUser);
			mdc.close();		
			//if(getUser.isEmpty())
			//		{}
			//if(getPassword.isEmpty())
			//{}
			if(getUser.isEmpty())
			{
				Toast toast1 = Toast.makeText(signin.this, "Enter Email Address", Toast.LENGTH_LONG);
				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
				v.setTextColor(Color.RED);
				toast1.show();
				
			}
			else if (getPassword.isEmpty())
			{Toast toast1 = Toast.makeText(signin.this, "Enter password", Toast.LENGTH_LONG);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.RED);
			toast1.show();
			}
			
			
			else  //(getPassword.equals(storedPassword))
			{
				
				mytask = new Operation1();
				mytask.execute();
				
				
			}
			
		}
				 
}
	
	public class Operation1 extends AsyncTask<String,Void,String>
	{
		List<ArrayList<String>> bookingDetails = new ArrayList<ArrayList<String>>();
		ArrayList<String> bookingNumber=new ArrayList<String>();
			Synchronization syn  = new Synchronization();
		    Curd curd = new Curd();
		   ProgressDialog pd=new ProgressDialog(signin.this);

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			curd = new Curd();
			
			
			Thread thread_login=new Thread(){
				public void run()
				{
					try {
			    		//curd.login();
					in=	curd.OpenHttpConnection("http://54.225.137.166/traveloore_crm.php?username="+getUser+"&password="+getPassword);
					System.out.println("responseeeeee" + in);
					
					  convert=curd.convertStreamToString(in);
					  
					  System.out.println("string "+convert);
					  String values[]=convert.split(" ");
					 ip=values[0];
					 String values__[]=ip.split(":");
					 serverIP=values__[0];
					 System.out.println("ip value "+serverIP);
					 port=values__[1];
					 database=values[1];
					 user=values[2];
					 pass=values[3];
					 System.out.println("ip "+serverIP);
					 System.out.println("user "+user);
					 System.out.println("password "+pass);
	                 if(database.contains(getUser) && pass.contains(getPassword))
	                 {
	                	 System.out.println("inside loop");
	                	 session.createLoginSession(database, pass,serverIP);
	                	 signin.this.runOnUiThread(new Runnable() {
	                		    public void run() {
	                		    	Toast toast1 = Toast.makeText(signin.this, "Traveloore team welcomes you", Toast.LENGTH_LONG);
	        	         			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
	        	         			v.setTextColor(Color.WHITE);
	        	         			toast1.show();
	        	                 	                		    }
	                		});
	 					
	         			///Toast toast=Toast.makeText(signin.this, "Traveloore team welcomes you", Toast.LENGTH_SHORT);
	         			//TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
	         			//v.setTextColor(Color.WHITE);
	         			//toast.show();
	         				System.out.println("after toast");
	         			    Intent intent1 = new Intent(signin.this, MainActivity.class);
	         				//intent.putExtra("userName",userName);
	         				startActivity(intent1);
	         			 
	                 }
	                 	 
	                 	
	                	 
					   // System.out.print......ln("second "+convert.get(1));
					} catch (Exception e) {
						System.out.println("exception");
						signin.this.runOnUiThread(new Runnable() {
                		    public void run() {
                		    	Toast toast1 = Toast.makeText(signin.this, "Wrong UserName or Password", Toast.LENGTH_LONG);
        	         			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
        	         			v.setTextColor(Color.RED);
        	         			toast1.show();
        	                 	                		    
                		    }
                		});
 					  
						// TODO Auto-generated catch block
						
					}
					
					try{
						ArrayList<String> idsHotel = new ArrayList<String>();
						ArrayList<String> idsStay = new ArrayList<String>();
						ArrayList<String> idsTravel = new ArrayList<String>();
						ArrayList<String> packingNumber = new ArrayList<String>();

						MyDatabaseClass mdc=new MyDatabaseClass(signin.this);
						mdc.open();
						idsHotel=mdc.getHotelSyncId();
						idsStay=mdc.getStaySyncId();
						idsTravel=mdc.getTravelSyncId();
						packingNumber=mdc.getPackageSychTime();
						mdc.close();
						String packNumber = null;
						Object pack_no=null;
						if(packingNumber.size()!=0)
						{
						packNumber=packingNumber.get(packingNumber.size()-1);
						   
						}

	            	     valuesPackageTotal=syn.getPackageDetails(packNumber,serverIP,database,pass);
	            	     //System.out.println("package "+ids);
	            	    // for(int i=0;i<ids.size();i++)
	            	   //  {
	            	  //  	 System.out.println("inside delete");
	            	 //   String where=Package_Table.id + " = " + ids.get(i);  
	            	//   getContentResolver().delete(MyDatabaseProvider.ADDPACKAGE_CONTENT_URI, where,null);
	               //   }
	            	    // System.out.println("totalvalues "+valuesPackageTotal.size());
	            	     ContentValues cv = new ContentValues();
	            	     for(int j=0;j<valuesPackageTotal.size();j++)
	            	     {
	            	     
		    				cv.put(Package_Table.package_id, valuesPackageTotal.get(j).get(0));
		    				cv.put(Package_Table.package_name, valuesPackageTotal.get(j).get(1));
		    				cv.put(Package_Table.adults,valuesPackageTotal.get(j).get(2));
		    				cv.put(Package_Table.children, valuesPackageTotal.get(j).get(3));
		    				cv.put(Package_Table.package_description, valuesPackageTotal.get(j).get(4));
		    				cv.put(Package_Table.date, valuesPackageTotal.get(j).get(5));
		    				//cv1.put(Stay_Table.stay_id, valuesPackageTotal.get(j).get(5));
		    				//cv1.put(Stay_Table.stay_city, valuesPackageTotal.get(j).get(6));
		    				//cv1.put(Stay_Table.days, valuesPackageTotal.get(j).get(7));
		    				//cv2.put(Hotel_Table.hotel_id, valuesPackageTotal.get(j).get(8));
		    				//cv2.put(Hotel_Table.hotel, valuesPackageTotal.get(j).get(9));
		    				//cv2.put(Hotel_Table.hotel_city, valuesPackageTotal.get(j).get(10));
		    				//cv2.put(Hotel_Table.hotel_address, valuesPackageTotal.get(j).get(11));
		    				//cv2.put(Hotel_Table.stars, valuesPackageTotal.get(j).get(12));
		    				getContentResolver().insert(
		    						MyDatabaseProvider.ADDPACKAGE_CONTENT_URI, cv);
		    				}
	            	     String syncId=null;
	            	     if(idsStay.size()!=0)
	 					{
	 					syncId=idsStay.get(idsStay.size()-1);
	 					   
	 					}

	            	     valuesStayTotal=syn.getStayDetails(syncId,serverIP,database,pass);
	            	    // System.out.println("package "+ids);
	            	    	            	    // System.out.println("totalvalues "+valuesPackageTotal.size());
	            	     ContentValues cv1 = new ContentValues();
	            	     for(int j=0;j<valuesStayTotal.size();j++)
	            	     {
		    				cv1.put(Stay_Table.stay_id, valuesStayTotal.get(j).get(0));
		    				cv1.put(Stay_Table.days, valuesStayTotal.get(j).get(1));
                           cv1.put(Stay_Table.stay_city, valuesStayTotal.get(j).get(2));
                           cv1.put(Stay_Table.desc, valuesStayTotal.get(j).get(3));
                           cv1.put(Stay_Table.staySyncId, valuesStayTotal.get(j).get(4));
		    				
                           //cv2.put(Hotel_Table.hotel_id, valuesPackageTotal.get(j).get(8));
		    				//cv2.put(Hotel_Table.hotel, valuesPackageTotal.get(j).get(9));
		    				//cv2.put(Hotel_Table.hotel_city, valuesPackageTotal.get(j).get(10));
		    				//cv2.put(Hotel_Table.hotel_address, valuesPackageTotal.get(j).get(11));
		    				//cv2.put(Hotel_Table.stars, valuesPackageTotal.get(j).get(12));
		    				getContentResolver().insert(
		    						MyDatabaseProvider.STAY_CONTENT_URI, cv1);
		    			
	            	     }
	            	     String hotelId=null;
	            	     if(idsHotel.size()!=0)
	 					{
	 					hotelId=idsHotel.get(idsHotel.size()-1);
	 					   
	 					}
	            	     valuesHotelTotal=syn.getHotelDetails(hotelId,serverIP,database,pass);
	            	     // System.out.println("totalvalues "+valuesPackageTotal.size());
	            	     ContentValues cv2 = new ContentValues();
	            	     for(int j=0;j<valuesHotelTotal.size();j++)
	            	     {
	            	     
	            	    	 cv2.put(Hotel_Table.hotel_id, valuesHotelTotal.get(j).get(0));
		    				cv2.put(Hotel_Table.hotel, valuesHotelTotal.get(j).get(1));
		    				cv2.put(Hotel_Table.hotel_city, valuesHotelTotal.get(j).get(2));
		    				cv2.put(Hotel_Table.hotel_address, valuesHotelTotal.get(j).get(3));
		    				cv2.put(Hotel_Table.stars, valuesHotelTotal.get(j).get(4));
		    				cv2.put(Hotel_Table.hotelSyncId, valuesHotelTotal.get(j).get(5));
		    				cv2.put(Hotel_Table.hotel_package, valuesHotelTotal.get(j).get(6));
		    				
		    				getContentResolver().insert(
		    						MyDatabaseProvider.HOTEL_CONTENT_URI, cv2);
	            	     
	            	     }
	            	    
	            	     String travelId=null;
	            	     if(idsTravel.size()!=0)
	 					{
	 					travelId=idsTravel.get(idsTravel.size()-1);
	 					   
	 					}
	            	     valuesTravelTotal=syn.getTravelDetails(travelId,serverIP,database,pass);
	            	     
	            	    // System.out.println("totalvalues "+valuesPackageTotal.size());
	            	     ContentValues cv3 = new ContentValues();
	            	     for(int j=0;j<valuesTravelTotal.size();j++)
	            	     {
	            	     
	            	    	cv3.put(Travel_Table.travel_id, valuesTravelTotal.get(j).get(0));
		    				cv3.put(Travel_Table.travel_mode, valuesTravelTotal.get(j).get(1));
		    				cv3.put(Travel_Table.source, valuesTravelTotal.get(j).get(2));
		    				cv3.put(Travel_Table.destination, valuesTravelTotal.get(j).get(3));
		    				cv3.put(Travel_Table.travel, valuesTravelTotal.get(j).get(4));

		    				cv3.put(Travel_Table.day_seq, valuesTravelTotal.get(j).get(5));
		    			    cv3.put(Travel_Table.price, valuesTravelTotal.get(j).get(6));
		    			    cv3.put(Travel_Table.travelSyncId, valuesTravelTotal.get(j).get(7));
		    				getContentResolver().insert(
		    						MyDatabaseProvider.TRAVEL_CONTENT_URI, cv3);
	            	     
	           
	            	     }
	            	    
	            	     	

	            	     }
					 
	            		catch(Exception e)
	            		{
	            			System.out.println("mubarak ho aap baap ban gaye");
	            		}

					
					try{
						
						MyDatabaseClass mdc=new MyDatabaseClass(signin.this);
						mdc.open();
						bookingNumber=mdc.getBookingSyncTime();
						ArrayList<String> synchIdTraveller = new ArrayList<String>();
		                ArrayList<String> synchIdStay = new ArrayList<String>(); 
		                ArrayList<String> synchIdTravel = new ArrayList<String>(); 
		                ArrayList<String> synchIdHotel = new ArrayList<String>(); 
		                ArrayList<String> synchIdRoom = new ArrayList<String>(); 
		                ArrayList<String> synchIdMeal = new ArrayList<String>(); 
		                ArrayList<String> synchIdAmenity = new ArrayList<String>(); 

		                synchIdTraveller=mdc.getTravellerId();
						synchIdStay=mdc.getBookingStayId();
						synchIdTravel=mdc.getBookingTravelId();
						synchIdHotel=mdc.getBookingHotelId();
						synchIdRoom=mdc.getBookingRoomId();
						synchIdMeal=mdc.getBookingMealId();
						synchIdAmenity=mdc.getBookingAmenityId();
						
						mdc.close();
						String bookNumber = null;
					    String travellerId = null;
					    String stayId = null;
					    String travelId =null;
					    String hotelId = null;
					    String roomId = null;
					    String mealId =null;
					    String amenityId = null;
						
					    if(bookingNumber.size()!=0)
						{
							bookNumber=bookingNumber.get(bookingNumber.size()-1);
						    
						}
					    if(synchIdRoom.size()!=0)
						{
							roomId=synchIdRoom.get(synchIdRoom.size()-1);
						    
						}if(synchIdMeal.size()!=0)
						{
							mealId=synchIdMeal.get(synchIdMeal.size()-1);
						    
						}if(synchIdAmenity.size()!=0)
						{
							amenityId=synchIdAmenity.get(synchIdAmenity.size()-1);
						    
						}
					    
						if(synchIdHotel.size()!=0)
						{
							hotelId=synchIdHotel.get(synchIdHotel.size()-1);
						    
						}
						if(synchIdTraveller.size()!=0)
						{
							travellerId=synchIdTraveller.get(synchIdTraveller.size()-1);
						    System.out.println("traveller id value "+travellerId);
							
						}if(synchIdStay.size()!=0)
						{
							stayId=synchIdStay.get(synchIdStay.size()-1);
						    System.out.println("booking stat id value "+stayId);
						    
						}
						if(synchIdTravel.size()!=0)
						{
							travelId=synchIdTravel.get(synchIdTravel.size()-1);
						    System.out.println("traveller id value "+travellerId);
							
						}

						

						 bookingDetails=syn.getBookingDetails(bookNumber,serverIP,database,pass);
						 travellerDetails=syn.getBookingTravellerDetails(travellerId,serverIP,database,pass);
	           	         bookingStayDetails=syn.getBookingStayDetails(stayId,serverIP,database,pass);
	           	         bookingTravelDetails=syn.getBookingTravelDetails(travelId,serverIP,database,pass);
	           	         bookingHotelDetails=syn.getBookingHotelDetails(hotelId,serverIP,database,pass);
	           	         bookingRoomDetails=syn.getBookingRoomDetails(roomId,serverIP,database,pass);
	        	         bookingMealDetails=syn.getBookingMealDetails(mealId,serverIP,database,pass);
	        	         bookingAmenityDetails=syn.getBookingAmenityDetails(amenityId,serverIP,database,pass);
						
	           	         Log.d("values get...", bookingTravelDetails.toString());
	           	         ContentValues cv = new ContentValues();
		           	     for(int j=0;j<bookingDetails.size();j++)
		           	     {
		           	     String togetData = database + " " + bookingDetails.get(j).get(23);
			    				cv.put(Booking_Table.booking_number, bookingDetails.get(j).get(0));
			    				cv.put(Booking_Table.booking_date, bookingDetails.get(j).get(1));
			    				cv.put(Booking_Table.start_date,bookingDetails.get(j).get(2));
			    				cv.put(Booking_Table.end_date, bookingDetails.get(j).get(3));
			    				cv.put(Booking_Table.advance_amount, bookingDetails.get(j).get(4));
			    				cv.put(Booking_Table.customer_id,bookingDetails.get(j).get(5));
			    				cv.put(Booking_Table.salutation,bookingDetails.get(j).get(6));
			    				
			    				cv.put(Booking_Table.customer_name, bookingDetails.get(j).get(7));
			    				cv.put(Booking_Table.gender, bookingDetails.get(j).get(8));
			    				cv.put(Booking_Table.address, bookingDetails.get(j).get(9));
			    				cv.put(Booking_Table.city, bookingDetails.get(j).get(10));
			    				cv.put(Booking_Table.state,bookingDetails.get(j).get(11)) ;
			    				cv.put(Booking_Table.country, bookingDetails.get(j).get(12));
			    				cv.put(Booking_Table.zip_code, bookingDetails.get(j).get(13));
			    				cv.put(Booking_Table.phone,bookingDetails.get(j).get(14));
			    				cv.put(Booking_Table.email, bookingDetails.get(j).get(15));
			    				cv.put(Booking_Table.id_type, bookingDetails.get(j).get(16));
			    				cv.put(Booking_Table.id_number, bookingDetails.get(j).get(17));
			    				cv.put(Booking_Table.package_id, bookingDetails.get(j).get(18));
			    				cv.put(Booking_Table.package_name,bookingDetails.get(j).get(19));
			    				cv.put(Booking_Table.adults, bookingDetails.get(j).get(20));
			    				cv.put(Booking_Table.child, bookingDetails.get(j).get(21));
			    				cv.put(Booking_Table.description, bookingDetails.get(j).get(22));
			    				cv.put(Booking_Table.synchId, bookingDetails.get(j).get(23));
			    				cv.put(Booking_Table.perticularBooking, database);
			    				cv.put(Booking_Table.synchPerti,togetData);
			    				
			    				getContentResolver().insert(
			    						MyDatabaseProvider.BOOKING_CONTENT_URI, cv);
		           	     }
	           	         
	           	         ContentValues cv1 = new ContentValues();
	           	    for(int k=0;k<travellerDetails.size();k++)
	           	    {

		           	     String togetData = database + " " + travellerDetails.get(k).get(14);

	           	    	cv1.put(Traveller_Details_Table.traveller_id, travellerDetails.get(k).get(0));
	           	    	cv1.put(Traveller_Details_Table.t_salutation, travellerDetails.get(k).get(1));
	           	    	cv1.put(Traveller_Details_Table.t_gender, travellerDetails.get(k).get(2));
	           	    	cv1.put(Traveller_Details_Table.t_address, travellerDetails.get(k).get(3));
	           	    	cv1.put(Traveller_Details_Table.t_country, travellerDetails.get(k).get(4));
	           	    	cv1.put(Traveller_Details_Table.t_m_no, travellerDetails.get(k).get(5));
	           	    	cv1.put(Traveller_Details_Table.t_id_type, travellerDetails.get(k).get(6));
	           	    	cv1.put(Traveller_Details_Table.t_city_name, travellerDetails.get(k).get(7));
	           	    	cv1.put(Traveller_Details_Table.t_zipcode, travellerDetails.get(k).get(8));
	           	    	cv1.put(Traveller_Details_Table.traveller_name, travellerDetails.get(k).get(9));
	           	    	cv1.put(Traveller_Details_Table.t_email, travellerDetails.get(k).get(10));
	           	    	cv1.put(Traveller_Details_Table.t_id_num, travellerDetails.get(k).get(11));
	           	    	cv1.put(Traveller_Details_Table.t_state_name, travellerDetails.get(k).get(12));
	           	        cv1.put(Traveller_Details_Table.synch_Id, travellerDetails.get(k).get(13));
	           	        cv1.put(Traveller_Details_Table.traveller, travellerDetails.get(k).get(14));
	           	        cv1.put(Traveller_Details_Table.synchPerti, togetData);
	           	    	
	           	        getContentResolver().insert(
	    						MyDatabaseProvider.TRAVELLER_CONTENT_URI, cv1);	 
	               	
	           	    }

	           	    ContentValues cv2 = new ContentValues();
	           	    for(int k=0;k<bookingStayDetails.size();k++)
	           	    {
		           	 String togetData = database + " " + bookingStayDetails.get(k).get(5);

	           	    	cv2.put(Booking_Stay_Details.stay_id, bookingStayDetails.get(k).get(0));
	           	    	cv2.put(Booking_Stay_Details.day_seq, bookingStayDetails.get(k).get(1));
	           	    	cv2.put(Booking_Stay_Details.name,  bookingStayDetails.get(k).get(2));
	           	    	cv2.put(Booking_Stay_Details.city, bookingStayDetails.get(k).get(3));
	           	    	cv2.put(Booking_Stay_Details.desc, bookingStayDetails.get(k).get(4));
	           	    	
	           	    	cv2.put(Booking_Stay_Details.stay, bookingStayDetails.get(k).get(5));
	           	    	cv2.put(Booking_Stay_Details.synch_Id, bookingStayDetails.get(k).get(6));
	           	    	cv2.put(Booking_Stay_Details.synchPerti, togetData);

	           	    	getContentResolver().insert(
	    						MyDatabaseProvider.BOOKING_STAY_CONTENT_URI, cv2);	 
	               	
	           	    }

	           	 ContentValues cv3 = new ContentValues();
	        	    for(int k=0;k<bookingTravelDetails.size();k++)
	        	    {
			       String togetData = database + " " + bookingTravelDetails.get(k).get(5);

	        	    	cv3.put(Booking_Travel_Details_Table.synch_id, bookingTravelDetails.get(k).get(0));
	        	    	cv3.put(Booking_Travel_Details_Table.day_seq, bookingTravelDetails.get(k).get(1));
	        	    	cv3.put(Booking_Travel_Details_Table.mode,  bookingTravelDetails.get(k).get(2));
	        	    	cv3.put(Booking_Travel_Details_Table.source, bookingTravelDetails.get(k).get(3));
	        	    	cv3.put(Booking_Travel_Details_Table.destination, bookingTravelDetails.get(k).get(4));
	        	    	cv3.put(Booking_Travel_Details_Table.itinerary_id, bookingTravelDetails.get(k).get(5));
	        	    	cv3.put(Booking_Travel_Details_Table.synchPerti, togetData);

	        	    	getContentResolver().insert(
	 						MyDatabaseProvider.BOOKING_TRAVEL_CONTENT_URI, cv3);	 
	            	
	        	    }

	        	    ContentValues cv4 = new ContentValues();
	        	    for(int k=0;k<bookingHotelDetails.size();k++)
	        	    {
	        	    	cv4.put(Booking_Hotel_Details_Table.hotel_id, bookingHotelDetails.get(k).get(0));
	        	    	cv4.put(Booking_Hotel_Details_Table.hotel_name, bookingHotelDetails.get(k).get(1));
	        	    	cv4.put(Booking_Hotel_Details_Table.city_name,  bookingHotelDetails.get(k).get(2));
	        	    	cv4.put(Booking_Hotel_Details_Table.address, bookingHotelDetails.get(k).get(3));
	        	    	cv4.put(Booking_Hotel_Details_Table.stars, bookingHotelDetails.get(k).get(4));
	        	    	cv4.put(Booking_Hotel_Details_Table.hotel, bookingHotelDetails.get(k).get(5));
	        	    	cv4.put(Booking_Hotel_Details_Table.synchId, bookingHotelDetails.get(k).get(6));
	        	    	
	        	    	getContentResolver().insert(
	 						MyDatabaseProvider.BOOKING_HOTEL_CONTENT_URI, cv4);	 
	            	
	        	    }

	        	    ContentValues cv5 = new ContentValues();
	        	    for(int k=0;k<bookingRoomDetails.size();k++)
	        	    {
	        	    	cv5.put(Booking_Room_Details_Table.synchId, bookingRoomDetails.get(k).get(0));
	        	    	cv5.put(Booking_Room_Details_Table.roomtype_id, bookingRoomDetails.get(k).get(1));
	        	    	cv5.put(Booking_Room_Details_Table.roomtype_name,  bookingRoomDetails.get(k).get(2));
	        	    	cv5.put(Booking_Room_Details_Table.price, bookingRoomDetails.get(k).get(3));
	        	    	
	        	    	getContentResolver().insert(
	 						MyDatabaseProvider.BOOKING_ROOM_CONTENT_URI, cv5);	 
	            	
	        	    }
	        	    ContentValues cv6 = new ContentValues();
	        	    for(int k=0;k<bookingMealDetails.size();k++)
	        	    {
	        	    	cv6.put(Booking_Meal_Details_Table.synchId, bookingMealDetails.get(k).get(0));
	        	    	cv6.put(Booking_Meal_Details_Table.mealtype_id, bookingMealDetails.get(k).get(1));
	        	    	cv6.put(Booking_Meal_Details_Table.mealtype_name,  bookingMealDetails.get(k).get(2));
	        	    	cv6.put(Booking_Meal_Details_Table.price, bookingMealDetails.get(k).get(3));
	        	    	
	        	    	getContentResolver().insert(
	 						MyDatabaseProvider.BOOKING_MEAL_CONTENT_URI, cv6);	 
	            	
	        	    }
	        	    ContentValues cv7 = new ContentValues();
	        	    for(int k=0;k<bookingAmenityDetails.size();k++)
	        	    {
	        	    	cv7.put(Booking_Amenity_Details_Table.synchId, bookingAmenityDetails.get(k).get(0));
	        	    	cv7.put(Booking_Amenity_Details_Table.amount, bookingAmenityDetails.get(k).get(1));
	        	    	cv7.put(Booking_Amenity_Details_Table.description,  bookingAmenityDetails.get(k).get(2));
	        	    	cv7.put(Booking_Amenity_Details_Table.amenity_name, bookingAmenityDetails.get(k).get(3));
	        	    	
	        	    	getContentResolver().insert(
	 						MyDatabaseProvider.BOOKING_AMENITY_CONTENT_URI, cv7);	 
	            	
	        	    }

	           	     }
					 
	           						
						
						
					
					catch(Exception e)
					{
						System.out.println("exception in getting traveller details");
					}

					
					
					
				}
			};
			thread_login.start();
			

			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
				pd.setIndeterminate(true);
				pd.setCancelable(true);
				pd.show();
				pd.setMessage("loading.....please wait");
				//pd.setIndeterminate(true);
				//pd.setCancelable(false);
				//pd.setMessage("loading..............");
				
				//pd.setMessage("synchronizing data....");
				//pd.show();
				Handler handler=new Handler();
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						pd.dismiss();
					}},30000);
				
		}
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
		//	Toast.makeText(getApplicationContext(), "sync with server",Toast.LENGTH_LONG).show();
			//System.out.println("status "+statusContact.get(0).get(0));
			//System.out.println("modified "+statusContact.get(0).get(1));
			//statusContact.get(i).get(0)==1 && (statusContact.get(i).get(1)
			//pd=new ProgressDialog(getActivity());
			//pd.show();
			//pd.setMessage("please wait...");
			///pd.setCancelable(true);
			//long t= System.currentTimeMillis();
			//long end = t+1500;
			//while(System.currentTimeMillis() < end) {}
			//pd.setMessage("successfully loaded data...");

			//long t= System.currentTimeMillis();
			//long end = t+15000;
			//while(System.currentTimeMillis() < end) {}
			 
			
			pd.dismiss();
		}
	}

}

