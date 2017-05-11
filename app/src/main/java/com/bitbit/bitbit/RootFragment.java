package com.bitbit.bitbit;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Javad Ansari on 4/23/2017.
 */

public class RootFragment extends Fragment {
    private View rootView;

    public static RootFragment newInstance() {
        RootFragment newInstanceRootFragment = new RootFragment();
        return newInstanceRootFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_root, container, false);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        HomeFragment nextFrag = new HomeFragment();
        transaction
         //       .remove(nextFrag)
                .add(R.id.root_frame, nextFrag,"first")
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();

        return rootView;

    }
}
