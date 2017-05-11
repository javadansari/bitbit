package tools;

import android.content.Context;

import java.util.ArrayList;

import entity.Result;
import entity.tbl.tbl_category;
import entity.tbl.tbl_gallery;

/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class eventCategory {

    Context mContext;
    private Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_category.entity>>();

    public eventCategory(Context mContext, Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> result) {
        this.mContext = mContext;
        this.result = result;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> getResult() {
        return result;
    }

    public void setResult(Result.Entity_ServiceResult<ArrayList<tbl_category.entity>> result) {
        this.result = result;
    }
}
