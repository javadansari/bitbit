package Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bitbit.bitbit.FavoriteFragment;
import com.bitbit.bitbit.HomeFragment;
import com.bitbit.bitbit.RootFragment;
import com.bitbit.bitbit.SearchFragment;
import com.bitbit.bitbit.UserFragment;


/**
 * Created by Javad Ansari on 1/6/2017.
 */

public class FragmentViewAdapter extends FragmentPagerAdapter {


    public FragmentViewAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
    }



    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RootFragment.newInstance();
            case 1:
                return FavoriteFragment.newInstance();
            case 2:
                return SearchFragment.newInstance();
           case 3:
                return UserFragment.newInstance();

            default:
                return null;
        }
    }


}