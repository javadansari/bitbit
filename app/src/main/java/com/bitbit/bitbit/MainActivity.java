package com.bitbit.bitbit;

import android.app.FragmentTransaction;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.FragmentViewAdapter;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_test;
import entityControl.Control_gallery;
import tools.PublicMethods;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    private PublicMethods pm;
    TabLayout.Tab tabCall;

    //  entity.Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /// start code

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPagerClass();
    }


    public void viewPagerClass() {


        FragmentViewAdapter FragmentViewAdapter = new FragmentViewAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(FragmentViewAdapter);
        viewPager.setOffscreenPageLimit(5);

        //   Typeface typeface = Typeface.createFromAsset(MainFragmentActivity.this.getAssets(),"Sans.ttf");
        tabLayout.setupWithViewPager(viewPager);
        tabCall = tabLayout.getTabAt(0);
        tabCall.setIcon(R.drawable.selector_home);
        tabCall.select();
        tabCall = tabLayout.getTabAt(1);
        tabCall.setIcon(R.drawable.selector_favorite);
        tabCall = tabLayout.getTabAt(2);
        tabCall.setIcon(R.drawable.selector_search);
        tabCall = tabLayout.getTabAt(3);
        tabCall.setIcon(R.drawable.selector_user);
        changeTabsFont();


    }

    private void changeTabsFont() {
        pm = new PublicMethods(this);
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(pm.getTypeface());
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        int page = 0;
        viewPager.setCurrentItem(page);

    }

  


}
