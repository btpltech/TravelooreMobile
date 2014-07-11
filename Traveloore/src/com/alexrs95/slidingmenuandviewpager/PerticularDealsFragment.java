package com.alexrs95.slidingmenuandviewpager;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseProvider;

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


@SuppressLint("ValidFragment")
public class PerticularDealsFragment extends SherlockListFragment  implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{
SimpleCursorAdapter mAdapter;
EditText getId;	
int id;
String strtext;
String name;
	//setHasOptionsMenu(true);
	//to enable menu item in fragment





PerticularDealsFragment(String rowName) {
	// TODO Auto-generated constructor stub
this.name=rowName;
}



@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	
 // String rowid = getArguments().getString("id"); //Returns your string value
    String strtext=getArguments().getString("id");

	return super.onCreateView(inflater, container, savedInstanceState);
}



public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub

	super.onActivityCreated(savedInstanceState);
	String[] from = new String[] { Deal_Table.deal_id,Deal_Table.dealName, Deal_Table.priority,Deal_Table.association};
   int[] to = new int[] { R.id.deal_id,R.id.deal_name, R.id.deal_priority,R.id.deal_owner};

   mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.perticular_deal_fragment, null, from, to, 0);
   
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
//Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();	
//Intent in = new Intent(getActivity(),ContactDetail.class);
//startActivity(in);
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
	String selection = Deal_Table.association + " = '" + name + "'";
	//KEY_BOOK + "='" + bkString + "'"
	String[] columns = new String[] { Deal_Table.deal_id,
			Deal_Table.dealName, Deal_Table.priority,Deal_Table.association};
	
	return new CursorLoader(getActivity(), MyDatabaseProvider.DEAL_CONTENT_URI,
			columns, selection, null, null);

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