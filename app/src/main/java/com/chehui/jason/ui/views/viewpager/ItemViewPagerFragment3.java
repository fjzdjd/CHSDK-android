package com.chehui.jason.ui.views.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chehui.jason.R;
import com.chehui.jason.base.fragment.JasonFragment;

/**
 * Created by zzp on 2016/1/28.
 */
public class ItemViewPagerFragment3 extends JasonFragment {

    @Override
    protected View createView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_item_fragment_layout3, null);

        // 获取Activity传递过来的参数
        Bundle mBundle = getArguments();
        String title = mBundle.getString("arg");
        Toast.makeText(getActivity(), title, Toast.LENGTH_LONG).show();
        return view;
    }
}
