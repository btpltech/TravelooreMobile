package com.alexrs95.slidingmenuandviewpager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class Package_Details extends SherlockActivity implements OnClickListener {

	LinearLayout package_layout, hotel_layout;
	
    TextView package_id,package_name,adults,children,description,stay_city,validity,hotel_id,hotel_name,
             hotel_city,star;      
	Button package_details, hotel_details;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modify_package_);

		ActionBar bar = getSupportActionBar();
		bar.setHomeButtonEnabled(true);
		
		create();
		initialize1();
		getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.traveloore_main_background));
		
	}

	private void initialize1() {

		package_id = (TextView) findViewById(R.id.package_id);
		package_name = (TextView) findViewById(R.id.package_name);
		adults = (TextView) findViewById(R.id.no_of_adults);
		children = (TextView) findViewById(R.id.no_of_child);
		description = (TextView) findViewById(R.id.description);
		stay_city = (TextView) findViewById(R.id.stay_city);
		validity = (TextView) findViewById(R.id.no_of_days);
		hotel_id = (TextView) findViewById(R.id.hotel_id);
	    hotel_name = (TextView) findViewById(R.id.hotel_name);
		hotel_city = (TextView) findViewById(R.id.stars);
	    star = (TextView) findViewById(R.id.hotel_city);
		
	}

	public void create() {

		package_layout = (LinearLayout) findViewById(R.id.basic_layout);
		hotel_layout = (LinearLayout) findViewById(R.id.hotel_layout);
		
		package_details = (Button) findViewById(R.id.button_package_details);
		hotel_details = (Button) findViewById(R.id.button_hotel_details);

		package_details.setOnClickListener(this);
		hotel_details.setOnClickListener(this);

		//hide(basic_layout);
		hide(hotel_layout);

	}

	public void hide(LinearLayout id) {

		id.setVisibility(View.GONE);

	}

	public void show(LinearLayout id) {

		id.setVisibility(View.VISIBLE);
	}

	@Override
	public void onClick(View arg0) {

		Button myButton = (Button) arg0;

		String text = (String) myButton.getText();

		if (text == package_details.getText()) {
			if (package_layout.getVisibility() == View.VISIBLE) {
				package_details.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(package_layout);
			} else {
				package_details.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(package_layout);
			}

		} else if (text == hotel_details.getText()) {
			if (hotel_layout.getVisibility() == View.VISIBLE) {
				hotel_details.setBackgroundDrawable(this.getResources()
						.getDrawable(R.drawable.traveloore_button_seclector));
				hide(hotel_layout);
			} else {
				hotel_details.setBackgroundColor(this.getResources().getColor(
						R.color.traveloore_green_theme));
				show(hotel_layout);
			}

		} 

	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.add_package_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {

		case android.R.id.home:
			Package_Details.this.finish();
			break;
		
	case R.id.book_now:
		Intent intentPackage = new Intent(this,Booking_Classs.class);
		startActivity(intentPackage);
		break;
	}
		
		return super.onOptionsItemSelected(item);
	}

	
}