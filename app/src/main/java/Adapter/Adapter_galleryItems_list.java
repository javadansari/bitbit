package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bitbit.bitbit.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import entity.tbl.tbl_galleryItems;
import tools.BlurTransformation;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class Adapter_galleryItems_list extends BaseAdapter {


    Context mContext;
      private List<tbl_galleryItems.entity> resultList = new ArrayList<tbl_galleryItems.entity>();

    public Adapter_galleryItems_list(Context mContext, List<tbl_galleryItems.entity> resultList) {
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


        View rowView = LayoutInflater.from(mContext).inflate(R.layout.gallery_items_cell_list, viewGroup, false);
        ImageView image_item = (ImageView) rowView.findViewById(R.id.image_gallery_items_list);
        //  Picasso.with(mContext).load(getItem(position).getImage()).into(image_item);
        Picasso.with(mContext).load(getItem(position).getFileUpload()).placeholder(R.drawable.back_16_9).centerCrop().fit().into(image_item);

        TextView title_name = (TextView) rowView.findViewById(R.id.title_gallery_items_list);


        title_name.setText(getItem(position).getTitle());
     //   String visit = getItem(position).getDatetimeCreate() + "";
     //   comment_name.setText(visit);


        return rowView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
