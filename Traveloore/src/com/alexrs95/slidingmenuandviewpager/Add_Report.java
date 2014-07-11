package com.alexrs95.slidingmenuandviewpager;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


public class Add_Report extends SherlockActivity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_report);

		setTitle("Add Report");
		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);

		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.add_lead_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case android.R.id.home :
			Add_Report.this.finish();
			break;
		case R.id.add_Report:
			Add_Report.this.finish();
			break;
		case R.id.cancel:
			Add_Report.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
