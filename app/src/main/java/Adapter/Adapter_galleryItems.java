package Adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bitbit.bitbit.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import entity.tbl.tbl_gallery;
import entity.tbl.tbl_galleryItems;

import static com.bitbit.bitbit.R.id.match_parent;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_galleryItems extends BaseAdapter {


    Context mContext;
    private List<tbl_galleryItems.entity> resultList = new ArrayList<tbl_galleryItems.entity>();

    public Adapter_galleryItems(Context mContext, List<tbl_galleryItems.entity> resultList) {
        this.mContext = mContext;
        this.resultList = resultList;
    }

    @Override
    public int getCount() {

        return resultList.size();
    }

    @Override
    public tbl_galleryItems.entity getItem(int index) {

        return resultList.get(index);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {


        View rowView = LayoutInflater.from(mContext).inflate(R.layout.gallery_items_cell, viewGroup, false);
        ImageView image_item = (ImageView) rowView.findViewById(R.id.image_gallery_items);
     //   LinearLayout linearLayout = (LinearLayout) rowView.findViewById(R.id.linearLayout_gallery_items);

        Picasso.with(mContext).load(getItem(position).getFileThumb()).placeholder(R.drawable.progress_animation).into(image_item);

        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
