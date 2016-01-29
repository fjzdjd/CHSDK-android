package com.chehui.jason.ui.views.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chehui.jason.R;
import com.chehui.jason.base.fragment.JasonFragment;
import com.chehui.jason.base.refresh.PtrClassicFrameLayout;
import com.chehui.jason.base.refresh.PtrFrameLayout;
import com.chehui.jason.base.refresh.PtrHandler;

/**
 * Created by zzp on 2016/1/25.
 */
public class ItemViewPagerFragment extends JasonFragment {


    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        final View view = inflater.inflate(R.layout.viewpager_item_fragment_layout, null);

        // 获取Activity传递过来的参数
        Bundle mBundle = getArguments();
        String title = mBundle.getString("arg");
        Toast.makeText(getActivity(), title, Toast.LENGTH_LONG).show();


        final PtrClassicFrameLayout ptrFrame = (PtrClassicFrameLayout) view.findViewById(R
                .id.viewpager_fragment0);

        ptrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrFrame.refreshComplete();
                    }
                }, 1800);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return true;
            }
        });
        ptrFrame.setLastUpdateTimeRelateObject(this);

        // the following are default settings
        ptrFrame.setResistance(1.7f);
        ptrFrame.setRatioOfHeaderHeightToRefresh(1.2f);
        ptrFrame.setDurationToClose(200);
        ptrFrame.setDurationToCloseHeader(1000);
        // default is false
        ptrFrame.setPullToRefresh(false);
        // default is true
        ptrFrame.setKeepHeaderWhenRefresh(true);

        // scroll then refresh
        // comment in base fragment
        ptrFrame.postDelayed(new Runnable() {
            @Override
            public void run() {
                // ptrFrame.autoRefresh();
            }
        }, 150);


        return view;
    }
}


