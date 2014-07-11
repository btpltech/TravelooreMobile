package com.alexrs95.slidingmenuandviewpager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class BookingDetails extends SherlockFragmentActivity {

	ViewPager viewPager;
BookingDetailPager mPagerAdapter;
	String rowid;
	String book,username,password,book_no;
	int i,book_id;
	String pertiId;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.booking_detail_fragment);
		
		//SlidingMenu sm = getSlidingMenu();

		//sm.setShadowWidthRes(R.dimen.shadow_width);
		//sm.setShadowDrawable(R.drawable.shadow);
		//sm.setBehindOffsetRes(R.dimen.actionbar_home_width);
		//setSlidingActionBarEnabled(true);
        
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.details);
		book_id = getIntent().getIntExtra("booking",1);
		book_no=getIntent().getStringExtra("booking_no");
		pertiId=getIntent().getStringExtra("pertiId");

		//username=getIntent().getStringExtra("username");
		//password=getIntent().getStringExtra("password");
		//rowid = getIntent().getStringExtra("rowid");
		
//book_no=Integer.parseInt(book);
		//i = Integer.parseInt(rowid);
		//TextView text = (TextView) findViewById(R.id.package_detail_name);
		
		//text.setText(name);
		
		FragmentManager fm = getSupportFragmentManager();
		viewPager = (ViewPager) findViewById(R.id.pager);
		mPagerAdapter = new BookingDetailPager(fm,book_id,book_no,pertiId);
		viewPager.setAdapter(mPagerAdapter);
		//Toast.makeText(this, i, Toast.LENGTH_LONG).show();
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		//inflater.inflate(R.menu.add_package_menu, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {

		case android.R.id.home:
			BookingDetails.this.finish();
			break;
		
	case R.id.book_now:
		Intent intentPackage = new Intent(this,Booking_Classs.class);
		intentPackage.putExtra("rowid",i);
		intentPackage.putExtra("username",username);
		intentPackage.putExtra("password",password);
		startActivity(intentPackage);
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

