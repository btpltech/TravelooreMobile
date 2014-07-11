package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;

import com.actionbarsherlock.app.SherlockListFragment;

import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.Booking_Table;
import com.btpl.database.MyDatabaseProvider;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Booking_Fragments extends SherlockListFragment implements
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{

ListView list;

SimpleCursorAdapter adapter;
String mCurFilter;
int index;
String generated_code,user,pass;
TextView t1,t2;
ArrayList<String> alist=new ArrayList<String>();



@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
	
}



@Override
public void onActivityCreated(Bundle savedInstanceState) {
// TODO Auto-generated method stub
super.onActivityCreated(savedInstanceState);
t1=(TextView)getActivity().findViewById(R.id.lblName);
t2=(TextView)getActivity().findViewById(R.id.lblEmail);
user=t1.getText().toString();
pass=t2.getText().toString();
System.out.println("checkkk " + user);
setHasOptionsMenu(true);
//set when list is empty
//setEmptyText("Nothis ");
String[] FROM = new String[] {Booking_Table._id,Booking_Table.booking_number,Booking_Table.package_name,
		Booking_Table.customer_name,Booking_Table.email,Booking_Table.synchId,Booking_Table.synchPerti};
int[] TO = new int[] {R.id.booking_id, R.id.booking_number,R.id.package_name,R.id.customer_name, R.id.customer_email,R.id.synch_id,R.id.synch_id_perti};

adapter = new SimpleCursorAdapter(getActivity(),
		R.layout.booking_list, null, FROM, TO, 0);
setListAdapter(adapter);
ListView list = getListView();
list.setOnItemClickListener(this);
list.setEmptyView(getActivity().findViewById(R.id.empty));

setListShown(false);
registerForContextMenu(getListView());
getLoaderManager().initLoader(0, null, this);
getActivity().setTitle("Booking");
//getActivity().setTitle("Deal");
getSherlockActivity().getSupportActionBar().setIcon(R.drawable.booking);
//getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
}



@Override
public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
	// TODO Auto-generated method stub
	TextView pertiId=(TextView)v.findViewById(R.id.synch_id_perti);
    TextView txt = (TextView) v.findViewById(R.id.synch_id);
    TextView txtName=(TextView)v.findViewById(R.id.booking_number);
	
	Intent intent = new Intent(getActivity(), BookingDetails.class);
	
	intent.putExtra("booking", Integer.parseInt(txt.getText().toString()));
	intent.putExtra("booking_no", txtName.getText().toString());
	intent.putExtra("pertiId", pertiId.getText().toString());
	//intent.putExtra("id", )
			startActivity(intent);
	
	
	
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
	String selection = Booking_Table.perticularBooking +  " = '" + user + "'";
	String[] columns = new String[] { Booking_Table._id,Booking_Table.booking_number,
			Booking_Table.customer_name,Booking_Table.email,Booking_Table.synchId,Booking_Table.perticularBooking,Booking_Table.synchPerti};
	return new CursorLoader(getActivity(), MyDatabaseProvider.BOOKING_CONTENT_URI,
			columns,selection, null, null);
}



@Override
public void onLoadFinished(Loader<Cursor> arg0, Cursor this_cursor) {
	// TODO Auto-generated method stub
	adapter.swapCursor(this_cursor);
	
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
	// TODO Auto-generated method stub
	adapter.swapCursor(null);
	
	
}}