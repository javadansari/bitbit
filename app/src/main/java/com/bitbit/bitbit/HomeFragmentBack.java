package com.bitbit.bitbit;

import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter_gallery;
import Adapter.EndlessScrollListener;
import cz.msebera.android.httpclient.Header;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;
import entityControl.Control_category;
import entityControl.Control_gallery;
import entityControl.Control_sliders;
import tools.eventCategory;
import tools.eventGallery;
import tools.eventItem;

/**
 * Created by Javad Ansari on 4/9/2017.
 */

public class HomeFragmentBack extends Fragment {
    private String title;
    private int page;
    private int preLast;
    //For View Flipper


    private String[] goToSiteImageStirng = {"http://www.google.com", "http://www.yahoo.com"
            , "http://www.farsnews.com", "http://www.zoomit.com",};
    private int[] imageArray = {R.drawable.slder01, R.drawable.slder02,
            R.drawable.slder03, R.drawable.slder04};
    int iForPic = 0;
    int goToSiteImage;
    int skip = 0;
    int take = 13;
    ImageView Sliders;
    Adapter_gallery listAllItemAdapter;
    private View homeView;
    List<tbl_sliders.entity> entTblSliders = new ArrayList<tbl_sliders.entity>();
    ListView listAllItem;

    public static HomeFragmentBack newInstance() {
        HomeFragmentBack newInstanceHomeActivity = new HomeFragmentBack();
        return newInstanceHomeActivity;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.fragment_home, container, false);
        //for progress bas
        homeView.findViewById(R.id.linlaHeaderProgress).setVisibility(View.VISIBLE);
        homeView.findViewById(R.id.HeaderProgressImage).setVisibility(View.VISIBLE);
        Sliders = (ImageView) homeView.findViewById(R.id.ImageChange);

        //call sliders
        sliderCall();


        //
        // ImageChangeItem = (ImageView) homeView.findViewById(R.id.ImageChange);

        listAllItem = (ListView) homeView.findViewById(R.id.list_gallery);

        Control_gallery control = new Control_gallery();
        //for Result
        Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_gallery.entity>>();

        //for service user
        Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
        serviceUser.setM_keyAtz("");
        serviceUser.setM_keyUnq("");

        //for post
        tbl_gallery.post servicePost = new tbl_gallery().new post();
        servicePost.setGalleryType(0);
        servicePost.setCategory("");
        servicePost.setSearchWord("");
        servicePost.setSkip(skip);
        servicePost.setTake(take);
        //for value
        Value.Entity_ServiceValue<tbl_gallery.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);
        result = control.postReturn(getActivity(), values);


        //View Flipper


        // for menu
        Control_category control_category = new Control_category();
        control_category.postReturn(getContext());
        // for Sliders
        ShowSliders();
        return homeView;

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

//    @Subscribe
//    public void eventSliders(final eventSliders resultEvent) {
//        final Handler mHandler = new Handler();
//        new Thread(new Runnable() {
//            public void run() {
//
//
//                iForPic++;
//                if (iForPic == imageArray.length) {
//                    iForPic = 0;
//                }
//                //     Picasso.with(getContext()).load(imageArray[2]).into(ImageChangeItem);
//
//                //     ImageChangeItem.setImageResource(imageArray[iForPic]);
//                //   ImageChangeItem.setImageResource(resultEvent.getResult().getM_Result().get(iForPic).getImage());
//
//                goToSiteImage = iForPic;
//                mHandler.postDelayed(this, 500);
//
//            }
//        }).start();
//
//
//    }


    @Subscribe
    public void eventAll(final eventGallery resultEvent) {

        listAllItemAdapter = new Adapter_gallery(getContext(), resultEvent.getResult().getM_Result());
        listAllItem.setAdapter(listAllItemAdapter);





        homeView.findViewById(R.id.linlaHeaderProgress).setVisibility(View.GONE);
        listAllItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), resultEvent.getResult().getM_Result().get(i).getTitle(), Toast.LENGTH_SHORT).show();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                ItemDialogue nextFrag = new ItemDialogue();

                transaction
                        //  .remove(nextFrag)
                        .add(R.id.root_frame, nextFrag, "second")
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack(HomeFragmentBack.class.getName())
                        .commit();
                EventBus.getDefault().post(new eventItem(getContext(), resultEvent.getResult().getM_Result().get(i)));
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("ImageGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getImage()).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("TitleGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getTitle()).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("DatetimeGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getDatetime()).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("SummeryGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getSummary()).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putString("CommentGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getComment()).commit();
                PreferenceManager.getDefaultSharedPreferences(getContext()).edit().putInt("VisitGetGetExtraShared", resultEvent.getResult().getM_Result().get(i).getVisit()).commit();
            }

        });

        listAllItem.setOnScrollListener(new EndlessScrollListener() {

            @Override
            public boolean onLoadMore(int page, int totalItemsCount) {

             //      Toast.makeText(getContext(), "hi", Toast.LENGTH_SHORT).show();

                   return false;
            }
        });
        setListViewHeightBasedOnChildren(listAllItem);
// Initialization stuff.


    }


    public void loadNextDataFromApi(int offset) {
        // Send an API request to retrieve appropriate paginated data
        //  --> Send the request including an offset value (i.e `page`) as a query parameter.
        //  --> Deserialize and construct new model objects from the API response
        //  --> Append the new data objects to the existing set of items inside the array of items
        //  --> Notify the adapter of the new items made with `notifyDataSetChanged()`
        Toast.makeText(getContext(), "salam", Toast.LENGTH_SHORT).show();
    }


    @Subscribe
    public void eventMenu(final eventCategory resultEventMenu) {
        // ListView listAllItem = (ListView) homeView.findViewById(R.id.list_gallery);

        homeView.findViewById(R.id.btn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                final PopupMenu popup = new PopupMenu(getContext(), homeView.findViewById(R.id.btn_menu));
                //Inflating the Popup using xml file
//                popup.getMenuInflater()
//                        .inflate(R.menu.poupup_menu, popup.getMenu());
                for (int i = 0; i < resultEventMenu.getResult().getM_Result().size(); i++) {
                    String menu = resultEventMenu.getResult().getM_Result().get(i).getTitle();
                    popup.getMenu().add(menu);

                }
//              //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                getContext(),
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT

                        ).show();

                        Control_gallery control = new Control_gallery();
                        //for Result
                        Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_gallery.entity>>();

                        //for service user
                        Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
                        serviceUser.setM_keyAtz("");
                        serviceUser.setM_keyUnq("");

                        //for post
                        tbl_gallery.post servicePost = new tbl_gallery().new post();
                        servicePost.setGalleryType(0);
                        servicePost.setCategory("");
                        servicePost.setSearchWord("");
                        servicePost.setUrlGallery("/" + resultEventMenu.getResult().getM_Result().get(item.getItemId()).getUrl());
                        servicePost.setSkip(skip);
                        servicePost.setTake(take);
                        //for value
                        Value.Entity_ServiceValue<tbl_gallery.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);
                        Log.d("catch", "response" + servicePost.getUrlGallery());
                        control.postReturn(getContext(), values);


                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        }); //closing the setOnClickListener method

    }

    public void ShowSliders() {
        final Control_sliders control_sliders = new Control_sliders();
        //for Result
        Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_sliders.entity>>();

        //for service user
        Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
        serviceUser.setM_keyAtz("");
        serviceUser.setM_keyUnq("");

        //for post
        tbl_sliders.post servicePost = new tbl_sliders().new post();
        servicePost.setSearchWord("");
        servicePost.setSkip(0);
        servicePost.setTake(6);

        //for value
        final Value.Entity_ServiceValue<tbl_sliders.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);


        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'take':" + values.getM_Data().getTake() + "}");
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://185.120.136.11:2100/webservice/SelectSlider", params, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        //call service
                        control_sliders.postReturn(getContext(), response);

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject
                                                  errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);


                    }
                }

        );
    }


    public void sliderCall() {


        final Control_sliders control_sliders = new Control_sliders();
        //for Result
        final Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_sliders.entity>>();

        //for service user
        Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
        serviceUser.setM_keyAtz("");
        serviceUser.setM_keyUnq("");

        //for post
        tbl_sliders.post servicePost = new tbl_sliders().new post();
        servicePost.setSearchWord("");
        servicePost.setSkip(0);
        servicePost.setTake(6);

        //for value
        Value.Entity_ServiceValue<tbl_sliders.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);


        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'take':" + values.getM_Data().getTake() + "}");
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://185.120.136.11:2100/webservice/SelectSlider", params, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        //call service
                        final Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result_tbl_sliders = control_sliders.postReturn(getContext(), response);
                        final Handler handler = new Handler();
                        Runnable runnable = new Runnable() {
                            int i = 0;

                            public void run() {

                                iForPic++;
                                if (iForPic == result_tbl_sliders.getM_Result().size()) {
                                    iForPic = 0;
                                }
                                //   Sliders.setImageResource(R.drawable.back);
                                Picasso.with(getContext()).load(result_tbl_sliders.getM_Result().get(iForPic).getImage()).placeholder(R.drawable.back_16_9).centerCrop().fit().into(Sliders);
                                homeView.findViewById(R.id.HeaderProgressImage).setVisibility(View.GONE);

                                goToSiteImage = iForPic;
                                handler.postDelayed(this, 5000);

                            }
                        };
                        handler.postDelayed(runnable, 5000);


                        //   Toast.makeText(getContext(), "jjjjj", Toast.LENGTH_SHORT).show();
                        //    Picasso.with(getContext()).load(result_tbl_sliders.getM_Result().get(1).getImage()).fit().into(Sliders);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject
                                                  errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);


                    }
                }

        );

    }


}


