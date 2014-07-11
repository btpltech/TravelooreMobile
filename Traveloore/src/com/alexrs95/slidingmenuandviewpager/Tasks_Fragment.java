package com.alexrs95.slidingmenuandviewpager;

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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.SherlockListFragment;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.SearchView.OnQueryTextListener;
import com.btpl.database.AddTask_Table;
import com.btpl.database.MyDatabaseProvider;


public class Tasks_Fragment  extends SherlockListFragment implements
LoaderCallbacks<Cursor>, OnQueryTextListener{

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
t1=(TextView)getActivity().findViewById(R.id.lblName);
check=t1.getText().toString();
System.out.println("checkkk" + check);
setRetainInstance(true);
//to enable menu item in fragment
setHasOptionsMenu(true);
//set when list is empty
//setEmptyText("Nothis ");
String[] FROM = new String[] {AddTask_Table.addtask_id,AddTask_Table.description,AddTask_Table.date,AddTask_Table.time};
int[] TO = new int[] {R.id.task_id,R.id.task_name,R.id.task_date,R.id.task_time};

adapter = new SimpleCursorAdapter(getActivity(),
		R.layout.add_task_details, null, FROM, TO, 0);
setListAdapter(adapter);
ListView list = getListView();
list.setEmptyView(getActivity().findViewById(R.id.empty));

setListShown(false);
registerForContextMenu(getListView());
getLoaderManager().initLoader(0, null, this);
getActivity().setTitle("Tasks");
//getActivity().setTitle("Deal");
getSherlockActivity().getSupportActionBar().setIcon(R.drawable.tasks);
   
}

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
		//index = info.position;
		editTask((int)info.id);
		//Intent intentEdit  =new Intent (getActivity(),Edit_Lead.class);
		//intentEdit.putS
		//startActivity(intentEdit);
		break;
	case R.id.delete:
		
	AdapterView.AdapterContextMenuInfo menuinfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
deleteLead(menuinfo.id);
	break;
	
	}
	return true;
}


	
	 public boolean editTask(int id)
	 {
		Intent editIntent=new Intent(getActivity(),Edit_Task.class);
		editIntent.putExtra("id",id);
		editIntent.putExtra("extra",check);
		startActivity(editIntent);
		 
		 return true;
		 
	 }
 
@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);	
		inflater.inflate(R.menu.task_menu, menu);
	
	}


@Override
public boolean onOptionsItemSelected(MenuItem item) {
	// TODO Auto-generated method stub
	if(item.getItemId() == R.id.addTask){
		Intent inte = new Intent(getActivity(), Add_Task.class);
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

String selection = AddTask_Table.signinEmail +  " = '" + check + "'";
String[] columns = new String[] {AddTask_Table.addtask_id,AddTask_Table.description,AddTask_Table.date,AddTask_Table.time};
return new CursorLoader(getActivity(), MyDatabaseProvider.ADDTASK_CONTENT_URI,
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
public void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	getLoaderManager().restartLoader(0, null, this);
}


/*
* Refreshing the list after deleting teh record*/	
public boolean deleteLead(long id)
{
	
	getActivity().getContentResolver().delete(MyDatabaseProvider.ADDTASK_CONTENT_URI,AddTask_Table.addtask_id + " =" + id,null);
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
