package com.btpl.contactfragments;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Contact_table;

public class NoteCurd extends SherlockActivity {

	EditText et;
	String rowName;
	long id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		et = new EditText(this);
		et.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		setContentView(et);

		rowName = getIntent().getStringExtra("name");
		id=getIntent().getIntExtra("id", 1);
		///rowid++;
		et.setText(getIntent().getStringExtra("extra"));
		//Toast.makeText(this, "pos " + rowid, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 11, 0, "Cancel").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);
		//menu.add(0, 21, 0, "fb").setShowAsAction(
		//		MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add(0, 31, 0, "Save").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);
		
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		
		case 11 :
			NoteCurd.this.finish();
			break;
		//case 21 :
			//NoteCurd.this.finish();
			//break;
		case 31 :
			ContentValues cv = new ContentValues();
			cv.put(Contact_table.contact_detail_notes, et.getText().toString());
			String where = Contact_table.contact_detail_notes_id + "=" + id;
			//String where = Contact_table.contact_detail_notes_contact_table_id + " = '" + rowName + "'";
			Uri uri = Uri.parse("content://com.btpl.database.MyDbProvider/contact_notes/" + id);
			int pos = getContentResolver().update(uri, cv, where, null);
			Log.i("tag", ""+ pos);
			Log.i("tag", ""+ et.getText().toString());
			NoteCurd.this.finish();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
