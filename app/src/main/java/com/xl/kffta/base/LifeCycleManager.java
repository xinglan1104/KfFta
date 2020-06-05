package com.xl.kffta.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import java.lang.ref.WeakReference;

public class LifeCycleManager {


    private static LifeCycleManager INSTANCE;
    private int mActivityCount = 0;
    private WeakReference<Activity> mTopActivity;

    private LifeCycleManager() {
    }

    public synchronized static LifeCycleManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LifeCycleManager();
        }
        return INSTANCE;
    }

    // NOTE: MUST be called in Application.onCreate
    void init(Application application) {
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                mTopActivity = new WeakReference<>(activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {
                mTopActivity = new WeakReference<>(activity);
            }

            @Override
            public void onActivityResumed(Activity activity) {
                mTopActivity = new WeakReference<>(activity);
            }

            @Override
            public void onActivityPaused(Activity activity) {
            }

            @Override
            public void onActivityStopped(Activity activity) {
            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            }

            @Override
            public void onActivityDestroyed(Activity activity) {
            }
        });
    }


    public Activity getTopActivity() {
        if (mTopActivity != null) {
            return mTopActivity.get();
        }
        return null;
    }

    public boolean isForeground() {
        return mActivityCount > 0;
    }
}
