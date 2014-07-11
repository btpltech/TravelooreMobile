package com.alexrs95.slidingmenuandviewpager;


import java.util.ArrayList;

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
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseProvider;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;


public class Deals_Fragment extends SherlockListFragment implements 
LoaderCallbacks<Cursor>, OnQueryTextListener, OnItemClickListener {
	
	 SimpleCursorAdapter madaptor;
	 int index;
	ListView list;
	String mCurFilter;
	ArrayList<String> alist=new ArrayList<String>();
	String check;
	TextView t1;
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		t1=(TextView)getActivity().findViewById(R.id.lblName);
		check=t1.getText().toString();
		System.out.println("checkkk" + check);
		setHasOptionsMenu(true);
		//to enable menu item in fragment
		String[] from = new String[] {Deal_Table.deal_id,Deal_Table.dealName,Deal_Table.priority,Deal_Table.association};
       int[] to = new int[] {R.id.deal_id,R.id.deal_name,R.id.deal_priority,R.id.deal_owner};
      
       madaptor = new SimpleCursorAdapter(getActivity(),R.layout.dealdetailsshowing, null, from, to, 0);
       setListAdapter(madaptor);
       ListView list = getListView();
      // list = (ListView) getActivity().findViewById(android.R.id.list);
	   list.setEmptyView(getActivity().findViewById(R.id.empty));

       setListShown(false);
	   list.setOnItemClickListener(this);
	   registerForContextMenu(getListView());
	   getLoaderManager().initLoader(0, null, this);
	   getActivity().setTitle("Deal");
	   getSherlockActivity().getSupportActionBar().setIcon(R.drawable.deals);
	   //getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
		
       
	
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
			editLead((int) info.id);
			break;
		case R.id.delete:
			
		AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
	deleteDeal(menuinfo.id);
	
		}
		return true;
		/* **********************************end** */
	}

	public boolean editLead(int id) {
		// TODO Auto-generated method stub
		//TextView txt_rowid=(TextView)getActivity().findViewById(R.id.contact_id);
		Intent intentEdit = new Intent(getActivity(),Edit_Deal.class);
		intentEdit.putExtra("id",id);
		intentEdit. putExtra("extra",check);
		startActivity(intentEdit);
		return true;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);	
		inflater.inflate(R.menu.deal_menu, menu);
		 
		ArrayList<String> flist= getResults();
	   ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_dropdown_item_1line,flist);
	  	
		
	}
	public ArrayList<String> getResults() {
		// TODO Auto-generated method stub
			
			
		String[] projection=new String[] {Deal_Table.dealName};	
		Cursor cursor=getActivity().getContentResolver().query(MyDatabaseProvider.DEAL_CONTENT_URI, projection,null,null,null);
		try
		{
			while(cursor.moveToNext())
					{
				
					alist.add(cursor.getString(cursor.getColumnIndex(Deal_Table.dealName)));
			    
					}
		}finally
		{
			cursor.close();
		}
			
			
		return alist;	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.add_Deal){
			Intent inte = new Intent(getActivity(), Add_Deal.class);
			inte.putExtra("extra", check);
			startActivity(inte);
		}
		return super.onOptionsItemSelected(item);
	}



	@Override
	public void onItemClick(AdapterView<?> arg0, View v, int arg2, long arg3) {
		// TODO Auto-generated method stub
		//TextView txt = (TextView) v.findViewById(R.id.deal_owner);
			
			TextView txt_rowid = (TextView) v
					.findViewById(R.id.deal_id);
			//Toast.makeText(getActivity(), txt_rowid.getText().toString(), Toast.LENGTH_LONG).show();
			//TextView txt_id = (TextView) v.findViewById(R.id.inflatelist_rowid)
			Intent intentDeal = new Intent(getActivity(), DealDetails.class);
			//intentDeal.putExtra("name", txt.getText().toString());
			intentDeal.putExtra("rowid", txt_rowid.getText().toString());
			//intent.putExtra("id", )
					startActivity(intentDeal);
			
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

		return true;
	}



	@Override
	public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
		// TODO Auto-generated method stub
		String selection = Deal_Table.signinEmail +  " = '" + check + "'";
		String[] columns = new String[] { Deal_Table.deal_id,
				Deal_Table.dealName, Deal_Table.priority,Deal_Table.association};
		
		return new CursorLoader(getActivity(), MyDatabaseProvider.DEAL_CONTENT_URI,
				columns, selection, null, null);
	}



	@Override
	public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
		// TODO Auto-generated method stub
	madaptor.swapCursor(arg1);
		
		//The list should be shown now
	if(isResumed()){
			setListShown(true);
	               }
		else{
			setListShownNoAnimation(true);
		}
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getLoaderManager().restartLoader(0, null, this);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		madaptor.swapCursor(null);

	}

	/* restart *****/
	public boolean deleteDeal(long id)
	{
		getActivity().getContentResolver().delete(MyDatabaseProvider.DEAL_CONTENT_URI,Deal_Table.deal_id +" =" + id,null);
		// finish();
     Toast.makeText(getActivity(), "Record deleted successfully", 1).show();
	  runOnUiThread(new Runnable() {
          public void run() {
        	 
              madaptor.notifyDataSetChanged();
          }
      });
	  madaptor.notifyDataSetChanged();
	return true;
	}
	
	
/*
 * Refreshing the list after deleting teh record*/	
	@SuppressWarnings("deprecation")
	private void runOnUiThread(Runnable runnable) {
		madaptor.getCursor().requery();
		
	}

/*  end************* */

}
