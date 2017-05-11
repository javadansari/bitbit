package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bitbit.bitbit.R;
import com.bitbit.bitbit.SqlGallery;
import com.bitbit.bitbit.SqlSliders;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import entity.tbl.tbl_gallery;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_gallery extends BaseAdapter {


    Context mContext;
      private List<tbl_gallery.entity> resultList = new ArrayList<tbl_gallery.entity>();

    public Adapter_gallery(Context mContext, List<tbl_gallery.entity> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }

    @Override
    public int getCount() {

        return resultList.size();
    }

    @Override
    public tbl_gallery.entity getItem(int index) {

        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {


        View rowView = LayoutInflater.from(mContext).inflate(R.layout.gallery_cell, viewGroup, false);
        ImageView image_item = (ImageView) rowView.findViewById(R.id.image_gallery);
        Picasso.with(mContext).load(getItem(position).getImage()).placeholder(R.drawable.back_16_9).centerInside().fit().into(image_item);

        TextView title_name = (TextView) rowView.findViewById(R.id.title_gallery);
        TextView comment_name = (TextView) rowView.findViewById(R.id.visit_gallery);
        //     TextView cale_name = (TextView) rowView.findViewById(R.id.txtCaleListSum);


        title_name.setText(getItem(position).getTitle());
        String visit = getItem(position).getVisit() + "";
        comment_name.setText(visit);


        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
