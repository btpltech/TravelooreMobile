package com.alexrs95.slidingmenuandviewpager;


import android.content.Intent;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;


import com.actionbarsherlock.app.SherlockFragment;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class Report_Fragment extends SherlockFragment {
	
	ListView list;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.report_fragment, container, false);
		getActivity().setTitle("Report");
		getActivity().setTitleColor(getResources().getColor(R.color.traveloore_green_theme));
		//getActivity().setTitle("Deal");
		   getSherlockActivity().getSupportActionBar().setIcon(R.drawable.reports);
		   
		setHasOptionsMenu(true);		

		list = (ListView) root.findViewById(android.R.id.list);
		list.setEmptyView(root.findViewById(R.id.empty));
		return root;
	}
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);	
		inflater.inflate(R.menu.report_menu, menu);
		
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.add_Report){
			Intent inte = new Intent(getActivity(), Add_Report.class);
			startActivity(inte);
		}
		return super.onOptionsItemSelected(item);
	}
	



}
