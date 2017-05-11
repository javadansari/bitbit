package tools;

import android.content.Context;

import java.util.ArrayList;

import entity.Result;
import entity.tbl.tbl_category;

/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class eventTool {

    Context mContext;
    String value;
    public eventTool(){}
    public eventTool(Context mContext, String value) {
        this.mContext = mContext;
        this.value = value;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
