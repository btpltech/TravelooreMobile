package com.alexrs95.slidingmenuandviewpager;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.app.SherlockFragment;
import com.btpl.database.AddTask_Table;
import com.btpl.database.Contact_table;
import com.btpl.database.Deal_Table;
import com.btpl.database.Delete_Lead_sync;
import com.btpl.database.Delete_contact_sync;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.NLead_Table;
import com.btpl.database.ServerSynchTime;
import com.btpl.database.Signup_Table;

public class SyncFragment extends SherlockFragment implements OnClickListener{

	Button btn_sync;
	TextView txt;
	int indexSynch,passIndexSynch;
	int passLead,passDeal,passTask,passContact,passUser,passLeadUnique,passContactUnique;
	Thread thread;
	Object result;
	Synchronization syn;
	List<ArrayList<String>> valuesLead,valuesDeal,valuesTask,valuesContact;
	List<ArrayList<Integer>> statusLead,statusDeal,statusContact;
	ArrayList<Integer> statusTask;
	Boolean checkerUser=false,checkerLogin=false,checkerLead=false,checkerDeal=false,checkerContact=false,checkerupdateLead=false,checkerUpdateContact=false;
	List<ArrayList<String>> serverValues; 
	MyDatabaseClass mdc;
	String leadServerDate,contactServerDate,dealServerDate;
	Curd curd;
	Thread loginThread;
	Boolean loginCheck=false;
	Button check,check2;
	TextView username,password,serverIp;
	String user="admin",pass;
	Object loginId;
	List<ArrayList<String>> listLead,listDeal,listContact;
	//ProgressDialog pd;
	ArrayList<Integer> statusDeleteLead;
	ArrayList<Integer> statusDeleteContact;
	ArrayList<String> getLeadCodeToDelete,getContactCodeToDelete;
	Boolean checkerLeadDelete=false,checkerContactDelete=false;
	boolean connected=false,checkerTaskLogin=false,loginServerContactDelete=false;
	List<ArrayList<String>> leadListToupdate;
	List<ArrayList<String>> valuesLeadToUpdate = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> valuesContactToUpdate = new ArrayList<ArrayList<String>>();
	ArrayList<String> contactListToUpdate;
	ArrayList<Integer> statusUser=new ArrayList<Integer>();
	List<ArrayList<String>> leadValuesFromServer = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> contactvaluesfromserver = new ArrayList<ArrayList<String>>();
	ArrayList<String> taskvaluesfromserver=new ArrayList<String>();
	List<ArrayList<String>> dealvaluesfromserver = new ArrayList<ArrayList<String>>();
	ArrayList<Integer> leadValuesFromServerToDelete = new ArrayList<Integer>();
	ArrayList<Integer> contactValuesFromServerToDelete = new ArrayList<Integer>();
    List<ArrayList<String>> contactValuesFromLocalDB = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> leadValuesFromLocalDB = new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> leadValuesUnniqueCode=new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> passUsersValues=new ArrayList<ArrayList<String>>();
	ArrayList<String> leadServerSyncTimeList=new ArrayList<String>();
	ArrayList<String> contactServerSyncTimeList=new ArrayList<String>();
	ArrayList<String> dealServerSyncTimeList=new ArrayList<String>();
	ArrayList<String> uniqueCodeOfLead = new ArrayList<String>();
	Boolean loginServerLead=false,loginServerContact=false,loginServerLeadDelete=false,loginServerLeadModify=false;
	InputStream in;
	String convert,serverIP,database,getUserValue;
	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		username=(TextView)getActivity().findViewById(R.id.lblName);
		password =(TextView)getActivity().findViewById(R.id.lblEmail);
		serverIp =(TextView)getActivity().findViewById(R.id.lblServer);

		database=username.getText().toString();
		pass=password.getText().toString();
		serverIP=serverIp.getText().toString();
		getUserValue=user;
		System.out.println("name" + user);
		System.out.println("password" + pass);
		System.out.println("ip "+serverIP);
		curd = new Curd();
		
		Operation1 mytask = null;
		mytask = new Operation1();
		mytask.execute();
		//new Operation1().execute("");
		
		
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.sync, container, false);
		//initialize(view);
		getActivity().setTitle("Synchronization");
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.sync);
	    btn_sync = (Button) view.findViewById(R.id.button_sync);
	    valuesLead = new ArrayList<ArrayList<String>>();
		statusLead = new ArrayList<ArrayList<Integer>>();
		valuesDeal = new ArrayList<ArrayList<String>>();
		statusDeal = new ArrayList<ArrayList<Integer>>();
		valuesTask = new ArrayList<ArrayList<String>>();
		statusTask = new ArrayList<Integer>();
		valuesContact = new ArrayList<ArrayList<String>>();
		statusContact = new ArrayList<ArrayList<Integer>>();
		statusDeleteLead = new ArrayList<Integer>();
		statusDeleteContact = new ArrayList<Integer>();
		getLeadCodeToDelete = new ArrayList<String>();
		getContactCodeToDelete = new ArrayList<String>();
		leadListToupdate = new ArrayList<ArrayList<String>>();
		//contactListToUpdate = new ArrayList<String>();
		
		mdc = new MyDatabaseClass(getActivity());
		mdc.open();
		
		passLead=mdc.getotalLeads(database);
		passDeal=mdc.getotalDeals(database);
		passTask=mdc.getotalTask(database);
		passContact=mdc.getotalContact(database);
		contactValuesFromLocalDB =mdc.getLocalContact(database);
		leadListToupdate=mdc.leadValueToUpdate1(database);
		contactListToUpdate=mdc.contactValueToUpdate1(database);
		System.out.println("total leads "+passLead);
		System.out.println("total deal "+passDeal);
		System.out.println("total task "+passTask);
		System.out.println("total contact "+passContact);
		//passIndexSynch=mdc.getIndex();
		valuesLead=mdc.valueForLeadServer(database);
		valuesDeal=mdc.valueForDealServer(database);
		valuesContact=mdc.valueForContactServer(database);
		valuesTask=mdc.valueForTaskServer(database);
		listLead = new ArrayList<ArrayList<String>>();
		//listDeal = new ArrayList<ArrayList<String>>();
		listContact = new ArrayList<ArrayList<String>>();
		listLead = mdc.leadValueToUpdate(database);
		System.out.println("lead to update "+listLead);
		//listDeal = mdc.DealValueToUpdate();
		listContact = mdc.contactValueToUpdate(database);
		getLeadCodeToDelete=mdc.getDeletedDBUniqueCodeLead(database);
		getContactCodeToDelete=mdc.getDeletedDBUniqueCodeContact(database);
		uniqueCodeOfLead=mdc.getUniqueCodeLead(database);
		System.out.println("values get "+listLead);
		//System.out.println("total lead"+statusLead);
	//	leadValuesUnniqueCode=mdc.leadValueForEachUniquecode();
		//System.out.println("lead values corresponding to unique code" + leadValuesUnniqueCode);
	
	contactServerSyncTimeList=mdc.getContactServerSyncTime(database);
	dealServerSyncTimeList=mdc.getDealServerSyncTime(database);
	
	System.out.println("lead unique code "+leadValuesFromLocalDB);
	System.out.println("contact unique code "+contactValuesFromLocalDB);
		mdc.close();
		
		if(contactServerSyncTimeList.size()!=0)
	contactServerDate=contactServerSyncTimeList.get(contactServerSyncTimeList.size()-1);
		
		//if(dealServerSyncTimeList.size()!=0)
		//	dealServerDate=dealServerSyncTimeList.get(dealServerSyncTimeList.size()-1);
		System.out.println("object value "+leadServerDate);
		System.out.println("object value for contact" + contactServerDate);
		System.out.println("contact value to modify" + listContact);
		System.out.println("lead value to modify" + listLead);
		System.out.println("lead code to delete" + getLeadCodeToDelete);
		System.out.println("contact code to delete" + getContactCodeToDelete);
	
		//System.out.println("object value for deal" + dealServerDate);
		//serverValues = new ArrayList<ArrayList<String>>();
		syn = new Synchronization();
		
		//check2=(Button)view.findViewById(R.id.buttonCheck2);
			    btn_sync.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				username=(TextView)getActivity().findViewById(R.id.lblName);
				password =(TextView)getActivity().findViewById(R.id.lblEmail);
				user=username.getText().toString();
				pass=password.getText().toString();
				System.out.println("got id "+checkerLogin);
				mdc = new MyDatabaseClass(getActivity());
				mdc.open();
				statusLead=mdc.statusLead(database);
				statusDeal=mdc.statusDeal(database);
				passLeadUnique=mdc.getotalLeadUniqueCode(database);
				passContactUnique=mdc.getotalContactUniqueCode(database);
				
				statusContact=mdc.statusContact(database);
				statusTask=mdc.statusTask(database);
				statusDeleteLead=mdc.statusDeleteLead(database);
				statusDeleteContact=mdc.statusDeleteContact(database);
				
				//leadValuesUnniqueCode=mdc.leadValueForEachUniquecode();
				mdc.close();
				//System.out.println("delete status "+statusDeleteLead.get(0));
				//System.out.println("lead code to delete "+getLeadCodeToDelete.get(0));
				//System.out.println("contact code to delete "+getContactCodeToDelete.get(0));
				System.out.println("lead values corresponding to unique code" + leadValuesUnniqueCode);
				System.out.println("checker value "+checkerLogin);
				
				connected=haveNetworkConnection();
				if (connected==true && checkerLogin==true)
					{
					new Operation().execute("");
					}
				else
					Toast.makeText(getActivity(), "Wait a minute or check internet connection", Toast.LENGTH_LONG).show();
					
				}
						});
		return view;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		//System.out.println("synching..........");
	}
	@SuppressWarnings("static-access")
	private boolean haveNetworkConnection() {
	    boolean haveConnectedWifi = false;
	    boolean haveConnectedMobile = false;

	    ConnectivityManager cm = (ConnectivityManager)getActivity(). getSystemService(getActivity().CONNECTIVITY_SERVICE);
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
	
	public class Operation extends AsyncTask<String,Void,String>
	{
			ProgressDialog pd = new ProgressDialog(getActivity());
			Synchronization syn  = new Synchronization();
			//Curd curd = new Curd();
		@Override
		protected String doInBackground(String... arg0) {
			
			MyDatabaseClass mdc = new MyDatabaseClass(getActivity());
			mdc.open();
			leadServerSyncTimeList=	mdc.getLeadServerSyncTime(database);
			if(leadServerSyncTimeList.size()!=0)
		leadServerDate=leadServerSyncTimeList.get(leadServerSyncTimeList.size()-1);	
			mdc.close();
			
			// TODO Auto-generated method stub
			thread=new Thread()
			{
				//@SuppressWarnings("static-access")
				
				
				public void run() {
					
					
					
					try{
						 
						  // syn.check();
						  leadValuesFromServer=syn.getValueFromServer(uniqueCodeOfLead,leadServerDate,serverIP,database,user,pass);
						  loginServerLead=true;
					   }
					   catch(Exception e)
					   {
						 System.out.println("exception in lead insertion from server");
						 loginServerLead=false;
					   }
					if(leadValuesFromServer.size()!=0 && loginServerLead==true)
					{
						Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						String formattedDate = df.format(c.getTime());

						
						//String where=NLead_Table.status + " = " + 2;
					//getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI, where,null);
					 //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				   	 //Calendar c = Calendar.getInstance();  
				   	 //String formattedDate = df.format(c.getTime());
						//Calendar c = Calendar.getInstance();
					    //System.out.println("Current time => "+c.getTime());

					    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					    //String formattedDate = df.format(c.getTime());

					System.out.println("server values size " +leadValuesFromServer.size());
					System.out.println("server values "+leadValuesFromServer);
					for(int i=0;i<leadValuesFromServer.size();i++)
					{
						System.out.println("user value"+user);
						String user_value=user;
						boolean check5=isEmailValid(leadValuesFromServer.get(i).get(4));
						System.out.println("email "+leadValuesFromServer.get(i).get(4));
						if(leadValuesFromServer.get(i).get(4).toString()=="false" || check5==true)
						{
							System.out.println("user value "+user);
							//System.out.println("");
					//String unique_code=leadValuesFromServer.get(i).get(0) + " " + leadValuesFromServer.get(i).get(1) + " " + leadValuesFromServer.get(i).get(2) + " " + formattedDate;
					
					ContentValues cv=new ContentValues();
					///System.out.println("insert from server lead1");
					//System.out.println("firstname "+leadValuesFromServer.get(i).get(0));
					///cv.put(NLead_Table.firstname,leadValuesFromServer.get(0).get(i));
					//System.out.println("lastname "+leadValuesFromServer.get(i).get(1));
					cv.put(NLead_Table.firstname,leadValuesFromServer.get(i).get(0));
					///System.out.println("company "+leadValuesFromServer.get(i).get(3));
					cv.put(NLead_Table.lastname,leadValuesFromServer.get(i).get(1));
					//System.out.println("phone number "+leadValuesFromServer.get(i).get(5));
					cv.put(NLead_Table.company,leadValuesFromServer.get(i).get(2));
					cv.put(NLead_Table.phone_no,leadValuesFromServer.get(i).get(3));
					cv.put(NLead_Table.emailAddress,leadValuesFromServer.get(i).get(4));
					cv.put(NLead_Table.website,leadValuesFromServer.get(i).get(5));
					cv.put(NLead_Table.address,leadValuesFromServer.get(i).get(6));
					cv.put(NLead_Table.facebook,leadValuesFromServer.get(i).get(7));
					cv.put(NLead_Table.linked_in,leadValuesFromServer.get(i).get(8));
					//cv.put(NLead_Table.description,leadValuesFromServer.get(i).get(9));
					cv.put(NLead_Table.generated_code,leadValuesFromServer.get(i).get(9));
					cv.put(NLead_Table.signinEmail,user_value);
					//cv.put(NLead_Table.date_time, )
					cv.put(NLead_Table.table_type,"forlead");
					cv.put(NLead_Table.status,2);
					
				//Uri uri=Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/");
			getActivity().getContentResolver().insert(MyDatabaseProvider.LEAD_CONTENT_URI,cv);
					//Toast.makeText(getActivity(),
					//			"return is " + uri.toString(), Toast.LENGTH_SHORT)
					//			.show();
						}
						//ContentValues cv2=new ContentValues();
						//cv2.put(ServerSynchTime.ServersynchId,leadValuesFromServer.get(10).get(0));
						
										}
					String username =user;
					ContentValues cv2=new ContentValues();
					cv2.put(ServerSynchTime.ServersynchId,leadValuesFromServer.get(0).get(10));
					cv2.put(ServerSynchTime.signinEmail, username);
					getActivity().getContentResolver().insert(MyDatabaseProvider.LEAD_SERVER_SYNC,cv2);
					//Toast.makeText(getActivity(),
					//			"return is " + uri.toString(), Toast.LENGTH_SHORT)
								//.show();
//
				/*	for(int i=0;i<getLeadCodeToDelete.size();i++)
					{
					String whereas=NLead_Table.generated_code + " = " + getLeadCodeToDelete.get(i);
					getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI, whereas,null);
					}
					*/
					}

					
					try {
						
						System.out.println("i am in thread");
						for(int i=0;i<passLead;i++)
						{
							System.out.println("i am in lead thread");
							if(statusLead.get(i).get(1)==1)// && (statusLead.get(i).get(0)==3 || statusLead.get(i).get(0)==1))
							{
						syn.passValueToServer(passLead,statusLead,valuesLead,serverIP,database,user,pass,loginId);
						    break;
							}
							
						}
					}
					catch(Exception e)
					{
					checkerLead=true;	
					}
					/*try{
						 
						   //leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
							contactvaluesfromserver=syn.getValueFromServerforcontact(contactValuesFromLocalDB,serverIP,database,user,pass);
							loginServerContact=true;
							//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
							//taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
								
					   }
					  catch(Exception e)
					   {
						 System.out.println("exception in insert on local contact"); 
						 loginServerContact=false;
					  }
					if(contactvaluesfromserver.size()!=0 && loginServerContact==true)
					{
						Calendar c = Calendar.getInstance();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						String formattedDate = df.format(c.getTime());

						
						//String where=NLead_Table.status + " = " + 2;
					//getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI, where,null);
					 //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				   	 //Calendar c = Calendar.getInstance();  
				   	 //String formattedDate = df.format(c.getTime());
						//Calendar c = Calendar.getInstance();
					    //System.out.println("Current time => "+c.getTime());

					    //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					    //String formattedDate = df.format(c.getTime());

					System.out.println("server values size " +contactvaluesfromserver.size());
					for(int i=0;i<contactvaluesfromserver.size();i++)
					{	
						
						
						
						String user_value=user;
					String unique_code=contactvaluesfromserver.get(i).get(0) + " " + contactvaluesfromserver.get(i).get(1) + " " + contactvaluesfromserver.get(i).get(4) + " " + formattedDate;
					ContentValues cv1=new ContentValues();
					cv1.put(Contact_table.firstname,contactvaluesfromserver.get(i).get(0));
					//cv1.put(Contact_table.company,contactvaluesfromserver.get(1).get(1));
					cv1.put(Contact_table.phone_no,contactvaluesfromserver.get(i).get(1));
					cv1.put(Contact_table.facebook,contactvaluesfromserver.get(i).get(2));
					cv1.put(Contact_table.address,contactvaluesfromserver.get(i).get(3));
					cv1.put(Contact_table.emailid,contactvaluesfromserver.get(i).get(4));
					cv1.put(Contact_table.website,contactvaluesfromserver.get(i).get(5));
					cv1.put(Contact_table.synchId,contactvaluesfromserver.get(i).get(6));
					//cv1.put(Contact_table.generated_code,contactvaluesfromserver.get(6).get(i));
					cv1.put(Contact_table.generated_code, unique_code);
					cv1.put(Contact_table.table_type,"contact");
					cv1.put(Contact_table.status,2);
					cv1.put(Contact_table.signinEmail,user_value);
				getActivity().getContentResolver().insert(MyDatabaseProvider.CONTENT_URI,cv1);
						}
				//Uri uri=Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/");
					//Toast.makeText(getActivity(),
					//			"return is " + uri.toString(), Toast.LENGTH_SHORT)
					//			.show();
						}
						//ContentValues cv2=new ContentValues();
						//cv2.put(ServerSynchTime.ServersynchId,leadValuesFromServer.get(10).get(0));
						
										
					//ContentValues cv2=new ContentValues();
					//cv2.put(ServerSynchTime.ServersynchId,leadValuesFromServer.get(0).get(11));
					//getActivity().getContentResolver().insert(MyDatabaseProvider.LEAD_SERVER_SYNC,cv2);
					//Toast.makeText(getActivity(),
					//			"return is " + uri.toString(), Toast.LENGTH_SHORT)
								//.show();
//
				/*	for(int i=0;i<getLeadCodeToDelete.size();i++)
					{
					String whereas=NLead_Table.generated_code + " = " + getLeadCodeToDelete.get(i);
					getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI, whereas,null);
					}
					*/
					
					
					try{
						for(int i=0;i<passContact;i++)
						{
							System.out.println("i am in contact thread");
							if(statusContact.get(i).get(0)==1)// && (statusContact.get(i).get(1)==3 || statusContact.get(i).get(1)==1))
							{
						syn.passValueToContact(passContact,statusContact,valuesContact,serverIP,database,user,pass,loginId);
							break;
							}
						}
					}
					catch(Exception e)
					{
					checkerContact=true;	
					}
					
					if(leadValuesFromServer.size()!=0)
					{
					for(int i=0;i<leadValuesFromServer.size();i++)
					{
						boolean check5=isEmailValid(leadValuesFromServer.get(i).get(4));
						if(leadValuesFromServer.get(i).get(4).toString()!="false" && check5==false) ///|| leadValuesFromServer.get(1).get(i).isEmpty())
						{
						
						//String unique_code=leadValuesFromServer.get(0).get(i) + " " + leadValuesFromServer.get(1).get(i) + " " + leadValuesFromServer.get(2).get(i);
					ContentValues cv=new ContentValues();
					//System.out.println("insert from server lead1");
					cv.put(Deal_Table.dealName, leadValuesFromServer.get(i).get(0));
					cv.put(Deal_Table.value,leadValuesFromServer.get(i).get(4));
					cv.put(Deal_Table.tabletype,"deal");
					cv.put(Deal_Table.status,2);
					cv.put(Deal_Table.modified_date, 3);
					cv.put(Deal_Table.signinEmail,user);
				//Uri uri=Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/");
			       getActivity().getContentResolver().insert(MyDatabaseProvider.DEAL_CONTENT_URI,cv);
					//Toast.makeText(getActivity(),
					//			"return is " + uri.toString(), Toast.LENGTH_SHORT)
					//			.show();
						}
						
					
					}			}
					
					
					try{
					for(int i=0;i<passDeal;i++)
						{
							System.out.println("i am in deal thread");
							if(statusDeal.get(i).get(0)==1)
							{
						syn.passValueToDeal(passDeal,statusDeal,valuesDeal,serverIP,database,user,pass,loginId);
							break;
							}
						}
					}
					catch(Exception e)
					{
					checkerDeal=true;	
					}
						
					System.out.println("i am in thread");
					try{
						for(int i=0;i<passLead;i++)
						{
							System.out.println("i am in lead thread");
							if(statusLead.get(i).get(0)==2)
							{
								System.out.println("lead value to modify" + listLead);
						syn.modifyLead(listLead,serverIP,database,user,pass);
						    break;
							}
							
						}
					}
					catch(Exception e)
					{
						checkerupdateLead=true;
					}
					
						try{
						for(int i=0;i<passContact;i++)
						{
							System.out.println("i am in contact thread");
							if(statusContact.get(i).get(1)==2)
							{
								System.out.println("contact value to modify" + listContact);
						syn.modifyContact(listContact,serverIP,database,user,pass);
							break;
							}
						}
						}
						catch(Exception e)
						{
						checkerUpdateContact=true;	
						}
						try{
						for(int i=0;i<passTask;i++)
						{
							if(statusTask.get(i)==1)
							{
						syn.passValueToTask(passTask, statusTask,valuesTask,serverIP,database,user,pass,loginId);
							break;
							}	
						}
						
					}
						catch(Exception e)
						{
							//System.out.println("exception in contact update");
							checkerTaskLogin=true;
						}
						
					 try{
						 for(int i=0;i<getLeadCodeToDelete.size();i++)
							{
								System.out.println("i am to delete");
								//syn.deleteContactFromServer(contact_unique_dbcode);
									System.out.println("lead code to delete" + getLeadCodeToDelete);
								syn.deleteLeadFromServer(getLeadCodeToDelete,serverIP,database,user,pass);
								break;
								
							}
					 }
					 catch(Exception e)
					 {
						 checkerLeadDelete=true;
						 System.out.println("exception in delete on servera lead");
					 }
					 try{
						 for(int i=0;i<passContact;i++)
						 {
							 if(statusDeleteContact.get(i)==1)
							 {
								 System.out.println("contact code to delete" + getContactCodeToDelete);
								 syn.deleteContactFromServer(getContactCodeToDelete,serverIP,database,user,pass);
								 break;
							 }
						 }
					 }
					 catch(Exception e)
					 {
						 checkerContactDelete=true;
					 }

					  
					  /* try{
							//contactValuesFromServerToDelete=syn.getValueFromServerToDeleteContact(contactValuesFromLocalDB);		

					      }
					   catch(Exception e)
					   {
						System.out.println("exception in delete in contact ");   
					   }*/
					 
						
					  /* try{
							valuesContactToUpdate=syn.serverContactModificationValues(contactListToUpdate);
						   
					   }
					   catch(Exception e)
					  {
						   System.out.println("exception in contact modification from server");
					  }*/
					  /* try{
						 
						   leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
							//contactvaluesfromserver=syn.getValueFromServerforcontact("54.251.186.100","traveloore","admin","1234");
							//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
							//taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
								
					   }
					  catch(Exception e)
					   {
						 System.out.println("exception in insert on local lead");  
					  }
					  */
					 /*  try
					  * {
						   
							/////// leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
								//contactvaluesfromserver=syn.getValueFromServerforcontact(contactServerDate);
								//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
								//System.out.println("deal Value get...");
								//taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
									
						   }
						   catch(Exception e)
						   {
							 System.out.println("exception in insert on local contact");  
						   }
					*/
					  /* try{
							dealvaluesfromserver=syn.getvaluefromserverfordeal(dealServerDate);
						   
					   }
					   catch(Exception e)
					   {
						   System.out.println("exception in insert on local deal");
					   }*/
					   
					/*   try{
							// leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
								//contactvaluesfromserver=syn.getValueFromServerforcontact("54.251.186.100","traveloore","admin","1234");
								//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
								taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
									
						   }
						   catch(Exception e)
						  {
							 System.out.println("exception in insert on local task");  
						   }
						   */
					  try{
						  MyDatabaseClass mdc = new MyDatabaseClass(getActivity());
							mdc.open();
							leadValuesFromLocalDB =mdc.getLocalLeads(database);
			                mdc.close();
							
					   leadValuesFromServerToDelete=syn.getValueFromServerToDelete(leadValuesFromLocalDB,serverIP,database,user,pass);
					  loginServerLeadDelete=true; 
					  }
					   catch(Exception e)
					   {
						   loginServerLeadDelete=false;
						 System.out.println("exception in delete on local in lead");  
					   }
					  
					  System.out.println("id got ? "+leadValuesFromServerToDelete);
					  // MyDatabaseClass	mdc=new MyDatabaseClass(getActivity());
						//mdc.open();
					  if(loginServerLeadDelete==true)
					  {
						for(int id=0;id<leadValuesFromServerToDelete.size();id++)
						getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI,NLead_Table.lead_id + " = " + leadValuesFromServerToDelete.get(id),null);
					  }
					    
						  System.out.println("id got for lead ? "+leadValuesFromServerToDelete);
						 //  MyDatabaseClass	mdc=new MyDatabaseClass(getActivity());
							//mdc.open();
						   
						  try{
							  MyDatabaseClass mdc = new MyDatabaseClass(getActivity());
							  mdc.open();
							  contactValuesFromLocalDB =mdc.getLocalContact(database);
                              mdc.close();
								contactValuesFromServerToDelete=syn.getValueFromServerToDeleteContact(contactValuesFromLocalDB,serverIP,database,user,pass);		
                                loginServerContactDelete=true;
						      }
						   catch(Exception e)
						   {
							   loginServerContactDelete=false;
							System.out.println("exception in delete in contact ");   
						   }

						  if(loginServerContactDelete==true)
						  {
							  System.out.println("ids to delete from database "+loginServerContactDelete);
							  for(int id=0;id<contactValuesFromServerToDelete.size();id++)
							getActivity().getContentResolver().delete(MyDatabaseProvider.CONTENT_URI,Contact_table.contact_id + " = " + contactValuesFromServerToDelete.get(id),null);
						  }
						
						 
						 
						  //System.out.println("size hai ? "+leadValuesFromServer.size());
					  //System.out.println("values size "+leadValuesFromServer.get(0).size());
					 
			  					
						/*System.out.println("contact value from server.." + contactvaluesfromserver);
						if(contactvaluesfromserver.size()!=0)
						{

						//String where1=Contact_table.status + " = " + 2;
						//	getActivity().getContentResolver().delete(MyDatabaseProvider.CONTENT_URI, where1, null);
							
							//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						   	// Calendar c = Calendar.getInstance();  
						   	// String formattedDate = df.format(c.getTime());
						 for(int i =0;i<contactvaluesfromserver.get(0).size();i++)
						 {
							 System.out.println("email id "+contactvaluesfromserver.get(4).get(i));
						 }
						   	 
						for(int i=0;i<contactvaluesfromserver.get(0).size();i++)
						{
							String unique =contactvaluesfromserver.get(0).get(i) + " " + contactvaluesfromserver.get(1).get(i) + " " + contactvaluesfromserver.get(4).get(i);
							ContentValues cv1=new ContentValues();
							cv1.put(Contact_table.firstname,contactvaluesfromserver.get(0).get(i));
							//cv1.put(Contact_table.company,contactvaluesfromserver.get(1).get(i));
							cv1.put(Contact_table.phone_no,contactvaluesfromserver.get(1).get(i));
							cv1.put(Contact_table.facebook,contactvaluesfromserver.get(2).get(i));
							cv1.put(Contact_table.address,contactvaluesfromserver.get(3).get(i));
							cv1.put(Contact_table.emailid,contactvaluesfromserver.get(4).get(i));
							cv1.put(Contact_table.website,contactvaluesfromserver.get(5).get(i));
							//cv1.put(Contact_table.description,contactvaluesfromserver.get(6).get(i));
							//cv1.put(Contact_table.generated_code,contactvaluesfromserver.get(6).get(i));
							cv1.put(Contact_table.generated_code, unique);
							cv1.put(Contact_table.table_type,"contact");
							cv1.put(Contact_table.status,2);
							Uri uri=getActivity().getContentResolver().insert(MyDatabaseProvider.CONTENT_URI,cv1);
							Toast.makeText(getActivity(),
										"return is " + uri.toString(), Toast.LENGTH_SHORT)
										.show();
							
						}
						ContentValues cv3=new ContentValues();
						cv3.put(ContactServerSynchTIme.Contact_ServersynchId,leadValuesFromServer.get(6).get(0));
						
						Uri uri=getActivity().getContentResolver().insert(MyDatabaseProvider.LEAD_SERVER_SYNC,cv3);
						Toast.makeText(getActivity(),
									"return is " + uri.toString(), Toast.LENGTH_SHORT)
									.show();
						}
						
						for(int i=0;i<getContactCodeToDelete.size();i++)
						{
						String whereas=Contact_table.generated_code + " = " + getContactCodeToDelete.get(i);
						getActivity().getContentResolver().delete(MyDatabaseProvider.CONTENT_URI, whereas, null);
						}*/
						
						
						
						//System.out.println("size of task" + taskvaluesfromserver.size());
						//System.out.println("task value from server.." + taskvaluesfromserver);
						//System.out.println("task value.." + taskvaluesfromserver.get(0));
						//System.out.println("task value" + taskvaluesfromserver.get(1));
						//System.out.println("task value" + taskvaluesfromserver.get(2));
						//System.out.println("task value" + taskvaluesfromserver.get(3));
						//System.out.println("task value" + taskvaluesfromserver.get(4));
						//System.out.println("task value" + taskvaluesfromserver.get(5));
						/*ContentValues cv2=new ContentValues();
						cv2.put(DealServerSyncTime.deal_ServersynchId,dealvaluesfromserver.get(2).get(0));
						Uri uri=getActivity().getContentResolver().insert(MyDatabaseProvider.DEAL_SERVER_SYNC,cv2);
						Toast.makeText(getActivity(),
									"return is " + uri.toString(), Toast.LENGTH_SHORT)
									.show();

						}*/	
						//leadValuesFromServer.clear();
						
						
						
						/*if(taskvaluesfromserver.size()!=0)
						{
						
						String where3=AddTask_Table.status + "=" + 2;
							getActivity().getContentResolver().delete(MyDatabaseProvider.ADDTASK_CONTENT_URI, where3, null);
							
						
						System.out.println("checkingggggggggg");
						for(int i=0;i<taskvaluesfromserver.size();i++)
						{
							ContentValues cv3 = new ContentValues();
							cv3.put(AddTask_Table.description,taskvaluesfromserver.get(i));
							cv3.put(AddTask_Table.tabletype,"addtask");
							cv3.put(AddTask_Table.status,2);
							Uri uri=getActivity().getContentResolver().insert(MyDatabaseProvider.ADDTASK_CONTENT_URI,cv3);
							Toast.makeText(getActivity(),
										"return is " + uri.toString(), Toast.LENGTH_SHORT)
										.show();
							
						}
						}*/
						
						 
							// mdc.close();	
						  try
						   {
							   valuesLeadToUpdate= syn.serverLeadModificationValues(leadListToupdate,serverIP,database,user,pass);
							   loginServerLeadModify=true;
						   }
						   catch(Exception e)
						   {
							   System.out.println("exception in modification lead");
							   loginServerLeadModify=false;
						   }
						 if(valuesLeadToUpdate.size() != 0 && loginServerLeadModify==true)
							{
							ArrayList<Integer> indexLeadToUpdate = new ArrayList<Integer>();
							for(int i=0;i<valuesLeadToUpdate.size()-1;i++)
							{
								indexLeadToUpdate.add(Integer.parseInt(valuesLeadToUpdate.get(valuesLeadToUpdate.size()-1).get(i)));
							}
							//System.out.println("id got "+indexLeadToUpdate.get(valuesLeadToUpdate.size()-1));
							for(int i=0;i<valuesLeadToUpdate.size()-1;i++)
							{
								//id = Integer.parseInt(valuesToUpdate.get(valuesToUpdate.size()-1).get(i));
								ContentValues cv = new ContentValues();
								cv.put(NLead_Table.firstname, valuesLeadToUpdate.get(i).get(0));
								cv.put(NLead_Table.lastname, valuesLeadToUpdate.get(i).get(1));
								cv.put(NLead_Table.company, valuesLeadToUpdate.get(i).get(2));
								cv.put(NLead_Table.phone_no, valuesLeadToUpdate.get(i).get(3));
								cv.put(NLead_Table.emailAddress,valuesLeadToUpdate.get(i).get(4));
								cv.put(NLead_Table.website, valuesLeadToUpdate.get(i).get(5));
								cv.put(NLead_Table.address, valuesLeadToUpdate.get(i).get(8));
								cv.put(NLead_Table.facebook,valuesLeadToUpdate.get(i).get(6));
								cv.put(NLead_Table.linked_in, valuesLeadToUpdate.get(i).get(7));
								cv.put(NLead_Table.description, valuesLeadToUpdate.get(i).get(9));
								//cv.put(NLead_Table.generated_code,valuesLeadToUpdate.get(i).get(10) );
								cv.put(NLead_Table.modified_date_time, 3);
								
								String where = NLead_Table.lead_id + "=" + indexLeadToUpdate.get(i);
								Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/" + indexLeadToUpdate.get(i));
								getActivity().getContentResolver().update(uri, cv, where, null);
							}
								
							}
						
					 System.out.println("cheking value is "+loginCheck);
				}
				
			};
				thread.start();
							

			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			  pd=new ProgressDialog(getActivity());
				pd.setIndeterminate(true);
				pd.setCancelable(false);
				pd.setMessage("Connecting with server.....please wait");
				//pd.setMessage("synchronizing data....");
				pd.show();
				Handler handler=new Handler();
				handler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						pd.dismiss();
					}},50000);
				
			//super.onPreExecute();
		}
		
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			Operation1 op = new Operation1();
		//	Toast.makeText(getApplicationContext(), "sync with server",Toast.LENGTH_LONG).show();
			System.out.println("values to update "+valuesLeadToUpdate);
			System.out.println("update data.....");
			System.out.println("connected "+connected);
			System.out.println("got response "+checkerLogin);
			System.out.println("exception in lead "+checkerLead);
			System.out.println("exception in deal "+checkerDeal);
			System.out.println("exception in contact "+checkerContact);
			System.out.println("exception in Task "+checkerTaskLogin);
			System.out.println("exception in lead delete "+checkerLeadDelete);
			System.out.println("exception in contact delete "+checkerContactDelete);
			System.out.println("exception in lead update "+checkerupdateLead);
			System.out.println("exception in contact update "+checkerUpdateContact);
			System.out.println("valueToUpdate size "+valuesLeadToUpdate.size());
			/*if(valuesLeadToUpdate.size() != 0)
			{
			ArrayList<Integer> indexLeadToUpdate = new ArrayList<Integer>();
			for(int i=0;i<valuesLeadToUpdate.size()-1;i++)
			{
				indexLeadToUpdate.add(Integer.parseInt(valuesLeadToUpdate.get(valuesLeadToUpdate.size()-1).get(i)));
			}
			//System.out.println("id got "+indexLeadToUpdate.get(valuesLeadToUpdate.size()-1));
			for(int i=0;i<valuesLeadToUpdate.size()-1;i++)
			{
				//id = Integer.parseInt(valuesToUpdate.get(valuesToUpdate.size()-1).get(i));
				ContentValues cv = new ContentValues();
				cv.put(NLead_Table.firstname, valuesLeadToUpdate.get(i).get(0));
				cv.put(NLead_Table.lastname, valuesLeadToUpdate.get(i).get(1));
				cv.put(NLead_Table.company, valuesLeadToUpdate.get(i).get(2));
				cv.put(NLead_Table.phone_no, valuesLeadToUpdate.get(i).get(3));
				cv.put(NLead_Table.emailAddress,valuesLeadToUpdate.get(i).get(4));
				cv.put(NLead_Table.website, valuesLeadToUpdate.get(i).get(5));
				cv.put(NLead_Table.address, valuesLeadToUpdate.get(i).get(8));
				cv.put(NLead_Table.facebook,valuesLeadToUpdate.get(i).get(6));
				cv.put(NLead_Table.linked_in, valuesLeadToUpdate.get(i).get(7));
				cv.put(NLead_Table.description, valuesLeadToUpdate.get(i).get(9));
				cv.put(NLead_Table.generated_code,valuesLeadToUpdate.get(i).get(10) );
				cv.put(NLead_Table.modified_date_time, 3);
				String where = NLead_Table.lead_id + "=" + indexLeadToUpdate.get(i);
				Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/" + indexLeadToUpdate.get(i));
				getActivity().getContentResolver().update(uri, cv, where, null);
			}
				
			}*/

			
			
			if(connected==true && checkerLogin==true){
				System.out.println("problems");	
					System.out.println("total lead "+passLead);
					System.out.println("total deal "+passDeal);
					System.out.println("total task "+passTask);
					System.out.println("total contact "+passContact);
					for(int i=0;i<passLead;i++)
					{
						System.out.println("insert lead");
						ContentValues cv = new ContentValues();
						System.out.println("insert lead 1");
						cv.put(NLead_Table.status, 2);
						System.out.println("insert lead 2");
						String value = valuesLead.get(i).get(0);
						System.out.println("values....."+value);
						String wherearg = NLead_Table.firstname +  " = '" + value + "'";
						System.out.println("insert lead 3");
						Uri uri =Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/" + i);
						getActivity().getContentResolver().update(uri, cv, wherearg, null);
					System.out.println("insert lead 4");			
					}
					
					for(int i=0;i<passDeal;i++)
					{
						System.out.println("to insert deal");
					ContentValues cv = new ContentValues();
					cv.put(Deal_Table.status,2);
                   String value =valuesDeal.get(i).get(0);
					String where = Deal_Table.dealName +  " = '" + value + "'";
					Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/deal_table/" + i);
					getActivity().getContentResolver().update(uri, cv, where, null);
						
						}
					
					
					for(int i=1;i<=passLeadUnique;i++)
					{
						//System.out.println("to insert deal");
					ContentValues cv = new ContentValues();
					cv.put(Delete_Lead_sync.delete_status,2);
                    
					String where = Delete_Lead_sync.id + "=" + i;
					Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/sync_delete_lead/" + i);
					getActivity().getContentResolver().update(uri, cv, where, null);
						
					}
					for(int i=1;i<=passContactUnique;i++)
					{
						//System.out.println("to insert deal");
					ContentValues cv = new ContentValues();
					cv.put(Delete_contact_sync.delete_status,2);

					String where = Delete_Lead_sync.id + "=" + i;
					Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/sync_delete_contact/" + i);
					getActivity().getContentResolver().update(uri, cv, where, null);
						
					}

					
					for(int i=1;i<=passContact;i++)
					{
						System.out.println("to insert contact");
						ContentValues cv = new ContentValues();
						cv.put(Contact_table.status,2);
						String value=valuesContact.get(i-1).get(0);
						String where = Contact_table.firstname +  " = '" + value + "'";;
						Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/contact_table/" + i);
						getActivity().getContentResolver().update(uri, cv, where, null);
						
					}
					for(int i=0;i<passTask;i++)
					{
						System.out.println("to insert task");
						ContentValues cv = new ContentValues();
						cv.put(AddTask_Table.status, 2);
						String value=valuesTask.get(i).get(0);
						String where = AddTask_Table.description +  " = '" + value + "'";;
						
						Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/addtask_table/" + i);
						getActivity().getContentResolver().update(uri, cv, where, null);
						
					}
					
					
					for(int i=0;i<listLead.size();i++)
					{
						System.out.println("to update lead");
						ContentValues cv = new ContentValues();
						cv.put(NLead_Table.modified_date_time,3);
				String value = listLead.get(i).get(0);
						String where = NLead_Table.firstname +  " = '" + value + "'";;
;
				Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/add_lead_table/" + i);
				getActivity().getContentResolver().update(uri, cv, where, null);
					
				}
					for(int i=0;i<listContact.size();i++)
					{
						System.out.println("to update contact");
						ContentValues cv = new ContentValues();
						cv.put(Contact_table.modified_status,3);
						String value = listContact.get(i).get(0);
						String where = Contact_table.firstname +  " = '" + value + "'";;
;						Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/contact_table/" + i);
						getActivity().getContentResolver().update(uri, cv, where, null);
						
					}	
				}
				
				if(connected==true && checkerLogin==true && checkerLeadDelete==false){
					for(int i=1;i<=passLead;i++)
					{
						System.out.println("to delete lead");
						ContentValues cv = new ContentValues();
						cv.put(Delete_Lead_sync.delete_status,2);
						String where = Delete_Lead_sync.id + "=" + i;
						Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/sync_delete_lead/" + i);
						getActivity().getContentResolver().update(uri, cv, where, null);
						
					}	
				}
				if(connected=true && checkerLogin==true && checkerContactDelete==false)
					for(int i=1;i<=passContact;i++)
					{
						System.out.println("to delete contact");
						ContentValues cv = new ContentValues();
						cv.put(Delete_contact_sync.delete_status,2);
						String where = Delete_contact_sync.id + "=" + i;
						Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/sync_delete_contact/" + i);
						getActivity().getContentResolver().update(uri, cv, where, null);
							
					}
				System.out.println("lead values from server.." + leadValuesFromServer);
							
			/*System.out.println("id got ? "+contactValuesFromServerToDelete);
			   MyDatabaseClass	mdc1=new MyDatabaseClass(getActivity());
				mdc1.open();
				for(int id=0;id<contactValuesFromServerToDelete.size();id++)
				getActivity().getContentResolver().delete(MyDatabaseProvider.CONTENT_URI,Contact_table.contact_id + " = " + contactValuesFromServerToDelete.get(id),null);
		mdc1.close();*/
			pd.setMessage("please wait..... synchronizing your data");
			Handler handler=new Handler();
			handler.postDelayed(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					pd.dismiss();
				}},40000);
			
			//System.out.println("status "+statusContact.get(0).get(0));
			//System.out.println("modified "+statusContact.get(0).get(1));
			//System.out.println("total contacts "+passContact);
			//pd.dismiss();
		}
	}
	public class Operation1 extends AsyncTask<String,Void,String>
	{
			Synchronization syn  = new Synchronization();
		    Curd curd = new Curd();
		   ProgressDialog pd=new ProgressDialog(getActivity());

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			curd = new Curd();
			//System.out.println("passuser......" + passUser);
			
			
			thread=new Thread()
			{
				
				//@SuppressWarnings("static-access")
				public void run() {
					
					/*try {
			    		//curd.login();
					in=	curd.OpenHttpConnection("http://54.225.137.166/traveloore_crm.php?username="+user+"&password="+pass);
					System.out.println("responseeeeee" + in);
					
					  convert=curd.convertStreamToString(in);
					  System.out.println("string "+convert);
					  String values[]=convert.split("\\s+");
					  //serverIP=values[0];
					  //database=values[1];
					    
	                        
					   // System.out.print......ln("second "+convert.get(1));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("exceptionnn.....");
					}*/
					/*try{

						System.out.println("i am in user thread");
						for(int i=0;i<passUser;i++)
						{
							System.out.println("i am in user thread");
							if(statusUser.get(i)==1)// && (statusLead.get(i).get(0)==3 || statusLead.get(i).get(0)==1))
							{
						syn.passUsersValueToServer(passUser, statusUser,passUsersValues,serverIP,database,user,pass);
					}
						}
						}catch(Exception e)
					{
						System.out.println("exception in user creation");
					}*/
					   try {
						loginId=curd.login(user,pass,database,serverIP);
						checkerLogin=true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("exception in login ");
						checkerLogin=false;
					}
					/*  try
					   {
						   valuesLeadToUpdate= syn.serverLeadModificationValues(leadListToupdate);
					   }
					   catch(Exception e)
					   {
						   System.out.println("exception in modification lead");
					   }
					  /* try{
							valuesContactToUpdate=syn.serverContactModificationValues(contactListToUpdate);
						   
					   }
					   catch(Exception e)
					  {
						   System.out.println("exception in contact modification from server");
					  }*/
					  /* try{
						 
						   leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
							//contactvaluesfromserver=syn.getValueFromServerforcontact("54.251.186.100","traveloore","admin","1234");
							//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
							//taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
								
					   }
					  catch(Exception e)
					   {
						 System.out.println("exception in insert on local lead");  
					  }
					  */
					 /*  try{
						   
							/////// leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
								//contactvaluesfromserver=syn.getValueFromServerforcontact(contactServerDate);
								//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
								//System.out.println("deal Value get...");
								//taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
									
						   }
						   catch(Exception e)
						   {
							 System.out.println("exception in insert on local contact");  
						   }
					*/
					  /* try{
							dealvaluesfromserver=syn.getvaluefromserverfordeal(dealServerDate);
						   
					   }
					   catch(Exception e)
					   {
						   System.out.println("exception in insert on local deal");
					   }*/
					   
					/*   try{
							// leadValuesFromServer=syn.getValueFromServer("54.251.186.100","traveloore","admin","1234");
								//contactvaluesfromserver=syn.getValueFromServerforcontact("54.251.186.100","traveloore","admin","1234");
								//dealvaluesfromserver=syn.getvaluefromserverfordeal("54.251.186.100","traveloore","admin","1234");
								taskvaluesfromserver=syn.getvaluefromserverfortask("54.251.186.100","traveloore","admin","1234");
									
						   }
						   catch(Exception e)
						  {
							 System.out.println("exception in insert on local task");  
						   }
						   */
					/*  try{
					   leadValuesFromServerToDelete=syn.getValueFromServerToDelete(leadValuesFromLocalDB);
					   }
					   catch(Exception e)
					   {
						 System.out.println("exception in delete on local in lead");  
					   }
					  
					  try{
							 
						  // syn.check();
						  leadValuesFromServer=syn.getValueFromServer(leadServerDate);
 
					   }
					   catch(Exception e)
					   {
						 System.out.println("exception in lead modification from server");  
					   }
*/
					  
					  					   
					   System.out.println("cheking value is "+checkerLogin);
				}
				
				};
				thread.start();
									

			return null;
		}
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
				pd.setIndeterminate(true);
				pd.setCancelable(false);
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
					}},20000);
				//pd.setMessage("synchronizing data....");
				
			//super.onPreExecute();
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
			/*for(int i=1;i<=passUser;i++)
			{
				System.out.println("to update uer");
				ContentValues cv = new ContentValues();
				cv.put(Signup_Table.status,2);
		String where = Signup_Table.signup_id + "=" + i;
		Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/signup_table/" + i);
		getActivity().getContentResolver().update(uri, cv, where, null);
			
		}*/
			pd.setMessage("successfully loaded data...");

			//long t= System.currentTimeMillis();
			//long end = t+15000;
			//while(System.currentTimeMillis() < end) {}
			 
			
			pd.dismiss();
		}
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