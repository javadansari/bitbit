package tools;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import entity.Result;
import entity.tbl.tbl_gallery;


/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class eventItem {

    Context mContext;
    private entity.tbl.tbl_gallery.entity  result = new entity.tbl.tbl_gallery().new entity();

    public eventItem(Context mContext, tbl_gallery.entity result) {
        this.mContext = mContext;
        this.result = result;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public tbl_gallery.entity getResult() {
        return result;
    }

    public void setResult(tbl_gallery.entity result) {
        this.result = result;
    }
}
