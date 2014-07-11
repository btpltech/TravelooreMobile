package com.alexrs95.slidingmenuandviewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter  {

	String st;
	Context context;
	public static ArrayList<List<String>> double_d_list;
	List<String> one_d_list;
	LayoutInflater inflater;
	String[] parentList = new String[] { "Contacts", "Leads"};
	
	

	public ExpandableAdapter(Context mainActivity) {
		// TODO Auto-generated constructor stub
		this.context = mainActivity;
		inflater = (LayoutInflater) mainActivity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		one_d_list = new ArrayList<String>();
		double_d_list = new ArrayList<List<String>>();
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		EditText et = new EditText(context);
		switch(groupPosition){
		case 0 :
			switch (childPosition) {
			case 0:
				et.setHint("First Name");
				et.addTextChangedListener(new TextWatcher() {
					
					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void afterTextChanged(Editable s) {
						// TODO Auto-generated method stub
						one_d_list.add(0, s.toString());
						
						Log.d("TAG", s.toString());
					}
				});
				
				break;
				
			case 1 :
				et.setHint("last Name");
	            et.addTextChangedListener(new TextWatcher() {
					
					@Override
					public void onTextChanged(CharSequence s, int start, int before, int count) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void afterTextChanged(Editable s) {
						// TODO Auto-generated method stub
						one_d_list.add(1, s.toString());
						Log.d("TAG", s.toString() + " "+ 0 + " " + 1);
					}
				});
 
				break;
			}
			double_d_list.add(0, one_d_list);
			break;
			
		case 1 :
			switch (childPosition) {
			case 0:
				et.setHint("Country");
				  et.addTextChangedListener(new TextWatcher() {
						
						@Override
						public void onTextChanged(CharSequence s, int start, int before, int count) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void beforeTextChanged(CharSequence s, int start, int count,
								int after) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub
							one_d_list.add(0, s.toString());
							Log.d("TAG", s.toString() + " "+ 0 + " " + 1);
						}
					});
				break;
			case 1 :
				et.setHint("Language");
				  et.addTextChangedListener(new TextWatcher() {
						
						@Override
						public void onTextChanged(CharSequence s, int start, int before, int count) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void beforeTextChanged(CharSequence s, int start, int count,
								int after) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub
							one_d_list.add(1, s.toString());
							Log.d("TAG", s.toString() + " "+ 0 + " " + 1);
						}
					});
				break;
			case 2 :
				et.setHint("Currency");
				  et.addTextChangedListener(new TextWatcher() {
						
						@Override
						public void onTextChanged(CharSequence s, int start, int before, int count) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void beforeTextChanged(CharSequence s, int start, int count,
								int after) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub
							one_d_list.add(2, s.toString());
							Log.d("TAG", s.toString() + " "+ 0 + " " + 1);
						}
					});
				break;
			}
			double_d_list.add(1, one_d_list);
			break;
		}
		return et;
	}
	
	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		if(groupPosition == 0)
			return 2;
		else
		return 3;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parentList.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView tv = new TextView(context);
		tv.setText(parentList[groupPosition]);
		tv.setPadding(40, 10, 5, 10);
		return tv;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}
}
