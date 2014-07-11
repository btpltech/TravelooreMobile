package com.alexrs95.slidingmenuandviewpager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.Contact_table;
import com.btpl.database.Delete_contact_sync;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;

public class Contact_Fragment extends SherlockListFragment implements
		LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener{

	ListView list;
	//int position;

	SimpleCursorAdapter adapter;
	String mCurFilter;
	int index;
	String generated_code,check;
	TextView t1;


	
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//to enable menu item in fragment
		t1=(TextView)getActivity().findViewById(R.id.lblName);
		check=t1.getText().toString();
		System.out.println("checkkk " + check);
		setHasOptionsMenu(true);
		//set when list is empty
		//setEmptyText("Nothis ");
		String[] FROM = new String[] {Contact_table.contact_id, Contact_table.firstname,Contact_table.phone_no, Contact_table.emailid};
		int[] TO = new int[] {R.id.contact_id, R.id.contact_name,R.id.phone_number, R.id.email};
	
		adapter = new SimpleCursorAdapter(getActivity(),
				R.layout.inflate_contact_list, null, FROM, TO, 0);
		setListAdapter(adapter);
		ListView list = getListView();
		list.setOnItemClickListener(this);
		list.setEmptyView(getActivity().findViewById(R.id.empty));
		
		setListShown(false);
		registerForContextMenu(getListView());
		getLoaderManager().initLoader(0, null, this);
		getActivity().setTitle("Contacts");
		//getActivity().setTitle("Deal");
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.contact);
		   
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		getSherlockActivity().getMenuInflater().inflate(R.menu.context_menu,menu);
	super.onCreateContextMenu(menu, v,menuInfo);
			}
	public boolean onContextItemSelected(android.view.MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
		case R.id.edit:
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			index = info.position;
			editLead((int) info.id);
			
			break;
		case R.id.delete:
			
		AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
	deleteContact(menuinfo.id);
	
		}
		return true;
		/* **********************************end** */
	}

	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getLoaderManager().restartLoader(0, null, this);
	}

		@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		inflater.inflate(R.menu.add_contact_menu, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId())
		{
		case R.id.add_person :
			Intent inte = new Intent(getActivity(), Add_Lead.class);
			inte.putExtra("extra",check);
			startActivity(inte);
			break;
	   case R.id.add_company :
				Intent intentCompany = new Intent(getActivity(),Add_Company.class);
				startActivity(intentCompany);
				break;
		}
		return true;
	}

	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		/*Uri baseUri;
		if (mCurFilter != null) {
			baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,
					Uri.encode(mCurFilter));
		} else {
			baseUri = Contacts.CONTENT_URI;
		}*/
		
		String selection = Contact_table.signinEmail +  " = '" + check + "'";
		String[] columns = new String[] { Contact_table.contact_id,
				Contact_table.firstname,Contact_table.phone_no,Contact_table.emailid};
		return new CursorLoader(getActivity(), MyDatabaseProvider.CONTENT_URI,
				columns, selection, null, null);
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
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;
		//getLoaderManager().restartLoader(0, null, this);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v,int position, long id) {
		// TODO Auto-generated method stub
		TextView rowid=(TextView)v.findViewById(R.id.contact_id);
        TextView txt = (TextView) v.findViewById(R.id.email);
        TextView txtName=(TextView)v.findViewById(R.id.contact_name);
		 //TextView txt_rowid=(TextView)v.findViewById(R.id.contact_id);
		//Toast.makeText(getActivity(), txt_rowid.getText().toString(), Toast.LENGTH_LONG).show();
		//TextView txt_id = (TextView) v.findViewById(R.id.inflatelist_rowid);
		Intent intent = new Intent(getActivity(), ContactDetail.class);
		intent.putExtra("rowid", rowid.getText().toString());
		intent.putExtra("name", txtName.getText().toString());
		intent.putExtra("email", txt.getText().toString());
		//intent.putExtra("rowid", txt_rowid.getText().toString());
		//intent.putExtra("id", )
				startActivity(intent);
		
	}

	/* restart *****/
	public boolean deleteContact(long id)
	{
		MyDatabaseClass mdc=new MyDatabaseClass(getActivity());
		mdc.open();
		String[] values=new String[1];
		values=mdc.getValuesForSyncDeleteContact(id);
		generated_code=values[0];
		ContentValues cv=new ContentValues();
		cv.put(Delete_contact_sync.unique_code,generated_code);
		cv.put(Delete_contact_sync.delete_status, 1);
		getActivity().getContentResolver().insert(MyDatabaseProvider.DELETE_CONTACT_SYNC_URI,cv);
		
		//Toast.makeText(getActivity(),
			//	"return is " + uri.toString(), Toast.LENGTH_SHORT)
				//.show();
		mdc.close();
		getActivity().getContentResolver().delete(MyDatabaseProvider.CONTENT_URI,Contact_table.contact_id +" =" + id,null);
		// finish();
    
	  runOnUiThread(new Runnable() {
          public void run() {
        	 
              adapter.notifyDataSetChanged();
          }
      });
	  adapter.notifyDataSetChanged();
	return true;

	}
	
	public boolean editLead(int id) {
		// TODO Auto-generated method stub
		//TextView txt_rowid=(TextView)getActivity().findViewById(R.id.contact_id);
		Intent intentEdit = new Intent(getActivity(),Add_Contact_Which_Is_Lead_Edit.class);
		
		intentEdit.putExtra("id",index+1);
		intentEdit.putExtra("extra",check);
		startActivity(intentEdit);
		return true;
	}

	
/*
 * Refreshing the list after deleting teh record*/	
	@SuppressWarnings("deprecation")
	private void runOnUiThread(Runnable runnable) {
		adapter.getCursor().requery();
		
	}
	
	
}
