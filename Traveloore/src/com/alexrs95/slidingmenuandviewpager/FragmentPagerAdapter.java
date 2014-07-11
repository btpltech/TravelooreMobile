package com.alexrs95.slidingmenuandviewpager;

import com.btpl.contactfragments.ContactNoteFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {

	String set,user;
	public FragmentPagerAdapter(FragmentManager fm,String user) {
		super(fm);
		this.user=user;
	}

	public FragmentPagerAdapter(FragmentManager fm) {
		// TODO Auto-generated constructor stub
		super(fm);
	}

	@Override
	public Fragment getItem(int i) {
		Fragment fragment;
		switch(i)
		{
		case 0:
		fragment = new TotalDealsClass(user);
		break;
		
		//case 1 :
		//fragment = new ContactNoteFragment();	
		//break;
		case 1 :
		fragment = new TotalDealWorth(user);	
		break;
		
		case 2 :
			fragment = new DealsInPipeline(user);
			break;
		default :
		fragment = new ContactNoteFragment();
		break;
		}
		Bundle args = new Bundle();
		//args.putInt(FragmentDemo.ARG_OBJECT, i + 1); // Our object is just an
														// integer :-P
		fragment.setArguments(args);
		return fragment;
		
		}

	@Override
	public int getCount() {
		return 3;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch(position){
		case 0:
			set = "Total Deals";
			break;
		//case 1:
			//set = "Deals In Pipeline";
			//break;
		case 1:
			set = "Deal Worth";
			break;
		
		case 2:
			set = "Deals in Pipeline";
			break;
		}
		return set;
	}

	

	
}
