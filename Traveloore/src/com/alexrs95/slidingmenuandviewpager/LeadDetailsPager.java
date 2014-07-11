package com.alexrs95.slidingmenuandviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class LeadDetailsPager  extends FragmentStatePagerAdapter {

	int id;
	String set,rowName;
	Context context;
	String name;

	public LeadDetailsPager(FragmentManager fm, int rowid ,String rowName) {
		super(fm);
		// TODO Auto-generated constructor stub
		this.id = rowid;
		this.name=rowName;
		//this.rowName = name;

	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment leadfragment;
		switch (position) {

	    case 0:
	    	//System.out.println("Value"+rowid);
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
             leadfragment = new LeadRegardingId(id);
			break;
	   // case 0:
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            //fragment = new PerticularTaskFragment(rowid);
	    	//leadfragment = new ContactNoteFragment();
	    	//break;
		case 1:
			leadfragment = new PerticularNoteFragment(name);
			break;
		case 2:
			leadfragment = new task_regarding_lead(name);
			break;
		//case 3:	
			//fragment = new ContactNoteFragment();
			//break;
		default:
			leadfragment = new PerticularNoteFragment(name);
			break;
		} 
		Bundle args = new Bundle();
		//args.putInt(FragmentDemo.ARG_OBJECT, id); // Our object is just an //
														// integer :-P
		leadfragment.setArguments(args);
		return leadfragment;
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
			set = "details";
			break;
		case 1:
			set = "notes";
			break;
		case 2:
			set = "Task";
			break;
	///	case 1:
		//	set = "Note";
		//	break;
		//case 2:
		//	set = "Calls";
		//	break;
		}
		return set;
	}
}
