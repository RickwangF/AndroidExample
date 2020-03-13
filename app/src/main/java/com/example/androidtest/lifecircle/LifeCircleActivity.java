package com.example.androidtest.lifecircle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidtest.R;

public class LifeCircleActivity extends AppCompatActivity implements LifecycleOwner {

    private LifecycleRegistry lifeCircleRegistry;

    private ActivityLifeObserver lifeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_circle);
        lifeCircleRegistry = new LifecycleRegistry(this);
        lifeCircleRegistry.markState(Lifecycle.State.CREATED);
        lifeObserver = new ActivityLifeObserver();
        this.getLifecycle().addObserver(lifeObserver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifeCircleRegistry.markState(Lifecycle.State.STARTED);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeCircleRegistry.markState(Lifecycle.State.RESUMED);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeCircleRegistry.markState(Lifecycle.State.DESTROYED);
    }

    @Override
    public Lifecycle getLifecycle() {
        return lifeCircleRegistry;
    }
}
