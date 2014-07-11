package com.alexrs95.slidingmenuandviewpager;


import java.util.HashMap;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.widget.TextView;


import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.MyDatabaseClass;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	public ViewPager mViewPager;
	protected ListFragment mFrag;
 	public static boolean flag=true;
 	SessionManager session;
 	MyDatabaseClass mdc;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.view_pager_and_titles);
		setContentView(R.layout.my_layout);
		session = new SessionManager(getApplicationContext());
        
       
		
         session.checkLogin();
        
		//for(int i=0;i<22;i++)
		//System.out.println("values get..."+values.get(i));
		//ContentValues cv = new ContentValues();
		//cv.put(SynchronizationTable.SynchronizationId,1);
		//Uri uri = getApplicationContext().getContentResolver().insert(
		//		MyDatabaseProvider.SYNCH_CONTENT_URI, cv);
		//System.out.println("inserted data.. "+uri.toString());
		
			

		//session = new SessionManager(getApplicationContext());
        
        TextView lblName = (TextView) findViewById(R.id.lblName);
        TextView lblEmail = (TextView) findViewById(R.id.lblEmail);
        TextView lblServer = (TextView) findViewById(R.id.lblServer);
        
		
        // session.checkLogin();
        
         HashMap<String, String> user = session.getUserDetails();
         
         // name
         String name = user.get(SessionManager.KEY_EMAIL);
         
         // email
         String email = user.get(SessionManager.KEY_PASSWORD);
         
         String serverIp = user.get(SessionManager.KEY_SERVERIP);

         // displaying user data
         lblName.setText(Html.fromHtml("<b>" + name + "</b>"));
         lblEmail.setText(Html.fromHtml("<b>" + email + "</b>"));
         lblServer.setText(Html.fromHtml("<b>" + serverIp + "</b>"));
				
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		DashBoard_Fragment my = new DashBoard_Fragment();
		
		// only adding Dashboard fragment for the first time only, removing problem with orientation change.
		if(flag==true)
		{
			t.add(R.id.my_id, my);
			
		}
	
		//setting the sliding menu
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		
		mFrag = new SampleListFragment();
		t.replace(R.id.menu_frame, mFrag);
		t.commit();

		// customize the SlidingMenu
		SlidingMenu sm = getSlidingMenu();
		
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.actionbar_home_width);
		setSlidingActionBarEnabled(true);
        //end of setting sliding menu
		
		final ActionBar mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
	}
		
	@Override
	public void onBackPressed() {
		Intent intent= new Intent(this,MainActivity.class);
		startActivity(intent);
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.activity_main :
			session.logoutUser();
			break;
		case android.R.id.home :
			toggle();
		}
		return super.onOptionsItemSelected(item);
	}

}
