package com.bitbit.bitbit;

import android.app.Activity;
import android.preference.PreferenceManager;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import CustomViews.CustomButton;
import CustomViews.CustomTextView;
import CustomViews.CustomTextViewBold;
import tools.eventItem;

//public class ItemDialogue extends Fragment {
public class ItemDialogue extends Fragment {
    private View itemView;


    public static ItemDialogue newInstance() {
        ItemDialogue newInstanceItemActivity = new ItemDialogue();
        return newInstanceItemActivity;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.activity_item_dialogue, container, false);

        final String ImageGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("ImageGetGetExtraShared", "");
        final String TitleGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("TitleGetGetExtraShared", "");
        final String DatetimeGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("DatetimeGetGetExtraShared", "");
        final String SummeryGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("SummeryGetGetExtraShared", "");
        final String CommentGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("CommentGetGetExtraShared", "");
        final int VisitGetGetExtraShared = PreferenceManager.getDefaultSharedPreferences(getActivity()).getInt("VisitGetGetExtraShared", 0);

        CustomTextViewBold text_item_title = (CustomTextViewBold) itemView.findViewById(R.id.text_item_title);
        CustomTextView text_item_datetime = (CustomTextView) itemView.findViewById(R.id.text_item_datetime);
        text_item_title.setText(TitleGetGetExtraShared);
        text_item_datetime.setText(DatetimeGetGetExtraShared);
        ImageView imageItem = (ImageView) itemView.findViewById(R.id.image_item);
        Picasso.with(getContext()).load(ImageGetGetExtraShared).placeholder(R.drawable.back_16_9).fit().centerCrop().into(imageItem);
        CustomButton btn_back = (CustomButton) itemView.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                FragmentTransaction transaction = getFragmentManager().popBackStack();

               getFragmentManager().popBackStack();
             //   RootFragment nextFrag = RootFragment.newInstance() ;
//                transaction
//                     //   .remove(nextFrag)
//                        .replace(R.id.root_frame,HomeFragment.instantiate(getContext(), HomeFragment.class.getName()))
//                       .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                    //    .addToBackStack(ItemDialogue.class.getName())
//                        .commit();
            }
        });


        return itemView;



    }


}

