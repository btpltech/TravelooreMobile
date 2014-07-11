package com.alexrs95.slidingmenuandviewpager;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.contactfragments.NoteCurd1;
import com.btpl.database.Contact_table;
import com.btpl.database.MyDatabaseProvider;

@SuppressLint("ValidFragment")
public class Note_For_Deals extends SherlockListFragment  implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{
SimpleCursorAdapter mAdapter;
EditText getId;	
int id;
String strtext,strName;
String name;
	//setHasOptionsMenu(true);
	//to enable menu item in fragment





public Note_For_Deals(int rowid) {
	// TODO Auto-generated constructor stub
//this.id = rowid;
this.id=rowid;
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
	String[] from = new String[] {Contact_table.contact_detail_notes_id,Contact_table.contact_detail_notes};
   int[] to = new int[] {R.id.perticular_note_id,R.id.perticular_note_details};

   mAdapter = new SimpleCursorAdapter(getActivity(),R.layout.perticular_note_fragment, null, from, to, 0);
   
   setListAdapter(mAdapter);
   ListView list = getListView();
  // list = (ListView) getActivity().findViewById(android.R.id.list);
   list.setEmptyView(getActivity().findViewById(R.id.empty));
   list.setOnItemClickListener(Note_For_Deals.this);
   setListShown(false);
   getLoaderManager().initLoader(0, null, this);
   getActivity().setTitle("Details");
   getSherlockActivity().getSupportActionBar().setIcon(R.drawable.details);
   //getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
   //Toast.makeText(getActivity(),"Value of Id" +strtext, Toast.LENGTH_LONG).show();

       

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
	String selection = Contact_table.contact_detail_notes_contact_table_id + " = '" + id + "'";
	///String selection = Deal_Table.association + " = '" + roName + "'";
	String[] columns = new String[] {Contact_table.contact_detail_notes_id,Contact_table.contact_detail_notes};
	
	return new CursorLoader(getActivity(), MyDatabaseProvider.NOTES_CONTENT_URI,
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

@Override
public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
	//Toast.makeText(v.getContext(), "Hello", Toast.LENGTH_LONG).show();
	// TODO Auto-generated method stub
	String s = ((TextView) v.findViewById(R.id.perticular_note_details)).getText().toString();
	String rowid = ((TextView) v.findViewById(R.id.perticular_note_id)).getText().toString();
	
	//Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
	Intent intent = new Intent(getActivity(), NoteCurd1.class);
	intent.putExtra("extra", s);
	intent.putExtra("name", rowid);
	intent.putExtra("id", position+1);
	
	startActivity(intent);
}

}



