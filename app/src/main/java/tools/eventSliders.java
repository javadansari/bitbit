package tools;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import entity.Result;
import entity.tbl.tbl_sliders;

/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class eventSliders {

    Context mContext;
    private Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_sliders.entity>>();

    public eventSliders(Context mContext, Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result) {
        this.mContext = mContext;
        this.result = result;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> getResult() {
        return result;
    }

    public void setResult(Result.Entity_ServiceResult<ArrayList<tbl_sliders.entity>> result) {
        this.result = result;
    }
}
