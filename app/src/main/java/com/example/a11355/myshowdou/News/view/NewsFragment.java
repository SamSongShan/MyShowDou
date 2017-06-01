package com.example.a11355.myshowdou.News.view;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.example.a11355.myshowdou.Base.BaseFragment;
import com.example.a11355.myshowdou.R;
import com.example.a11355.myshowdou.Utils.Constant;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /*
    * 新闻
    *
    * */
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    private List<Fragment> fragments;

    @Override
    protected int getViewResId() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init(View v) {
        fragments = new ArrayList<>();

        for (int i = 0; i < Constant.Strings.NewsDetailTitle.length; i++) {
            fragments.add(NewsDetailFragment.instantiate(getActivity(),));
        }
        srl.setOnRefreshListener(this);
        vp.setAdapter(new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return null;
            }

            @Override
            public int getCount() {
                return Constant.Strings.NewsDetailTitle.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return Constant.Strings.NewsDetailTitle[position];
            }
        });
    }

    @Override
    public void onRefresh() {

    }


}
