package com.btpl.contactfragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.alexrs95.slidingmenuandviewpager.FragmentDemo;
import com.btpl.database.Contact_table;
import com.btpl.database.MyDatabaseProvider;

public class ContactNoteFragment extends SherlockListFragment implements
		LoaderCallbacks<Cursor>, OnItemClickListener{

	SimpleCursorAdapter adapter;int id;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		id = getArguments().getInt(FragmentDemo.ARG_OBJECT, 1);
		
		setHasOptionsMenu(true);
		// set when list is empty
		setEmptyText("Nothis ");
		String[] FROM = new String[] { Contact_table.contact_detail_notes,Contact_table.contact_detail_notes_contact_table_id};
		int[] TO = new int[] {android.R.id.text1, android.R.id.text2};
		adapter = new SimpleCursorAdapter(getActivity(),
				android.R.layout.simple_list_item_2, null, FROM, TO, 0);
		setListAdapter(adapter);

		ListView list = getListView();
		list.setOnItemClickListener(this);
		getLoaderManager().initLoader(0, null, this);
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getLoaderManager().restartLoader(0, null, this);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		String selection = Contact_table.contact_detail_notes_contact_table_id + "=" + id;
		return new CursorLoader(getActivity(),
				MyDatabaseProvider.NOTES_CONTENT_URI, null, selection, null, null);
	}

	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
		// TODO Auto-generated method stub
		adapter.swapCursor(arg1);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		adapter.swapCursor(null);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
		// TODO Auto-generated method stub
		String s = ((TextView) v.findViewById(android.R.id.text1)).getText().toString();
		//Toast.makeText(getActivity(), s, Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(getActivity(), NoteCurd.class);
		intent.putExtra("extra", s);
		intent.putExtra("rowid",id);
		startActivity(intent);
	}
}
