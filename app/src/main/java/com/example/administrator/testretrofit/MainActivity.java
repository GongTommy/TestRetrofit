package com.example.administrator.testretrofit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager vp;
    private List<Fragment> Fragments;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragments = new ArrayList<>();
        Fragments.add(new FragmentThird());
        Fragments.add(new FragmentFirst());
        Fragments.add(new FragmentSecond());
        Fragments.add(new FragmentThird());
        Fragments.add(new FragmentFirst());
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(), Fragments);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(adapter);
        vp.setCurrentItem(1);

        vp.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int i) {
                int pageIndex = i;

                if (i == 0) {
                    // 当视图在第一个时，将页面号设置为图片的最后一张。
                    pageIndex = 3;
                } else if (i == 3 + 1) {
                    // 当视图在最后一个是,将页面号设置为图片的第一张。
                    pageIndex = 1;
                }
                if (i != pageIndex) {
                    vp.setCurrentItem(pageIndex, false);
                    return;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

        private List<Fragment> mList = new ArrayList<Fragment>();
        public ViewPagerFragmentAdapter(FragmentManager fm , List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList != null ? mList.size() : 0;
        }
    }

}
