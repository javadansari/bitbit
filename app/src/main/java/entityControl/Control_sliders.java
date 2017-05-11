package entityControl;

import android.content.Context;
import android.util.Log;


import com.bitbit.bitbit.SqlSliders;
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
import entity.tbl.tbl_sliders;
import tools.Event;
import tools.eventSliders;

/**
 * Created by Javad Ansari on 4/10/2017.
 */

public class Control_sliders {

    Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_sliders.entity>>();

    // public void postReturn(final Context c, JSONObject response) {
    public Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> postReturn(final Context c, JSONObject response) {


        String name = null;
        List<tbl_sliders.entity> entTblSliders = new ArrayList<tbl_sliders.entity>();
        try

        {
            //code for get JSon object
            JSONObject all_obj = new JSONObject(response.toString());
            name = all_obj.getString("Result");
            JSONArray mJsonArray = new JSONArray(name);


            // sql_sliders.

            for (int n = 0; n < mJsonArray.length(); n++) {
                JSONObject object = mJsonArray.getJSONObject(n);


                tbl_sliders.entity tbl_sliders = new tbl_sliders().new entity();

                tbl_sliders.setType(object.getInt("type"));
                tbl_sliders.setId(object.getInt("id"));
                tbl_sliders.setUrl(object.getString("url"));
                tbl_sliders.setTitle(object.getString("title"));
                tbl_sliders.setSummary(object.getString("summary"));
                String imageUrl = "http://d.bitbit.ir/cms/Data/Gallery/1/" + object.getString("image");
                tbl_sliders.setImage(imageUrl);
                entTblSliders.add(tbl_sliders);

            }

            result.setM_Status(new Result().new Entity_ServiceStatus(true, ""));
            result.setM_Result((ArrayList<tbl_sliders.entity>) entTblSliders);
       //     EventBus.getDefault().post(new eventSliders(c, result));
            Log.d("okokokok", "event");
        } catch (Exception e) {
            Log.d("catch", "response" + e);
            result.setM_Status(new Result().new Entity_ServiceStatus(false, e.toString()));
            //  EventBus.getDefault().post(new eventSliders(c, result));

        }

        return result;
    }

}
