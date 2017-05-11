package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;

import com.bitbit.bitbit.R;
import com.rey.material.widget.CheckBox;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


import entity.tbl.tbl_galleryCollection;
import entity.tbl.tbl_galleryCollectionSpecification;
import entity.tbl.tbl_galleryFilter;
import tools.eventFilter;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_galleryCollectionSpecification extends BaseAdapter {


    Context mContext;
    int galleryCollection;
    private List<tbl_galleryCollectionSpecification.entity> resultList = new ArrayList<tbl_galleryCollectionSpecification.entity>();

    public Adapter_galleryCollectionSpecification(Context mContext, int galleryCollection, List<tbl_galleryCollectionSpecification.entity> resultList) {
        this.mContext = mContext;
        this.galleryCollection = galleryCollection;
        this.resultList = resultList;
    }

    @Override
    public int getCount() {

        return resultList.size();
    }

    @Override
    public tbl_galleryCollectionSpecification.entity getItem(int index) {

        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View view, ViewGroup viewGroup) {


        final View rowView = LayoutInflater.from(mContext).inflate(R.layout.filter_child_cell, viewGroup, false);
        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.filter_child_title);

        checkBox.setText(getItem(position).getTitle()+getItem(position).getCount());
        if (getItem(position).getSelectedItem() == true) {
            checkBox.setCheckedImmediately(true);

        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                Boolean isChecked;
                if (compoundButton.isChecked()) {
                    rowView.setSelected(true);
                    isChecked = true;
                } else {
                    rowView.setSelected(false);
                    isChecked = false;
                }

                EventBus.getDefault().post(new eventFilter(mContext, isChecked, getItem(position).getId(), galleryCollection));

            }
        });
        return rowView;
    }


}
