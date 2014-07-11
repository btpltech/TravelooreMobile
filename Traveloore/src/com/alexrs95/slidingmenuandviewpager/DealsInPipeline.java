package com.alexrs95.slidingmenuandviewpager;

import com.btpl.database.MyDatabaseClass;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class DealsInPipeline extends Fragment {
	 SimpleCursorAdapter madaptor;
	 MyDatabaseClass database;
	ListView list;
	String m;
	int to;
	TextView totalD;
	Cursor cursor;
	String user;
	public DealsInPipeline(String user) {
		// TODO Auto-generated constructor stub
		
		this.user=user;
	}
	//AutoCompleteTextView a;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.check_pipeline_lead, container, false);
		totalD=(TextView)v.findViewById(R.id.deals_in_pipeline);
		//a = (AutoCompleteTextView)v.findViewById(R.id.autoCompleteTextView1);
		//ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
	//totalD = (TextView)v.findViewById(R.id.textView1);
		//mPagerAdapter = new FragmentPagerAdapter(getSherlockActivity()
		//		.getSupportFragmentManager());
		//viewPager.setAdapter(mPagerAdapter);
		//getActivity().setTitle("Dashboard");
		//getActivity().setTitleColor(getResources().getColor(R.color.traveloore_green_theme));
		//getSherlockActivity().getSupportActionBar().setIcon(R.drawable.dashboard);
		//getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
		
		
		//list = (ListView) v.findViewById(android.R.id.list);
		//list.setEmptyView(v.findViewById(R.id.empty));
		//MyDatabaseClass data = new MyDatabaseClass(getActivity());
		///data.open();
		//list = (ListView) v.findViewById(android.R.id.list);
		//list.setEmptyView(v.findViewById(R.id.empty));
		database = new MyDatabaseClass(getActivity());
		database.open();
		to=database.dealsInPipeline(user);
		m=Integer.toString(to);
		totalD.setText(m);
		
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(TotalDealsClass.this, R.layout.total_deals,R.id.textTotalDeals,);
		//textview
		
		//cursor = database.getContactsCount();
		//String[] FROM = new String[] { Deal_Table.deal_id};
		//int[] to = new int[] {R.id.textTotalDeals};
				//getActivity().startManagingCursor(cursor);
				//madaptor = new SimpleCursorAdapter(getActivity(), R.layout.total_deals,cursor, FROM, to);
			//	list.setAdapter(madaptor);
				
	   // to=data.getContactsCount();
		//Toast.makeText(getActivity(), "Hello", Toast.LENGTH_LONG).show();//totalDeals.setText(totalDeal);
		///m=Integer.toString(to);
		//ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,to);
		//a.setdapter(adapter);

		//totalD.setText(m);
		return v;
	}

	

	}





