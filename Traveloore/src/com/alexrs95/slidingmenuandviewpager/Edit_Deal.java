package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.Dialog;
import android.content.ContentValues;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseClass;


public class Edit_Deal extends SherlockActivity implements OnClickListener,
OnItemClickListener {

Dialog dialog, dialog1, dialog2;
Spinner priorityspinner,ownerspinner;
Spinner associtionbtn;
Button refferalbtn;
int rowId;
ArrayList<String> list, list1, list2,list3;
EditText editText1,editText2,editText3,createdon,txtcurrentTime,et_date,et_time;
String dName,dPriority,dAssociation,dValue,dRefferal,dOwner,tableType,date,time,dsasso;
Calendar date1=Calendar.getInstance();
String dNAmeFtech,dValueFetch;
MyDatabaseClass mdc;
String []storeValue;
String user;
private int mm;
private int yy;
private int dd;

//SimpleCursorAdapter madapter;
//String[] FROM = new String[] { Contact_table.firstname};
//int[] TO = new int[] { R.id.associationList};


@Override
protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onCreate(savedInstanceState);
setContentView(R.layout.edit_deal);
user=getIntent().getStringExtra("extra");
ActionBar bar = getSupportActionBar();
bar.setDisplayHomeAsUpEnabled(true);
getSherlock().getActionBar().setIcon(R.drawable.data_edit);
getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
rowId=getIntent().getIntExtra("id", 1);
priorityspinner = (Spinner) findViewById(R.id.priority);
associtionbtn = (Spinner) findViewById(R.id.listofcontacthere);
refferalbtn = (Button) findViewById(R.id.referel);
editText1 = (EditText)findViewById(R.id.editText1);
editText2 = (EditText)findViewById(R.id.editText2);
//ownerspinner = (Spinner)findViewById(R.id.owner);
et_date=(EditText)findViewById(R.id.et_created);
et_time=(EditText)findViewById(R.id.et_createdtime);

mdc= new MyDatabaseClass(this);
mdc.open();
//cursor=mdc.getValueToEdit1(rowId);


storeValue=mdc.getValueToEditDeal(rowId);
dNAmeFtech=storeValue[0];
dValueFetch=storeValue[1];

editText1.setText(dNAmeFtech);
editText2.setText(dValueFetch);


list = new ArrayList<String>();
list.add("Urgent");
list.add("High");
list.add("Low");




list2 = new ArrayList<String>();
list2.add("From Website");
list2.add("From Word Of Mouth");
list2.add("From Friends");
list2.add("NewsPaper");

ArrayAdapter<String> adaptor = new ArrayAdapter<String>(Edit_Deal.this,
		R.layout.priotiryrow, R.id.weekofday, list);
priorityspinner.setAdapter(adaptor);

refferalbtn.setOnClickListener(this);
//getLoaderManager().initLoader(0, null, (android.app.LoaderManager.LoaderCallbacks<Cursor>)this);


MyDatabaseClass hd = new MyDatabaseClass(this);
hd.open();
ArrayList<String> contact = hd.getFirstName(user);
list1 = new ArrayList<String>();
list1.add("add a contact");
list1.addAll(contact);
//Collections.sort(list1);
hd.close();

ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		Edit_Deal.this, R.layout.listofcontacts,R.id.listofcontacthere,list1);

associtionbtn.setAdapter(adapter);






/*MyDatabaseClass mdc = new MyDatabaseClass(this);
mdc.open();
ArrayList<String> owner = mdc.getFirstName();
list3 = new ArrayList<String>();
list3.add("add owner name");
list3.addAll(owner);
mdc.close();

ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
		Add_Deal.this, R.layout.list_of_owner_here,R.id.listofownerhere,list3);
ownerspinner.setAdapter(adapter1);*/




 createdon = (EditText)findViewById(R.id.et_created);
	
 final Calendar c = Calendar.getInstance();
    yy = c.get(Calendar.YEAR);
    mm = c.get(Calendar.MONTH);
    dd = c.get(Calendar.DAY_OF_MONTH);
    createdon.setText(new StringBuilder()
    // Month is 0 based, just add 1
            .append(yy).append(" ").append("-").append(mm + 1).append("-")
            .append(dd));
    
     txtcurrentTime= (EditText)findViewById(R.id.et_createdtime);
    Date dt = new Date();
    int hours = dt.getHours();
    int minutes = dt.getMinutes();
    int seconds = dt.getSeconds();
    String curTime = hours + ":" + minutes + ":" + seconds;
    txtcurrentTime.setText(curTime);
// created by shikha singh
}

@Override
public void onClick(View v) {
	dialog1 = new Dialog(Edit_Deal.this);
	dialog1.setContentView(R.layout.refferallist);
	dialog1.setTitle("Refferal");
	dialog1.setCancelable(true);
	ListView lv1 = (ListView) dialog1.findViewById(R.id.refferallist1);

	ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
			android.R.layout.simple_list_item_1, list2);
	lv1.setAdapter(adapter1);
	lv1.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1,
				int pos, long arg3) {
		String refer=list2.get(pos).toString();
		refferalbtn.setText(refer);
			dialog1.dismiss();
		}
	});

	dialog1.show();
}



//@Override
//public void onItemClick(AdapterView<?> adv, View arg1, int pos, long id) {

//String priority = list1.get(pos).toString();
//associtionbtn.setText(priority);
//dialog.dismiss();
//}


@Override
public boolean onCreateOptionsMenu(Menu menu) {
// TODO Auto-generated method stub
MenuInflater inflater = getSupportMenuInflater();
inflater.inflate(R.menu.edit_deal_menu, menu);
return super.onCreateOptionsMenu(menu);
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {

// TODO Auto-generated method stub
switch(item.getItemId()){
case android.R.id.home:
	Edit_Deal.this.finish();
	break;

case R.id.deal_edit :
	
//created by shikha singh
	dName= editText1.getText().toString();
	dPriority= priorityspinner.getSelectedItem().toString();
	dAssociation= associtionbtn.getSelectedItem().toString();
	dValue= editText2.getText().toString();
	dRefferal= refferalbtn.getText().toString();

	//dOwner= ownerspinner.getSelectedItem().toString();

	date=et_date.getText().toString();
	time=et_time.getText().toString();

	if (TextUtils.isEmpty(dName)) {
		 
		 Toast toast1=Toast.makeText(this, "Some fields are not valid", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.WHITE);
			toast1.show();
			editText1.setError("This field can not be empty");
		
		//focusView = first_name;
		//cancel = true;
		return false;
	} 
	
	String st=associtionbtn.getSelectedItem().toString();
	int con=associtionbtn.getSelectedItemPosition();
	if (con!=0)
	{
		dsasso = associtionbtn.getSelectedItem().toString();  
	}
	else
	{
		Toast toast1 = Toast.makeText(this, "Please choose a contact", Toast.LENGTH_SHORT);
		TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
		v.setTextColor(Color.GREEN);
		toast1.show();
		return false;


	}
	 if(!st.equals("add contact"))  
     {  
         dsasso = associtionbtn.getSelectedItem().toString();  
                    }  
                    else{  
                    	Toast toast2 = Toast.makeText(this, "Please choose a contact", Toast.LENGTH_SHORT);
        				TextView v1 = (TextView) toast2.getView().findViewById(android.R.id.message);
        				v1.setTextColor(Color.GREEN);
        				toast2.show();
          return false; 
                    }
	 
	/* String st1=ownerspinner.getSelectedItem().toString();
		int own=ownerspinner.getSelectedItemPosition();
		if (own!=0)
		{
			dOwner = ownerspinner.getSelectedItem().toString();  
		}
		else
		{
			Toast toast1 = Toast.makeText(this, "Please add a owner", Toast.LENGTH_SHORT);
			TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
			v.setTextColor(Color.GREEN);
			toast1.show();
            return false;
  
		}
		 if(!st.equals("add owner"))  
         {  
             dOwner = ownerspinner.getSelectedItem().toString();  
                        }  
                        else{  
                        	Toast toast1 = Toast.makeText(this, "Please add a owner", Toast.LENGTH_SHORT);
            				TextView v = (TextView) toast1.getView().findViewById(android.R.id.message);
            				v.setTextColor(Color.GREEN);
            				toast1.show();
             return false; 
                        }
	
	
	/*MyDatabaseClass mdc = new MyDatabaseClass(this);
	mdc.open();
	mdc.insert_Lead(dName,dPriority,dAssociation,dValue,dRefferal,dOwner);
	mdc.close();*/
		
		  
	ContentValues cv1 = new ContentValues();
	cv1.put(Deal_Table.dealName, dName);
	cv1.put(Deal_Table.priority, dPriority);
	cv1.put(Deal_Table.association, dAssociation);
	cv1.put(Deal_Table.value, dValue);
	cv1.put(Deal_Table.refferal, dRefferal);
	//cv1.put(Deal_Table.owner, dOwner);
	cv1.put(Deal_Table.tabletype, "deal");
	cv1.put(Deal_Table.cdate, date);
	cv1.put(Deal_Table.ctime, time);
	cv1.put(Deal_Table.modified_date, 2);
	String where = Deal_Table.deal_id + "=" + rowId;
	Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/deal_table/" + rowId);
	getContentResolver().update(uri, cv1, where, null);
	
	//Uri uri = getContentResolver().insert(
	//		MyDatabaseProvider.CONTENT_URI, cv);
	Toast.makeText(getApplicationContext(),"Deal Edited", Toast.LENGTH_SHORT)
			.show();
		Edit_Deal.this.finish();
		 	 	 
	break;
		 		
case R.id.add_Deal:
	Edit_Deal.this.finish();
}
return super.onOptionsItemSelected(item);
}

@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
// TODO Auto-generated method stub

}



}
