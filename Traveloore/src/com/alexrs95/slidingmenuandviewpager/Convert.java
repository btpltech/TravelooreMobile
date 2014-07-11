package com.alexrs95.slidingmenuandviewpager;


import java.util.Calendar;
import java.util.Date;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.AddTask_Table;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseProvider;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Convert<chk12> extends SherlockFragmentActivity implements OnClickListener{
	
	TextView name;
	EditText showName,createdon,txtcurrentTime;
	String getName;
	
	LinearLayout createdeal , createtask;
	Boolean checkDeal,checkTask;
	CheckBox chk1,chk2;
	String firstName,rowid;
	EditText date,time;
	
	private int mm;
	private int yy;
	private int dd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.convert);
		chk1=(CheckBox)findViewById(R.id.checkBox1);
		chk2=(CheckBox)findViewById(R.id.checkBox2);
		showName=(EditText)findViewById(R.id.convertname);
		//getName=showName.getText().toString();
		//Create();
		//initialize();
		firstName = getIntent().getStringExtra("name");
		rowid = getIntent().getStringExtra("rowid");
		showName.setText(firstName);

	
		//chk2.setOnClickListener(this);
		 createdon = (EditText)findViewById(R.id.et_created);
			
		 final Calendar c = Calendar.getInstance();
		    yy = c.get(Calendar.YEAR);
		    mm = c.get(Calendar.MONTH);
		    dd = c.get(Calendar.DAY_OF_MONTH);
		    createdon.setText(new StringBuilder()
		    // Month is 0 based, just add 1
		            .append(yy).append(" ").append("-").append(mm + 1).append("-")
		            .append(dd));
		    
		     txtcurrentTime= (EditText)findViewById(R.id.et_created_time);
            Date dt = new Date();
            int hours = dt.getHours();
            int minutes = dt.getMinutes();
            int seconds = dt.getSeconds();
            String curTime = hours + ":" + minutes + ":" + seconds;
            txtcurrentTime.setText(curTime);
        // created by shikha singh
            
            
            
            
            createdeal = (LinearLayout) findViewById(R.id.createDeallayout);
    		chk1.setOnClickListener(this);
    		hide(createdeal);

}

	
	public void hide(LinearLayout id) {
		// TODO Auto-generated method stub
		id.setVisibility(View.GONE);
		
	}
	public void show(LinearLayout id) {
		// TODO Auto-generated method stub
		id.setVisibility(View.VISIBLE);
		
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getSupportMenuInflater().inflate(R.menu.convert_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.convert:
			date=(EditText)findViewById(R.id.et_created);
			time=(EditText)findViewById(R.id.et_created_time);
			if(chk1.isChecked()==true){
				ContentValues cv1 = new ContentValues();
				cv1.put(Deal_Table.dealName, firstName);
				cv1.put(Deal_Table.priority, "null");
				cv1.put(Deal_Table.association, "null");
				cv1.put(Deal_Table.value, "null");
				cv1.put(Deal_Table.refferal, "null");
				//cv1.put(Deal_Table.owner, "null");
				cv1.put(Deal_Table.tabletype, "deal");
				cv1.put(Deal_Table.cdate, date.getText().toString());
				cv1.put(Deal_Table.ctime, time.getText().toString());

				Uri uri = getContentResolver().insert(
						MyDatabaseProvider.DEAL_CONTENT_URI, cv1);
				 Toast.makeText(getApplicationContext(),
					"return is " + uri.toString(), Toast.LENGTH_SHORT)
			   		.show();
					Convert.this.finish();}
if(chk1.isChecked()==true){
	ContentValues cv2 = new ContentValues();
	cv2.put(AddTask_Table.description, firstName);
	cv2.put(AddTask_Table.date, date.getText().toString() );
	cv2.put(AddTask_Table.time, time.getText().toString());
	//cv2.put(AddTask_Table.associatedwith, associatedwith.getSelectedItem().toString());
	cv2.put(AddTask_Table.assignedto, "null");
	cv2.put(AddTask_Table.tabletype,"addtask");
	Uri uri = getContentResolver().insert(
			MyDatabaseProvider.ADDTASK_CONTENT_URI, cv2);
	 Toast.makeText(getApplicationContext(),
		"return is " + uri.toString(), Toast.LENGTH_SHORT)
   		.show();
	
				Convert.this.finish();
}
		
		case R.id.cancel :
			this.finish();
		}
		return super.onOptionsItemSelected(item);
	}

	
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		CheckBox mybutton = (CheckBox) arg0;

		String text = (String) mybutton.getText();
		if (text == chk1.getText()) {
			if (createdeal.getVisibility() == View.VISIBLE) {
				chk1.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(createdeal);
			} else {
				chk1.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(createdeal);
			}
		
	}

	

	
	}

	
}

