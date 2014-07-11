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
import com.btpl.contactfragments.AddNote;

public class LeadsDetails extends SherlockFragmentActivity {

	ViewPager leadViewPager;
	LeadDetailsPager leadPagerAdapter;
	String rowid,extra;
	String firstName;
	int i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.leads_details_fragment);
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setIcon(R.drawable.details);
		firstName = getIntent().getStringExtra("name");
		rowid = getIntent().getStringExtra("rowid");

		i = Integer.parseInt(rowid);
		TextView text = (TextView) findViewById(R.id.leaddetail_name);
		text.setText(firstName);
		FragmentManager leadfm = getSupportFragmentManager();
		leadViewPager = (ViewPager) findViewById(R.id.lead_pager);
		leadPagerAdapter = new LeadDetailsPager(leadfm,i,firstName);
		leadViewPager.setAdapter(leadPagerAdapter);
		//Toast.makeText(this, i, Toast.LENGTH_LONG).show();
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.lead_detail_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home :
			LeadsDetails.this.finish();
			break;
		case R.id.deal_detail_addNote:
			Intent intent = new Intent(this, AddNote.class);
			intent.putExtra("extra",i);
			intent.putExtra("name",firstName);
			startActivity(intent);
			//System.out.println("Note added");
			break;
		case R.id.lead_detail_addTask:
			Intent intentTask = new Intent(LeadsDetails.this,Add_Task.class);
			startActivity(intentTask);
			break;
		//case R.id.add_peri_deal :
			//Intent intentEdit = new Intent(this,Add.class);
			///startActivity(intentEdit);
			//break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
}
