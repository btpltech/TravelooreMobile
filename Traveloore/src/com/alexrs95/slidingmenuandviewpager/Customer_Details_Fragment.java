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
import com.btpl.database.Hotel_Table;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.Package_Table;
import com.btpl.database.Traveller_Details_Table;

@SuppressLint("ValidFragment")
public class Customer_Details_Fragment extends SherlockListFragment  implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{
SimpleCursorAdapter mAdapter;
EditText getId;	
int id;
String strtext,roName,booking_no;
String name;
//String check = "'Himanshu'";
	//setHasOptionsMenu(true);
	//to enable menu item in fragment





public Customer_Details_Fragment(String booking_no) {
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
	String[] from = new String[] {Traveller_Details_Table.id,Traveller_Details_Table.traveller_name,Traveller_Details_Table.t_address,
			Traveller_Details_Table.t_state_name,Traveller_Details_Table.t_zipcode,Traveller_Details_Table.t_m_no,Traveller_Details_Table.t_email,
			Traveller_Details_Table.t_id_type,Traveller_Details_Table.t_id_num};
	   int[] to = new int[] { R.id.textViewgone,R.id.customer_name,R.id.customer_address,
			   R.id.customer_state,R.id.customer_zip_code,R.id.customer_phone_number,R.id.customer_email,R.id.customer_id_type,
			   R.id.customer_id_num};

	   mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.customer_details, null, from, to, 0);
   
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
	//String selection =Traveller_Details_Table.synchPerti  + " = " +booking_no;
	String selection = Traveller_Details_Table.synchPerti +  " = '" + booking_no + "'";

	//String selection = "select" +Deal_Table.association +"FROM" +Deal_Table.TABLE_NAME +"where" +Deal_Table.association +"="+"'Himanshu'";
	String[] columns = new String[] {Traveller_Details_Table.id,Traveller_Details_Table.traveller_name,Traveller_Details_Table.t_address,
			Traveller_Details_Table.t_state_name,Traveller_Details_Table.t_zipcode,
			Traveller_Details_Table.t_m_no,Traveller_Details_Table.t_email,Traveller_Details_Table.t_id_type,
			Traveller_Details_Table.t_id_num,Traveller_Details_Table.traveller,Traveller_Details_Table.synchPerti};
	
	return new CursorLoader(getActivity(), MyDatabaseProvider.TRAVELLER_CONTENT_URI,
			columns, selection , null, null);
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