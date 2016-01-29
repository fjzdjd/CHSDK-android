package com.chehui.jason;

import android.os.Bundle;

import com.chehui.jason.base.fragment.JTitleBaseActivity;
import com.chehui.jason.base.fragment.MintsBaseActivity;
import com.chehui.jason.ui.HomeFragment;

public class MainActivity extends MintsBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushFragmentToBackStack(HomeFragment.class, null);


    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.id_fragment;
    }

    @Override
    protected String getCloseWarning() {
        return "确定要推出程序吗？";
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
