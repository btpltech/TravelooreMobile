package com.alexrs95.slidingmenuandviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.actionbarsherlock.app.SherlockFragment;

public class MyFragment  extends SherlockFragment {

	FragmentPagerAdapter mPagerAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View root = inflater.inflate(R.layout.view_pager_and_titles, container, false);
		ViewPager pager = (ViewPager) root.findViewById(R.id.pager);
		
		mPagerAdapter = new FragmentPagerAdapter(getSherlockActivity().getSupportFragmentManager());
		pager.setAdapter(mPagerAdapter);
		return root;
	}
}
