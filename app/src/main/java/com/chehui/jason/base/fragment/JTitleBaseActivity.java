package com.chehui.jason.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chehui.jason.R;

/**
 * Created by zzp on 2016/1/22.
 */
public abstract class JTitleBaseActivity extends MintsBaseActivity {

    protected JTitleHeaderBar mTitleHeaderBar;
    protected LinearLayout mContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

    }



    protected int getFrameLayoutId() {
        return R.layout.title_base_fragment_with_header_layout;
    }

    protected JTitleHeaderBar getTitleHeaderBar() {
        return (JTitleHeaderBar) findViewById(R.id.frame_title_header);
    }

    protected LinearLayout getContentContainer() {
        return (LinearLayout) findViewById(R.id.content_frame_content);
    }

    protected void initViews() {
        super.setContentView(getFrameLayoutId());
        mTitleHeaderBar = getTitleHeaderBar();
        mContentContainer = getContentContainer();

        if (enableDefaultBack()) {
            mTitleHeaderBar.setLeftOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!processBackPressed()) {
                        doReturnBack();
                    }
                }
            });
        } else {
            mTitleHeaderBar.getLeftViewContainer().setVisibility(View.INVISIBLE);
        }

    }

    protected boolean enableDefaultBack() {
        return true;
    }


    @Override
    public void setContentView(int layoutResID) {
        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mContentContainer.addView(view);
    }

    public void setContentViewSupper(int layoutResID) {
        super.setContentView(layoutResID);
    }

    protected void setHeaderTitle(int id) {
        mTitleHeaderBar.getTitleTextView().setText(id);
    }

    protected void setHeaderTitle(String title) {
        mTitleHeaderBar.setTitle(title);
    }


    protected void setHeaderRightTitle(String title) {
        mTitleHeaderBar.setRightTitleTextView(title);
    }
}
