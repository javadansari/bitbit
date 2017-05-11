package com.bitbit.bitbit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter_gallery;
import Adapter.Adapter_galleryItems;
import Adapter.Adapter_galleryItems_list;
import Adapter.EndlessScrollListener;
import CustomViews.CustomButton;
import CustomViews.CustomButtonBold;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_galleryItems;
import entity.tbl.tbl_sliders;
import entityControl.Control_category;
import entityControl.Control_gallery;
import entityControl.Control_galleryItems;
import tools.eventCategory;
import tools.eventGallery;
import tools.eventGalleryItems;
import tools.eventTool;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by Javad Ansari on 4/9/2017.
 */

public class FavoriteFragment extends Fragment {


    int skip = 0;
    int take = 20;
    Adapter_galleryItems listAllItemAdapter;
    Adapter_galleryItems_list listAllItemAdapterList;
    GridView gridAllItemSecond;
    GridView gridAllItem;
    CustomButtonBold btn_gallery;
    CustomButtonBold btn_filter;
    ImageView btn_change_grid;
    private View favoriteView;


    public static FavoriteFragment newInstance() {
        FavoriteFragment newInstanceFavoriteActivity = new FavoriteFragment();
        return newInstanceFavoriteActivity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        favoriteView = inflater.inflate(R.layout.fragment_favorite, container, false);
        favoriteView.findViewById(R.id.gridHeaderProgress).setVisibility(VISIBLE);
        gridAllItem = (GridView) favoriteView.findViewById(R.id.list_gallery_grid);
        gridAllItemSecond = (GridView) favoriteView.findViewById(R.id.list_gallery_grid_second);
        btn_gallery = (CustomButtonBold) favoriteView.findViewById(R.id.btn_gallery);
        btn_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DialogueCategoryIntent = new Intent(getContext(), DialogueCategory.class);
                startActivity(DialogueCategoryIntent);
                //for progress
            }
        });
        btn_filter = (CustomButtonBold) favoriteView.findViewById(R.id.btn_filter);
        //  btn_filter.setEnabled(false);
        btn_filter.setTextColor(this.getResources().getColor(R.color.grayLight));
        btn_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent DialogueFilterIntent = new Intent(getContext(), DialogueFilter.class);
                startActivity(DialogueFilterIntent);
                //for progress
            }
        });

        galleryCall(skip);
        btn_change_grid = (ImageView) favoriteView.findViewById(R.id.btn_change_grid);
        btn_change_grid.setImageResource(R.drawable.list_01);
        gridAllItemSecond.setVisibility(GONE);
        //for change grid
        btn_change_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gridAllItem.getVisibility() == View.VISIBLE) {

                    btn_change_grid.setImageResource(R.drawable.list_02);
                    gridAllItem.setVisibility(GONE);
                    gridAllItemSecond.setVisibility(VISIBLE);
                } else {
                    btn_change_grid.setImageResource(R.drawable.list_01);
                    //    listAllItemAdapter.notifyDataSetChanged();
                    gridAllItem.setVisibility(VISIBLE);
                    gridAllItemSecond.setVisibility(GONE);
                }


            }
        });

        return favoriteView;

    }


    public void galleryCall(int skip) {

        Control_galleryItems control = new Control_galleryItems();
        //for Result
        Result.Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>>();

        //for service user
        Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
        serviceUser.setM_keyAtz("");
        serviceUser.setM_keyUnq("");

        //for post
        tbl_galleryItems.post servicePost = new tbl_galleryItems().new post();
        servicePost.setGalleryType(0);
        servicePost.setCategory("");
        servicePost.setSearchWord("");
        servicePost.setGalleryCollectionFilterItem("");
        servicePost.setGalleryCollection("");
        servicePost.setSkip(skip);
        servicePost.setTake(take);
        //for value
        Value.Entity_ServiceValue<tbl_galleryItems.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);
        control.postReturn(getActivity(), values);

    }

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Subscribe
    public void eventTool(eventTool eventTool) {
        favoriteView.findViewById(R.id.gridHeaderProgress).setVisibility(View.VISIBLE);

    }


    @Subscribe
    public void eventGalleryItems(final eventGalleryItems resultEventItems) {
        //for filter
        if (PreferenceManager.getDefaultSharedPreferences(getContext()).getString("urlFilter", "") != "") {
            btn_filter.setEnabled(true);
            btn_filter.setTextColor(this.getResources().getColor(R.color.textColor));
        }

        // for list
        favoriteView.findViewById(R.id.gridHeaderProgress).setVisibility(GONE);

        listAllItemAdapter = new Adapter_galleryItems(getContext(), resultEventItems.getResult().getM_Result());
        if (skip == 0) {
            gridAllItem.setAdapter(listAllItemAdapter);
        } else {
            listAllItemAdapter.notifyDataSetChanged();
            gridAllItem.setAdapter(listAllItemAdapter);
        }

        listAllItemAdapterList = new Adapter_galleryItems_list(getContext(), resultEventItems.getResult().getM_Result());
        if (skip == 0) {
            gridAllItemSecond.setAdapter(listAllItemAdapterList);
        } else {
            listAllItemAdapterList.notifyDataSetChanged();
        }
        Log.d("check item", "responseitem" + gridAllItem.getWidth() + "---" + gridAllItem.getHeight());
        Log.d("check item", "responseitem" + gridAllItemSecond.getWidth() + "---" + gridAllItemSecond.getHeight());


//        setListViewHeightBasedOnChildren(listAllItem);
//        homeView.findViewById(R.id.linlaHeaderProgress).setVisibility(View.GONE);
//        listAllItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(getContext(), resultEvent.getResult().getM_Result().get(i).getTitle(), Toast.LENGTH_SHORT).show();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//
//                ItemDialogue nextFrag = new ItemDialogue();
//
//                transaction
//                        //  .remove(nextFrag)
//                        .add(R.id.root_frame, nextFrag, "second")
//                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                        .addToBackStack(HomeFragment.class.getName())
//                        .commit();
//                EventBus.getDefault().post(new eventItem(getContext(), resultEvent.getResult().getM_Result().get(i)));
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("ImageGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getImage()).commit();
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("TitleGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getTitle()).commit();
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("DatetimeGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getDatetime()).commit();
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("SummeryGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getSummary()).commit();
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("CommentGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getComment()).commit();
//                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt("VisitGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getVisit()).commit();
//            }
//        });
//        listAllItem.setOnScrollListener(new EndlessScrollListener() {
//
//
//            @Override
//            public boolean onLoadMore(int page, int totalItemsCount) {
//                // Triggered only when new data needs to be appended to the list
//                // Add whatever code is needed to append new items to your AdapterView
//                //  loadNextDataFromApi(totalItemsCount);
//                //  Toast.makeText(getContext(), skip + "javad", Toast.LENGTH_SHORT).show();
//                loadNextDataFromApi(5);
//                // or loadNextDataFromApi(totalItemsCount);
//                return false; // ONLY if more data is actually being loaded; false otherwise.
//            }
//        });


        gridAllItem.setOnScrollListener(new EndlessScrollListener() {
            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {

                //  Toast.makeText(getContext(), "salam" + skip, Toast.LENGTH_SHORT).show();
//                skip = skip + 20;
//                galleryCall(skip);

                return false;
            }
        });
    }



}



