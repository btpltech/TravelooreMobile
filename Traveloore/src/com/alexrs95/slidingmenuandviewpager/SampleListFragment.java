package com.alexrs95.slidingmenuandviewpager;

import com.alexrs95.slidingmenuandviewpager.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class SampleListFragment extends ListFragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.list, null);
		return rootView;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		int[] int_array = new int[] { R.drawable.dashboard, R.drawable.leads,
				R.drawable.contact, R.drawable.packages, R.drawable.deals,
				R.drawable.tasks, R.drawable.reports,R.drawable.booking,R.drawable.sync};
		String[] array = new String[] { "Dashboard", "Leads", "Contacts",
				"Package", "Deals", "Tasks", "Reports","Bookings","Synchronization"};
		SampleAdapter adapter = new SampleAdapter(getActivity());

		for (int i = 0; i < 9; i++) {
			adapter.add(new SampleItem(array[i], int_array[i]));
		}

		setListAdapter(adapter);
	}

	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}

	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);
			return convertView;
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Fragment frags;

		switch (position) {
		case 0:
			frags = new DashBoard_Fragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			// frags = new MyFragment();
			break;
		case 1:
			frags = new Leads_Fragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;

		case 2:
			frags = new Contact_Fragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;
		case 3:
			frags = new PackageFragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;
		case 4:
			frags = new Deals_Fragment();// Deal
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;
		case 5:
			frags = new Tasks_Fragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;
		case 6:
			frags = new Report_Fragment();
			//((MainActivity)getActivity()).getSlidingMenu().showContent();
			break;
	
		case 7:
			frags = new Booking_Fragments();
			break;
			
		case 8:
			frags = new SyncFragment();
			break;
			
		default:
			frags = new Leads_Fragment();
			break;

		}

		FragmentTransaction t = getActivity().getSupportFragmentManager()
				.beginTransaction();
		t.replace(R.id.my_id, frags);
		t.commit();

		SlidingMenu slide = new SlidingMenu(getActivity());
		//slide.attachToActivity(getActivity(),SlidingMenu.SLIDING_CONTENT);
		slide.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		slide.toggle();
		((MainActivity)getActivity()).getSlidingMenu().showContent();
		//Log.d("TAG", "line checked");
	}
}
