package com.chehui.jason.base.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chehui.jason.R;

/**
 * Created by zzp on 2016/1/22.
 */
public class JTitleHeaderBar extends RelativeLayout {

    /**
     * 头部标题
     */
    private TextView mCenterTitleTextView;
    private ImageView mLeftReturnImageView;
    private RelativeLayout mLeftViewContainer;
    private RelativeLayout mRightViewContainer;
    private RelativeLayout mCenterViewContainer;
    private String mTitle;
    /**
     * 右部标题
     */
    private TextView mRightTitleTextView;

    public JTitleHeaderBar(Context context) {
        this(context, null);
    }

    public JTitleHeaderBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public JTitleHeaderBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        LayoutInflater.from(context).inflate(getHeaderViewLayoutId(), this);
        mLeftViewContainer = (RelativeLayout) findViewById(R.id.rly_title_bar_left);
        mCenterViewContainer = (RelativeLayout) findViewById(R.id.rly_title_bar_center);
        mRightViewContainer = (RelativeLayout) findViewById(R.id.rly_title_bar_right);
        mLeftReturnImageView = (ImageView) findViewById(R.id.img_title_bar_left);
        mCenterTitleTextView = (TextView) findViewById(R.id.txt_title_bar_title);
        mRightTitleTextView = (TextView) findViewById(R.id.txt_right_bar_title);
    }

    protected int getHeaderViewLayoutId() {
        return R.layout.jbase_header_bar_title;
    }

    public ImageView getLeftImageView() {
        return mLeftReturnImageView;
    }

    public TextView getTitleTextView() {
        return mCenterTitleTextView;
    }

    public void setTitle(String title) {
        mTitle = title;
        mCenterTitleTextView.setText(title);
    }

    public TextView getRightTitleTextView() {
        return mRightTitleTextView;
    }

    public void setRightTitleTextView(String title) {
        mRightTitleTextView.setText(title);
    }

    private LayoutParams makeLayoutParams(View view) {
        ViewGroup.LayoutParams lpOld = view.getLayoutParams();
        LayoutParams lp = null;
        if (lpOld == null) {
            lp = new LayoutParams(-2, -1);
        } else {
            lp = new LayoutParams(lpOld.width, lpOld.height);
        }
        return lp;
    }

    /**
     * set customized view to left side
     *
     * @param view the view to be added to left side
     */
    public void setCustomizedLeftView(View view) {
        mLeftReturnImageView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_VERTICAL);
        lp.addRule(ALIGN_PARENT_LEFT);
        getLeftViewContainer().addView(view, lp);
    }

    /**
     * set customized view to left side
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedLeftView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedLeftView(view);
    }

    /**
     * set customized view to center
     *
     * @param view the view to be added to center
     */
    public void setCustomizedCenterView(View view) {
        mCenterTitleTextView.setVisibility(GONE);
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_IN_PARENT);
        getCenterViewContainer().addView(view, lp);
    }

    /**
     * set customized view to center
     *
     * @param layoutId the xml layout file id
     */
    public void setCustomizedCenterView(int layoutId) {
        View view = inflate(getContext(), layoutId, null);
        setCustomizedCenterView(view);
    }

    /**
     * set customized view to right side
     *
     * @param view the view to be added to right side
     */
    public void setCustomizedRightView(View view) {
        LayoutParams lp = makeLayoutParams(view);
        lp.addRule(CENTER_VERTICAL);
        lp.addRule(ALIGN_PARENT_RIGHT);
        getRightViewContainer().addView(view, lp);
    }

    public RelativeLayout getLeftViewContainer() {
        return mLeftViewContainer;
    }

    public RelativeLayout getCenterViewContainer() {
        return mCenterViewContainer;
    }

    public RelativeLayout getRightViewContainer() {
        return mRightViewContainer;
    }

    public void setLeftOnClickListener(OnClickListener l) {
        mLeftViewContainer.setOnClickListener(l);
    }

    public void setCenterOnClickListener(OnClickListener l) {
        mCenterViewContainer.setOnClickListener(l);
    }

    public void setRightOnClickListener(OnClickListener l) {
        mRightViewContainer.setOnClickListener(l);
    }


}
