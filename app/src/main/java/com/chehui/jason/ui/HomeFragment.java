package com.chehui.jason.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chehui.jason.R;
import com.chehui.jason.base.fragment.JTitleBaseFragment;
import com.chehui.jason.base.refresh.PtrDefaultHandler;
import com.chehui.jason.base.refresh.PtrFrameLayout;
import com.chehui.jason.base.refresh.PtrHandler;
import com.chehui.jason.base.refresh.StoreHouseHeader;
import com.chehui.jason.ui.views.viewpager.ViewPagerActivity;
import com.chehui.jason.utils.LocalDisplay;

/**
 * Created by zzp on 2016/1/22.
 */
public class HomeFragment extends JTitleBaseFragment {


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, null);

        initWidgets();

        view.setBackgroundColor(getResources().getColor(R.color.refresh));
        final PtrFrameLayout ptrFrameLayout = (PtrFrameLayout) view.findViewById(R.id
                .fragment_ptr_home_ptr_frame);
        StoreHouseHeader header = new StoreHouseHeader(getContext());
        header.setPadding(0, LocalDisplay.dp2px(20), 0, LocalDisplay.dp2px(20));
        header.initWithString("CHE HUI", 27);
        ptrFrameLayout.setDurationToCloseHeader(1500);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                ptrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrameLayout.refreshComplete();
                        Intent intent = new Intent();
                        Class<?> dstClassName = ViewPagerActivity.class;
                        intent.setClass(getActivity(), dstClassName);
                        startActivity(intent);
                    }
                }, 1500);
            }
        });
        return view;

    }

    /***
     * 初始化组件值
     */
    private void initWidgets() {
        setHeaderTitle("车惠SDK");
        setHeaderRightTitle("设置");


    }

    @Override
    protected boolean enableDefaultBack() {
        return true;
    }
}
