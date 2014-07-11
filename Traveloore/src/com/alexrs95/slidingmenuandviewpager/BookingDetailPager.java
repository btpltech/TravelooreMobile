package com.alexrs95.slidingmenuandviewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class BookingDetailPager extends FragmentStatePagerAdapter {

	int rowid,book_id;
	String set,rowName,rowEmail,book_no,pertiId;
	Context context;

	public BookingDetailPager(FragmentManager fm,int book_id, String book_no, String pertiId) {
		super(fm);
		// TODO Auto-generated constructor stub
		//this.rowid = rowid;
		this.book_no=book_no;
        this.book_id=book_id; 
        this.pertiId=pertiId;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment fragment;
		switch (position) {

		case 0:
			fragment = new Booking_Details_Fragment(book_no);
		    break;
		
		case 1:
			fragment = new Customer_Details_Fragment(pertiId);
		    break;
	    case 2:
	    	//System.out.println("Value"+rowid);
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            fragment = new Package_Details_Fragment(pertiId);
			break;
			
	    case 3:
	    	
	    	fragment = new Booking_Stay_Fragment(pertiId);
	    	break;
	   
        case 4:
	    	
	    	fragment = new Booking_Travel_Fragment(pertiId);
	    	break;
	    
        case 5:
        	fragment = new Booking_Hotel_fragment(book_id);
        	break;
	    	// case 0:
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            //fragment = new PerticularTaskFragment(rowid);
	    	//fragment = new Package_Details_Fragment(book_no);
	    	//break;
		
		default:
			fragment = new Package_Details_Fragment(pertiId);
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
		return 6;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			set = "Booking Details";
			break;
	    case 1:
			set = "Customer Details";
			break;
	    case 2:
	    	set = "Package Details";
		    break;
		
	    case 3:
	    	set="Stay Details";
		    break;
	    case 4:
	    	set="Travel Details";
		    break;
	    case 5:
	    	set="Hotel Details";
	    	break;
		}
		return set;
	}
}
