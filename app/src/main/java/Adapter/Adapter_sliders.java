package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bitbit.bitbit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import entity.tbl.tbl_gallery;
import entity.tbl.tbl_sliders;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_sliders extends BaseAdapter{



        Context mContext;
    private List<tbl_sliders.entity> resultList = new ArrayList<tbl_sliders.entity>();


    public Adapter_sliders(Context mContext, List<tbl_sliders.entity> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }


    @Override
    public int getCount() {

        return resultList.size();
    }

    @Override
    public tbl_sliders.entity getItem(int index) {

        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {


        View rowView = LayoutInflater.from(mContext).inflate(R.layout.gallery_cell, viewGroup, false);
//        ImageView image_item = (ImageView) rowView.findViewById(R.id.image_gallery);
//        Picasso.with(mContext).load(getItem(position).getImage()).into(image_item);
//
//        TextView title_name = (TextView) rowView.findViewById(R.id.title_gallery);
//        TextView comment_name = (TextView) rowView.findViewById(R.id.visit_gallery);
//   //     TextView cale_name = (TextView) rowView.findViewById(R.id.txtCaleListSum);
//
//
//        title_name.setText(getItem(position).getTitle());
//        comment_name.setText(getItem(position).getTitle());
//
//
        Toast.makeText(mContext, resultList.get(position).getTitle(), Toast.LENGTH_SHORT).show();

        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

}
