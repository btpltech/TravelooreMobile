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
import com.btpl.database.AddTask_Table;
import com.btpl.database.MyDatabaseProvider;

@SuppressLint("ValidFragment")
public class task_regarding_lead extends SherlockListFragment  implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{
SimpleCursorAdapter mAdapter;
EditText getId;	
int id;
String strtext,roName;
String name;
String check,add="Leads";
//String check = "'Himanshu'";
	//setHasOptionsMenu(true);
	//to enable menu item in fragment





public task_regarding_lead(String rowName) {
	// TODO Auto-generated constructor stub
this.name=rowName;
check=add + " " + rowName;
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
	String[] from = new String[] {AddTask_Table.addtask_id,AddTask_Table.description,AddTask_Table.date,AddTask_Table.time};
	   int[] to = new int[] {R.id.textId,R.id.textDescription,R.id.textDate,R.id.textTime};

	   mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.task_regarding_leads, null, from, to, 0);
   
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
	String selection = AddTask_Table.fetch_task_lead + " = '" + check + "'";
	//String selection = "select" +Deal_Table.association +"FROM" +Deal_Table.TABLE_NAME +"where" +Deal_Table.association +"="+"'Himanshu'";
	String[] columns = new String[] {AddTask_Table.addtask_id,AddTask_Table.description,AddTask_Table.date,AddTask_Table.time,AddTask_Table.fetch_task_lead};
	
	return new CursorLoader(getActivity(), MyDatabaseProvider.ADDTASK_CONTENT_URI,
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