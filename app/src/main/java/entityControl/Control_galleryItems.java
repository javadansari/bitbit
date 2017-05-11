package entityControl;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import entity.Result;
import entity.Value;
import entity.tbl.tbl_gallery;
import entity.tbl.tbl_galleryItems;
import tools.eventGallery;
import tools.eventGalleryItems;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Control_galleryItems {
    String urlGallery = "";

    public void postReturn(final Context c, Value.Entity_ServiceValue<tbl_galleryItems.post> value) {
        final Result.Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_galleryItems.entity>>();
        final List<tbl_galleryItems.entity> entities = new ArrayList<tbl_galleryItems.entity>();

        RequestParams params = new RequestParams();
        params.put("data", "{'company':1,'galleryCollection':'" + value.getM_Data().getGalleryCollection() + "','galleryCollectionFilterItem':["+value.getM_Data().getGalleryCollectionFilterItem()+"],'skip':" + value.getM_Data().getSkip() + ",'take':" + value.getM_Data().getTake() + "}");


        final AsyncHttpClient client = new AsyncHttpClient();

        if (value.getM_Data().getUrlGallery() != null) {
            urlGallery = value.getM_Data().getUrlGallery().toString();

        }

        client.post("http://185.120.136.11:2100/webservice/SelectGalleryItem" + urlGallery, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Log.d("onSuccess", "response" + this.toString());
                String Onename = null;
                String name = null;
//                List<tbl_gallery.entity> entities = new ArrayList<tbl_gallery.entity>();

                try

                {

                    //code for get JSon object
                    JSONObject one_all_obj = new JSONObject(response.toString());

                    Onename = one_all_obj.getString("Result");
                    JSONObject all_obj = new JSONObject(Onename.toString());


                    name = all_obj.getString("Result");
                    JSONArray mJsonArray = new JSONArray(name);

                    for (int n = 0; n < mJsonArray.length(); n++) {
                        JSONObject object = mJsonArray.getJSONObject(n);


                        tbl_galleryItems.entity entity = new tbl_galleryItems().new entity();


                        entity.setId(object.getInt("id"));
                        entity.setGallery(object.getInt("gallery"));
                        entity.setGalleryCollection(object.getInt("galleryCollection"));
                        entity.setGalleryItemStatus(object.getInt("galleryItemStatus"));
                        entity.setGalleryItemType(object.getInt("galleryItemType"));
                        entity.setVisit(object.getInt("visit"));
                        entity.setRate(object.getInt("rate"));
                        entity.setUrl(object.getString("url"));
                        entity.setTitle(object.getString("title"));
                        entity.setSummary(object.getString("summary"));
                        entity.setComment(object.getString("comment"));
                        //    entity.setFileThumb(object.getString("fileThumb"));
                        //    entity.setFileUpload(object.getString("fileUpload"));
                        entity.setFileSize(object.getString("fileSize"));
                        entity.setDatetime(object.getString("datetime"));
                        entity.setDatetimeCreate(object.getString("datetimeCreate"));
                        entity.setDescription(object.getString("description"));
                        entity.setTitleGalleryCollection(object.getString("titleGalleryCollection"));
                        entity.setTitleGalleryItemStatus(object.getString("titleGalleryItemStatus"));
                        entity.setTitleGalleryItemType(object.getString("titleGalleryItemType"));
                        entity.setFileUpload("http://d.bitbit.ir/cms/Data/Galleryitem/2/" + object.getString("fileUpload"));
                        entity.setFileThumb("http://d.bitbit.ir/cms/Data/GalleryItem/Thumb/" + object.getString("fileThumb"));
                        entities.add(entity);


                    }


                    result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
                    result.setM_Result((ArrayList<tbl_galleryItems.entity>) entities);
                    EventBus.getDefault().post(new eventGalleryItems(c, result));

                } catch (Exception e) {
                    Log.d("fail", "response" + e);

                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.d("fail", "response" + errorResponse);


            }


        });

    }
}
