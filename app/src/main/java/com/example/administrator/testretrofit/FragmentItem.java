package com.example.administrator.testretrofit;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gong on 2018\10\31 0031.
 */

public class FragmentItem extends Fragment {
    private TextView tv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lv_item, null);
        tv = (TextView) view.findViewById(R.id.tv);
        return view;
    }

    public void setTv(String title){
        tv.setText(title);
    }
}
