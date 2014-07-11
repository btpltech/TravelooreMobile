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
import com.btpl.contactfragments.AddNote_Deal;



public class DealDetails extends SherlockFragmentActivity {

	ViewPager dealViewPager;
	DealDetailsPager dealPagerAdapter;
	String rowid,extra;
	String firstName;
	int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.deal_details_fragment);
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.details);
		firstName = getIntent().getStringExtra("name");
		rowid = getIntent().getStringExtra("rowid");

		i = Integer.parseInt(rowid);
		TextView text = (TextView) findViewById(R.id.dealdetail_name);
		text.setText(firstName);
		FragmentManager dealfm = getSupportFragmentManager();
		dealViewPager = (ViewPager) findViewById(R.id.deal_pager);
		dealPagerAdapter = new DealDetailsPager(dealfm,i,firstName);
		dealViewPager.setAdapter(dealPagerAdapter);
		//Toast.makeText(this, i, Toast.LENGTH_LONG).show();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.deal_details_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home :
			DealDetails.this.finish();
			break;
		case R.id.deal_detail_addNote:
			Intent intent = new Intent(this, AddNote_Deal.class);
			intent.putExtra("extra",rowid);
			intent.putExtra("name",firstName);
			startActivity(intent);
			//System.out.println("Note added");
			break;
		case R.id.deal_detail_addTask:
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
