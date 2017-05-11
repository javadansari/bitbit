package com.bitbit.bitbit;

import android.content.Context;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import entity.Result;
import entity.tbl.tbl_gallery;

/**
 * Created by Javad Ansari on 4/11/2017.
 */

public class SqlGallery extends SugarRecord {


    //    private Result.Entity_ServiceResult<ArrayList<tbl_gallery.entity>> result = new Result().new Entity_ServiceResult<ArrayList<tbl_gallery.entity>>();
    private List<tbl_gallery.entity> result = new ArrayList<tbl_gallery.entity>();

    public SqlGallery(List<tbl_gallery.entity> result) {
        this.result = result;
    }

    public List<tbl_gallery.entity> getResult() {
        return result;
    }

    public void setResult(List<tbl_gallery.entity> result) {
        this.result = result;
    }
}

