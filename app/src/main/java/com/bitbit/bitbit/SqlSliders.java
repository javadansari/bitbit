package com.bitbit.bitbit;

import com.orm.SugarRecord;

import java.util.ArrayList;

import entity.Result;
import entity.tbl.tbl_sliders;

/**
 * Created by Javad Ansari on 4/11/2017.
 */

public class SqlSliders extends SugarRecord {

    ArrayList<tbl_sliders.entity> result = new ArrayList<tbl_sliders.entity>();

    public SqlSliders(ArrayList<tbl_sliders.entity> result) {
        this.result = result;
    }

    public ArrayList<tbl_sliders.entity> getResult() {
        return result;
    }

    public void setResult(ArrayList<tbl_sliders.entity> result) {
        this.result = result;
    }
}

