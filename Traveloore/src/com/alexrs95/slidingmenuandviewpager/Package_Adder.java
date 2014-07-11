package com.alexrs95.slidingmenuandviewpager;

import android.os.Bundle;
import android.widget.EditText;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.btpl.database.MyDatabaseClass;

public class Package_Adder extends SherlockActivity {

	MyDatabaseClass database;
	EditText name, source, destination, title, summary, keywords;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.package_adder);

		intialize();
	}

	private void intialize() {
		// TODO Auto-generated method stub
		name = (EditText) findViewById(R.id.et_Package_name);
		source = (EditText) findViewById(R.id.et_Source_city);
		destination = (EditText) findViewById(R.id.et_Destination_city);
		title = (EditText) findViewById(R.id.et_title);
		summary = (EditText) findViewById(R.id.et_Summary);
		keywords = (EditText) findViewById(R.id.et_keywords);

		database = new MyDatabaseClass(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.package_adder, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.p_adder_ok) {
			/*database.insertIntoPackageTable(name.getText().toString(), destination
					.getText().toString(), summary.getText().toString(), title
					.getText().toString(), keywords.getText().toString());*/
		} else if (item.getItemId() == R.id.p_adder_cancel) {

		}
		return super.onOptionsItemSelected(item);
	}
}
