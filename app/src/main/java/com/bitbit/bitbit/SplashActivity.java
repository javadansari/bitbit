package com.bitbit.bitbit;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.rey.material.app.Dialog;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;
import entityControl.Control_category;
import entityControl.Control_gallery;
import entityControl.Control_sliders;
import tools.Event;
import tools.eventSliders;


public class SplashActivity extends AppCompatActivity {
    List<tbl_sliders.entity> entTblSliders = new ArrayList<tbl_sliders.entity>();
    int skip = 0;
    int take = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //default String
        PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).edit().putString("urlFilter", "").commit();

        // use
        UpdateOnePage();


    }


    public void NoConnection() {
        final Dialog noConnectionDialog = new Dialog(SplashActivity.this);
        noConnectionDialog.title(R.string.alertConnection).positiveAction(R.string.reConnect).show();
        noConnectionDialog.positiveActionClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateOnePage();
                //    UpdateAutoSearch();
                noConnectionDialog.dismiss();
            }

        });

    }

    public void SplashHandler() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent MainActivityIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(MainActivityIntent);


            }
        }, 2500);

    }


    public void UpdateOnePage() {
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
                    public void onSuccess(int statusCode, cz.
                            msebera.android.httpclient.Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        //call service
                        control_sliders.postReturn(SplashActivity.this, response);
                        SplashHandler();
                    }

                    @Override
                    public void onFailure(int statusCode, cz.
                            msebera.android.httpclient.Header[] headers, Throwable throwable, JSONObject
                                                  errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        NoConnection();

                    }
                }

        );
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
    public void eventAll(eventSliders resultEvent) {


    }


}