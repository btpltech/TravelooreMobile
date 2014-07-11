package com.alexrs95.slidingmenuandviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ContactDetailPagerAdapter extends FragmentStatePagerAdapter {

	int rowid;
	String set,rowName,rowEmail;
	Context context;

	public ContactDetailPagerAdapter(FragmentManager fm, String name,String email) {
		super(fm);
		// TODO Auto-generated constructor stub
		//this.rowid = rowid;
		this.rowName = name;
		this.rowEmail= email;

	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment fragment;
		switch (position) {

	    case 0:
	    	//System.out.println("Value"+rowid);
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            fragment = new PerticularDealsFragment(rowName);
			break;
	    case 1:
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            //fragment = new PerticularTaskFragment(rowid);
	    	fragment = new Note_For_Contacts(rowEmail);
	    	break;
		case 2:
			fragment = new Task_regarding_Contacts(rowName);
		    break;
		//case 3:	
			//fragment = new ContactNoteFragment();
			//break;
		default:
			fragment = new PerticularDealsFragment(rowName);
			break;
		} 
		Bundle args = new Bundle();
		//args.putInt(FragmentDemo.ARG_OBJECT, rowid); // Our object is just an //
														// integer :-P
		fragment.setArguments(args);
		return fragment;
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
			set = "Deals";
			break;
	    case 1:
			set = "Notes";
			break;
	    case 2:
	    	set = "Tasks";
		}
		return set;
	}
}
