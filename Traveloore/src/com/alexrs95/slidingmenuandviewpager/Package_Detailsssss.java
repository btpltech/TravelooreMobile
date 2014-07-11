
package com.alexrs95.slidingmenuandviewpager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TextView;


import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import com.btpl.contactfragments.Add_Note_Contact;


public class Package_Detailsssss extends SherlockFragmentActivity {

	ViewPager viewPager;
PackageDetailPager mPagerAdapter;
	String rowid;
	String name;;
	int id_;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.package_detail_fragment);
		
		//SlidingMenu sm = getSlidingMenu();

		//sm.setShadowWidthRes(R.dimen.shadow_width);
		//sm.setShadowDrawable(R.drawable.shadow);
		//sm.setBehindOffsetRes(R.dimen.actionbar_home_width);
		//setSlidingActionBarEnabled(true);
        
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.details);
		name = getIntent().getStringExtra("package");
		id_ =getIntent().getIntExtra("id", 1);
		//rowid = getIntent().getStringExtra("rowid");
		

		//i = Integer.parseInt(rowid);
		TextView text = (TextView) findViewById(R.id.package_detail_name);
		
		text.setText(name);
		
		FragmentManager fm = getSupportFragmentManager();
		viewPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new PackageDetailPager(fm,name,id_);
		viewPager.setAdapter(mPagerAdapter);
		//Toast.makeText(this, i, Toast.LENGTH_LONG).show();
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case android.R.id.home:
				//Intent intentCompany = new Intent(getActivity(),Add_Company.class);
				//startActivity(intentCompany);
			Package_Detailsssss.this.finish();
				break;
		}
		return true;
	}

	
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
