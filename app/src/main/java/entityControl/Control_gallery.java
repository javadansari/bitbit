package entityControl;

import android.content.Context;
import android.util.Log;

import com.bitbit.bitbit.SqlGallery;
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
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;

import tools.eventGallery;
import tools.eventSliders;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Control_gallery {
    //    Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_gallery.entity>>();
    String urlGallery = "";

    public Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> postReturn(final Context c, Value.Entity_ServiceValue<tbl_gallery.post> value) {
        final Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_gallery.entity>>();
        final List<tbl_gallery.entity> entities = new ArrayList<tbl_gallery.entity>();

        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'category':'" + value.getM_Data().getCategory() + "','galleryType':" + value.getM_Data().getGalleryType() + ",'searchWord':'" + value.getM_Data().getSearchWord() + "','skip':" + value.getM_Data().getSkip() + ",'take':" + value.getM_Data().getTake() + "}");
        //    params.put("data", "{'company':1,'category':'','galleryType':0,'searchWord':'','skip':0,'take':20}");


        final AsyncHttpClient client = new AsyncHttpClient();
        //  SyncHttpClient client = new SyncHttpClient();

        if (value.getM_Data().getUrlGallery() != null) {
            urlGallery = value.getM_Data().getUrlGallery().toString();

        }

        client.post("http://185.120.136.11:2100/webservice/SelectGallery" + urlGallery, params, new JsonHttpResponseHandler() {


            //  client.post("http://185.120.136.11:2100/webservice/SelectGallery" + value.getM_Data().getUrlGallery(), params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Log.d("ok111", "response" + urlGallery.toString());
                String Onename = null;
                String name = null;
//                List<tbl_gallery.entity> entities = new ArrayList<tbl_gallery.entity>();

                try

                {
                    Log.d("ok111", "response" + response);
                    //code for get JSon object
                    JSONObject one_all_obj = new JSONObject(response.toString());

                    Onename = one_all_obj.getString("Result");
                    JSONObject all_obj = new JSONObject(Onename.toString());


                    name = all_obj.getString("Result");
                    JSONArray mJsonArray = new JSONArray(name);

                    for (int n = 0; n < mJsonArray.length(); n++) {
                        JSONObject object = mJsonArray.getJSONObject(n);


                        tbl_gallery.entity entity = new tbl_gallery().new entity();


                        entity.setId(object.getInt("id"));
                        entity.setGalleryStatus(object.getInt("galleryStatus"));
                        entity.setGalleryType(object.getInt("galleryType"));
                        entity.setVisit(object.getInt("visit"));
                        entity.setRate(object.getInt("rate"));
                        entity.setUrl(object.getString("url"));
                        entity.setTitle(object.getString("title"));
                        entity.setSummary(object.getString("summary"));
                        entity.setComment(object.getString("comment"));
                        entity.setDatetime(object.getString("datetime"));
                        entity.setSummary(object.getString("summary"));
                        entity.setImage("http://d.bitbit.ir/cms/Data/Gallery/1/" + object.getString("image"));
                        entities.add(entity);
                        Log.d("okokok", "response" + entity.getTitle());


                    }

//                    SqlGallery sqlGallery = new SqlGallery(result.getM_Result());
//                    sqlGallery.save();


                    result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                    result.setM_Result((ArrayList<tbl_gallery.entity>) entities);
                    EventBus.getDefault().post(new eventGallery(c, result));

                } catch (Exception e) {
                    Log.d("catch", "response" + e);
                    //   result.setM_Status(new Result().new Entity_ServiceStatus(false, e.toString()));

                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("fail", "response" + errorResponse);
                //    result.setM_Status(new Result().new Entity_ServiceStatus(false, errorResponse.toString()));


            }


        });
//        result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
//        result.setM_Result((ArrayList<tbl_gallery.entity>) entities);
        return result;
    }
}
