package com.chehui.jason.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chehui.jason.R;

/**
 * Created by zzp on 2016/1/25.
 */
public abstract class JTitleBaseFragment extends JasonFragment {

    protected JTitleHeaderBar mTitleHeaderBar;
    protected LinearLayout mContentContainer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(getFrameLayoutId(), null);
        LinearLayout contentContainer = (LinearLayout) view.findViewById(R.id
                .content_frame_content);

        mTitleHeaderBar = (JTitleHeaderBar) view.findViewById(R.id.frame_title_header);
        if (enableDefaultBack()) {
            mTitleHeaderBar.setLeftOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        } else {
            mTitleHeaderBar.getLeftViewContainer().setVisibility(View.INVISIBLE);
        }
        mContentContainer = contentContainer;
        View contentView = createView(inflater, view, savedInstanceState);
        contentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        contentContainer.addView(contentView);
        return view;
    }

    protected int getFrameLayoutId() {
        return R.layout.title_base_fragment_with_header_layout;
    }

    /**
     * make it looks like Activity
     */
    private void onBackPressed() {
        getContext().onBackPressed();
    }

    /**
     * 默认 ——退回
     *
     * @return true
     */
    protected boolean enableDefaultBack() {
        return true;
    }

    /**
     * 设置头部标题
     *
     * @param id 资源文件
     */
    protected void setHeaderTitle(int id) {
        mTitleHeaderBar.getTitleTextView().setText(id);
    }

    /**
     * 设置头部标题
     *
     * @param title String
     */
    protected void setHeaderTitle(String title) {
        mTitleHeaderBar.getTitleTextView().setText(title);
    }

    /**
     * 设置右边标题文字
     *
     * @param title String
     */
    protected void setHeaderRightTitle(String title) {
        mTitleHeaderBar.getRightTitleTextView().setText(title);
    }

    /**
     * 取得返回值
     *
     * @return
     */
    public JTitleHeaderBar getTitleHeaderBar() {
        return mTitleHeaderBar;
    }

}
