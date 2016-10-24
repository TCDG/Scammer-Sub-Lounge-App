package com.collectivedev.sslapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.collectivedev.sslapp.R;


/**
 * Created by XeliteXirish on 24/10/2016 (www.xelitexirish.com)
 */

public class FragmentHome extends Fragment{

    CardView mCardViewInfo;
    CardView mCardViewStaffList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCardViewInfo = (CardView) view.findViewById(R.id.card_info);
        mCardViewStaffList = (CardView) view.findViewById(R.id.card_staff_list);
    }
}
