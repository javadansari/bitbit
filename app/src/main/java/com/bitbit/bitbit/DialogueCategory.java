package com.bitbit.bitbit;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Adapter.Adapter_category;
import cz.msebera.android.httpclient.Header;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_category;
import entity.tbl.tbl_galleryItems;
import entityControl.Control_galleryItems;
import tools.eventGallery;
import tools.eventTool;

import static android.view.View.VISIBLE;

public class DialogueCategory extends Activity {
    LinearLayout activity_dialogue_category;
    ListView list_category;
    ImageView btn_dialogue_category_close;
    int skip = 0;
    int take = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_category);
        activity_dialogue_category = (LinearLayout) findViewById(R.id.activity_dialogue_category);
        //for display
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels - 100;
        int width = displayMetrics.widthPixels - 50;
        activity_dialogue_category.setMinimumHeight(height);
        activity_dialogue_category.setMinimumWidth(width);

        //for progress
        findViewById(R.id.HeaderProgressCategory).setVisibility(VISIBLE);

        //update list
        UpdateList();
        list_category = (ListView) findViewById(R.id.list_category);

        //for Close
        btn_dialogue_category_close = (ImageView) findViewById(R.id.btn_dialogue_category_close);
        btn_dialogue_category_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    public void UpdateList() {
        final Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_category.entity>>();

        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'skip':0,'take':200}");


        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://185.120.136.11:2100/webservice/SelectGalleryCollectionHierarch", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, final JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.d(this.toString(), "ok first" + response);
                List<tbl_category.entity> entities = new ArrayList<tbl_category.entity>();
                String name = null;

                try

                {
                    Log.d(this.toString(), "response" + response);
                    //code for get JSon object
                    JSONObject all_obj = new JSONObject(response.toString());

                    name = all_obj.getString("Result");
                    JSONArray mJsonArray = new JSONArray(name);

                    for (int n = 0; n < mJsonArray.length(); n++) {
                        JSONObject object = mJsonArray.getJSONObject(n);


                        tbl_category.entity entity = new tbl_category().new entity();


                        entity.setId(object.getInt("id"));
                        entity.setParent(object.getString("parent"));
                        entity.setCompany(object.getInt("company"));
                        entity.setGalleryCollectionStatus(object.getInt("galleryCollectionStatus"));
                        entity.setGalleryCollectionType(object.getInt("galleryCollectionType"));
                        entity.setUrl(object.getString("url"));
                        entity.setTitle(object.getString("title"));
                        entity.setComment(object.getString("comment"));
                        entity.setSort(object.getInt("sort"));
                        entity.setDatetimeCreate(object.getString("datetimeCreate"));
                        entity.setTitleGalleryCollectionStatus(object.getString("titleGalleryCollectionStatus"));
                        entity.setTitleGalleryCollectionType(object.getString("titleGalleryCollectionType"));
                        entity.setLevel(object.getString("level"));
                        entity.setEntGalleryCollectionCategory(object.getString("entGalleryCollectionCategory"));
                        entity.setEntGalleryItem(object.getString("entGalleryItem"));
                        if (entity.getGalleryCollectionStatus() != 0) {
                            entities.add(entity);
                        }
                    }

                    result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                    result.setM_Result((ArrayList<tbl_category.entity>) entities);
                    Log.d(this.toString(), "response" + result.getM_Result().size());
                    final Adapter_category adapter_category = new Adapter_category(DialogueCategory.this, result.getM_Result());
                    list_category.setAdapter(adapter_category);
                    findViewById(R.id.HeaderProgressCategory).setVisibility(View.GONE);
                    list_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
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
                            servicePost.setGalleryCollection(adapter_category.getItem(i).getUrl());
                            servicePost.setSkip(skip);
                            servicePost.setTake(take);
                            //for value
                            Value.Entity_ServiceValue<tbl_galleryItems.post> values = new Value().new Entity_ServiceValue<>(serviceUser, servicePost);
                            control.postReturn(DialogueCategory.this, values);
                            PreferenceManager.getDefaultSharedPreferences(DialogueCategory.this).edit().putString("urlFilter", adapter_category.getItem(i).getUrl()).commit();
                            //send event bus for progress
                            EventBus.getDefault().post(new eventTool(DialogueCategory.this, ""));

                            finish();
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

}

