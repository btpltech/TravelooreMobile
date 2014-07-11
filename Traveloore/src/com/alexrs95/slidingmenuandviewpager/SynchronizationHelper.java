package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.Vector;

import android.content.Context;
import com.bremskerl.de.interfaces.openerp.OpenERP;
import com.btpl.database.MyDatabaseClass;

public class SynchronizationHelper {
	int length,totalValuesOfLeads,index,totalEntryOnServer;
	Curd curd;
	String[] storeDate;
	ArrayList<String> storeLocalDate;
	SynchronizationHelper syn;
	MyDatabaseClass mdc;
	//Context context;
	Vector<Object> vactor;
	OpenERP openerp;
	Context _context;
	int lead;
	
	/*public int indexToSynch() throws Exception
	{
		boolean contains;
		syn = new SynchronizationHelper();
		length=syn.getTotalEntryOnServer("54.251.186.100", "traveloore", "admin", "1234");
		
		curd=new Curd();
		storeDate = new String[length];
		storeLocalDate=new ArrayList<String>();
		storeDate=curd.search_and_output("54.251.186.100", "traveloore", "admin", "1234");
			 mdc= new MyDatabaseClass(context);
			 mdc.open();
				
			storeLocalDate= mdc.getTotalDate();
			totalValuesOfLeads=mdc.getotalLeads();
			mdc.close();
			contains=storeLocalDate.contains(storeDate[0]);
			if(contains==true)
		index=storeLocalDate.indexOf(storeDate[0]);
			else
			index=0;	
		return index;
	}*/
	
/*public int getTotalEntryOnServer(String host,String dbName , String userName, String password) throws Exception
{
	openerp = new OpenERP(host, dbName, userName, password);
	OpenERPDomain domain = new OpenERPDomain();
	Object[] result_ids = openerp.search("crm.lead");
	OpenERPRecordSet results = openerp.readRecords("crm.lead", result_ids, new String[] { "create_date" });
	vactor= new Vector<Object>();
	vactor=results.getFieldContents("create_date");
	totalEntryOnServer=vactor.size();
	return totalEntryOnServer;	
}

public int totalLeads()
{
	mdc = new MyDatabaseClass(context);
	mdc.open();
	lead=mdc.getotalLeads();
return lead;	
}*/
	public void synchronizedId(int id)
	{
		//System.out.println("inserted.........");
		
	}
}
