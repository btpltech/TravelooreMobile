package com.alexrs95.slidingmenuandviewpager;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class DealDetailsPager extends FragmentStatePagerAdapter {

	int id;
	String set,rowName;
	Context context;

	public DealDetailsPager(FragmentManager fm, int rowid, String name) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.id = rowid;
		this.rowName = name;

	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment dealfragment;
		switch (position) {

	    case 0:
	    	
	    	//System.out.println("Value"+rowid);
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            dealfragment = new ContactRegardingDeals(rowName);
			break;
	    case 1:
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            //fragment = new PerticularTaskFragment(rowid);
	    	dealfragment = new Note_For_Deals(id);
	    	break;
		case 2:	
			dealfragment = new Task_regarding_deals(rowName);
			break;
		default:
			dealfragment = new PerticularNoteFragment(rowName);
			break;
		} 
		Bundle args = new Bundle();
		args.putInt(FragmentDemo.ARG_OBJECT, id); // Our object is just an //
														// integer :-P
		dealfragment.setArguments(args);
		return dealfragment;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			set = "contacts";
			break;
		//case 1:
			///set = "Leads";
			//break;
		//case 1:
			//set = "Task";
			//break;
		case 1:
			set = "Note";
			break;
		case 2:
			set = "Task";
		//	break;
		}
		return set;
	}
}
