package com.chehui.jason.base.fragment;

import android.os.Bundle;
import android.util.Log;

import com.chehui.jason.base.lifeCycle.IComponentContainer;
import com.chehui.jason.base.lifeCycle.LifeCycleComponent;
import com.chehui.jason.base.lifeCycle.LifeCycleComponentManager;

/**
 * Created by zzp on 2016/1/22.
 */
public abstract class XActivity extends JasonFragmentActivity implements IComponentContainer {

    private LifeCycleComponentManager mComponentContainer = new LifeCycleComponentManager();

    private static final boolean DEBUG=false;


    @Override
    protected void onRestart() {
        super.onRestart();
        mComponentContainer.onBecomesVisibleFromTotallyInvisible();
        if (DEBUG) {
            showStatus("onRestart");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mComponentContainer.onBecomesPartiallyInvisible();
        if (DEBUG){
            showStatus("onPause");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mComponentContainer.onBecomesVisibleFromPartiallyInvisible();
        if (DEBUG) {
            showStatus("onResume");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (DEBUG) {
            showStatus("onCreate");
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        mComponentContainer.onBecomesTotallyInvisible();
        if (DEBUG) {
            showStatus("onStop");
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mComponentContainer.onDestroy();
        if (DEBUG) {
            showStatus("onDestroy");
        }
    }

    @Override
    public void addComponent(LifeCycleComponent component) {
        mComponentContainer.addComponent(component);
    }

    private void showStatus(String status) {
        final String[] className = ((Object) this).getClass().getName().split("\\.");
        Log.d("cube-lifecycle", String.format("%s %s", className[className.length - 1], status));
    }

}
