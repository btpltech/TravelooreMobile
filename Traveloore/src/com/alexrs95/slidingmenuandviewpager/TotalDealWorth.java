package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.btpl.database.MyDatabaseClass;

@SuppressLint("ValidFragment")
public class TotalDealWorth extends SherlockFragment{
MyDatabaseClass database;
TextView totalDW;
ArrayList<Integer> worth,totalWortharray;
int totalWorth;
	String user;
	public TotalDealWorth(String user) {
	// TODO Auto-generated constructor stub
		this.user=user;
}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.total_deals, container, false);
		totalDW=(TextView)v.findViewById(R.id.textTotalDeals);
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
		worth=new ArrayList<Integer>();
		worth=database.countDealsWorth(user);
		database.close();
		for(int i=0; i <worth.size(); i++)   
        {  
           totalWorth =totalWorth + worth.get(i);  
        }  
		//totalWortharray.addAll(worth);
		//for(int i=0;i<worth.lastIndexOf(worth);i++)
		//{
		//totalWorth= totalWorth+worth.indexOf(i);
		//}
		String show=Integer.toString(totalWorth);
		totalDW.setText(show);
		//to=database.getotalDeals();
		//m=Integer.toString(to);
		//totalD.setText(m);
		return v;
	}

}
