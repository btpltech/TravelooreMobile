
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


public class ContactDetail extends SherlockFragmentActivity {

	ViewPager viewPager;
	ContactDetailPagerAdapter mPagerAdapter;
	String rowid;
	String firstName,rowEmail,phone;
	int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.contactdetailfragment);
		
		//SlidingMenu sm = getSlidingMenu();

		//sm.setShadowWidthRes(R.dimen.shadow_width);
		//sm.setShadowDrawable(R.drawable.shadow);
		//sm.setBehindOffsetRes(R.dimen.actionbar_home_width);
		//setSlidingActionBarEnabled(true);
        
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.details);
		firstName = getIntent().getStringExtra("name");
		rowid = getIntent().getStringExtra("rowid");
		rowEmail=getIntent().getStringExtra("email");
		phone=getIntent().getStringExtra("phone");

		i = Integer.parseInt(rowid);
		TextView text = (TextView) findViewById(R.id.contactdetail_name);
		TextView phoneText =(TextView) findViewById(R.id.contactdetail_phone);
		text.setText(firstName);
		phoneText.setText(phone);
		FragmentManager fm = getSupportFragmentManager();
		viewPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new ContactDetailPagerAdapter(fm,firstName,rowEmail);
		viewPager.setAdapter(mPagerAdapter);
		//Toast.makeText(this, i, Toast.LENGTH_LONG).show();
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.contactdetail, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home :
			ContactDetail.this.finish();
			break;
		
		case R.id.add_peri_deal1 :
			Intent intent1 = new Intent(this,Add_Deal.class);
			startActivity(intent1);
			break;
		
		case R.id.contactdetail_addNote:
			Intent intent = new Intent(ContactDetail.this, Add_Note_Contact.class);
			intent.putExtra("email", rowEmail);
			intent.putExtra("name", firstName);
			intent.putExtra("extra",i);
			startActivity(intent);
			//System.out.println("Note added");
			break;
		case R.id.contactdetail_addTask:
			Intent intentTask = new Intent(this,Add_Task.class);
			startActivity(intentTask);
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
