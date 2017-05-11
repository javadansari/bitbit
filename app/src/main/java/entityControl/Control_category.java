package entityControl;

import android.content.Context;
import android.util.Log;

import com.bitbit.bitbit.SqlCategory;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_category;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;
import tools.eventCategory;
import tools.eventSliders;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Control_category {
    Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_category.entity>>();

    public void postReturn(final Context c) {


        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'skip':0,'take':200}");


        AsyncHttpClient client = new AsyncHttpClient();
//          SyncHttpClient client = new SyncHttpClient();

        client.post("http://185.120.136.11:2100/webservice/SelectGalleryCollectionHierarch", params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
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
                       if (entity.getGalleryCollectionStatus() !=0) {
                           entities.add(entity);
                       }
                    }
                        result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                        result.setM_Result((ArrayList<tbl_category.entity>) entities);
                    EventBus.getDefault().post(new eventCategory(c, result));
                    Log.d(this.toString(), "response" + result.getM_Result().size());



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
