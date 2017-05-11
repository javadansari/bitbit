package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bitbit.bitbit.R;

import java.util.ArrayList;
import java.util.List;


import entity.tbl.tbl_galleryCollection;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_filter extends BaseAdapter {


    Context mContext;
    private List<tbl_galleryCollection.entity> resultList = new ArrayList<tbl_galleryCollection.entity>();


    public Adapter_filter(Context mContext, List<tbl_galleryCollection.entity> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }


    @Override
    public int getCount() {

        return resultList.size();
    }

    @Override
    public tbl_galleryCollection.entity getItem(int index) {

        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {


        View rowView = LayoutInflater.from(mContext).inflate(R.layout.filter_cell, viewGroup, false);
        TextView title_name = (TextView) rowView.findViewById(R.id.filter_title);
        title_name.setText(getItem(position).getTitle());

        return rowView;
    }


}
