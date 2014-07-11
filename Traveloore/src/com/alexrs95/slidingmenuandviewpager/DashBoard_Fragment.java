package com.alexrs95.slidingmenuandviewpager;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;
import com.btpl.database.Deal_Table;
import com.btpl.database.MyDatabaseClass;
import com.btpl.database.MyDbHelper;

public class DashBoard_Fragment extends SherlockFragment {

	ListView list;
	MyDatabaseClass database;
	SimpleCursorAdapter adapter;
	Cursor cursor;
	SQLiteDatabase sdb;
	FragmentPagerAdapter mPagerAdapter;
	MyDbHelper helper;
	TextView user;
	String check;
	@SuppressWarnings("deprecation")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		user=(TextView)getActivity().findViewById(R.id.lblName);
		check=user.getText().toString();
		View v = inflater.inflate(R.layout.my_dash, container, false);
		
		ViewPager viewPager = (ViewPager) v.findViewById(R.id.pager);
	
		mPagerAdapter = new FragmentPagerAdapter(getSherlockActivity()
				.getSupportFragmentManager(),check);
		viewPager.setAdapter(mPagerAdapter);
		getActivity().setTitle("Dashboard");
		getActivity().setTitleColor(getResources().getColor(R.color.traveloore_green_theme));
		getSherlockActivity().getSupportActionBar().setIcon(R.drawable.dashboard);
		//getSherlockActivity().getSupportActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.color_dasboard));
		
		list = (ListView) v.findViewById(android.R.id.list);
		list.setEmptyView(v.findViewById(R.id.empty));
		database = new MyDatabaseClass(getActivity());
		database.open();
//String query = "Select" + Deal_Table.dealName + "from" + Deal_Table.TABLE_NAME + "INNER JOIN" + NLead_Table.TABLE_NAME + "ON" + Deal_Table.deal_id + "=" + NLead_Table.lead_id;
		//	cursor.close();
        	//cursor=null;
        
		
		//cursor.moveToFirst();
		
		//cursor=sdb.rawQuery(query, null);
cursor = database.getCursorFromDashboardTable(check);
		//String []FROM = new String[] {NLead_Table.lead_id,NLead_Table.firstname,Deal_Table.dealName};
	String[] FROM = new String[] { Deal_Table.deal_id,
				Deal_Table.dealName,Deal_Table.priority,Deal_Table.value,Deal_Table.cdate,Deal_Table.ctime};
		int[] to = new int[] {R.id.dash_id,R.id.dash_Name,R.id.dash_priority,R.id.dash_owner,R.id.textView1,R.id.textView3};
		//int []to = new int[] {R.id.dash_id,R.id.dash_Name,R.id.dash_priority};
				getActivity().startManagingCursor(cursor);
		adapter = new SimpleCursorAdapter(getActivity(), R.layout.dashinflater,
				cursor, FROM, to);
		list.setAdapter(adapter);
		
		
	/*cursor1=database.getCursorFromDashboardTable();
	cursor2=database.getCursorFromDashboardTable3();
		CursorJoiner joiner=new CursorJoiner(cursor1,new String[]{Deal_Table.deal_id},cursor2,new String[]{NLead_Table.lead_id});
		  MatrixCursor cursor = new MatrixCursor( new String[] 
				  {Deal_Table.deal_id+"," +Deal_Table.dealName+","+NLead_Table.firstname},10); 
	 for (CursorJoiner.Result joinerResult : joiner) { 
		switch (joinerResult) 
		{ 
         case BOTH: // handle case where a row with the same key is in 
			 String id = cursor1.getString(0); 
		String name =cursor1.getString(1); 
	 String secret_identity =cursor2.getString(1);
	 cursor.addRow(new String[] {id,name,secret_identity});
	 break; 
      } 
		} 
		*/
/*	String query="Select" + Deal_Table.deal_id + "AS ID ," + NLead_Table.lead_id + "AS C2" + "FROM" +
		Deal_Table.TABLE_NAME + "INNER JOIN" + "ON" + Deal_Table.deal_id + "=" +NLead_Table.lead_id;
					Cursor cursor=sdb.rawQuery(query,null);
				while(cursor.moveToNext())
				{
				String id=cursor.getString(cursor.getColumnIndex("ID"));
				String C2=cursor.getString(cursor.getColumnIndex("C2"));
				}
				*/
		
/*	String query=("SELECT" + Deal_Table.dealName + "," + NLead_Table.firstname + "FROM" + 
	Deal_Table.TABLE_NAME + "," + NLead_Table.TABLE_NAME + 
			"WHERE" +  Deal_Table.deal_id + "=" + NLead_Table.lead_id);
					cursor=sdb.rawQuery(query,null);	
	 String[] FROM = new String[] {Deal_Table.deal_id,Deal_Table.dealName};
	 int[] to = new int[] {R.id.dash_id,R.id.dash_Name};
	 getActivity().startManagingCursor(cursor);
	 adapter=new SimpleCursorAdapter(getActivity(),R.layout.dashinflater,cursor,FROM,to);
				list.setAdapter(adapter);  */                
	/*SQLiteQueryBuilder builder=new SQLiteQueryBuilder();
	builder.setTables(Deal_Table.TABLE_NAME + 
	        " LEFT OUTER JOIN " + NLead_Table.TABLE_NAME+ " ON " + 
	        Deal_Table.deal_id + " = " + NLead_Table.lead_id);
		
		sdb=helper.getReadableDatabase();
		cursor=sdb.query(null,null,null,null,null,null,null);*/
		//cursor.moveToFirst();
	 
		//cursor.
		
		//list.setDivider(getActivity().getResources().getDrawable(R.color.traveloore_green_theme));
	   // list.setDividerHeight(2);
	  //list.setPadding(10, 0, 10, 0);
		/*String columns[]={Deal_Table.deal_id,Deal_Table.dealName,NLead_Table.lead_id,NLead_Table.firstname};
		cursor=sdb.query(true, "Select deal_name from deal_table a inner join add_lead_table b on a.id=b.id",
				columns,null,null,null,null,null,null);			        
		if (cursor != null) {
	        if(cursor.getCount() > 0)
	        {

	             cursor.moveToFirst();
	        
	        }
	 String[] FROM = new String[] {Deal_Table.deal_id,Deal_Table.dealName,NLead_Table.firstname};
	 int[] to = new int[] {R.id.dash_id,R.id.dash_Name,R.id.priority};
	 getActivity().startManagingCursor(cursor);
	 adapter=new SimpleCursorAdapter(getActivity(),R.layout.dashinflater,cursor,FROM,to);
				list.setAdapter(adapter); */
	
			
	//}
		return v;
		}
}