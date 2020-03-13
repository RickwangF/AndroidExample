package com.example.androidtest.lifecircle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidtest.R;
import com.example.androidtest.databinding.ActivityLifeCircleBinding;

import java.util.jar.Attributes;

public class LifeCircleActivity extends AppCompatActivity implements LifecycleOwner {

    private LifecycleRegistry lifeCircleRegistry;

    private ActivityLifeObserver lifeObserver;

    private NameViewModel viewModel;

    private ActivityLifeCircleBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_life_circle);
        lifeCircleRegistry = new LifecycleRegistry(this);
        lifeCircleRegistry.markState(Lifecycle.State.CREATED);
        lifeObserver = new ActivityLifeObserver();
        this.getLifecycle().addObserver(lifeObserver);
        viewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        viewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mBinding.nameText.setText(s);
            }
        });
        viewModel.getNameAsync();
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
