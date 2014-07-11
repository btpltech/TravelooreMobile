package com.alexrs95.slidingmenuandviewpager;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PackageDetailPager extends FragmentStatePagerAdapter {

	int id;
	String set,rowName;
	Context context;

	public PackageDetailPager(FragmentManager fm, String name,int id) {
		super(fm);
		// TODO Auto-generated constructor stub
		//this.id = rowid;
		this.rowName = name;
		this.id = id;

	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		Fragment packagefragment;
		switch (position) {

	    case 0:
	    	
	    	//System.out.println("Value"+rowid);
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            packagefragment = new PackageOptions(id);
			break;
	    case 1:
			//Toast.makeText(context, rowid, Toast.LENGTH_LONG).show();
            //fragment = new PerticularTaskFragment(rowid);
	    	packagefragment = new StayPackageOptions(id);
	    	break;
		case 2:	
			packagefragment = new HotelRegardingPackage(id);
			break;
		default:
			packagefragment = new PackageOptions(id);
			break;
		} 
		Bundle args = new Bundle();
		args.putInt(FragmentDemo.ARG_OBJECT, id); // Our object is just an //
														// integer :-P
		packagefragment.setArguments(args);
		return packagefragment;
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
			set = "Package Details";
			break;
		
		case 1:
			set = "Stay Details";
			break;
		case 2:
			set = "Hotel Details";
		//	break;
		}
		return set;
	}
}
