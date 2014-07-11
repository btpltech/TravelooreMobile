package com.btpl.contactfragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.alexrs95.slidingmenuandviewpager.R;
import com.btpl.database.ContactDetail_Table;
import com.btpl.database.MyDatabaseClass;

public class ContactTasksFragment extends SherlockFragment {

	ListView list;
	MyDatabaseClass database;
	SimpleCursorAdapter adapter;
	Cursor cursor;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.add_package, container, false);
		initialize(v);
		return v;
	}

	private void initialize(View v) {
		list = (ListView) v.findViewById(R.id.package_list);
		TextView xt = (TextView) v.findViewById(R.id.empty);
		list.setEmptyView(xt);

		database = new MyDatabaseClass(getActivity());
		database.open();
		inflateList();
	}

	@SuppressWarnings("deprecation")
	private void inflateList() {
		cursor = database.getCursorfromContactdatail();
		String[] FROM = new String[] { ContactDetail_Table.content,
				ContactDetail_Table.date, ContactDetail_Table.id };
		int[] TO = new int[] {};
		getActivity().startManagingCursor(cursor);
		adapter = new SimpleCursorAdapter(getActivity(), R.layout.dashinflater,
				cursor, FROM, TO);
		list.setAdapter(adapter);
	}
}
