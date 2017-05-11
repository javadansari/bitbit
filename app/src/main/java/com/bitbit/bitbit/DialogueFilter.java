package com.bitbit.bitbit;

import android.app.Activity;
import android.app.LauncherActivity;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter_filter;
import Adapter.Adapter_galleryCollectionSpecification;
import CustomViews.CustomButtonBold;
import cz.msebera.android.httpclient.Header;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_galleryCollection;
import entity.tbl.tbl_galleryCollectionSpecification;
import entity.tbl.tbl_galleryFilter;
import entity.tbl.tbl_galleryItems;
import entityControl.Control_galleryItems;
import tools.eventFilter;
import tools.eventTool;

import static android.view.View.VISIBLE;
import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE;

public class DialogueFilter extends Activity {
    LinearLayout activity_dialogue_filter;
    ListView list_filter;
    ListView list_filter_child;
    ImageView btn_dialogue_filter_close;
    ImageView btn_filter_go;
    int skip = 0;
    int take = 20;
    int thisList = 0;
    int thisListChild = 0;
    int lastItem = 0;

    String galleryCollection = "";
    Result.Entity_ServiceResult<ArrayList<tbl_galleryCollectionSpecification.entity>> resultChild;
    final Result.Entity_ServiceResult<ArrayList<tbl_galleryCollection.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_galleryCollection.entity>>();
    ArrayList<tbl_galleryFilter.entity> galleryFilter = new ArrayList<tbl_galleryFilter.entity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_filter);
        activity_dialogue_filter = (LinearLayout) findViewById(R.id.activity_dialogue_filter);

        //for display
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels - 100;
        int width = displayMetrics.widthPixels - 50;
        activity_dialogue_filter.setMinimumHeight(height);
        activity_dialogue_filter.setMinimumWidth(width);

        //for progress
        findViewById(R.id.HeaderProgressFilter).setVisibility(VISIBLE);
        findViewById(R.id.HeaderProgressFilterChild).setVisibility(VISIBLE);


        //update list
        UpdateFilterList();
        list_filter = (ListView) findViewById(R.id.list_filter);
        list_filter_child = (ListView) findViewById(R.id.list_filter_child);

        //for Close
        btn_dialogue_filter_close = (ImageView) findViewById(R.id.btn_dialogue_filter_close);
        btn_dialogue_filter_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //for filter go
        btn_filter_go = (ImageView) findViewById(R.id.btn_filter_go);
        btn_filter_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Control_galleryItems control = new Control_galleryItems();
                //for Result
//                Result.Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>>();

                //for service user
                Value.Entity_ServiceUser serviceUser = new Value().new Entity_ServiceUser();
                serviceUser.setM_keyAtz("");
                serviceUser.setM_keyUnq("");

                //for post
                tbl_galleryItems.post servicePost = new tbl_galleryItems().new post();
                servicePost.setGalleryType(0);
                servicePost.setCategory("");
                servicePost.setSearchWord("");
                servicePost.setGalleryCollectionFilterItem(getGalleryCollectionFilterItem());
                galleryCollection = PreferenceManager.getDefaultSharedPreferences(DialogueFilter.this).getString("urlFilter", "");
                servicePost.setGalleryCollection(galleryCollection);
                servicePost.setSkip(skip);
                servicePost.setTake(take);
                //for value
                Value.Entity_ServiceValue<tbl_galleryItems.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);
                control.postReturn(DialogueFilter.this, values);
                //send event bus for progress
                EventBus.getDefault().post(new eventTool(DialogueFilter.this, ""));
                finish();
            }
        });



    }


    public void UpdateFilterList() {

        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'galleryCollection':'" + PreferenceManager.getDefaultSharedPreferences(DialogueFilter.this).getString("urlFilter", "") + "','galleryCollectionFilterItem':[],'skip':0,'take':0}");


        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://185.120.136.11:2100/webservice/SelectGalleryCollectionSpecification", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(this.toString(), "ok first" + response);
                final List<tbl_galleryCollection.entity> entities = new ArrayList<tbl_galleryCollection.entity>();
                String name = null;

                try

                {
                    Log.d(this.toString(), "ok first" + "111");
                    //    Log.d(this.toString(), "response" + response);

                    //code for get JSon object
                    JSONObject all_obj = new JSONObject(response.toString());

                    name = all_obj.getString("Result");
                    JSONArray mJsonArray = new JSONArray(name);

                    for (int n = 0; n < mJsonArray.length(); n++) {
                        JSONObject object = mJsonArray.getJSONObject(n);


                        tbl_galleryCollection.entity entity = new tbl_galleryCollection().new entity();


                        entity.setId(object.getInt("id"));
                        entity.setEmployee(object.getInt("employee"));
                        entity.setCompany(object.getInt("company"));
                        entity.setGalleryCollection(object.getInt("galleryCollection"));
                        entity.setGalleryCollectionSpecificationStatus(object.getInt("galleryCollectionSpecificationStatus"));
                        entity.setGalleryCollectionSpecificationType(object.getInt("galleryCollectionSpecificationType"));
                        entity.setTitle(object.getString("title"));
                        entity.setComment(object.getString("comment"));
                        entity.setList(object.getInt("list"));
                        entity.setSort(object.getInt("sort"));
                        entity.setDatetimeCreate(object.getString("datetimeCreate"));
                        entity.setTitleGalleryCollectionSpecificationStatus(object.getString("titleGalleryCollectionSpecificationStatus"));
                        entity.setTitleGalleryCollectionSpecificationType(object.getString("titleGalleryCollectionSpecificationType"));
                        entity.setEntListDeatil(object.getString("entListDeatil"));
                        entity.setEntVoluDetail(object.getString("entVoluDetail"));
                        entities.add(entity);
                    }

                    result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                    result.setM_Result((ArrayList<tbl_galleryCollection.entity>) entities);
                    thisList = result.getM_Result().size();
                    Log.d(this.toString(), "ok first" + "go");
                    Adapter_filter adapter_filter = new Adapter_filter(DialogueFilter.this, result.getM_Result());
                    list_filter.setAdapter(adapter_filter);
                    findViewById(R.id.HeaderProgressFilter).setVisibility(View.GONE);

                    // for child for first time
                    //   list_filter.setSelection(0);
                    //   list_filter.getSelectedView().setSelected(true);
                    childFilter(entities.get(0).getGalleryCollection(), entities.get(0).getId(), 0);


                    list_filter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            //  colorOff(lastItem,true);
                            view.setSelected(true);
                            childFilter(entities.get(i).getGalleryCollection(), entities.get(i).getId(), i);
                            findViewById(R.id.HeaderProgressFilterChild).setVisibility(VISIBLE);
                            // change color of this
                            //     colorOff(i,false);
                            //    list_filter.getChildAt(lastItem).setBackgroundResource(R.color.darkGrayBackground);

                            try {
                                getGalleryCollectionFilterItem();
                            } catch (Exception e) {
                                Log.d("fail", this.toString() + e);

                            }


                        }
                    });

                } catch (Exception e) {
                    Log.d("catch", "response" + this.toString() + e);
                    result.setM_Status(new Result().new Entity_ServiceStatus(true, e.toString()));
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("fail", "response" + this.toString() + errorResponse);

            }


        });


    }


    public void childFilter(final int galleryCollection, final int galleryCollectionSpecification, final int i) {
        lastItem = list_filter.getSelectedItemPosition();
        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'galleryCollection':" + galleryCollection + ",'galleryCollectionSpecification':" + galleryCollectionSpecification + ",'galleryCollectionFilterItem':[" + getGalleryCollectionFilterItem() + "],'skip':0,'take':0}");
        AsyncHttpClient client = new AsyncHttpClient();
        //  SyncHttpClient client = new SyncHttpClient();
        client.post("http://185.120.136.11:2100/webservice/SelectGalleryCollectionSpecificationListDetail", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(this.toString(), "ok first" + response);
                List<tbl_galleryCollectionSpecification.entity> entities = new ArrayList<tbl_galleryCollectionSpecification.entity>();
                String name = null;
                resultChild = new Result().new Entity_ServiceResult<ArrayList<tbl_galleryCollectionSpecification.entity>>();

                try

                {
                    Log.d(this.toString(), "ok first" + "111");
                    //    Log.d(this.toString(), "response" + response);

                    //code for get JSon object
                    JSONObject all_obj = new JSONObject(response.toString());

                    name = all_obj.getString("Result");
                    JSONArray mJsonArray = new JSONArray(name);

                    for (int n = 0; n < mJsonArray.length(); n++) {
                        JSONObject object = mJsonArray.getJSONObject(n);
                        Log.d(this.toString(), "ok first" + "okokokoknnn");

                        tbl_galleryCollectionSpecification.entity entity = new tbl_galleryCollectionSpecification().new entity();

                        entity.setId(object.getInt("id"));
                        entity.setList(object.getInt("list"));
                        entity.setTitle(object.getString("title"));
                        entity.setComment(object.getString("comment"));
                        entity.setSort(object.getInt("sort"));
                        entity.setCount(object.getInt("count"));
                        entity.setSelectedItem(false);
                        for (int i = 0; i < galleryFilter.size(); i++) {
                            if (galleryFilter.get(i).getMinvalue() == entity.getId()) {
                                entity.setSelectedItem(true);
                            }

                        }
                        entities.add(entity);

                    }

                    resultChild.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                    resultChild.setM_Result((ArrayList<tbl_galleryCollectionSpecification.entity>) entities);
                    thisListChild = resultChild.getM_Result().size();
                    Adapter_galleryCollectionSpecification adapter_filter = new Adapter_galleryCollectionSpecification(DialogueFilter.this, galleryCollectionSpecification, resultChild.getM_Result());
                    list_filter_child.setAdapter(adapter_filter);
                    findViewById(R.id.HeaderProgressFilterChild).setVisibility(View.GONE);

                    list_filter_child.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    });


                } catch (Exception e) {
                    Log.d("catch", "response" + this.toString() + e);
                    resultChild.setM_Status(new Result().new Entity_ServiceStatus(false, e.toString()));
                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("fail", "response" + this.toString() + errorResponse);
                resultChild.setM_Status(new Result().new Entity_ServiceStatus(false, errorResponse.toString()));

            }


        });

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
    public void eventFilter(eventFilter eventFilter) {
        tbl_galleryFilter.entity tbl_galleryFilter = new tbl_galleryFilter().new entity();

        if (eventFilter.getValue() == true) {
            tbl_galleryFilter.setMaxvalue(0);
            tbl_galleryFilter.setMinvalue(eventFilter.getId());
            tbl_galleryFilter.setGalleryCollectionSpecification(eventFilter.getGalleryCollection());
            galleryFilter.add(tbl_galleryFilter);
        } else {
            for (int n = 0; n < galleryFilter.size(); n++) {

                if (galleryFilter.get(n).getMinvalue() == eventFilter.getId()) {
                    galleryFilter.remove(n);
                }

            }

        }


    }

    public String getGalleryCollectionFilterItem() {
        String getGalleryCollectionFilterItem = "";
        if (galleryFilter.size() == 0) {
            getGalleryCollectionFilterItem = "";
        } else {
            for (int n = 0; n < galleryFilter.size(); n++) {
                Log.d("catch", "getGalleryCollectionFilterItem" + galleryFilter.get(n).getGalleryCollectionSpecification());

                getGalleryCollectionFilterItem = getGalleryCollectionFilterItem + "{'galleryCollectionSpecification':" + galleryFilter.get(n).getGalleryCollectionSpecification() + ",'minvalue':" + galleryFilter.get(n).getMinvalue() + ",'maxvalue':0}";
                if (n + 1 != galleryFilter.size()) {
                    getGalleryCollectionFilterItem = getGalleryCollectionFilterItem + ",";
                }

            }
        }

        return getGalleryCollectionFilterItem;
    }


}
//{'company':1,'galleryCollection':3,'galleryCollectionSpecification':13,'galleryCollectionFilterItem':[{'galleryCollectionSpecification':12,'minvalue':108,'maxvalue':0}],'skip':0,'take':0}
//{'company':1,'galleryCollection':3,'galleryCollectionSpecification':13,'galleryCollectionFilterItem':[{'galleryCollectionSpecification':12,'minvalue':108,'maxvalue':0},{'galleryCollectionSpecification':13,'minvalue':117,'maxvalue':0}],'skip':0,'take':0}