package com.btpl.contactfragments;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.Contact_table;
import com.btpl.database.MyDatabaseProvider;

public class AddNote extends SherlockActivity {

	EditText et;
	int rowid;
	String rowName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		et = new EditText(this);
		et.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));

		setContentView(et);

		rowid = getIntent().getIntExtra("extra", 1);
		rowName=getIntent().getStringExtra("name");
		//rowid++;
		//et.setHint("rowid is " + rowid);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		menu.add(0, 1, 0, "Cancel").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);
		menu.add(0, 3, 0, "Save").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		// cancel note
		case 1:
			System.out.println(item.getTitle());
			AddNote.this.finish();
			break;
		// save to database
		case 3:

			ContentValues cv = new ContentValues();
			cv.put(Contact_table.contact__notes, et.getText().toString());
			cv.put(Contact_table.contact__notes_table_type,"forlead");

			Uri uri = getContentResolver().insert(
					MyDatabaseProvider.NOTES_CONTENT_URI_LEAD, cv);
			Toast.makeText(getApplicationContext(), uri.toString(),
					Toast.LENGTH_SHORT).show();
			AddNote.this.finish();
			break;

		}
		return super.onOptionsItemSelected(item);
	}
}
