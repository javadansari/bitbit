package com.bitbit.bitbit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter_gallery;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;
import entityControl.Control_category;
import entityControl.Control_gallery;
import tools.eventCategory;
import tools.eventGallery;

/**
 * Created by Javad Ansari on 4/9/2017.
 */

public class SearchFragment extends Fragment {

    //For View Flipper


    private String[] goToSiteImageStirng = {"http://www.google.com", "http://www.yahoo.com"
            , "http://www.farsnews.com", "http://www.zoomit.com",};
    private int[] imageArray = {R.drawable.slder01, R.drawable.slder02,
            R.drawable.slder03, R.drawable.slder04};
    int iForPic = 0;
    int goToSiteImage;
    int skip = 0;
    int take = 20;
    Adapter_gallery listAllItemAdapter;
    private View homeView;
    List<tbl_sliders.entity> entTblSliders = new ArrayList<tbl_sliders.entity>();
    ListView listAllItem;
    public static SearchFragment newInstance() {
        SearchFragment newInstanceHomeActivity = new SearchFragment();
        return newInstanceHomeActivity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_search, container, false);



        return homeView;

    }


    public void loadNextDataFromApi(int offset) {


        Toast.makeText(getContext(), skip + "", Toast.LENGTH_SHORT).show();


        // Send an API request to retrieve appropriate paginated data
        //  --> Send the request including an offset value (i.e `page`) as a query parameter.
        //  --> Deserialize and construct new model objects from the API response
        //  --> Append the new data objects to the existing set of items inside the array of items
        //  --> Notify the adapter of the new items made with `notifyDataSetChanged()`

    }


    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }



}


