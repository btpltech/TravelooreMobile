package com.alexrs95.slidingmenuandviewpager;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.Booking_Table;
import com.btpl.database.Contact_table;
import com.btpl.database.Deal_Table;
import com.btpl.database.Hotel_Table;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.Package_Table;

@SuppressLint("ValidFragment")
public class Booking_Details_Fragment extends SherlockListFragment  implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{
SimpleCursorAdapter mAdapter;
EditText getId;	
int id;
String strtext,roName,booking_no;
String name;
//String check = "'Himanshu'";
	//setHasOptionsMenu(true);
	//to enable menu item in fragment





public Booking_Details_Fragment(String booking_no) {
	// TODO Auto-generated constructor stub
this.booking_no=booking_no;
}



@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
 // String rowid = getArguments().getString("id"); //Returns your string value
  //  String strtext=getArguments().getString("id");

	return super.onCreateView(inflater, container, savedInstanceState);
}



public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub

	super.onActivityCreated(savedInstanceState);
	String[] from = new String[] {Booking_Table._id,Booking_Table.booking_number,Booking_Table.booking_date,Booking_Table.start_date,
			Booking_Table.end_date,Booking_Table.advance_amount,Booking_Table.total_amount,Booking_Table.customer_name,
			Booking_Table.address,Booking_Table.phone,Booking_Table.email};
	   int[] to = new int[] { R.id.id_____,R.id.booking_number,R.id.booking_date,R.id.start_date,R.id.end_date,
			   R.id.advance_amount,R.id.total_amount,R.id.customer_name,R.id.address,R.id.phone_number,
			   R.id.email_id};

	   mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.booking_details_fragment, null, from, to, 0);
   
   setListAdapter(mAdapter);
   ListView list = getListView();
  // list = (ListView) getActivity().findViewById(android.R.id.list);
   list.setEmptyView(getActivity().findViewById(R.id.empty));

   setListShown(false);
   getLoaderManager().initLoader(0, null, this);
   getActivity().setTitle("Details");
   getSherlockActivity().getSupportActionBar().setIcon(R.drawable.details);
   //getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
  // Toast.makeText(getActivity(),"Value of Id" +strtext, Toast.LENGTH_LONG).show();

       

	}


@Override
public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
	
}

@Override
public boolean onQueryTextSubmit(String query) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean onQueryTextChange(String newText) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
	// TODO Auto-generated method stub
	//String selection = Booking_Table.synchId + " = " +booking_no;
	String selection = Booking_Table.booking_number +  " = '" + booking_no + "'";

	///String selection = "select" +Deal_Table.association +"FROM" +Deal_Table.TABLE_NAME +"where" +Deal_Table.association +"="+"'Himanshu'";
	String[] columns = new String[] {Booking_Table._id,Booking_Table.booking_number,Booking_Table.booking_date,Booking_Table.start_date,
			Booking_Table.end_date,Booking_Table.advance_amount,Booking_Table.total_amount,
			Booking_Table.customer_name,Booking_Table.address,Booking_Table.phone,Booking_Table.email,Booking_Table.synchId};
	
	return new CursorLoader(getActivity(), MyDatabaseProvider.BOOKING_CONTENT_URI,
			columns, selection, null, null);
	//return new CursorLoader(getActivity(), MyDatabaseProvider.DEAL_CONTENT_URI, projection, selection, selectionArgs, sortOrder)
}

@Override
public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
	// TODO Auto-generated method stub
mAdapter.swapCursor(arg1);
	
	//The list should be shown now
if(isResumed()){
		setListShown(true);
               }
	else{
		setListShownNoAnimation(true);
	}
}

@Override
public void onLoaderReset(Loader<Cursor> arg0) {
	mAdapter.swapCursor(null);
	
}

	
@Override
public void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	getLoaderManager().restartLoader(0, null, this);
}

}