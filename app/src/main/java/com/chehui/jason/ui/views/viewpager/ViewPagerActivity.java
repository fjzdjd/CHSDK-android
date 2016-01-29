package com.chehui.jason.ui.views.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.Toast;

import com.chehui.jason.R;
import com.chehui.jason.base.fragment.JTitleBaseActivity;
import com.chehui.jason.base.fragment.JasonFragment;
import com.chehui.jason.base.viewpager.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zzp on 2016/1/25.
 */
public class ViewPagerActivity extends JTitleBaseActivity {
    private List<String> listContentTitle = new ArrayList<>();
    private int w_screen;
    private TabPageIndicator mCatTabPageIndicator;
    private ViewPager mFragmentViewPager;
    private FragmentViewPagerAdapter mPagerAdapter;
    /**
     * 新建fragment集合
     */
    private ArrayList<JasonFragment> listFragment = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHeaderTitle("viewpager页面");
        setHeaderRightTitle(" ");
        setContentView(R.layout.tabs_activity_layout);
        listContentTitle.add("第一节目");
        listContentTitle.add("第二节目");
        listContentTitle.add("第三节目");
        listContentTitle.add("第四节目");
        initCurrentFragment();

    }

    /**
     * 获取屏幕宽度
     */
    private void getScreenWidth() {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        w_screen = dm.widthPixels;

    }

    private void initCurrentFragment() {
        getScreenWidth();
        int startIndex = 0;

        ItemViewPagerFragment viewPagerFragment = new ItemViewPagerFragment();
        ItemViewPagerFragment1 viewPagerFragment1 = new ItemViewPagerFragment1();
        ItemViewPagerFragment2 viewPagerFragment2 = new ItemViewPagerFragment2();
        ItemViewPagerFragment3 viewPagerFragment3 = new ItemViewPagerFragment3();

        listFragment.add(viewPagerFragment);
        listFragment.add(viewPagerFragment1);
        listFragment.add(viewPagerFragment2);
        listFragment.add(viewPagerFragment3);


        mCatTabPageIndicator = (TabPageIndicator) this.findViewById(R.id.tab_indicator);
        mFragmentViewPager = (ViewPager) this.findViewById(R.id.tab_pager_content);

        mPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), listFragment);
        mFragmentViewPager.setAdapter(mPagerAdapter);

        //匹配viewpager头部
        mCatTabPageIndicator.setViewHolderCreator(new TabPageIndicator.ViewHolderCreator() {
            @Override
            public TabPageIndicator.ViewHolderBase createViewHolder() {
                return new HomeCatItemViewHolder();
            }
        });

        mCatTabPageIndicator.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageSelected(int i) {
                switchTo(i);
//                Toast.makeText(ViewPagerActivity.this, i + "", Toast.LENGTH_SHORT).show();
            }


        });

        mCatTabPageIndicator.setViewPager(mFragmentViewPager);
        mFragmentViewPager.setCurrentItem(startIndex);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCatTabPageIndicator.moveToItem(mFragmentViewPager.getCurrentItem());
    }

    private void switchTo(int position) {
        mPagerAdapter.switchTO(position);
    }

    @Override
    protected boolean enableDefaultBack() {
        return false;
    }

    /**
     * fragment适配viewpager
     */
    private class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {

        private final ArrayList<JasonFragment> mViewPagerFragments;

        private FragmentManager mFragmentManager;
        private JasonFragment mCurrentFragment;

        public FragmentViewPagerAdapter(FragmentManager fm, ArrayList<JasonFragment> list) {
            super(fm);
            mFragmentManager = fm;
            mViewPagerFragments = list;
        }

        @Override
        public Fragment getItem(int position) {
            // 新建一个Fragment来展示ViewPager item的内容，并传递参数
            Bundle bundle = new Bundle();
            bundle.putString("arg", listContentTitle.get(position));
            mViewPagerFragments.get(position).setArguments(bundle);
            return mViewPagerFragments.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public int getCount() {
            return mViewPagerFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        public void switchTO(final int position) {
            int len = mViewPagerFragments.size();
            for (int i = 0; i < len; i++) {
                JasonFragment fragment = mViewPagerFragments.get(i);
                if (i == position) {
                    mCurrentFragment = fragment;
                    mFragmentManager.beginTransaction().show(mCurrentFragment);
                } else {
                    mFragmentManager.beginTransaction().hide(mCurrentFragment);
                }
            }
        }

    }

    /**
     * 指示器样式
     */
    private class HomeCatItemViewHolder extends TabPageIndicator.ViewHolderBase {

        private TextView mNameView;

        private View mTagView;

        @Override
        public View createView(LayoutInflater layoutInflater, int position) {
            View view = layoutInflater.inflate(R.layout.view_pager_indicator_item, null);
            //根据屏幕大小进行适配
            view.setLayoutParams(new AbsListView.LayoutParams(w_screen / 4, ViewGroup
                    .LayoutParams.MATCH_PARENT));
            mNameView = (TextView) view.findViewById(R.id.view_pager_indicator_name);
            mTagView = view.findViewById(R.id.view_pager_indicator_tab_current);
            return view;
        }

        @Override
        public void updateView(int position, boolean isCurrent) {

            mNameView.setText(listContentTitle.get(position));
            if (isCurrent) {
                mTagView.setVisibility(View.VISIBLE);
            } else {
                mTagView.setVisibility(View.INVISIBLE);
            }

        }

    }

}
