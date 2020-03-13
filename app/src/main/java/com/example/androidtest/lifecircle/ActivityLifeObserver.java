package com.example.androidtest.lifecircle;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class ActivityLifeObserver implements LifecycleObserver {

    private String mActivityState;

    public ActivityLifeObserver() {
    }

    public ActivityLifeObserver(String mActivityState) {
        this.mActivityState = mActivityState;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void activityCreat() {
        mActivityState = "OnCreate";
        System.out.println("Activity Life Circle is " + mActivityState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void activityStart() {
        mActivityState = "OnStart";
        System.out.println("Activity Life Circle is " + mActivityState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void activityResume() {
        mActivityState = "OnResume";
        System.out.println("Activity Life Circle is " + mActivityState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void activityPause() {
        mActivityState = "OnPause";
        System.out.println("Activity Life Circle is " + mActivityState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void activityStop() {
        mActivityState = "OnStop";
        System.out.println("Activity Life Circle is " + mActivityState);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void activityDestory() {
        mActivityState = "OnDestory";
        System.out.println("Activity Life Circle is " + mActivityState);
    }
}
