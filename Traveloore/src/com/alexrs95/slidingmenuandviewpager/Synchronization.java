package com.alexrs95.slidingmenuandviewpager;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import android.app.Activity;
import android.util.Log;

import com.bremskerl.de.interfaces.openerp.OpenERP;
import com.bremskerl.de.interfaces.openerp.OpenERPDomain;
import com.bremskerl.de.interfaces.openerp.OpenERPRecordSet;
import com.btpl.database.MyDatabaseClass;

public class Synchronization extends Activity {
	int index,totalValuesOfLeads,totalEntryOnServer,length;
	Curd curd;
	MyDatabaseClass mdc;
	//Context _context;
	Vector<Object> vactor;
	OpenERP openerp;
	String[] storeDate;
	ArrayList<String> storeLocalDate;
	int getLead;
	String first,last,company,titleValue,industry,phone,facebook,twitter,linkedin,skype,address,email,
	websiteValue,descriptionValue,date_time;
	String[] values;
	int mapping,indexSynch,indexTOStore;
	Synchronization syn;
	Object result;
	SynchronizationHelper synHelper;
	List<ArrayList<String>> getValues,valuesPass,uservalues;
	List<ArrayList<Integer>> getIndex;
	Vector<Object> vactorName,vactorLname,vactorCompany,vactorPhone,vactorEmail,vactorWeb,vactorAddress,
	               vactorFacebook,vactorLinkedin,vactorDescription,vactorZip;
	ArrayList<String> stringName,stringLname,stringCompany,stringEmail,stringPhone,stringWeb,stringAddress,
					  stringFacebook,stringLinkedin,stringDescription,stringZip;
	Vector<Object> vactorcName,vactorcCompany,vactorcPhone,vactorcEmail,vactorcWeb,vactorcAddress,
    vactorcFacebook,vactorcDescription,vactorccity;
	ArrayList<String> stringcName,stringcCompany,stringcEmail,stringcPhone,stringcWeb,stringcAddress,
	  stringcFacebook,stringcDescription,stringccity;
	Vector<Object> vactordname,vactordvalue,vactortname;
	ArrayList<String> stringdname,stringdvalue,stringtname;	
	ArrayList<Integer> index_matched=new ArrayList<Integer>();
	ArrayList<Integer> finalIdInteger = new ArrayList<Integer>();
	ArrayList<Integer> status;
	String username,password,emailvalue;
	
	public void passValueToServer(int getPassLead,List<ArrayList<Integer>> index, List<ArrayList<String>> getValues,String serverIP,String database
			,String username,String password,Object login) throws Exception
	{
		System.out.println("after login");
		//int synchId;
					//here is all process for phase I
					String name,Lname,company,email,phone,street,description,web,linkedin,facebook,uniqueCode;
					valuesPass = new ArrayList<ArrayList<String>>();
					getIndex = new ArrayList<ArrayList<Integer>>();
					getIndex=index;
					System.out.println("values not passed");
					valuesPass=getValues;
					System.out.println("values" +valuesPass.get(0));
					//MyDatabaseClass mdc = new MyDatabaseClass(_context);
					//mdc.open();
					//valuesPass= new ArrayList<String>(getValues.size());
					
					//String values[] = new String[getValues.size()];
					
					//for(int i=0;i<getValues.size();i++)
						//values[i]=getValues.get(i);
					//for()
					int totalLead=getPassLead;
					//Curd curd = new Curd();
					//indexSynch=index;
					///synchId=indexSynch+1;
					//System.out.println("after login index" +indexSynch);
					//int i=1;
					for(int i=0;i<totalLead;i++)
					{
					if (i==1)
					{
						System.out.println("working....");
					}
					}
					System.out.println("total leads" +totalLead);
					for(int i=0;i<totalLead;i++)
						System.out.println("value hai jo..."+getIndex.get(i));
						
					int i;
					curd = new Curd();
					//String status= "synchronized";
					//SynchronizationHelper synHelper = new SynchronizationHelper();
					for(i=0;i<totalLead;i++)
					{
						//String values=getIndex.get(i);
					    if (getIndex.get(i).get(1)==1)
						 {
					    	//ArrayList<String> rList=valuesPass.get(i);
						System.out.println("i am in loop");
						name=valuesPass.get(i).get(0);
						System.out.println("name value..."+name);
						Lname=valuesPass.get(i).get(1);
						company=valuesPass.get(i).get(2);
						phone=valuesPass.get(i).get(3);
						email=valuesPass.get(i).get(4);
						web=valuesPass.get(i).get(5);
						street=valuesPass.get(i).get(6);
						facebook=valuesPass.get(i).get(7);
						linkedin=valuesPass.get(i).get(8);
						uniqueCode=valuesPass.get(i).get(9);
						description=valuesPass.get(i).get(10);
						System.out.println(("unique code value.." + uniqueCode));
						
						System.out.println("value is going to pass......");			
	  curd.create(name, Lname , company , phone, email, web, street, facebook, linkedin,uniqueCode,description,serverIP,database,
			  "admin",password,login);
		System.out.println("value passed......");

						}
						}

						}
		
	public void passValueToContact(int getPassContact,List<ArrayList<Integer>> index, List<ArrayList<String>> getValues,String serverIP,String database
			,String username,String password,Object login) throws Exception
	{
		//first company phone facebook address email website description generated code
		String name,company,phone,facebook,address,email,web,description,uniqueCode;
					valuesPass = new ArrayList<ArrayList<String>>();
					getIndex = new ArrayList<ArrayList<Integer>>();
					getIndex=index;
					System.out.println("values not passed");
					valuesPass=getValues;
					System.out.println("values" +valuesPass.get(0));
					int totalLead=getPassContact;
					System.out.println("total leads" +totalLead);
					for(int i=0;i<totalLead;i++)
						System.out.println("value hai jo..."+getIndex.get(i));
						
					int i;
					curd = new Curd();
					//String status= "synchronized";
					//SynchronizationHelper synHelper = new SynchronizationHelper();
					for(i=0;i<totalLead;i++)
					{
						//String values=getIndex.get(i);
					    if (getIndex.get(i).get(0)==1)
						 {
				//first company phone facebook address email website description generated code

					    System.out.println("i am in loop");
						name=valuesPass.get(i).get(0);
						//System.out.println("name value..."+name);
						company=valuesPass.get(i).get(1);
						phone=valuesPass.get(i).get(2);
						facebook=valuesPass.get(i).get(3);
						address=valuesPass.get(i).get(4);
						email=valuesPass.get(i).get(5);
						web=valuesPass.get(i).get(6);
						description=valuesPass.get(i).get(7);
						uniqueCode=valuesPass.get(i).get(8);
						//uniqueCode="null";//valuesPass.get(i).get(8);
						
						System.out.println("value is going to pass......");			
						curd.insertContact(name,company,phone,facebook,address,email,web,description,uniqueCode,serverIP,database,
								"admin",password,login);
		System.out.println("value passed......");

						}
						}
	}
	public void passValueToTask(int getPassTask,ArrayList<Integer> index, List<ArrayList<String>> getValues,String serverIP,String database
			,String username,String password,Object login) throws Exception
	{
				String taskDescription;
					valuesPass = new ArrayList<ArrayList<String>>();
					ArrayList<Integer> getIndex = new ArrayList<Integer>();
					getIndex=index;
					System.out.println("values not passed");
					valuesPass=getValues;
					//System.out.println("values" +valuesPass.get(0));
					int totalLead=getPassTask;
					System.out.println("total leads" +totalLead);
					for(int i=0;i<totalLead;i++)
						System.out.println("value hai jo..."+getIndex.get(i));
						
					int i;
					curd = new Curd();
					//String status= "synchronized";
					//SynchronizationHelper synHelper = new SynchronizationHelper();
					for(i=0;i<totalLead;i++)
					{
						//String values=getIndex.get(i);
					    if (getIndex.get(i)==1)
						 {
					    System.out.println("i am in loop");
					    taskDescription=valuesPass.get(i).get(0);
						
						System.out.println("value is going to pass......");			
	  curd.insertTask(taskDescription,serverIP,database,"admin",password,login);
		System.out.println("value passed......");

						}
						}
	}
	public List<ArrayList<String>> getValueFromServer(ArrayList<String> uniqueCodeLocal,String leadServerdate,String serverIP,String database
			,String username,String password) throws Exception {
		//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
Vector<Object> vactorDate=new Vector<Object>();
		vactor=new Vector<Object>();
		openerp = new OpenERP(serverIP,database,"admin",password);
		//OpenERPDomain domain = new OpenERPDomain();
    //	domain.add("id", 2);
		Object date =leadServerdate;
	   // formattedDate.
		System.out.println("date comparison "+date);

		Object[] result_ids;
		if(leadServerdate == null){
			result_ids = openerp.search("crm.lead");
		}
		
		else{
		result_ids = openerp.search("crm.lead","create_date",">",date);
		}
		OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","name","contact_name","partner_name","phone","email_from","city","street","street2","fax","description","zip"});
	    System.out.println("results...." + results);
		
		vactorName = new Vector<Object>();
		vactorLname = new Vector<Object>();
		vactorCompany = new Vector<Object>();
		vactorPhone = new Vector<Object>();
		vactorEmail = new Vector<Object>();
		vactorWeb = new Vector<Object>();
		vactorAddress = new Vector<Object>();
		vactorFacebook= new Vector<Object>();
		vactorLinkedin = new Vector<Object>();
		vactorDescription = new Vector<Object>();
		Vector<Object> vactorUniqueCode = new Vector<Object>();
			Vector<Object> vactorId= new Vector<Object>();
		vactorId=results.getFieldContents("id");
		vactorDate=results.getFieldContents("create_date");
		vactorName=results.getFieldContents("name");
		vactorLname=results.getFieldContents("contact_name");
		vactorCompany=results.getFieldContents("partner_name");
		vactorPhone=results.getFieldContents("phone");
		vactorEmail=results.getFieldContents("email_from");
		vactorWeb=results.getFieldContents("city");
		vactorAddress=results.getFieldContents("street");
		vactorFacebook=results.getFieldContents("street2");
		vactorLinkedin=results.getFieldContents("fax");
		vactorDescription=results.getFieldContents("zip");
		vactorUniqueCode=results.getFieldContents("description");
		System.out.println("description " +vactorUniqueCode);
			List<ArrayList<String>> vecTotal1 = new ArrayList<ArrayList<String>>();
		for(int i=0;i<vactorName.size();i++)
		{
			ArrayList<String> stringName = new ArrayList<String>();
			stringName.add(vactorName.get(i).toString());
			stringName.add(vactorLname.get(i).toString());
			stringName.add(vactorCompany.get(i).toString());
			stringName.add(vactorPhone.get(i).toString());
			stringName.add( vactorEmail.get(i).toString());
			stringName.add(vactorWeb.get(i).toString());
			stringName.add( vactorAddress.get(i).toString());
			stringName.add(vactorFacebook.get(i).toString());
			stringName.add(vactorLinkedin.get(i).toString());
			stringName.add(vactorDescription.get(i).toString());
			stringName.add(vactorUniqueCode.get(i).toString());
			stringName.add(vactorDate.get(i).toString());
			vecTotal1.add(stringName);
		}
		ArrayList<String> uniqueCodeToSend = new ArrayList<String>();
		ArrayList<Integer> idInteger = new ArrayList<Integer>();
		ArrayList<Integer> indexToInsert = new ArrayList<Integer>();
		
		for(int i=0;i<vecTotal1.size();i++)
		{
			String serverUniqueCode = vecTotal1.get(i).get(10);
			for(int j=0;i<uniqueCodeLocal.size();i++)
			{
				
				String localUniqueCode = uniqueCodeLocal.get(j);
				if(!serverUniqueCode.contains(localUniqueCode))
					indexToInsert.add(i);
			}
		}
			
 		List<ArrayList<String>> totalValues = new ArrayList<ArrayList<String>>();
		//ArrayList<String> values = new ArrayList<String>();
		for(int i=0;i<indexToInsert.size();i++)
		{
			ArrayList<String> valuesGlobal  = new ArrayList<String>();
			valuesGlobal=(vecTotal1.get(indexToInsert.get(i)));
			totalValues.add(valuesGlobal);
		}
		
		System.out.println("total values which will insert "+vecTotal1);
		
		
		
		for(int i=0;i<vecTotal1.size();i++)
		{
			if(vecTotal1.get(i).get(10).toString()== "false")
			{
				Calendar c = Calendar.getInstance();
			    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			    String formattedDate = df.format(c.getTime());
		        System.out.println("date "+formattedDate); 
			String uniqueCode = formattedDate;
        	uniqueCodeToSend.add(uniqueCode);
        	idInteger.add(i);
			}
		}
		for(int i=0;i<idInteger.size();i++)
		{
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("description",uniqueCodeToSend.get(i));
	    	
	openerp.write("crm.lead", Integer.parseInt(vactorId.get(idInteger.get(i)).toString()), params);
		}
		
		Object[] result_ids_se;
		if(leadServerdate == null){
			result_ids_se = openerp.search("crm.lead");
		}
		
		else{
		result_ids_se = openerp.search("crm.lead","create_date",">",date);
		}
		OpenERPRecordSet results_se = openerp.readRecords("crm.lead", result_ids_se, new String[] {"id","create_date","name","contact_name","partner_name","phone","email_from","city","street","street2","fax","description","zip"});
	    
		Vector<Object> vactorDescrip = new Vector<Object>();
		vactorDescrip=results_se.getFieldContents("description");
		List<ArrayList<String>> vecResults = new ArrayList<ArrayList<String>>();

		for(int i=0;i<vactorName.size();i++)
		{
			ArrayList<String> stringName = new ArrayList<String>();
			stringName.add(vactorName.get(i).toString());
			stringName.add(vactorLname.get(i).toString());
			stringName.add(vactorCompany.get(i).toString());
			stringName.add(vactorPhone.get(i).toString());
			stringName.add( vactorEmail.get(i).toString());
			stringName.add(vactorWeb.get(i).toString());
			stringName.add( vactorAddress.get(i).toString());
			stringName.add(vactorFacebook.get(i).toString());
			stringName.add(vactorLinkedin.get(i).toString());
			stringName.add(vactorDescrip.get(i).toString());
			stringName.add(vactorDate.get(i).toString());
			vecResults.add(stringName);
		}
		
			return vecResults;
	}
	
	
/*	
public void getValueFromServer()
{
	OpenERPRecordSet results = null;
	//Object results;
	curd = new Curd();
	try {
		results=curd.search_and_output("54.251.186.100", "traveloore", "admin", "1234");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("error exists..");
	}
	vactorName = new Vector<Object>();
	vactorLname = new Vector<Object>();
	vactorCompany = new Vector<Object>();
	vactorPhone = new Vector<Object>();
	vactorEmail = new Vector<Object>();
	vactorWeb = new Vector<Object>();
	vactorAddress = new Vector<Object>();
	vactorFacebook = new Vector<Object>();
	vactorLinkedin = new Vector<Object>();
	vactorDescription = new Vector<Object>();
	vactorName=results.getFieldContents("name");
	vactorName=results.getFieldContents("contact_name");
	vactorName=results.getFieldContents("partner_name");
	vactorName=results.getFieldContents("phone");
	vactorName=results.getFieldContents("email_from");
	vactorWeb=results.getFieldContents("city");
	vactorAddress=results.getFieldContents("street");
	vactorFacebook=results.getFieldContents("street2");
	vactorLinkedin=results.getFieldContents("fax");
	vactorDescription=results.getFieldContents("description");
	
	//"contact_name","partner_name","phone","email_from","city","street","street2","fax","description"
	//for(int i=0;i<vactorName.size();i++)
	//System.out.println("checking "+vactorName.get(i).toString());
	
}
*/
public List<ArrayList<String>> getValueFromServerLead(String host,String dbName , String userName, String password) throws Exception {
	//ArrayList<String> resultSet,getServerValues;
	//resultSet=new ArrayList<String>();
	//getServerValues = new ArrayList<String>();
	List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
//List<ArrayList<String>> totalDBLeads=new ArrayList<ArrayList<String>>();
//totalDBLeads=leadValues;
	vactor=new Vector<Object>();
	openerp = new OpenERP(host, dbName, userName, password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);

	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "name","contact_name","partner_name","phone","email_from","city","street","street2","fax","description","zip"});
	vactorName = new Vector<Object>();
	vactorLname = new Vector<Object>();
	vactorCompany = new Vector<Object>();
	vactorPhone = new Vector<Object>();
	vactorEmail = new Vector<Object>();
	vactorWeb = new Vector<Object>();
	vactorAddress = new Vector<Object>();
	vactorFacebook= new Vector<Object>();
	vactorLinkedin = new Vector<Object>();
	vactorDescription = new Vector<Object>();
	vactorZip=new Vector<Object>();
	stringName = new ArrayList<String>();
	stringLname = new ArrayList<String>();
	stringCompany = new ArrayList<String>();
	stringPhone = new ArrayList<String>();
	stringEmail = new ArrayList<String>();
	stringWeb = new ArrayList<String>();
	stringAddress = new ArrayList<String>();
	stringFacebook = new ArrayList<String>();
	stringLinkedin = new ArrayList<String>();
	stringDescription = new ArrayList<String>();
    stringZip=new ArrayList<String>();
	
    vactorName=results.getFieldContents("name");
	vactorLname=results.getFieldContents("contact_name");
	vactorCompany=results.getFieldContents("partner_name");
	vactorPhone=results.getFieldContents("phone");
	vactorEmail=results.getFieldContents("email_from");
	vactorWeb=results.getFieldContents("city");
	vactorAddress=results.getFieldContents("street");
	vactorFacebook=results.getFieldContents("street2");
	vactorLinkedin=results.getFieldContents("fax");
	vactorDescription=results.getFieldContents("description");
	vactorZip=results.getFieldContents("zip");
	//vecTotal.add(vactorName);
	for(int i=0;i<vactorName.size();i++)
	{
		stringName.add(vactorName.get(i).toString());
		stringLname.add(vactorLname.get(i).toString());
		stringCompany.add(vactorCompany.get(i).toString());
		stringPhone.add(vactorPhone.get(i).toString());
		stringEmail.add( vactorEmail.get(i).toString());
		stringWeb.add(vactorWeb.get(i).toString());
		stringAddress.add( vactorAddress.get(i).toString());
	    stringFacebook.add(vactorFacebook.get(i).toString());
		stringLinkedin.add(vactorLinkedin.get(i).toString());
		stringDescription.add(vactorDescription.get(i).toString());	
		stringZip.add(vactorZip.get(i).toString());
	}
	vecTotal.add(stringName);
	vecTotal.add(stringLname);
	vecTotal.add(stringCompany);
	vecTotal.add(stringPhone);
	vecTotal.add(stringEmail);
	vecTotal.add(stringWeb);
	vecTotal.add(stringAddress);
	vecTotal.add(stringFacebook);
	vecTotal.add(stringLinkedin);
	vecTotal.add(stringDescription);
	vecTotal.add(stringZip);

	
		
	
	
	//System.out.println("vectot name value "+vactorName);
	//System.out.println("string name value "+stringName);
	System.out.println("vector total..." + vecTotal);
	//System.out.println("2d lead values from db" + totalDBLeads);
	System.out.println("name 2d access" +vecTotal.get(0).get(0));
	System.out.println("name 2d access" +vecTotal.get(0).get(1));

return vecTotal;
}

public List<ArrayList<String>> getValueFromServerforcontact(List<ArrayList<String>> LocalUniqueCode,String serverIP,String database,String username,String password) throws Exception {
	List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	///Vector<Object> vactorDate=new Vector<Object>();
			vactor=new Vector<Object>();
			openerp = new OpenERP(serverIP,database,"admin",password);
			//OpenERPDomain domain = new OpenERPDomain();
	    //	domain.add("id", 2);
			//Object date =leadServerdate;
		   // formattedDate.
			///System.out.println("date comparison "+date);

			Object[] result_ids = openerp.search("res.partner");
			
			//System.out.println("results...." + result_ids);
			//OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","write_date","name","contact_name","partner_name","phone","email_from","city","street","street2"});
			OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] {"id","create_date", "name","phone","street2","street","email","website","city"});
		    System.out.println("results...." + results);
			
		    Vector<Object> vactorId  = new Vector<Object>();
		    Vector<Object> vactorName = new Vector<Object>();
		    Vector<Object> vactorPhone = new Vector<Object>();
		    Vector<Object> vactorFacebook = new Vector<Object>();
		    Vector<Object> vactorAddress = new Vector<Object>();
		    Vector<Object> vactorEmail = new Vector<Object>();
		    Vector<Object> vactorWeb = new Vector<Object>();
		    Vector<Object> vactorDate = new Vector<Object>();
		    Vector<Object> vactorCity = new Vector<Object>();
		    vactorDate = results.getFieldContents("create_date");
		    vactorName =results.getFieldContents("name");
		    vactorPhone =results.getFieldContents("phone");
		    vactorFacebook= results.getFieldContents("street2");
		    vactorAddress= results.getFieldContents("street");
		    vactorEmail = results.getFieldContents("email");
		    vactorWeb = results.getFieldContents("website");
		   // vactorDescription = results.getFieldContents("description");
		    vactorCity =results.getFieldContents("city");
		    
		    System.out.println("vactorID" + vactorId);
		    System.out.println("vactorName" + vactorName);
		    System.out.println("vactorPhone" + vactorPhone);
		    System.out.println("vactorfacebook" + vactorFacebook);
		    System.out.println("vactorAddress" + vactorAddress);
		    System.out.println("vactorEmail" + vactorEmail);
		    System.out.println("vactorWeb" + vactorWeb);
		  //  System.out.println("vactorDescription" + vactorDescription);
		    System.out.println("vactorCity" + vactorCity);
		    
		    
		    
		    List<ArrayList<String>> vecTotal1 = new ArrayList<ArrayList<String>>();
			for(int i=0;i<vactorName.size();i++)
			{
				ArrayList<String> stringName = new ArrayList<String>();
				stringName.add(vactorName.get(i).toString());
				stringName.add(vactorPhone.get(i).toString());
				stringName.add(vactorFacebook.get(i).toString());
				stringName.add(vactorAddress.get(i).toString());
				stringName.add(vactorEmail.get(i).toString());
				stringName.add(vactorWeb.get(i).toString());
			//	stringName.add(vactorDescription.get(i).toString());
				stringName.add(vactorCity.get(i).toString());
				stringName.add(vactorDate.get(i).toString());
				vecTotal1.add(stringName);
			}
			System.out.println("total values "+vecTotal1);
			System.out.println("unique code "+vecTotal1.get(0).get(6));
			ArrayList<String> uniqueCodeToSend = new ArrayList<String>();
			ArrayList<Integer> idInteger = new ArrayList<Integer>();
			
			ArrayList<Integer> indexToInsert = new ArrayList<Integer>();
			
			for(int i=0;i<vecTotal1.size();i++)
			{
				String serverUniqueCode = vecTotal1.get(i).get(10);
				for(int j=0;i<LocalUniqueCode.size();i++)
				{
					
					String localUniqueCode = LocalUniqueCode.get(j).get(1);
					if(!serverUniqueCode.contains(localUniqueCode))
						indexToInsert.add(i);
				}
			}
				
	 		List<ArrayList<String>> totalValues = new ArrayList<ArrayList<String>>();
			//ArrayList<String> values = new ArrayList<String>();
			for(int i=0;i<indexToInsert.size();i++)
			{
				ArrayList<String> valuesGlobal  = new ArrayList<String>();
				valuesGlobal=(vecTotal1.get(indexToInsert.get(i)));
				totalValues.add(valuesGlobal);
			}
			
			System.out.println("total values which will insert "+totalValues);
		
			
			
			Calendar c = Calendar.getInstance();
		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		    String formattedDate = df.format(c.getTime());

			for(int i=0;i<vecTotal1.size();i++)
			{
				if(vecTotal1.get(i).get(6).toString()== "false")
				{	
				String uniqueCode = vecTotal1.get(i).get(0) + " " + vecTotal1.get(i).get(1) + " " + vecTotal1.get(i).get(4) + " " + formattedDate;
	        	uniqueCodeToSend.add(uniqueCode);
	        	idInteger.add(i);
				}
			}
			//List<ArrayList<String>> finalValues = new ArrayList<ArrayList<String>>();
			System.out.println("id to update unique code"+idInteger);
			for(int i=0;i<idInteger.size();i++)
			{
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("city",uniqueCodeToSend.get(i));
		    	
		openerp.write("res.partner", Integer.parseInt(vactorId.get(idInteger.get(i)).toString()), params);
			}
			
			return vecTotal1;
	
}

public List<ArrayList<String>> getvaluefromserverfordeal(Object dealServerdate,String serverIP,String database
		,String username,String password) throws Exception {

	
	System.out.println("in deal function");
	//ArrayList<String> resultSet,getServerValues;
	//resultSet=new ArrayList<String>();
	List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	vactor=new Vector<Object>();
	openerp = new OpenERP(serverIP,database,username,password);
	System.out.println("before domain");
	//OpenERPDomain domain = new OpenERPDomain();
	Object[] result_ids;
	if(dealServerdate == null){
		result_ids = openerp.search("crm.lead");
	}
	
	
	else{
	result_ids = openerp.search("crm.lead","create_date",">",dealServerdate);
	}
	//System.out.println("results...." + result_ids);
	//OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","write_date","name","contact_name","partner_name","phone","email_from","city","street","street2"});
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "create_date","name","email_from"});
System.out.println("results...." + results);
	//domain.add("type","opportunity");
	//System.out.println("before domain 1");
  
	//Object[] result_ids = openerp.search("crm.lead",domain);
	//System.out.println("before domain 2");

	
	//System.out.println("after domain 2");
ArrayList<String> stringdate=new ArrayList<String>();
    System.out.println("values...."+results);
    Vector<Object> vactordate=new Vector<Object>();
	vactordname = new Vector<Object>();
	vactordvalue = new Vector<Object>();
	stringdname = new ArrayList<String>();
	stringdvalue = new ArrayList<String>();
	vactordname = results.getFieldContents("name");
	vactordvalue = results.getFieldContents("email_from");
	vactordate=results.getFieldContents("create_date");
	
	System.out.println("values in vactor "+vactordate);
	System.out.println("values of name in vactor "+vactordname);
	for(int i=0;i<vactordname.size();i++)
	{ 
		stringdname.add(vactordname.get(i).toString());
		stringdvalue.add(vactordvalue.get(i).toString());
		stringdate.add(vactordate.get(i).toString());
		
	}
	vecTotal.add(stringdname);
	vecTotal.add(stringdvalue);
	vecTotal.add(stringdate);
	//vecTotal.add(stringdvalue);
	System.out.println("vector total..." + vecTotal);
	
	//System.out.println("name 2d access" +vecTotal.get(0).get(0));
	//System.out.println("name 2d access" +vecTotal.get(0).get(1));


	  
	return vecTotal;
}

public ArrayList<String> getvaluefromserverfortask(String host,String dbName, String userName, String password) throws Exception {
	//ArrayList<String> resultSet,getServerValues;
	//resultSet=new ArrayList<String>();
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	vactor=new Vector<Object>();
	openerp = new OpenERP(host, dbName, userName, password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);

	Object[] result_ids = openerp.search("project.task");
	OpenERPRecordSet results = openerp.readRecords("project.task", result_ids, new String[] { "name"});
	
	vactortname = new Vector<Object>();

	stringtname = new ArrayList<String>();
	vactortname = results.getFieldContents("name");
	
	System.out.println("vector name..." + vactortname);
	for(int i=0;i<vactortname.size();i++)
	{
		stringtname.add(vactortname.get(i).toString());
		
		
	}
	
	//vecTotal.add(stringtname);

	System.out.println("vector total..." + stringtname);
	
	//System.out.println("name 2d access" +vecTotal.get(0).get(0));
	//System.out.println("name 2d access" +vecTotal.get(0).get(1));



	
	return stringtname;
}

/*public ArrayList<Integer> getValueFromServerToDelete(String host,String dbName , String userName, String password,List<ArrayList<String>> leadValuesFromLocalDB ) throws Exception
{   ArrayList<String> finalIds=new ArrayList<String>();
	ArrayList<String> localIds=new ArrayList<String>();
ArrayList<String> localCombination=new ArrayList<String>();
ArrayList<String> serverCombination=new ArrayList<String>();
List<ArrayList<String>> leadValuesFromDB=new ArrayList<ArrayList<String>>();
List<ArrayList<String>> vectotal=new ArrayList<ArrayList<String>>();

index_matched = new ArrayList<Integer>();
openerp = new OpenERP(host, dbName, userName, password);
OpenERPDomain domain = new OpenERPDomain();
//domain.add("id", 2);

Object[] result_ids = openerp.search("crm.lead");
OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "name","contact_name","partner_name"});


vactorName = new Vector<Object>();
vactorLname = new Vector<Object>();
vactorCompany = new Vector<Object>();
//vactorPhone = new Vector<Object>();
//vactorEmail = new Vector<Object>();
//vactorWeb = new Vector<Object>();
//vactorAddress = new Vector<Object>();
//vactorFacebook = new Vector<Object>();
//vactorLinkedin = new Vector<Object>();
//vactorDescription = new Vector<Object>();

stringName=new ArrayList<String>();
stringLname=new ArrayList<String>();
stringCompany=new ArrayList<String>();
vactorName=results.getFieldContents("name");
vactorLname=results.getFieldContents("contact_name");
vactorCompany=results.getFieldContents("partner_name");
//vactorName=results.getFieldContents("phone");
//vactorName=results.getFieldContents("email_from");
//vactorWeb=results.getFieldContents("city");
//vactorAddress=results.getFieldContents("street");
//vactorFacebook=results.getFieldContents("street2");
//vactorLinkedin=results.getFieldContents("fax");
//vactorDescription=results.getFieldContents("description");
for(int i=0;i<vactorName.size();i++)
{
stringName.add(vactorName.get(i).toString());
stringLname.add(vactorLname.get(i).toString());
stringCompany.add(vactorCompany.get(i).toString());
//"contact_name","partner_name","phone","email_from","city","street","street2","fax","description"
//for(int i=0;i<vactorName.size();i++)
//System.out.println("checking "+vactorName.get(i).toString());
}

vectotal.add(stringName);
vectotal.add(stringLname);
vectotal.add(stringCompany);

for(int i=0;i<vectotal.get(0).size();i++)
{
	serverCombination.add(vectotal.get(0).get(i) + " " + vectotal.get(1).get(i) + " " + vectotal.get(2).get(i));
	
}
System.out.println("server fields combination...." + serverCombination);

leadValuesFromDB=leadValuesFromLocalDB;
for(int i=0;i<leadValuesFromDB.size();i++)
{
	localIds.add(leadValuesFromDB.get(i).get(0));
}
System.out.println("local ids......" + localIds);
for(int i=0;i<leadValuesFromDB.size();i++)
{
	localCombination.add(leadValuesFromDB.get(i).get(1) + " " +leadValuesFromDB.get(i).get(2) + " " + 
leadValuesFromDB.get(i).get(3));
}
System.out.println("local fields combination..." + localCombination);
for(int i=0;i<localCombination.size();i++)
{
	System.out.println("loop 1");
	if(!serverCombination.contains(localCombination.get(i)))
	{
		System.out.println("loop 2");
		index_matched.add(i);
	}
	}

System.out.println("index not matched "+index_matched);
for(int i=0;i<index_matched.size();i++)
{
	finalIds.add(localIds.get(index_matched.get(i)));
}
for(int i=0;i<finalIds.size();i++)
{
	finalIdInteger.add(Integer.parseInt(finalIds.get(i)));
}
System.out.println("final ids "+finalIds);
return finalIdInteger;
}

*/

/*public ArrayList<Integer> getValueFromServerToDeleteContact(String host,String dbName , String userName, String password,List<ArrayList<String>> contactValuesFromLocalDB ) throws Exception
{   ArrayList<String> finalIds=new ArrayList<String>();
	ArrayList<String> localIds=new ArrayList<String>();
ArrayList<String> localCombination=new ArrayList<String>();
ArrayList<String> serverCombination=new ArrayList<String>();
List<ArrayList<String>> contactValuesFromDB=new ArrayList<ArrayList<String>>();
List<ArrayList<String>> vectotal=new ArrayList<ArrayList<String>>();
ArrayList<Integer> finalIdInteger = new ArrayList<Integer>();
index_matched = new ArrayList<Integer>();
openerp = new OpenERP(host, dbName, userName, password);
OpenERPDomain domain = new OpenERPDomain();
//domain.add("id", 2);

Object[] result_ids = openerp.search("res.partner");
OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] { "name","partner_id"});

vactorcName = new Vector<Object>();
vactorcCompany = new Vector<Object>();

stringcName = new ArrayList<String>();
stringcCompany = new ArrayList<String>();


vactorcName=results.getFieldContents("name");
vactorcCompany=results.getFieldContents("partner_id");

for(int i=0;i<vactorcName.size();i++)
{
	stringcName.add(vactorcName.get(i).toString());
	stringcCompany.add(vactorcCompany.get(i).toString());
	
}

vectotal.add(stringcName);
vectotal.add(stringcCompany);



for(int i=0;i<vectotal.get(0).size();i++)
{
	serverCombination.add(vectotal.get(0).get(i) + " " + vectotal.get(1).get(i));
	
}
System.out.println("server fields combination...." + serverCombination);

contactValuesFromDB=contactValuesFromLocalDB;
for(int i=0;i<contactValuesFromDB.size();i++)
{
	localIds.add(contactValuesFromDB.get(i).get(0));
}
System.out.println("local ids......" + localIds);
for(int i=0;i<contactValuesFromDB.size();i++)
{
	localCombination.add(contactValuesFromDB.get(i).get(1) + " " +contactValuesFromDB.get(i).get(2) + " " + 
contactValuesFromDB.get(i).get(3));
}
System.out.println("local fields combination..." + localCombination);
for(int i=0;i<localCombination.size();i++)
{
	System.out.println("loop 1");
	if(!serverCombination.contains(localCombination.get(i)))
	{
		System.out.println("loop 2");
		index_matched.add(i);
	}
	}

System.out.println("index not matched "+index_matched);
for(int i=0;i<index_matched.size();i++)
{
	finalIds.add(localIds.get(index_matched.get(i)));
}
for(int i=0;i<finalIds.size();i++)
{
	finalIdInteger.add(Integer.parseInt(finalIds.get(i)));
}
System.out.println("final ids "+finalIds);
return finalIdInteger;
}*/

public void passValueToDeal(int getPassDeal,List<ArrayList<Integer>> index, List<ArrayList<String>> getValues,String serverIP,String database
		,String username,String password,Object login) throws Exception
{
	String dealName,dealValue;
	valuesPass = new ArrayList<ArrayList<String>>();
	getIndex = new ArrayList<ArrayList<Integer>>();
	getIndex=index;
	System.out.println("values not passed");
	valuesPass=getValues;
	System.out.println("values" +valuesPass.get(0));
	int totalLead=getPassDeal;
	System.out.println("total leads" +totalLead);
	for(int i=0;i<totalLead;i++)
		System.out.println("value hai jo..."+getIndex.get(i));
		
	int i;
	curd = new Curd();
	//String status= "synchronized";
	//SynchronizationHelper synHelper = new SynchronizationHelper();
	for(i=0;i<totalLead;i++)
	{
		//String values=getIndex.get(i);
	    if (getIndex.get(i).get(0)==1)
		 {
	    System.out.println("i am in loop");
		dealName=valuesPass.get(i).get(0);
		dealValue=valuesPass.get(i).get(1);
		//System.out.println("name value..."+name);
		
		System.out.println("value is going to pass......");			
curd.insertDeal(dealName,dealValue,serverIP,database,"admin",password,login);
System.out.println("value passed......");

		}
		}

	
}
public void modifyContact(List<ArrayList<String>> listToDelete,String serverIP,String database
		,String username,String passWord) throws Exception
{
	OpenERP openerp;
	System.out.println("in modification method");
	
	List<ArrayList<String>> listLocalData = new ArrayList<ArrayList<String>>();
	listLocalData=listToDelete;
	System.out.println("values get "+listLocalData);
    ArrayList<String> integerId = new ArrayList<String>();
    ArrayList<Integer> finalId=new ArrayList<Integer>();
    ArrayList<Object> vactor=new ArrayList<Object>();
    Vector<Object> vactorId = new Vector<Object>();
	openerp = new OpenERP(serverIP, database, username,password);
	
	for(int i=0;i<listLocalData.size();i++)
	{
	Object	value =listLocalData.get(i).get(8);
	Object[] result_ids = openerp.search("res.partner","city","=",value);
	OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] {"id"});
	
	vactorId=results.getFieldContents("id");
	//vactor.add(vactorId);
	System.out.println("vactor values  "+vactorId);
	}
	for(int i=0;i<vactorId.size();i++)
	{
	integerId.add(vactorId.get(i).toString());
	System.out.println("id to update "+integerId);
	}
	
	for(int i=0;i<integerId.size();i++)
	{
		finalId.add(Integer.parseInt(integerId.get(i)));
	}
		System.out.println("idssss..."+finalId);
	for(int i=0;i<finalId.size();i++)
	{
		HashMap<String, Object> params = new HashMap<String, Object>();

		params.put("name",listLocalData.get(i).get(0) );
		params.put("email",listLocalData.get(i).get(1));
		params.put("phone",listLocalData.get(i).get(2));
		params.put("street",listLocalData.get(i).get(3));
	    //System.out.println("hello hello......");
	    params.put("website",listLocalData.get(i).get(4));
	    params.put("partner_id",listLocalData.get(i).get(5));
	   // params.put("title",title.getText().toString());
	  //  params.put("comment", getDescription);
	    params.put("street2",listLocalData.get(i).get(6));
	    params.put("city", listLocalData.get(i).get(8));//params.put("partner_address_email","abc@gmail.com");

		
	    openerp.write("res.partner", finalId.get(i), params);
	}

}


public void modifyLead(List<ArrayList<String>> listToDelete,String serverIP,String database
		,String user,String pass) throws Exception
{
	OpenERP openerp;
	System.out.println("in modification method............");
	ArrayList<Integer> finalId = new ArrayList<Integer>();
	List<ArrayList<String>> listLocalData = new ArrayList<ArrayList<String>>();
	listLocalData=listToDelete;
	System.out.println("values get "+listLocalData);
	ArrayList<String> integerId = new ArrayList<String>();
	ArrayList<Object> vactor=new ArrayList<Object>();
	openerp = new OpenERP(serverIP, database, user, pass);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);
	System.out.println("total size to update "+listLocalData.size());
	Vector<Object> vactorId = new Vector<Object>();
	
	Object []result_ids;
	OpenERPRecordSet results;
	for(int i=0;i<listLocalData.size();i++)
	{
		Object value =listLocalData.get(i).get(10);
	
		System.out.println("unique code to update "+value);
	result_ids = openerp.search("crm.lead","description","=",value);
	System.out.println("result ids.." + result_ids);
	results = openerp.readRecords("crm.lead", result_ids, new String[] {"id"});
	System.out.println("values.... "+results);
	vactorId = results.getFieldContents("id");
//	vactor.add(vactorId);
	System.out.println("vactor values  "+vactor);
	}
	for(int i=0;i<vactorId.size();i++)
	{
	integerId.add(vactorId.get(i).toString());
	System.out.println("id to update "+integerId);
	}
	
	for(int i=0;i<integerId.size();i++)
	{
		finalId.add(Integer.parseInt(integerId.get(i)));
	}
		System.out.println("idssss..."+finalId);
	for(int i=0;i<finalId.size();i++)
	{
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name",listLocalData.get(i).get(0));
		params.put("contact_name",listLocalData.get(i).get(1));
		params.put("partner_name",listLocalData.get(i).get(2));
		params.put("phone",listLocalData.get(i).get(3));   //street email_from
		//System.out.println("hello hello......");
	    params.put("email_from",listLocalData.get(i).get(4));
		params.put("city", listLocalData.get(i).get(5));
		//params.put("name", "ShameerHabeeb3");
	    params.put("street",listLocalData.get(i).get(6));
	    params.put("street2",listLocalData.get(i).get(7));
	    params.put("fax",listLocalData.get(i).get(8));
	    params.put("zip",listLocalData.get(i).get(9));
	    params.put("description",listLocalData.get(i).get(10));
	    	
	openerp.write("crm.lead", finalId.get(i), params);
	}

}


public void modifyDeal(String host, String dbName, String userName, String password,List<ArrayList<String>> listToDelete,String serverIP,String database
		,String user,String pass) throws Exception
{
	OpenERP openerp;
	System.out.println("in modification method");
	
	ArrayList<String> idCollection = new ArrayList<String>();
	ArrayList<String> uniqueCodeCollection = new ArrayList<String>();
	List<ArrayList<String>> listLocalData = new ArrayList<ArrayList<String>>();
	ArrayList<Integer> indexToDelete = new ArrayList<Integer>();
	ArrayList<Integer> idToDelete = new ArrayList<Integer>();
	listLocalData=listToDelete;
	System.out.println("values get "+listLocalData);
	Vector<Object> vactorId = new Vector<Object>();
	Vector<Object> vactorUniqueCode = new Vector<Object>();
	openerp = new OpenERP(host, dbName, userName, password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);
	
	
	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","description"});
	vactorId=results.getFieldContents("id");
	vactorUniqueCode=results.getFieldContents("description");
	System.out.println("ids "+vactorId);
	System.out.println("unique code "+vactorUniqueCode);
	
	for(int i=0;i<vactorId.size();i++)
	{
	idCollection.add(vactorId.get(i).toString());
	uniqueCodeCollection.add(vactorUniqueCode.get(i).toString());
    }
	
	System.out.println("ids string "+idCollection);
	System.out.println("unique code string "+uniqueCodeCollection);
	
	System.out.println("arraylist Columns "+listLocalData.get(0).size());
	System.out.println("arraylist name "+listLocalData.get(0).get(0));
	System.out.println("arraylist second "+listLocalData.get(0).get(1));
	System.out.println("arraylist third "+listLocalData.get(0).get(2));
	System.out.println("arraylist four "+listLocalData.get(0).get(3));
	System.out.println("arraylist five "+listLocalData.get(0).get(4));
	System.out.println("arraylist six "+listLocalData.get(0).get(5));
	System.out.println("arraylist seven "+listLocalData.get(0).get(6));
	System.out.println("arraylist eight "+listLocalData.get(0).get(7));
	System.out.println("arraylist nine "+listLocalData.get(0).get(8));
	System.out.println("arraylist tenth "+listLocalData.get(0).get(9));
	System.out.println("arraylist eleventh "+listLocalData.get(0).get(10));

	for(int i=0;i<listLocalData.size();i++)
	{
		if(uniqueCodeCollection.contains(listLocalData.get(i).get(10)))
          indexToDelete.add(uniqueCodeCollection.indexOf((listLocalData.get(i).get(10))));
	}
	
	System.out.println("index to delete "+indexToDelete);
	
	for(int i=0;i<indexToDelete.size();i++)
	  idToDelete.add(Integer.parseInt(idCollection.get(indexToDelete.get(i))));
  
	System.out.println("id to delete "+idToDelete);
	
	for(int i=0;i<idToDelete.size();i++)
	{
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("name",listLocalData.get(i).get(0));
		params.put("contact_name",listLocalData.get(i).get(1));
		params.put("partner_name",listLocalData.get(i).get(2));
		params.put("phone",listLocalData.get(i).get(3));   //street email_from
		//System.out.println("hello hello......");
	    params.put("email_from",listLocalData.get(i).get(4));
		params.put("city", listLocalData.get(i).get(5));
		//params.put("name", "ShameerHabeeb3");
	    params.put("street",listLocalData.get(i).get(6));
	    params.put("street2",listLocalData.get(i).get(7));
	    params.put("fax",listLocalData.get(i).get(8));
	    params.put("description",listLocalData.get(i).get(9));
	    params.put("zip",listLocalData.get(i).get(10));
	    	
	openerp.write("crm.lead", idToDelete.get(i), params);
	}

}


public void deleteLeadFromServer(ArrayList<String> u_code,String serverIP,String database
		,String username,String password) throws Exception
{
	
	openerp = new OpenERP(serverIP,database,"admin",password);
	ArrayList<String> integerId = new ArrayList<String>();
	Vector<Object> vactorId = new Vector<Object>();
	ArrayList<Integer> finalId=new ArrayList<Integer>();
	Object[] result_ids = null;
	for(int i=0;i<u_code.size();i++)
	{
	Object value=u_code.get(i);
	result_ids = openerp.search("crm.lead","description","=",value);
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "id"});
	vactorId =results.getFieldContents("id");
	System.out.println("values.."+vactorId);
	}
	for(int i=0;i<vactorId.size();i++)
	{
		integerId.add(vactorId.get(i).toString());
	}
	
    //integerId.add(Integer.parseInt(vactorId.toString())); 
   // stringUniqueCode.add(results.getFieldContents("description").toString());
	for(int i=0;i<integerId.size();i++)
	{
		finalId.add(Integer.parseInt(integerId.get(i)));
	}
	

		
		for(int i=0;i<finalId.size();i++)
		openerp.delete("crm.lead",finalId.get(i));

}

public void deleteContactFromServer(ArrayList<String> unique_code_contact,String serverIP,String database
		,String username,String password) throws Exception
{
			openerp = new OpenERP(serverIP,database,"admin",password);
			ArrayList<String> integerId = new ArrayList<String>();
			ArrayList<Integer> finalId=new ArrayList<Integer>();
			Vector<Object> vactorId = new Vector<Object>();
			Object[] result_ids = null;
			for(int i=0;i<unique_code_contact.size();i++)
			{
			Object value=unique_code_contact.get(i);
			result_ids = openerp.search("res.partner","city","=",value);
			OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] { "id"});
		    vactorId=results.getFieldContents("id");
		    System.out.println("values..."+vactorId);
			}
		    for(int i=0;i<vactorId.size();i++)
		    {
			integerId.add(vactorId.get(i).toString()); 
		   // stringUniqueCode.add(results.getFieldContents("description").toString());
			}

			for(int i=0;i<finalId.size();i++)
			{
				
			
				openerp.delete("res.partner",finalId.get(i));
			
}

}


public List<ArrayList<String>> serverLeadModificationValues(List<ArrayList<String>> valuesToUpdate,String serverIP,String database
		,String username,String password)throws Exception
{
	curd=new Curd();
	vactor=new Vector<Object>();
	openerp = new OpenERP(serverIP,database,"admin",password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);
	List<ArrayList<String>> valuesToupdate = new ArrayList<ArrayList<String>>();
	valuesToupdate=valuesToUpdate;
	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","write_date"});
	
	Vector<Object> vactorModifiedDate=new Vector<Object>();
	Vector<Object> vactorCreationDate=new  Vector<Object>();
	Vector<Object> vactorId=new  Vector<Object>();
	
	
	///Vector<Object> vactorName = new Vector<Object>();
	//Vector<Object> vactorLname = new Vector<Object>();
	//Vector<Object> vactorCompany = new Vector<Object>();
	//Vector<Object> vactorPhone = new Vector<Object>();
	//Vector<Object> vactorEmail = new Vector<Object>();
	//Vector<Object> vactorFacebook = new Vector<Object>();
	//Vector<Object> vactorLinkedin = new Vector<Object>();
	//Vector<Object> vactorWeb = new Vector<Object>();
	//Vector<Object> vactorDescription = new Vector<Object>();
	//Vector<Object> vactorAddress = new Vector<Object>();
	//Vector<Object> vactorUniqueCode = new Vector<Object>();
	//ArrayList<String> stringName = new ArrayList<String>();
	//ArrayList<String> stringLname = new ArrayList<String>();
	//ArrayList<String> stringCompany = new ArrayList<String>();
	//ArrayList<String> stringPhone = new ArrayList<String>();
	//ArrayList<String> stringEmail = new ArrayList<String>();
	//ArrayList<String> stringWeb = new ArrayList<String>();
	///<String> stringAddress = new ArrayList<String>();
	//ArrayList<String> stringFacebook = new ArrayList<String>();
	//ArrayList<String> stringLinkedin = new ArrayList<String>();
	//ArrayList<String> stringDescription = new ArrayList<String>();
    //ArrayList<String> collection = new ArrayList<String>();

	ArrayList<String> creationDateString = new ArrayList<String>();
	ArrayList<String> modifiedDateString = new ArrayList<String>();
	ArrayList<String> idString = new ArrayList<String>();
	
	
	
	//ArrayList<String> valuesToModified = new ArrayList<String>();
	
	
	vactorCreationDate=results.getFieldContents("create_date");
	vactorModifiedDate=results.getFieldContents("write_date");
	vactorId=results.getFieldContents("id");
	
	//vactorName=results.getFieldContents("name");
	//vactorLname=results.getFieldContents("contact_name");
	//vactorCompany=results.getFieldContents("partner_name");
	//vactorPhone=results.getFieldContents("phone");
	//vactorEmail=results.getFieldContents("email_from");
	//vactorWeb=results.getFieldContents("city");
	//vactorAddress=results.getFieldContents("street");
	//vactorFacebook=results.getFieldContents("street2");
	//vactorDescription=results.getFieldContents("zip");
	//vactorLinkedin=results.getFieldContents("fax");
	//vactorUniqueCode=results.getFieldContents("description");
	///vactorDescription=results.getFieldContents("street2");
	System.out.println("real date "+vactorCreationDate);
	System.out.println("modified dates "+vactorModifiedDate);
	//System.out.println("id collection "+vactorId);
	//System.out.println("name  "+vactorName);
	//System.out.println("lastname "+vactorLname);
	//System.out.println("company "+vactorCompany);
	///System.out.println("phone "+vactorPhone);
	//System.out.println("email "+vactorEmail);
	///System.out.println("web "+vactorWeb);
	//System.out.println("address "+vactorAddress);
	///System.out.println("description "+vactorDescription);
	//stringName = new ArrayList<String>();
	for(int i=0;i<vactorCreationDate.size();i++)
	{
		creationDateString.add(vactorCreationDate.get(i).toString());
		modifiedDateString.add(vactorModifiedDate.get(i).toString());
		//stringLname.add(vactorName.get(i).toString());
		//stringLname.add(vactorCompany.get(i).toString());
		//stringCompany.add(vactorCompany.get(i).toString());
		//stringPhone.add(vactorPhone.get(i).toString());
		//stringEmail.add(vactorEmail.get(i).toString());
		//stringWeb.add(vactorWeb.get(i).toString());
		//stringAddress.add(vactorAddress.get(i).toString());
		//stringDescription.add(vactorDescription.get(i).toString());
		//idString.add(vactorId.get(i).toString());
	}
	System.out.println("creation date in string "+creationDateString);
	System.out.println("modified date in string "+modifiedDateString);
	
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 ArrayList<Date> creation = new ArrayList<Date>();
	 ArrayList<Date> modified = new ArrayList<Date>();

	 for(int i=0;i<creationDateString.size();i++)
	 {
		 String mytime=creationDateString.get(i);
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date myDate = dateFormat.parse(mytime);
			creation.add(myDate);
		
			String mytime1=creationDateString.get(i);
	        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date myDate1 = dateFormat.parse(mytime1);
		
			
			modified.add(myDate1);
	 }
	 
	/// Date check = df.parse(creationDateString.get(0));
	// Date checkModified=df.parse(modifiedDateString.get(0));
	// Date check2 =df.parse(creationDateString.get(1));
	/// Date checkModified2 = df.parse(modifiedDateString.get(1));
	 ArrayList<Integer> indexToModified = new ArrayList<Integer>();
	 for(int i=0;i<creation.size();i++)
	 {
		if(!creation.get(i).equals(modified.get(i)))
		{
			System.out.println("index to modify "+i);
			indexToModified.add(i);
		}
	 }
	 
  
 
System.out.println("index to modified "+indexToModified);
ArrayList<Object> idsObject = new ArrayList<Object>();
for(int i=0;i<indexToModified.size();i++)
{
idsObject.add(vactorId.get(indexToModified.get(i)));
	
    //collection.add(vactorName.get(indexToModified.get(i)).toString());
   // collection.add(vactorLname.get(indexToModified.get(i)).toString());	
   // collection.add(vactorCompany.get(indexToModified.get(i)).toString());	
   // collection.add(vactorPhone.get(indexToModified.get(i)).toString());	
   // collection.add(vactorEmail.get(indexToModified.get(i)).toString());	
   // collection.add(vactorWeb.get(indexToModified.get(i)).toString());
   // collection.add(vactorFacebook.get(indexToModified.get(i)).toString());
    //collection.add(vactorLinkedin.get(indexToModified.get(i)).toString());
   // collection.add(vactorAddress.get(indexToModified.get(i)).toString());	
   // collection.add(vactorDescription.get(indexToModified.get(i)).toString());
   // collection.add(vactorUniqueCode.get(indexToModified.get(i)).toString());
  //  totalValesToModified.add(collection);
    //System.out.println("name "+collection.get(0));
    //System.out.println("name "+collection.get(1));
   // System.out.println("name "+collection.get(2));
   // System.out.println("name "+collection.get(3));
   // System.out.println("name "+collection.get(4));
   // System.out.println("name "+collection.get(5));
  //  System.out.println("name "+collection.get(6));
  //  System.out.println("name "+collection.get(7));
  //  System.out.println("combination "+totalValesToModified);


}
System.out.println("ids Object "+idsObject);
    Vector<Object> vactorName = new Vector<Object>();
	Vector<Object> vactorLname = new Vector<Object>();
	Vector<Object> vactorCompany = new Vector<Object>();
	Vector<Object> vactorPhone = new Vector<Object>();
	Vector<Object> vactorEmail = new Vector<Object>();
	Vector<Object> vactorFacebook = new Vector<Object>();
	Vector<Object> vactorLinkedin = new Vector<Object>();
	Vector<Object> vactorWeb = new Vector<Object>();
	Vector<Object> vactorDescription = new Vector<Object>();
	Vector<Object> vactorAddress = new Vector<Object>();
	Vector<Object> vactorUniqueCode = new Vector<Object>();
	
	List<ArrayList<String>> totalValesToModified = new ArrayList<ArrayList<String>>();

   Object[] result_idss;
for(int i=0;i<idsObject.size();i++)
{
result_idss = openerp.search("crm.lead","id","=",idsObject.get(i));

OpenERPRecordSet results1 = openerp.readRecords("crm.lead", result_idss, new String[] {	"name","contact_name","partner_name","phone","email_from","city","street","street2","fax","description","zip"});

    vactorName=results1.getFieldContents("name");
	vactorLname=results1.getFieldContents("contact_name");
	vactorCompany=results1.getFieldContents("partner_name");
	vactorPhone=results1.getFieldContents("phone");
	vactorEmail=results1.getFieldContents("email_from");
	vactorWeb=results1.getFieldContents("city");
	vactorAddress=results1.getFieldContents("street");
	vactorFacebook=results1.getFieldContents("street2");
	vactorZip=results1.getFieldContents("zip");
	vactorLinkedin=results1.getFieldContents("fax");
    vactorUniqueCode=results1.getFieldContents("description");
	
	ArrayList<String> stringName = new ArrayList<String>();
	stringName.add(vactorName.toString());
	stringName.add(vactorLname.toString());
	stringName.add(vactorCompany.toString());
	stringName.add(vactorPhone.toString());
	stringName.add(vactorEmail.toString());
	stringName.add(vactorWeb.toString());
	stringName.add(vactorAddress.toString());
	stringName.add(vactorFacebook.toString());
	stringName.add(vactorDescription.toString());
	stringName.add(vactorLinkedin.toString());
	stringName.add(vactorUniqueCode.toString());
	System.out.println("name in string "+stringName);
	totalValesToModified.add(stringName);    
}
//ArrayList<String> idString = new ArrayList<String>();
ArrayList<Integer> indexOfServerValueToUpdate = new ArrayList<Integer>();
for(int i=0;i<totalValesToModified.size();i++)
{
String checkServer=totalValesToModified.get(i).get(10);
System.out.println("server combination "+checkServer);
for(int j=0;j<valuesToupdate.size();j++)
{
String checkLocal=valuesToupdate.get(j).get(1);
System.out.println("local combination "+checkLocal);
if(checkServer.contains(checkLocal))
    {
	idString.add(valuesToupdate.get(j).get(0));
	indexOfServerValueToUpdate.add(i);
	break;
    }
}
}
List<ArrayList<String>> finalValuesToModify = new ArrayList<ArrayList<String>>();
for(int i=0;i<indexOfServerValueToUpdate.size();i++)
{
	ArrayList<String> finalv = new ArrayList<String>();
    finalv= totalValesToModified.get(indexOfServerValueToUpdate.get(i));
    finalValuesToModify.add(finalv);
}
System.out.println("total size to modify "+finalValuesToModify.size());
System.out.println("total entries to modify "+finalValuesToModify.get(0).size());

System.out.println("id to modify "+idString);
finalValuesToModify.add(idString);
//System.out.println("id to update "+totalValesToModified.get(totalValesToModified.size()-1).get(0));
//System.out.println("values to modified "+totalValesToModified.get(0).get(0));
return finalValuesToModify;
}
public List<ArrayList<String>> serverContactModificationValues(ArrayList<String> valuesToUpdate,String serverIP,String database
		,String username,String password)throws Exception
{
	curd=new Curd();
	vactor=new Vector<Object>();
	openerp = new OpenERP(serverIP,database,username,password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);
	ArrayList<String> valuesToupdate = new ArrayList<String>();
	valuesToupdate=valuesToUpdate;
	Object[] result_ids = openerp.search("res.partner");
	OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] {"id","create_date","write_date","name","partner_id","phone","street2","street","email","website","description"});
	
	
	Vector<Object> vactorModifiedDate=new Vector<Object>();
	Vector<Object> vactorCreationDate=new  Vector<Object>();
	Vector<Object> vactorId=new  Vector<Object>();
	Vector<Object> vactorName = new Vector<Object>();
	Vector<Object> vactorCompany = new Vector<Object>();
	Vector<Object> vactorPhone = new Vector<Object>();
	Vector<Object> vactorFacebook = new Vector<Object>();
	Vector<Object> vactorAddress = new Vector<Object>();
    Vector<Object> vactorEmail = new Vector<Object>();
	Vector<Object> vactorWeb = new Vector<Object>();
	Vector<Object> vactorUniqueCode = new Vector<Object>();
	//ArrayList<String> stringName = new ArrayList<String>();
	//ArrayList<String> stringLname = new ArrayList<String>();
	//ArrayList<String> stringCompany = new ArrayList<String>();
	//ArrayList<String> stringPhone = new ArrayList<String>();
	//ArrayList<String> stringEmail = new ArrayList<String>();
	//ArrayList<String> stringWeb = new ArrayList<String>();
	///<String> stringAddress = new ArrayList<String>();
	//ArrayList<String> stringFacebook = new ArrayList<String>();
	//ArrayList<String> stringLinkedin = new ArrayList<String>();
	//ArrayList<String> stringDescription = new ArrayList<String>();
    List<ArrayList<String>> totalValesToModified = new ArrayList<ArrayList<String>>();
    ArrayList<String> collection = new ArrayList<String>();

	ArrayList<String> creationDateString = new ArrayList<String>();
	ArrayList<String> modifiedDateString = new ArrayList<String>();
	ArrayList<String> idString = new ArrayList<String>();
	
	
	ArrayList<Date> creation = new ArrayList<Date>();
	ArrayList<Date> modified = new ArrayList<Date>();

	//ArrayList<String> valuesToModified = new ArrayList<String>();
	ArrayList<Integer> indexToModified = new ArrayList<Integer>();

	vactorCreationDate=results.getFieldContents("create_date");
	vactorModifiedDate=results.getFieldContents("write_date");
	vactorId=results.getFieldContents("id");
	vactorName=results.getFieldContents("name");
	vactorCompany=results.getFieldContents("partner_id");
	vactorPhone=results.getFieldContents("phone");
	vactorFacebook=results.getFieldContents("street2");
	vactorAddress=results.getFieldContents("street");
	vactorEmail=results.getFieldContents("email");
	vactorWeb=results.getFieldContents("website");
	vactorUniqueCode=results.getFieldContents("city");
	///vactorDescription=results.getFieldContents("street2");
	System.out.println("real date "+vactorCreationDate);
	System.out.println("modified dates "+vactorModifiedDate);
	System.out.println("id collection "+vactorId);
	System.out.println("name  "+vactorName);
	System.out.println("company "+vactorCompany);
	System.out.println("phone "+vactorPhone);
	System.out.println("email "+vactorEmail);
	System.out.println("web "+vactorWeb);
	System.out.println("address "+vactorAddress);
	System.out.println("description "+vactorUniqueCode);
	//stringName = new ArrayList<String>();
	for(int i=0;i<vactorCreationDate.size();i++)
	{
		creationDateString.add(vactorCreationDate.get(i).toString());
		modifiedDateString.add(vactorModifiedDate.get(i).toString());
		//stringLname.add(vactorName.get(i).toString());
		//stringLname.add(vactorCompany.get(i).toString());
		//stringCompany.add(vactorCompany.get(i).toString());
		//stringPhone.add(vactorPhone.get(i).toString());
		//stringEmail.add(vactorEmail.get(i).toString());
		//stringWeb.add(vactorWeb.get(i).toString());
		//stringAddress.add(vactorAddress.get(i).toString());
		//stringDescription.add(vactorDescription.get(i).toString());
		//idString.add(vactorId.get(i).toString());
	}
	System.out.println("creation date in string "+creationDateString);
	System.out.println("modified date in string "+modifiedDateString);
	
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	 for(int i=0;i<creationDateString.size();i++)
	 {
		creation.add(df.parse(creationDateString.get(i)));
		modified.add(df.parse(modifiedDateString.get(i)));
	 }
	 
	/// Date check = df.parse(creationDateString.get(0));
	// Date checkModified=df.parse(modifiedDateString.get(0));
	// Date check2 =df.parse(creationDateString.get(1));
	/// Date checkModified2 = df.parse(modifiedDateString.get(1));
	 for(int i=0;i<creation.size();i++)
	 {
		if(!creation.get(i).equals(modified.get(i)))
		{
			System.out.println("index to modify "+i);
			indexToModified.add(i);
		}
	 }
	 
  
 
System.out.println("index to modified "+indexToModified);

for(int i=0;i<indexToModified.size();i++)
{

    collection.add(vactorName.get(indexToModified.get(i)).toString());
    collection.add(vactorLname.get(indexToModified.get(i)).toString());	
    collection.add(vactorCompany.get(indexToModified.get(i)).toString());	
    collection.add(vactorPhone.get(indexToModified.get(i)).toString());	
    collection.add(vactorEmail.get(indexToModified.get(i)).toString());	
    collection.add(vactorWeb.get(indexToModified.get(i)).toString());
    collection.add(vactorFacebook.get(indexToModified.get(i)).toString());
    collection.add(vactorLinkedin.get(indexToModified.get(i)).toString());
    collection.add(vactorAddress.get(indexToModified.get(i)).toString());	
    collection.add(vactorDescription.get(indexToModified.get(i)).toString());
    collection.add(vactorUniqueCode.get(indexToModified.get(i)).toString());
    totalValesToModified.add(collection);
    System.out.println("name "+collection.get(0));
    System.out.println("name "+collection.get(1));
    System.out.println("name "+collection.get(2));
    System.out.println("name "+collection.get(3));
    System.out.println("name "+collection.get(4));
    System.out.println("name "+collection.get(5));
    System.out.println("name "+collection.get(6));
    System.out.println("name "+collection.get(7));
    System.out.println("combination "+totalValesToModified);


}
for(int i=0;i<totalValesToModified.size();i++)
{
String checkServer=totalValesToModified.get(i).get(10);
System.out.println("server combination "+checkServer);
for(int j=0;j<valuesToupdate.size();j++)
{
String checkLocal=valuesToupdate.get(j);
System.out.println("local combination "+checkLocal);
if(checkServer.contains(checkLocal))
    {
	idString.add(valuesToupdate.get(j));
	break;
    }
}
}
System.out.println("id to modify "+idString);
totalValesToModified.add(idString);
System.out.println("id to update "+totalValesToModified.get(indexToModified.size()).get(0));
//System.out.println("values to modified "+totalValesToModified.get(0).get(0));
return totalValesToModified;
}


public ArrayList<Integer> getValueFromServerToDelete(List<ArrayList<String>> leadValuesFromLocalDB ,String serverIP,String database
		,String username,String password) throws Exception
{   ArrayList<String> finalIds=new ArrayList<String>();
 	ArrayList<String> localIds=new ArrayList<String>();
	ArrayList<String> localCombination=new ArrayList<String>();
	//ArrayList<String> serverCombination=new ArrayList<String>();
	//List<ArrayList<String>> leadValuesFromDB=new ArrayList<ArrayList<String>>();
	List<ArrayList<String>> vectotal=new ArrayList<ArrayList<String>>();
	
	for(int i=0;i<leadValuesFromLocalDB.size();i++)
	{
		System.out.println("lead unique caose "+leadValuesFromLocalDB.get(i));
	}
	
	index_matched = new ArrayList<Integer>();
	openerp = new OpenERP(serverIP,database,"admin",password);
	OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);

	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "description"});


	vactorName = new Vector<Object>();
	//vactorLname = new Vector<Object>();
	//vactorCompany = new Vector<Object>();
	//vactorPhone = new Vector<Object>();
	//vactorEmail = new Vector<Object>();
	//vactorWeb = new Vector<Object>();
	//vactorAddress = new Vector<Object>();
	//vactorFacebook = new Vector<Object>();
	//vactorLinkedin = new Vector<Object>();
	//vactorDescription = new Vector<Object>();
	
	stringName=new ArrayList<String>();
	//stringLname=new ArrayList<String>();
	//stringCompany=new ArrayList<String>();
	vactorName=results.getFieldContents("description");
	System.out.println("unique code from server.." + vactorName.get(0));
	System.out.println("unique code from local db..." + leadValuesFromLocalDB.get(0).get(1));
	//vactorLname=results.getFieldContents("contact_name");
	//vactorCompany=results.getFieldContents("partner_name");
	//vactorName=results.getFieldContents("phone");
	//vactorName=results.getFieldContents("email_from");
	//vactorWeb=results.getFieldContents("city");
	//vactorAddress=results.getFieldContents("street");
	//vactorFacebook=results.getFieldContents("street2");
	//vactorLinkedin=results.getFieldContents("fax");
	//vactorDescription=results.getFieldContents("description");
	for(int i=0;i<vactorName.size();i++)
	{
	stringName.add(vactorName.get(i).toString());
	//stringLname.add(vactorLname.get(i).toString());
	//stringCompany.add(vactorCompany.get(i).toString());
	//"contact_name","partner_name","phone","email_from","city","street","street2","fax","description"
	//for(int i=0;i<vactorName.size();i++)
	//System.out.println("checking "+vactorName.get(i).toString());
	}
	ArrayList<Date> uniqueDate = new ArrayList<Date>();
	for(int i=0;i<stringName.size();i++)
	{
		String mytime=stringName.get(i);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date myDate = dateFormat.parse(mytime);
		System.out.println("date to compare "+myDate);
		uniqueDate.add(myDate);
	}
		
	//vectotal.add(stringName);
	///vectotal.add(stringLname);
	//vectotal.add(stringCompany);
	
	//for(int i=0;i<vectotal.get(0).size();i++)
	//{
	//	serverCombination.add(vectotal.get(0).get(i) + " " + vectotal.get(1).get(i) + " " + vectotal.get(2).get(i));
		
	//}
	System.out.println("server fields combination...." + stringName);
	
	///leadValuesFromDB=leadValuesFromLocalDB;
	for(int i=0;i<leadValuesFromLocalDB.size();i++)
	{
		localIds.add(leadValuesFromLocalDB.get(i).get(0));
	}
	System.out.println("local ids......" + localIds);
	for(int i=0;i<leadValuesFromLocalDB.size();i++)
	{
		localCombination.add(leadValuesFromLocalDB.get(i).get(1));
	}
	ArrayList<Integer> localCombInt = new ArrayList<Integer>();
	ArrayList<Integer> serverCombInt = new ArrayList<Integer>();

	/*for(int i=0;i<localCombination.size();i++)
	{
		localCombInt.add(Integer.parseInt(localCombination.get(i)));
		
	}
	
	for(int i=0;i<stringName.size();i++)
	{
		serverCombInt.add(Integer.parseInt(localCombination.get(i)));

	}
	System.out.println();*/
	System.out.println("local fields combination..." + localCombination);
	for(int i=0;i<localCombination.size();i++)
	{
		String mytime=localCombination.get(i);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date myDate = dateFormat.parse(mytime);
		System.out.println("date to compare "+myDate);
		if(!uniqueDate.contains(myDate))
		{
			System.out.println("loop 2");
			index_matched.add(i);
		}
		}
		
	
	System.out.println("index not matched "+index_matched);
	for(int i=0;i<index_matched.size();i++)
	{
		finalIds.add(localIds.get(index_matched.get(i)));
	}
	for(int i=0;i<finalIds.size();i++)
	{
		finalIdInteger.add(Integer.parseInt(finalIds.get(i)));
	}
	System.out.println("final ids "+finalIds);
	return finalIdInteger;
}

public ArrayList<Integer> getValueFromServerToDeleteContact(List<ArrayList<String>> contactValuesFromLocalDB,String serverIP,String database
		,String username,String password ) throws Exception
{   ArrayList<String> finalIds=new ArrayList<String>();
	ArrayList<String> localIds=new ArrayList<String>();
ArrayList<Date> localCombination=new ArrayList<Date>();
//ArrayList<String> serverCombination=new ArrayList<String>();
//List<ArrayList<String>> leadValuesFromDB=new ArrayList<ArrayList<String>>();
List<ArrayList<String>> vectotal=new ArrayList<ArrayList<String>>();

index_matched = new ArrayList<Integer>();
openerp = new OpenERP(serverIP,database,"admin",password);
OpenERPDomain domain = new OpenERPDomain();
//domain.add("id", 2);

Object[] result_ids = openerp.search("res.partner");
OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] { "city"});


vactorName = new Vector<Object>();
//vactorLname = new Vector<Object>();
//vactorCompany = new Vector<Object>();
//vactorPhone = new Vector<Object>();
//vactorEmail = new Vector<Object>();
//vactorWeb = new Vector<Object>();
//vactorAddress = new Vector<Object>();
//vactorFacebook = new Vector<Object>();
//vactorLinkedin = new Vector<Object>();
//vactorDescription = new Vector<Object>();

stringName=new ArrayList<String>();
//stringLname=new ArrayList<String>();
//stringCompany=new ArrayList<String>();
vactorName=results.getFieldContents("city");
System.out.println("unique code from server.." + vactorName.get(0));
System.out.println("unique code from local db..." + contactValuesFromLocalDB.get(0).get(1));
//vactorLname=results.getFieldContents("contact_name");
//vactorCompany=results.getFieldContents("partner_name");
//vactorName=results.getFieldContents("phone");
//vactorName=results.getFieldContents("email_from");
//vactorWeb=results.getFieldContents("city");
//vactorAddress=results.getFieldContents("street");
//vactorFacebook=results.getFieldContents("street2");
//vactorLinkedin=results.getFieldContents("fax");
//vactorDescription=results.getFieldContents("description");
for(int i=0;i<vactorName.size();i++)
{
stringName.add(vactorName.get(i).toString());
//stringLname.add(vactorLname.get(i).toString());
//stringCompany.add(vactorCompany.get(i).toString());
//"contact_name","partner_name","phone","email_from","city","street","street2","fax","description"
//for(int i=0;i<vactorName.size();i++)
//System.out.println("checking "+vactorName.get(i).toString());
}
ArrayList<Date> uniqueDate = new ArrayList<Date>();
for(int i=0;i<stringName.size();i++)
{
String mytime=stringName.get(i);
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date myDate = dateFormat.parse(mytime);
uniqueDate.add(myDate);
}

vectotal.add(stringName);
///vectotal.add(stringLname);
//vectotal.add(stringCompany);

//for(int i=0;i<vectotal.get(0).size();i++)
//{
//	serverCombination.add(vectotal.get(0).get(i) + " " + vectotal.get(1).get(i) + " " + vectotal.get(2).get(i));
	
//}
System.out.println("server fields combination...." + uniqueDate);

///leadValuesFromDB=leadValuesFromLocalDB;
for(int i=0;i<contactValuesFromLocalDB.size();i++)
{
	localIds.add(contactValuesFromLocalDB.get(i).get(0));
}
System.out.println("local ids......" + localIds);
for(int i=0;i<contactValuesFromLocalDB.size();i++)
{
	String mytime=contactValuesFromLocalDB.get(i).get(1);
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date myDate = dateFormat.parse(mytime);
	uniqueDate.add(myDate);

	localCombination.add(myDate);
}
System.out.println("local fields combination..." + localCombination);
for(int i=0;i<localCombination.size();i++)
{
	System.out.println("loop 1");
	if(!uniqueDate.contains(localCombination.get(i)))
	{
		System.out.println("loop 2");
		index_matched.add(i);
	}
	}

System.out.println("index not matched "+index_matched);
for(int i=0;i<index_matched.size();i++)
{
	finalIds.add(localIds.get(index_matched.get(i)));
}
for(int i=0;i<finalIds.size();i++)
{
	finalIdInteger.add(Integer.parseInt(finalIds.get(i)));
}
System.out.println("final ids "+finalIds);
System.out.println("final ids in integer "+finalIdInteger);
return finalIdInteger;
}

public List<ArrayList<String>> getValueFromServerCheck(String host,String dbName , String userName, String password,String serverIP,String database
		,String user,String pass) throws Exception {
	ArrayList<String> resultSet,getServerValues;
	resultSet=new ArrayList<String>();
	//getServerValues = new ArrayList<String>();
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();

	Vector<Object> vactorId=new Vector<Object>();
	Vector<Object> vactorUnique=new Vector<Object>();
	openerp = new OpenERP(host, dbName, userName, password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);

	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","description"});
   vactorId=results.getFieldContents("id");
   vactorUnique=results.getFieldContents("description");
return null; 
}
public void check() throws Exception
{
	openerp = new OpenERP("54.251.186.100","traveloore","admin","1234");
	//OpenERPDomain domain = new OpenERPDomain();
	Calendar c = Calendar.getInstance();
    System.out.println("Current time => "+c.getTime());

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = df.format(c.getTime());
    Object date=formattedDate;
    System.out.println("date "+date);
   // formattedDate.
	Object[] result_ids = openerp.search("crm.lead","create_date",">",date);
	//System.out.println("results...." + result_ids);
	//OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","write_date","name","contact_name","partner_name","phone","email_from","city","street","street2"});
	OpenERPRecordSet results=openerp.readRecords("crm.lead",result_ids,new String[]{"name","email_from","create_date"});
System.out.println("results...." + results);

}
public void passUsersValueToServer(int passUser,ArrayList<Integer> statusUser, List<ArrayList<String>> getUserValues,String serverIP,String database
		,String username,String pass) throws Exception
{
	System.out.println("after login");
	System.out.println("username..." + username);
	int synchId;
				//here is all process for phase I
				String fName,login,password;
				String name,Lname,company,email,phone,street,description,web,linkedin,facebook,uniqueCode;
	
	uservalues=new ArrayList<ArrayList<String>>();
	status=new ArrayList<Integer>();
	int totalUser=passUser;
	status=statusUser;
				System.out.println("values not passed");
			uservalues=getUserValues;
				System.out.println("values" +uservalues.get(0));
				//MyDatabaseClass mdc = new MyDatabaseClass(_context);
				//mdc.open();
				//valuesPass= new ArrayList<String>(getValues.size());
				
				//String values[] = new String[getValues.size()];
				
				//for(int i=0;i<getValues.size();i++)
					//values[i]=getValues.get(i);
				//for()
				//Curd curd = new Curd();
				//indexSynch=index;
				///synchId=indexSynch+1;
				//System.out.println("after login index" +indexSynch);
				//int i=1;
				for(int i=0;i<totalUser;i++)
				{
				if (i==1)
				{
					System.out.println("working....");
				}
				}
				System.out.println("total users" +totalUser);
				for(int i=0;i<totalUser;i++)
					System.out.println("value hai jo..."+status.get(i));
					
				int i;
				curd = new Curd();
				//String status= "synchronized";
				//SynchronizationHelper synHelper = new SynchronizationHelper();
				for(i=0;i<totalUser;i++)
				{
					//String values=getIndex.get(i);
				    if (status.get(0)==1)
					 {
				    	//ArrayList<String> rList=valuesPass.get(i);
					System.out.println("i am in loop");
					fName=uservalues.get(i).get(0);
					System.out.println("name value..."+fName);
					login=uservalues.get(i).get(1);
					password=uservalues.get(i).get(2);
					
					System.out.println("value is going to pass......");			
  curd.createUser(fName,login,password,serverIP,database,username,password);
	System.out.println("value passed......");


					}
					}

					}

public List<ArrayList<String>> getPackageInformation() throws Exception
{
	List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	Vector<Object> vactorDate=new Vector<Object>();
			vactor=new Vector<Object>();
			openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
			
			Object[] result_ids;
			
			
			result_ids = openerp.search("travel.package");
			
			OpenERPRecordSet results = openerp.readRecords("travel.package", result_ids, new String[] {"package_id","package_name","adults","child"});
		    System.out.println("results...." + results);
			
			
		/*	vactorName = new Vector<Object>();
			vactorLname = new Vector<Object>();
			vactorCompany = new Vector<Object>();
			vactorPhone = new Vector<Object>();
			vactorEmail = new Vector<Object>();
			vactorWeb = new Vector<Object>();
			vactorAddress = new Vector<Object>();
			vactorFacebook= new Vector<Object>();
			vactorLinkedin = new Vector<Object>();
			vactorDescription = new Vector<Object>();
			Vector<Object> vactorUniqueCode = new Vector<Object>();
				Vector<Object> vactorId= new Vector<Object>();
			vactorId=results.getFieldContents("id");
			vactorDate=results.getFieldContents("create_date");
			vactorName=results.getFieldContents("name");
			vactorLname=results.getFieldContents("contact_name");
			vactorCompany=results.getFieldContents("partner_name");
			vactorPhone=results.getFieldContents("phone");
			vactorEmail=results.getFieldContents("email_from");
			vactorWeb=results.getFieldContents("city");
			vactorAddress=results.getFieldContents("street");
			vactorFacebook=results.getFieldContents("street2");
			vactorLinkedin=results.getFieldContents("fax");
			vactorDescription=results.getFieldContents("zip");
			vactorUniqueCode=results.getFieldContents("description");
			System.out.println("description " +vactorUniqueCode);
				List<ArrayList<String>> vecTotal1 = new ArrayList<ArrayList<String>>();
			for(int i=0;i<vactorName.size();i++)
			{
				ArrayList<String> stringName = new ArrayList<String>();
				stringName.add(vactorName.get(i).toString());
				stringName.add(vactorLname.get(i).toString());
				stringName.add(vactorCompany.get(i).toString());
				stringName.add(vactorPhone.get(i).toString());
				stringName.add( vactorEmail.get(i).toString());
				stringName.add(vactorWeb.get(i).toString());
				stringName.add( vactorAddress.get(i).toString());
				stringName.add(vactorFacebook.get(i).toString());
				stringName.add(vactorLinkedin.get(i).toString());
				stringName.add(vactorDescription.get(i).toString());
				stringName.add(vactorUniqueCode.get(i).toString());
				stringName.add(vactorDate.get(i).toString());
				vecTotal1.add(stringName);
			}
			*/
	return null;
	
}
public List<ArrayList<String>> getValueFromServerCheckContact(String host,String dbName , String userName, String password) throws Exception {
	ArrayList<String> resultSet,getServerValues;
	resultSet=new ArrayList<String>();
	Vector<Object> vactorId=new Vector<Object>();
	Vector<Object> vactorUnique=new Vector<Object>();
	openerp = new OpenERP(host, dbName, userName, password);
	//OpenERPDomain domain = new OpenERPDomain();
//	domain.add("id", 2);

	Object[] result_ids = openerp.search("res.partner");
	OpenERPRecordSet results = openerp.readRecords("res.partner", result_ids, new String[] {"id","city"});
   vactorId=results.getFieldContents("id");
   vactorUnique=results.getFieldContents("city");
return null; 
}
public void checkContact() throws Exception
{
	openerp = new OpenERP("54.251.186.100","traveloore","admin","1234");
	//OpenERPDomain domain = new OpenERPDomain();
	Calendar c = Calendar.getInstance();
    System.out.println("Current time => "+c.getTime());

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String formattedDate = df.format(c.getTime());
    Object date=formattedDate;
    System.out.println("date "+date);
   // formattedDate.
	Object[] result_ids = openerp.search("res.partner","create_date",">",date);
	//System.out.println("results...." + result_ids);
	//OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] {"id","create_date","write_date","name","contact_name","partner_name","phone","email_from","city","street","street2"});
	OpenERPRecordSet results=openerp.readRecords("res.partner",result_ids,new String[]{"name","email","create_date"});
System.out.println("results...." + results);

}
public List<ArrayList<String>> getBookingDetails(String bookingNumber,String serverIP,String database,String pass) throws Exception
{
	//openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	//OpenERPDomain domain = new OpenERPDomain();
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

   Object bookNumber =bookingNumber;	
	System.out.println("Booking Number "+bookNumber);
		Object[] result_ids;
		if(bookNumber == null){
			result_ids = openerp.search("travel.booking");
		}
		
		else{
		result_ids = openerp.search("travel.booking","book_no",">",bookNumber);
		}
		
	
	OpenERPRecordSet results=openerp.readRecords("travel.booking",result_ids,new String[]{"id","book_no",
	    "date","start_date","end_date","advance_amount","customer_id","salutation","customer_name","customer_name_NAME",
	    "gender","address","city","state_name","country","zipcode","m_no","email","id_type",
	"id_num","package_id","package_name","adults","child","desc"});

Log.d("booking check ", results.toString());
	
	// System.out.println("results...." + results);
     
    //  System.out.println("check....."+results.getFieldContents("traveller_line").getClass().getName().g);
     
     // System.out.println("check it...."+results.getFieldContents("traveller_line").getClass().getDeclaredField("traveller_id"));
     // System.out.println("check it...."+results.getFieldContents("traveller_line").getClass().getDeclaredFields());

      // getClass().getName() + '@' +Integer.toHexString(hashCode())

	
 //Vector<Object> data =  new Vector<Object>();
 //String finalData;
 //data=results.getFieldContents("traveller_line");
 ///finalData=data.getClass().getFields().toString();
// System.out.println("values........... "+finalData);    
     
     //Vector<Object> id = new Vector<Object>();
  Vector<Object> booking_number = new Vector<Object>();
  Vector<Object> booking_date  = new Vector<Object>();
  Vector<Object> start_date  = new Vector<Object>();
  Vector<Object> end_date = new Vector<Object>();
  Vector<Object> advance_amount = new Vector<Object>();
  Vector<Object> total_amount = new Vector<Object>();
 
  Vector<Object> customer_id  = new Vector<Object>();
  Vector<Object> salutation  = new Vector<Object>();
  Vector<Object> customer_name = new Vector<Object>();
  Vector<Object> gender = new Vector<Object>();

  Vector<Object> address = new Vector<Object>();
  Vector<Object> city  = new Vector<Object>();
  Vector<Object> state  = new Vector<Object>();
  Vector<Object> country = new Vector<Object>();
  Vector<Object> zip_code = new Vector<Object>();

  Vector<Object> mobile = new Vector<Object>();
  Vector<Object> email  = new Vector<Object>();
  Vector<Object> id_type  = new Vector<Object>();
  Vector<Object> id_number = new Vector<Object>();
  Vector<Object> package_id = new Vector<Object>();
  Vector<Object> package_name = new Vector<Object>();
  Vector<Object> adults  = new Vector<Object>();
  Vector<Object> child  = new Vector<Object>();
  Vector<Object> description = new Vector<Object>();
  Vector<Object> synchId = new Vector<Object>();
  
  
    booking_number=results.getFieldContents("book_no");
    booking_date=results.getFieldContents("date");
    start_date=results.getFieldContents("start_date");
    end_date=results.getFieldContents("end_date");
    advance_amount=results.getFieldContents("advance_amount");
    customer_id=results.getFieldContents("customer_id");
    salutation=results.getFieldContents("salutation");
    customer_name=results.getFieldContents("customer_name_NAME");
    gender=results.getFieldContents("gender");
    address=results.getFieldContents("address");
    city=results.getFieldContents("city");
    state=results.getFieldContents("state_name");
    country=results.getFieldContents("country");
    zip_code=results.getFieldContents("zipcode");
    mobile=results.getFieldContents("m_no");
    email=results.getFieldContents("email");
    id_type=results.getFieldContents("id_type");
    id_number=results.getFieldContents("id_num");
    package_id=results.getFieldContents("package_id");
    package_name=results.getFieldContents("package_name");
    adults=results.getFieldContents("adults");
    child=results.getFieldContents("child");
    description=results.getFieldContents("desc");
    synchId=results.getFieldContents("id");

System.out.println("booking number" + booking_number);
System.out.println("booking date" + booking_date);
System.out.println("start date" + start_date);
System.out.println("end date" + end_date);
System.out.println("advance amount" +advance_amount);
System.out.println("customer id" +customer_id);
System.out.println("salutation" + salutation);
System.out.println("customer name" + customer_name);
System.out.println("gender" + gender);
System.out.println("address" +address);
System.out.println("city" + city);
System.out.println("state" + state);
System.out.println("country" + country);
System.out.println("zip_code" + zip_code);
System.out.println("mobile number" + mobile);
System.out.println("email" + email);
System.out.println("id_type" + id_type);
System.out.println("id number" + id_number);
System.out.println("package_id" + package_id);
System.out.println("package name" + package_name);
System.out.println("adults" + adults);
System.out.println("children" + child);
System.out.println("description" + description);

List<ArrayList<String>> totalDetails=new ArrayList<ArrayList<String>>();
for(int i=0;i<booking_number.size();i++)
{  
	System.out.println("valuesss...inside loop");
	ArrayList<String> bookingDetails=new ArrayList<String>();
	bookingDetails.add(booking_number.get(i).toString());
	bookingDetails.add(booking_date.get(i).toString());
	bookingDetails.add(start_date.get(i).toString());
	bookingDetails.add(end_date.get(i).toString());
	bookingDetails.add(advance_amount.get(i).toString());
	bookingDetails.add(customer_id.get(i).toString());
    bookingDetails.add(salutation.get(i).toString());
    bookingDetails.add(customer_name.get(i).toString());
    bookingDetails.add(gender.get(i).toString());
    bookingDetails.add(address.get(i).toString());
    bookingDetails.add(city.get(i).toString());
    bookingDetails.add(state.get(i).toString());
    bookingDetails.add(country.get(i).toString());
    bookingDetails.add(zip_code.get(i).toString());
    bookingDetails.add(mobile.get(i).toString());
    bookingDetails.add(email.get(i).toString());
    bookingDetails.add(id_type.get(i).toString());
    bookingDetails.add(id_number.get(i).toString());
    bookingDetails.add(package_id.get(i).toString());
    bookingDetails.add(package_name.get(i).toString());
    bookingDetails.add(adults.get(i).toString());
    bookingDetails.add(child.get(i).toString());
    bookingDetails.add(description.get(i).toString());
    bookingDetails.add(synchId.get(i).toString());
    System.out.println("booking details" + bookingDetails);
totalDetails.add(bookingDetails);	
}




return totalDetails;

	
}

public List<ArrayList<String>> getHotelDetails() throws Exception {
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	
	
	
    Object []result_ids_hotel = openerp.search("travel.hotel.room");
	
	OpenERPRecordSet results = openerp.readRecords("travel.hotel.room", result_ids_hotel, 
			new String[] {"id","hotel_id","hotel_name","city_name","address","stars"});
  
	
	System.out.println("id values ");
	System.out.println("results..package.." + results);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	
	Vector<Object> id = new Vector<Object>();
	Vector<Object> hotelId = new Vector<Object>();
	Vector<Object> hotelName  = new Vector<Object>();
	Vector<Object> hotelCity  = new Vector<Object>();
	Vector<Object> hotelAddress = new Vector<Object>();
	Vector<Object> hotelStars = new Vector<Object>();
    Vector<Object> hotelStay = new Vector<Object>();
    
    id=results.getFieldContents("id");
	hotelId=results.getFieldContents("hotel_id");
	hotelName=results.getFieldContents("hotel_name");
	hotelCity=results.getFieldContents("city_name");
	hotelAddress=results.getFieldContents("address");
	hotelStars=results.getFieldContents("stars");
	hotelStay=results.getFieldContents("stay_id");
	
	
	System.out.println("hotel normal id "+id);
	System.out.println("hotel id "+hotelId);
	System.out.println("hotel name "+hotelName);
	System.out.println("hotel city "+hotelCity);
	System.out.println("hotel address "+hotelAddress);
	System.out.println("hotel stars "+hotelStars);
	System.out.println("stay id in hotel field "+hotelStay);
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	System.out.println("outside of loop");

	
	for(int i=0;i<hotelId.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
	    packageId.add(hotelId.get(i).toString());
		packageId.add(hotelName.get(i).toString());
		packageId.add(hotelCity.get(i).toString());
		packageId.add(hotelAddress.get(i).toString());
		packageId.add(hotelStars.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}

public List<ArrayList<String>> getStayDetails() throws Exception {
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	
	//System.out.println("package size "+packageValues.size());
	
	
Object []result_ids_stay = openerp.search("travel.stay");
	
	OpenERPRecordSet results = openerp.readRecords("travel.stay", result_ids_stay, 
			new String[] {"stay","stay_id","day_seq","city_name","desc"});
	
	  Log.d("package connection test 2", results.toString());
	//System.out.println("id values ");
	//System.out.println("results..package.." + results);
	
	
	//Vector<Object> id  = new Vector<Object>();
	//Vector<Object> stay_id  = new Vector<Object>();
	Vector<Object> stay  = new Vector<Object>();

	Vector<Object> day_seq  = new Vector<Object>();
	Vector<Object> city_name  = new Vector<Object>();
	Vector<Object> desc  = new Vector<Object>();

	//Object[] first_field = null;
	
	//id=results.getFieldContents("id");
	//stay_id=results.getFieldContents("stay_id");
	stay=results.getFieldContents("stay");
	day_seq=results.getFieldContents("day_seq");
	city_name=results.getFieldContents("city_name");
	desc=results.getFieldContents("desc");
	
	//hotelLines=results.getFieldContents("hotel_lines");
	
	
	
	//System.out.println("stay normal id"+id);
	///System.out.println("stay_id "+stay_id);
	System.out.println("stay "+stay);
	System.out.println("day sequence "+day_seq);
	System.out.println("city name "+city_name);
    System.out.println("description "+desc);
    
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+stayId.size());
	for(int i=0;i<day_seq.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> stayId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		stayId.add(stay.get(i).toString());
		stayId.add(day_seq.get(i).toString());
	    stayId.add(city_name.get(i).toString());
	    stayId.add(desc.get(i).toString());

	    total.add(stayId);
	}
	
return total;	
}

public List<ArrayList<String>> getPackageDetails(String dateString,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);
	
  
	
	
	//System.out.println("package size "+packageValues.size());	
	System.out.println("Package Date "+dateString);
		Object[] result_ids;
		if(dateString == null){
			result_ids = openerp.search("travel.package");
		}
		
		else{
			Object date=dateString; 
			
		result_ids = openerp.search("travel.package","date",">",date);
		}
	
	
	OpenERPRecordSet results = openerp.readRecords("travel.package", result_ids, 
			new String[] {"date","id","package_name","no_adults","no_children","discription"});

//Object []result_ids_rel = openerp.search("travel_hotel_rel");
	
	//OpenERPRecordSet results_rel = openerp.readRecords("travel.package", result_ids_rel, 
	//		new String[] {"stay_id","hotel_id"});

	
/*Object []result_ids_stay = openerp.search("travel.stay");
	
	OpenERPRecordSet results_stay = openerp.readRecords("travel.stay", result_ids_stay, 
			new String[] {"stay_id","stay","city_name","days","travel_hotel_rel"});
	
	 Object []result_ids_hotel = openerp.search("travel.hotel.room");
		
		OpenERPRecordSet results_hotel = openerp.readRecords("travel.hotel.room", result_ids_hotel, 
				new String[] {"hotel_id","travel","hotel_name","city_name","address","stars","travel_hotel_rel"});
	*/
	System.out.println("id values ");
	System.out.println("results..package.." + results);
	//System.out.println("result.. relationship "+results_rel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	
	Vector<Object> vactorId = new Vector<Object>();
	Vector<Object> vactorPackageName  = new Vector<Object>();
	Vector<Object> vactorAdults  = new Vector<Object>();
	Vector<Object> vactorChildren = new Vector<Object>();
	Vector<Object> vactorDescription = new Vector<Object>();
	Vector<Object> vactorDate = new Vector<Object>();
	
	
	//vactorPackageId=results.getFieldContents("package_id");
	vactorPackageName=results.getFieldContents("package_name");
	vactorAdults=results.getFieldContents("no_adults");
	vactorChildren=results.getFieldContents("no_children");
	vactorDescription=results.getFieldContents("discription");
	vactorId=results.getFieldContents("id");
    vactorDate=results.getFieldContents("date");
	
	
	//System.out.println("package id "+vactorId);
	System.out.println("package name "+vactorPackageName);
	System.out.println("adults "+vactorAdults);
	System.out.println("children "+vactorChildren);
	System.out.println("description "+vactorDescription);
	System.out.println("package normal id "+vactorId);
	System.out.println("package date "+vactorDate);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<vactorId.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(vactorId.get(i).toString());
		packageId.add(vactorPackageName.get(i).toString());
		packageId.add(vactorAdults.get(i).toString());
		packageId.add(vactorChildren.get(i).toString());
		packageId.add(vactorDescription.get(i).toString());
		packageId.add(vactorDate.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}


public List<ArrayList<String>> getTravelDetails(String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);
	
	//System.out.println("package size "+packageValues.size());

	Object []result_ids = openerp.search("travel.itenary");
	
	OpenERPRecordSet results = openerp.readRecords("travel.itenary", result_ids, 
			new String[] {"travel","travel_id","tm_name","city","d_city","day_seq","price"});


	System.out.println("id values ");
	System.out.println("results..package.." + results);
	//System.out.println("result.. relationship "+results_rel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	
	Vector<Object> travelId = new Vector<Object>();
	Vector<Object> travelMode  = new Vector<Object>();
	Vector<Object> travelSource  = new Vector<Object>();
	Vector<Object> travelDestination = new Vector<Object>();
	Vector<Object> day_seq = new Vector<Object>();
	Vector<Object> price = new Vector<Object>();

	Vector<Object> travel = new Vector<Object>();
	
	
	//vactorPackageId=results.getFieldContents("package_id");

	travelId=results.getFieldContents("travel_id");
	travelMode=results.getFieldContents("tm_name");
	travelSource=results.getFieldContents("city");
	travelDestination=results.getFieldContents("d_city");
	travel=results.getFieldContents("travel");
	day_seq=results.getFieldContents("day_seq");
	price=results.getFieldContents("price");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	System.out.println("stay travel connection field "+travel);
	System.out.println("travel id "+travelId);
	System.out.println("travel mode "+travelMode);
	System.out.println("travel source "+travelSource);
	System.out.println("travel destination "+travelDestination);
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<travelId.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(travelId.get(i).toString());
		packageId.add(travelMode.get(i).toString());
		packageId.add(travelSource.get(i).toString());
		packageId.add(travelDestination.get(i).toString());
		packageId.add(day_seq.get(i).toString());
		packageId.add(price.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}

public List<ArrayList<String>> getBookingStayDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	///OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object id =synchId;
	System.out.println("id in object form booking stay "+id);

	//System.out.println("package size "+packageValues.size());

	Object[] result_ids;
	if(id == null){
		result_ids = openerp.search("travel.stay.line");
	}
	
	else{ 
	result_ids = openerp.search("travel.stay.line","id",">",id);
	}
	
	
	
	OpenERPRecordSet results = openerp.readRecords("travel.stay.line", result_ids, 
			new String[] {"id","stay_id","day_seq","name","city","desc","stay"});

	Log.d("traveller details", results.toString());

	
	
	Vector<Object> stay_Id = new Vector<Object>();
	Vector<Object> day_seq  = new Vector<Object>();
	Vector<Object> name  = new Vector<Object>();
	Vector<Object> city = new Vector<Object>();
	Vector<Object> desc = new Vector<Object>();
	Vector<Object> stay = new Vector<Object>();
	Vector<Object> syncId = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

    stay_Id=results.getFieldContents("stay_id");
	day_seq=results.getFieldContents("day_seq");
	name=results.getFieldContents("name");
    city=results.getFieldContents("city");
	desc=results.getFieldContents("desc");
	stay=results.getFieldContents("stay");
	syncId=results.getFieldContents("id");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	System.out.println("stay travel connection field "+stay_Id);
	System.out.println("travel id "+day_seq);
	System.out.println("travel mode "+name);
	System.out.println("travel source "+city);
	System.out.println("travel destination "+desc);
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<stay_Id.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(stay_Id.get(i).toString());
		packageId.add(day_seq.get(i).toString());
		packageId.add(name.get(i).toString());
		packageId.add(city.get(i).toString());
		packageId.add(desc.get(i).toString());
		packageId.add(stay.get(i).toString());
		packageId.add(syncId.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}

public List<ArrayList<String>> getBookingMealDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object id =synchId;
	System.out.println("id in object form booking stay "+id);

	//System.out.println("package size "+packageValues.size());

	Object[] result_ids;
	if(id == null){
		result_ids = openerp.search("meal");
	}
	
	else{ 
	result_ids = openerp.search("meal","id",">",id);
	}
	
	
	
	OpenERPRecordSet results = openerp.readRecords("meal", result_ids, 
			new String[] {"id","mealtype_id","mealtype_name","price_unit"});


	
	
	Vector<Object> synchid = new Vector<Object>();
	Vector<Object>  meal_id = new Vector<Object>();
	Vector<Object> meal_name  = new Vector<Object>();
	Vector<Object> meal_price = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

    synchid=results.getFieldContents("id");
	meal_id=results.getFieldContents("mealtype_id");
	meal_name=results.getFieldContents("mealtype_name");
    meal_price=results.getFieldContents("price_unit");
	
	
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<synchid.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(synchid.get(i).toString());
		packageId.add(meal_id.get(i).toString());
		packageId.add(meal_name.get(i).toString());
		packageId.add(meal_price.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}
public List<ArrayList<String>> getBookingRoomDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object id =synchId;
	System.out.println("id in object form booking stay "+id);

	//System.out.println("package size "+packageValues.size());

	Object[] result_ids;
	if(id == null){
		result_ids = openerp.search("room.type");
	}
	
	else{ 
	result_ids = openerp.search("room.type","id",">",id);
	}
	
	
	
	OpenERPRecordSet results = openerp.readRecords("room.type", result_ids, 
			new String[] {"id","roomtype_id","roomtype_name","price"});

	Log.d("traveller details", results.toString());

	
	
	Vector<Object> synch_Id = new Vector<Object>();
	Vector<Object> room_id  = new Vector<Object>();
	Vector<Object> room_name  = new Vector<Object>();
	Vector<Object> room_price = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

    synch_Id=results.getFieldContents("id");
	room_id=results.getFieldContents("roomtype_id");
	room_name=results.getFieldContents("roomtype_name");
    room_price=results.getFieldContents("price");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<synch_Id.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(synch_Id.get(i).toString());
		packageId.add(room_id.get(i).toString());
		packageId.add(room_name.get(i).toString());
		packageId.add(room_price.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}
public List<ArrayList<String>> getBookingAmenityDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object id =synchId;
	System.out.println("id in object form booking stay "+id);

	//System.out.println("package size "+packageValues.size());

	Object[] result_ids;
	if(id == null){
		result_ids = openerp.search("amenities");
	}
	
	else{ 
	result_ids = openerp.search("amenities","id",">",id);
	}
	
	
	
	OpenERPRecordSet results = openerp.readRecords("amenities", result_ids, 
			new String[] {"id","amount","description","amenity_name"});

	Log.d("traveller details", results.toString());

	
	
	Vector<Object> synch_Id = new Vector<Object>();
	Vector<Object> amount  = new Vector<Object>();
	Vector<Object> description  = new Vector<Object>();
	Vector<Object> amenity_name = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

    synch_Id=results.getFieldContents("id");
	amount=results.getFieldContents("amount");
	description=results.getFieldContents("description");
    amenity_name=results.getFieldContents("amenity_name");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<synch_Id.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(synch_Id.get(i).toString());
		packageId.add(amount.get(i).toString());
		packageId.add(description.get(i).toString());
		packageId.add(amenity_name.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}


public List<ArrayList<String>> getBookingTravelDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object id =synchId;
	System.out.println("id in object form booking stay "+id);

	//System.out.println("package size "+packageValues.size());

	Object[] result_ids;
	if(id == null){
		result_ids = openerp.search("travel.line");
	}
	
	else{ 
	result_ids = openerp.search("travel.line","id",">",id);
	}
	
	
	
	OpenERPRecordSet results = openerp.readRecords("travel.line", result_ids, 
			new String[] {"id","day_seq","mode","source","destination","itinerary_id"});

	Log.d("booking travel details", results.toString());

	
	
	Vector<Object> normalId = new Vector<Object>();
	Vector<Object> day_seq  = new Vector<Object>();
	Vector<Object> mode  = new Vector<Object>();
	Vector<Object> source = new Vector<Object>();
	Vector<Object> destination = new Vector<Object>();
	Vector<Object> itinerary_id = new Vector<Object>();
	
	
	//vactorPackageId=results.getFieldContents("package_id");

    normalId=results.getFieldContents("id");
	day_seq=results.getFieldContents("day_seq");
	mode=results.getFieldContents("mode");
    source=results.getFieldContents("source");
	destination=results.getFieldContents("destination");
	itinerary_id=results.getFieldContents("itinerary_id");
	
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	System.out.println("booking stay travel id "+normalId);
	System.out.println("booking day_seq "+day_seq);
	System.out.println("booking travel mode "+mode);
	System.out.println("booking travel source "+source);
	System.out.println("booking travel destination "+destination);
	System.out.println("booking travel connection id "+itinerary_id);
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<normalId.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(normalId.get(i).toString());
		packageId.add(day_seq.get(i).toString());
		packageId.add(mode.get(i).toString());
		packageId.add(source.get(i).toString());
		packageId.add(destination.get(i).toString());
		packageId.add(itinerary_id.get(i).toString());

		total.add(packageId);
	}
	
return total;	
}



public List<ArrayList<String>> getBookingTravellerDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object synchTravellerId=synchId;
	System.out.println("id in object form traveller "+synchTravellerId);
	
	Object[] result_ids;
	if(synchTravellerId == null){
		result_ids = openerp.search("traveller.details");
	}
	
	else{ 
	result_ids = openerp.search("traveller.details","id",">",synchTravellerId);
	}
	//System.out.println("package size "+packageValues.size());

	
	OpenERPRecordSet results = openerp.readRecords("traveller.details", result_ids, 
			new String[] {"traveller_id","t_salutation","t_gender","t_address","t_country",
			              "t_m_no","t_id_type","t_city_name","t_zipcode","traveller_name","t_email","t_id_num",
			              "t_state_name","id","traveller"});

	Log.d("traveller details", results.toString());


	
	
	Vector<Object> traveller_Id = new Vector<Object>();
	Vector<Object> t_salutation  = new Vector<Object>();
	Vector<Object> t_gender  = new Vector<Object>();
	Vector<Object> t_address = new Vector<Object>();
	Vector<Object> t_country = new Vector<Object>();
	Vector<Object> t_m_no = new Vector<Object>();
	Vector<Object> t_id_type = new Vector<Object>();
	Vector<Object> t_city_name = new Vector<Object>();
	Vector<Object> t_zipcode = new Vector<Object>();
	Vector<Object> traveller_name = new Vector<Object>();
	Vector<Object> t_email = new Vector<Object>();
	Vector<Object> t_id_num = new Vector<Object>();
	Vector<Object> t_state_name = new Vector<Object>();
    Vector<Object> traveller = new Vector<Object>();
	Vector<Object> id = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

	traveller_Id=results.getFieldContents("traveller_id");
	t_salutation=results.getFieldContents("t_salutation");
	t_gender=results.getFieldContents("t_gender");
	t_address=results.getFieldContents("t_address");
	t_country=results.getFieldContents("t_country");
	t_m_no=results.getFieldContents("t_m_no");
	t_id_type=results.getFieldContents("t_id_type");
	t_city_name=results.getFieldContents("t_city_name");
	t_zipcode=results.getFieldContents("t_zipcode");
	traveller_name=results.getFieldContents("traveller_name");
	t_email=results.getFieldContents("t_email");
	t_id_num=results.getFieldContents("t_id_num");
	t_state_name=results.getFieldContents("t_state_name");
    id=results.getFieldContents("id");
	traveller=results.getFieldContents("traveller"); 
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	
	System.out.println("stay travel connection field "+traveller_Id);
	System.out.println("travel id "+t_salutation);
	System.out.println("travel mode "+t_gender);
	System.out.println("travel source "+t_address);
	System.out.println("travel destination "+t_country);
	System.out.println("stay travel connection field "+t_m_no);
	System.out.println("travel id "+t_id_type);
	System.out.println("travel mode "+t_city_name);
	System.out.println("travel source "+t_zipcode);
	System.out.println("travel destination "+traveller_name);
	System.out.println("stay travel connection field "+t_email);
	System.out.println("travel id "+t_id_num);
	System.out.println("travel mode "+t_state_name);
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<traveller_Id.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(traveller_Id.get(i).toString());
		packageId.add(t_salutation.get(i).toString());
		packageId.add(t_gender.get(i).toString());
		packageId.add(t_address.get(i).toString());
		packageId.add(t_country.get(i).toString());
		packageId.add(t_m_no.get(i).toString());
		packageId.add(t_id_type.get(i).toString());
		packageId.add(t_city_name.get(i).toString());
		packageId.add(t_zipcode.get(i).toString());
		packageId.add(traveller_name.get(i).toString());
		packageId.add(t_email.get(i).toString());
		packageId.add(t_id_num.get(i).toString());
		packageId.add(t_state_name.get(i).toString());
		packageId.add(id.get(i).toString());
		packageId.add(traveller.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}

public List<ArrayList<String>> getBookingHotelDetails(String synchId,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	Object synchTravellerId=synchId;
	System.out.println("id in object form traveller "+synchTravellerId);
	
	Object[] result_ids;
	if(synchTravellerId == null){
		result_ids = openerp.search("booking.hotel.room");
	}
	
	else{ 
	result_ids = openerp.search("booking.hotel.room","id",">",synchTravellerId);
	}
	//System.out.println("package size "+packageValues.size());

	
	OpenERPRecordSet results = openerp.readRecords("booking.hotel.room", result_ids, 
			new String[] {"id","hotel_id","hotel_name","hotel_NAME","hotel_name_NAME","city_name","address","stars","hotel"});

	Log.d("correct hotel check 1", results.toString());

  
	Vector<Object> id = new Vector<Object>();
	Vector<Object> hotel_id  = new Vector<Object>();
	Vector<Object> hotel_name  = new Vector<Object>();
	Vector<Object> city_name = new Vector<Object>();
	Vector<Object> address = new Vector<Object>();
	Vector<Object> stars = new Vector<Object>();
	Vector<Object> hotel = new Vector<Object>();
	
	//vactorPackageId=results.getFieldContents("package_id");

	id=results.getFieldContents("id");
	hotel_id=results.getFieldContents("hotel_id");
	hotel_name=results.getFieldContents("hotel_name_NAME");
	city_name=results.getFieldContents("city_name_NAME");
	address=results.getFieldContents("address");
	stars=results.getFieldContents("stars");
	hotel=results.getFieldContents("hotel");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	
	Log.d("booking hotel values to store ", results.toString());
	
	/*System.out.println("stay travel connection field "+traveller_Id);
	System.out.println("travel id "+t_salutation);
	System.out.println("travel mode "+t_gender);
	System.out.println("travel source "+t_address);
	System.out.println("travel destination "+t_country);
	System.out.println("stay travel connection field "+t_m_no);
	System.out.println("travel id "+t_id_type);
	System.out.println("travel mode "+t_city_name);
	System.out.println("travel source "+t_zipcode);
	System.out.println("travel destination "+traveller_name);
	System.out.println("stay travel connection field "+t_email);
	System.out.println("travel id "+t_id_num);
	System.out.println("travel mode "+t_state_name);
	*/
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<id.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		
		packageId.add(hotel_id.get(i).toString());
		packageId.add(hotel_name.get(i).toString());
		packageId.add(city_name.get(i).toString());
		packageId.add(address.get(i).toString());
		packageId.add(stars.get(i).toString());
		packageId.add(hotel.get(i).toString());
		packageId.add(id.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}


public List<ArrayList<String>> getHotelDetails(String hotelSyncId,String serverIP,String database,String pass) throws Exception {
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);
	
	Object hotelId=hotelSyncId;
	System.out.println("hotel id" + hotelId);
	
	Object[] result_ids;
	if(hotelId == null){
		result_ids = openerp.search("travel.stay");
	}
	
	else{
	result_ids = openerp.search("travel.hotel.room","id",">",hotelId);
	}
	
	
	OpenERPRecordSet results = openerp.readRecords("travel.hotel.room", result_ids, 
			new String[] {"id","hotel_id","hotel_name","hotel_name_NAME","city_name","city_name_NAME","address","stars","hotel_package"});
  
	System.out.println("id values ");
	System.out.println("results..hotel...." + results);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	Log.d("package reltaion check ", results.toString());
	Vector<Object> id = new Vector<Object>();
	Vector<Object> hotelIds = new Vector<Object>();
	Vector<Object> hotelName  = new Vector<Object>();
	Vector<Object> hotelCity  = new Vector<Object>();
	Vector<Object> hotelAddress = new Vector<Object>();
	Vector<Object> hotelStars = new Vector<Object>();
    Vector<Object> hotel_package = new Vector<Object>();
    
    id=results.getFieldContents("id");
	hotelIds=results.getFieldContents("hotel_id");
	hotelName=results.getFieldContents("hotel_name_NAME");
	hotelCity=results.getFieldContents("city_name_NAME");
	hotelAddress=results.getFieldContents("address");
	hotelStars=results.getFieldContents("stars");
	hotel_package=results.getFieldContents("hotel_package");
	//hotelStay=results.getFieldContents("stay_id");
	
	
	System.out.println("hotel normal id "+id);
	System.out.println("hotel id "+hotelIds);
	System.out.println("hotel name "+hotelName);
	System.out.println("hotel city "+hotelCity);
	System.out.println("hotel address "+hotelAddress);
	System.out.println("hotel stars "+hotelStars);
	//System.out.println("stay id in hotel field "+hotelStay);
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	System.out.println("outside of loop");

	
	for(int i=0;i<hotelIds.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
	
	    packageId.add(hotelIds.get(i).toString());
		packageId.add(hotelName.get(i).toString());
		packageId.add(hotelCity.get(i).toString());
		packageId.add(hotelAddress.get(i).toString());
		packageId.add(hotelStars.get(i).toString());
		packageId.add(id.get(i).toString());
		packageId.add(hotel_package.get(i).toString());
		total.add(packageId);
		System.out.println("total" + total);
	}
	
return total;	
}

public List<ArrayList<String>> getStayDetails(String syncId,String serverIP,String database,String pass) throws Exception {
	//List<ArrayList<String>> vecTotal = new ArrayList<ArrayList<String>>();
	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	//System.out.println("package size "+packageValues.size());
	Object staySyncId=syncId;
	System.out.println("sync id" + staySyncId);
	
	Object[] result_ids;
	if(staySyncId == null){
		result_ids = openerp.search("travel.stay");
	}
	
	else{
	result_ids = openerp.search("travel.stay","id",">",staySyncId);
	}
	

	
	OpenERPRecordSet results = openerp.readRecords("travel.stay", result_ids, 
			new String[] {"id","stay","day_seq","city_name","city_name_NAME","desc"});
	
	  
	//System.out.println("id values ");
	System.out.println("results..package.." + results);
	
	
	//Vector<Object> id  = new Vector<Object>();
	//Vector<Object> stay_id  = new Vector<Object>();
	Vector<Object> stay  = new Vector<Object>();

	Vector<Object> day_seq  = new Vector<Object>();
	Vector<Object> city_name  = new Vector<Object>();
	Vector<Object> desc  = new Vector<Object>();
	Vector<Object> id  = new Vector<Object>();

	//Object[] first_field = null;
	
	//id=results.getFieldContents("id");
	//stay_id=results.getFieldContents("stay_id");
	stay=results.getFieldContents("stay");
	day_seq=results.getFieldContents("day_seq");
	city_name=results.getFieldContents("city_name_NAME");
	desc=results.getFieldContents("desc");
	id=results.getFieldContents("id");
	//hotelLines=results.getFieldContents("hotel_lines");
	
	
	
	//System.out.println("stay normal id"+id);
	///System.out.println("stay_id "+stay_id);
	System.out.println("stay "+stay);
	System.out.println("day sequence "+day_seq);
	System.out.println("city name "+city_name);
    System.out.println("description "+desc);
    System.out.println("id "+id);
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+stayId.size());
	for(int i=0;i<day_seq.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> stayId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		stayId.add(stay.get(i).toString());
		stayId.add(day_seq.get(i).toString());
	    stayId.add(city_name.get(i).toString());
	    stayId.add(desc.get(i).toString());
         stayId.add(id.get(i).toString());
	    total.add(stayId);
	}
	
return total;	
}

public List<ArrayList<String>> getTravelDetails(String travelIdSync,String serverIP,String database,String pass) throws Exception {

	//OpenERP	openerp = new OpenERP("54.226.135.29","traveloore","admin","123");
	OpenERP	openerp = new OpenERP(serverIP,database,"admin",pass);

	//System.out.println("package size "+packageValues.size());
	
	Object travelSyncId=travelIdSync;
	System.out.println("travel id" + travelSyncId);
	
	Object[] result_ids;
	if(travelSyncId == null){
		result_ids = openerp.search("travel.itenary");
	}
	
	else{
	result_ids = openerp.search("travel.itenary","id",">",travelSyncId);
	}

	OpenERPRecordSet results = openerp.readRecords("travel.itenary", result_ids, 
			new String[] {"id","travel","travel_id","tm_name","s_city","d_city","day_seq","price"});


	System.out.println("id values ");
	System.out.println("results..package.." + results);
	//System.out.println("result.. relationship "+results_rel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	//System.out.println("results..stay.." +results_stay);
	//System.out.println("results..hotel.."+results_hotel);
	
	Vector<Object> travelId = new Vector<Object>();
	Vector<Object> travelMode  = new Vector<Object>();
	Vector<Object> travelSource  = new Vector<Object>();
	Vector<Object> travelDestination = new Vector<Object>();
	Vector<Object> day_seq = new Vector<Object>();
	Vector<Object> price = new Vector<Object>();

	Vector<Object> travel = new Vector<Object>();
	Vector<Object> travelSync = new Vector<Object>();
	
	
	//vactorPackageId=results.getFieldContents("package_id");

	travelId=results.getFieldContents("travel_id");
	travelMode=results.getFieldContents("tm_name");
	travelSource=results.getFieldContents("s_city");
	travelDestination=results.getFieldContents("d_city");
	travel=results.getFieldContents("travel");
	day_seq=results.getFieldContents("day_seq");
	price=results.getFieldContents("price");
	//vactorPackageStay=results.getFieldContents("travel_hotel_rel");
	travelSync=results.getFieldContents("id");
	
	System.out.println("stay travel connection field "+travel);
	System.out.println("travel id "+travelId);
	System.out.println("travel mode "+travelMode);
	System.out.println("travel source "+travelSource);
	System.out.println("travel destination "+travelDestination);
	System.out.println("day sequence "+day_seq);
	System.out.println("price "+price);
	System.out.println("travel sync id "+travelSync);
	
	//System.out.println("package stay field "+vactorPackageStay);
	
	
	List<ArrayList<String>> total = new ArrayList<ArrayList<String>>();
	
	System.out.println("outside of loop");
	//System.out.println(" total package ids "+vactorId.size());
	
	
	for(int i=0;i<travelId.size();i++)
	{
		System.out.println("inside of loop");
		ArrayList<String> packageId = new ArrayList<String>();
		System.out.println(" more inside of loop");
		packageId.add(travelId.get(i).toString());
		packageId.add(travelMode.get(i).toString());
		packageId.add(travelSource.get(i).toString());
		packageId.add(travelDestination.get(i).toString());
		packageId.add(travel.get(i).toString());
		packageId.add(day_seq.get(i).toString());
		packageId.add(price.get(i).toString());
		packageId.add(travelSync.get(i).toString());
		total.add(packageId);
	}
	
return total;	
}


}




