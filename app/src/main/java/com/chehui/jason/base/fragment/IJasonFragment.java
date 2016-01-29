package com.chehui.jason.base.fragment;

/**
 * Created by zzp on 2016/1/22.
 */
public interface IJasonFragment  {


    void onEnter(Object data);

    void onLeave();

    void onBack();

    void onBackWithData(Object data);

    /**
     * process the return back logic
     * return true if back pressed event has been processed and should stay in current view
     *
     * @return
     */
    boolean processBackPressed();

}
