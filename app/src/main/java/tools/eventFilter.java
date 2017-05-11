package tools;

import android.content.Context;

/**
 * Created by Javad Ansari on 3/12/2017.
 */

public class eventFilter {

    Context mContext;
    Boolean value;
    int id;
    int galleryCollection;

    public eventFilter() {
    }

    public eventFilter(Context mContext, Boolean value, int id, int galleryCollection) {
        this.mContext = mContext;
        this.value = value;
        this.id = id;
        this.galleryCollection = galleryCollection;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGalleryCollection() {
        return galleryCollection;
    }

    public void setGalleryCollection(int galleryCollection) {
        this.galleryCollection = galleryCollection;
    }
}



