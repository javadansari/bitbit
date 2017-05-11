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

public class UserFragment extends Fragment {

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
    public static UserFragment newInstance() {
        UserFragment newInstanceHomeActivity = new UserFragment();
        return newInstanceHomeActivity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_user, container, false);


        return homeView;

    }




}


