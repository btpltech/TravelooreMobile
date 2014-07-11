package com.alexrs95.slidingmenuandviewpager;

import android.database.Cursor;
import android.os.Bundle;

import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseClass;

public class Jugad_Testing extends SherlockFragment {

	ListView list1,list2;
	MyDatabaseClass database,database2;
	SimpleCursorAdapter adapter1,adapter2;
	Cursor cursor,cursor1;
	FragmentPagerAdapter mPagerAdapter;

	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.jugad_testing, container, false);
		
		//ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
	
		//mPagerAdapter = new FragmentPagerAdapter(getSherlockActivity()
			//	.getSupportFragmentManager());
		//viewPager.setAdapter(mPagerAdapter);
		getActivity().setTitle("Dashboard");
		///getActivity().setTitleColor(getResources().getColor(R.color.traveloore_green_theme));
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.dashboard);
		//getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
		
		
		list1 = (ListView) v.findViewById(R.id.listView1);
		//list1.setEmptyView(v.findViewById(R.id.empty));
		list2=(ListView)v.findViewById(R.id.listView2);
		database = new MyDatabaseClass(getActivity());
		database.open();
		cursor = database.getCursorFromDashboardTable("abc");
		String[] FROM = new String[] { Deal_Table.deal_id,
				Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.cdate,Deal_Table.ctime};
		int[] to = new int[] {R.id.i,R.id.n,R.id.p,R.id.a,R.id.v,R.id.v1};
				getActivity().startManagingCursor(cursor);
		adapter1 = new SimpleCursorAdapter(getActivity(), R.layout.jugad_testing1,
				cursor, FROM, to);
		list1.setAdapter(adapter2);
		database.close();
		database2=new MyDatabaseClass(getActivity());
		database2.open();
		
		cursor1 = database2.getCursorFromDashboardTable1();
		String[] FROM2 = new String[] { Deal_Table.deal_id,
				Deal_Table.dealName,Deal_Table.priority,Deal_Table.association,Deal_Table.cdate,Deal_Table.ctime};
		int[] to2 = new int[] {R.id.i2,R.id.n2,R.id.p2,R.id.a2,R.id.v2,R.id.v3};
				getActivity().startManagingCursor(cursor);
		adapter2 = new SimpleCursorAdapter(getActivity(), R.layout.jugad_testing1,
				cursor1, FROM2, to2);
		list2.setAdapter(adapter2);
		
		
		//list.setDivider(getActivity().getResources().getDrawable(R.color.traveloore_green_theme));
	   // list.setDividerHeight(2);
	  //list.setPadding(10, 0, 10, 0);
		
		return v;
	}
}
