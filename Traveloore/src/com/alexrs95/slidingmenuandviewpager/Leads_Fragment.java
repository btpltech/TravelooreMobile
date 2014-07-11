package com.alexrs95.slidingmenuandviewpager;


import java.util.ArrayList;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.Delete_Lead_sync;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.NLead_Table;

public class Leads_Fragment extends SherlockListFragment implements
		LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener {

	ListView list;

	SimpleCursorAdapter adapter;
	String mCurFilter;
	int index;
	String generated_code,check;
	TextView t1;
	ArrayList<String> alist=new ArrayList<String>();
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		t1=(TextView)getActivity().findViewById(R.id.lblName);
		check=t1.getText().toString();
		System.out.println("ckeckk" + check);
		setRetainInstance(true);
		//to enable menu item in fragment
		setHasOptionsMenu(true);
		//set when list is empty
		//setEmptyText("Nothis ");
		String[] FROM_LEAD = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.phone_no,NLead_Table.emailAddress};
		int[] TO_LEAD = new int[] { R.id.lead_id,R.id.lead_firstName,R.id.lead_contactNumber,R.id.lead_email};
	
		adapter = new SimpleCursorAdapter(getActivity(),
				R.layout.lead_list, null, FROM_LEAD, TO_LEAD, 0);
		setListAdapter(adapter);
		
		ListView list = getListView();
		
		
		list.setOnItemClickListener(this);
		list.setEmptyView(getActivity().findViewById(R.id.empty));
		
		setListShown(false);
		registerForContextMenu(getListView());
		getLoaderManager().initLoader(0, null, this);
		getActivity().setTitle("Lead");
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.leads);
		//getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		getSherlockActivity().getMenuInflater().inflate(R.menu.context_menu_lead,menu);
	super.onCreateContextMenu(menu, v,menuInfo);
			}
	public boolean onContextItemSelected(android.view.MenuItem item) {
		// TODO Auto-generated method stub
		
		switch(item.getItemId())
		{
		case R.id.edit:
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			//index = info.position;
			editLead((int)info.id);
			//Intent intentEdit  =new Intent (getActivity(),Edit_Lead.class);
			//intentEdit.putS
			//startActivity(intentEdit);
			break;
		case R.id.delete:
			
		AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
	deleteLead(menuinfo.id);
		break;
		case R.id.convert :
			AdapterView.AdapterContextMenuInfo menuinfo1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
			 Intent intentConvert = new Intent(getActivity(),Convert.class);
			 TextView txt = (TextView) getActivity().findViewById(R.id.lead_firstName);
			 TextView txt_rowid = (TextView) getActivity().findViewById(R.id.lead_id);
				
			 intentConvert.putExtra("name", txt.getText().toString());
			 intentConvert.putExtra("rowid", txt_rowid.getText().toString());
			 startActivity(intentConvert);
			 deleteLead(menuinfo1.id);
			break;
		}
		return true;
	}
	
	public boolean editLead(int id) {
		// TODO Auto-generated method stub
		//TextView txt_rowid=(TextView)getActivity().findViewById(R.id.contact_id);
		Intent intentEdit = new Intent(getActivity(),Edit_Lead.class);
		
		intentEdit.putExtra("id",id);
		intentEdit.putExtra("extra",check);
		startActivity(intentEdit);
		return true;
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
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.add_lead_fragment_sign, menu);
	}
				
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.add_lead_ok) {
			Intent inte = new Intent(getActivity(), Add_Contact_Which_Is_Lead.class);
			inte.putExtra("extra", check);
			startActivity(inte);
		}
		return super.onOptionsItemSelected(item);
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
		String selection = NLead_Table.signinEmail +  " = '" + check + "'";
		String[] columns = new String[] {NLead_Table.lead_id,NLead_Table.firstname,NLead_Table.phone_no,NLead_Table.emailAddress};
		return new CursorLoader(getActivity(), MyDatabaseProvider.LEAD_CONTENT_URI,
				columns, selection, null, null);
	}
	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;
		//getLoaderManager().restartLoader(0, null, this);
		return true;
	}
	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		// TODO Auto-generated method stub
		 TextView txt = (TextView) v.findViewById(R.id.lead_firstName);
			
			TextView txt_rowid = (TextView) v
					.findViewById(R.id.lead_id);
			//Toast.makeText(getActivity(), txt_rowid.getText().toString(), Toast.LENGTH_LONG).show();
			//TextView txt_id = (TextView) v.findViewById(R.id.inflatelist_rowid)
			Intent intentLead = new Intent(getActivity(),LeadsDetails.class);
			intentLead.putExtra("name", txt.getText().toString());
			intentLead.putExtra("rowid", txt_rowid.getText().toString());
			//intent.putExtra("id", )
					startActivity(intentLead);

	}

	@SuppressLint("ShowToast")
	public boolean deleteLead(long id)
	{
		MyDatabaseClass mdc=new MyDatabaseClass(getActivity());
		mdc.open();
		String[] values=new String[1];
		values=mdc.getValuesForSyncDeleteLead(id);
		generated_code=values[0];
		ContentValues cv=new ContentValues();
		cv.put(Delete_Lead_sync.unique_code,generated_code);
		cv.put(Delete_Lead_sync.delete_status, 1);
		@SuppressWarnings("unused")
		Uri uri=getActivity().getContentResolver().insert(MyDatabaseProvider.DELETE_LEAD_SYNC_URI,cv);
		
		//Toast.makeText(getActivity(),
				//"return is " + uri.toString(), Toast.LENGTH_SHORT)
				//.show();
		mdc.close();
		
		getActivity().getContentResolver().delete(MyDatabaseProvider.LEAD_CONTENT_URI,NLead_Table.lead_id + " =" + id,null);
		// finish();
   

	 // Toast.makeText(getActivity(), "Record deleted successfully", 1).show();
	

	  Toast.makeText(getActivity(), "Record deleted successfully", 1).show();
	  runOnUiThread(new Runnable() {
          public void run() {
        	 
              adapter.notifyDataSetChanged();
          }
      });
	  adapter.notifyDataSetChanged();
	return true;
	
	}
	
	@SuppressWarnings("deprecation")
	private void runOnUiThread(Runnable runnable) {
		adapter.getCursor().requery();
		
	}
	}