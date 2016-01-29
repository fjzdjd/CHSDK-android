package com.chehui.jason.base.fragment;

import com.chehui.jason.R;

/**
 * Created by zzp on 2016/1/25.
 * 没有头部
 */
public abstract class MintsBaseActivity extends XActivity {

    @Override
    protected String getCloseWarning() {
        return getString(R.string.exit_tips);
    }

    @Override
    protected int getFragmentContainerId() {
        return 0;
    }
}
