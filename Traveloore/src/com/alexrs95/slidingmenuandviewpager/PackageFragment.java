package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.MyDatabaseProvider;
import com.btpl.database.Package_Table;

public class PackageFragment extends SherlockListFragment implements
		LoaderCallbacks<Cursor>,OnItemClickListener {

	ListView list;

	SimpleCursorAdapter adapter;
	String mCurFilter;
ArrayList<String> alist=new ArrayList<String>();
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//to enable menu item in fragment
		setHasOptionsMenu(true);
		//set when list is empty
		//setEmptyText("Nothis ");
		String[] FROM = new String[] {Package_Table.id,Package_Table.package_id,
				                      Package_Table.package_name,Package_Table.adults,
				                      Package_Table.children,Package_Table.package_description};
		int[] TO = new int[] {R.id.id,R.id.synch_id, R.id.package_name,R.id.adults, 
				              R.id.child,R.id.package_description};
	
		adapter = new SimpleCursorAdapter(getActivity(),
				R.layout.inflate_package_list, null, FROM, TO, 0);
		setListAdapter(adapter);
		
		ListView list = getListView();
		list.setOnItemClickListener(this);
		list.setEmptyView(getActivity().findViewById(R.id.empty));
		
		setListShown(false);
		registerForContextMenu(getListView());
		getLoaderManager().initLoader(0, null, this);
		getActivity().setTitle("Package");
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.packages);

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
		/*Uri baseUri;
		if (mCurFilter != null) {
			baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI,
					Uri.encode(mCurFilter));
		} else {
			baseUri = Contacts.CONTENT_URI;
		}*/
		//String selection = Package_Table.tabletype + " = " + "'packages'";
		String[] columns = new String[] {Package_Table.id,Package_Table.package_id,
			Package_Table.package_name,Package_Table.adults,Package_Table.children,
			Package_Table.package_description};
		return new CursorLoader(getActivity(), MyDatabaseProvider.ADDPACKAGE_CONTENT_URI,
				columns, null, null, null);
	}
	
	//@Override
	//public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		//return false;
	//}


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

	//@Override
	//public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		//mCurFilter = !TextUtils.isEmpty(newText) ? newText : null;

		//return true;
	//}
	
	
	@Override
	public void onLoaderReset(Loader<Cursor> arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		TextView t=(TextView)v.findViewById(R.id.package_name);
		TextView text=(TextView)v.findViewById(R.id.synch_id);

		Intent getDetails = new Intent(getActivity(),Package_Detailsssss.class);
	    getDetails.putExtra("package",t.getText().toString());
	    getDetails.putExtra("id",Integer.parseInt(text.getText().toString()));
        
	    startActivity(getDetails);
	}

	
	
	


	

	

}