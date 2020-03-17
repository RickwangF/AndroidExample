package com.example.androidtest.multisection;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.androidtest.R;
import com.example.androidtest.databinding.ActivityMultiSectionBinding;

import java.util.ArrayList;
import java.util.List;

public class MultiSectionActivity extends AppCompatActivity implements LifecycleOwner {

    private LifecycleRegistry lifeCircleRegistry;

    ActivityMultiSectionBinding mbinding;

    MultiTypeViewModel viewModel;

    MultiTypeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mbinding = DataBindingUtil.setContentView(this, R.layout.activity_multi_section);
        lifeCircleRegistry = new LifecycleRegistry(this);
        lifeCircleRegistry.markState(Lifecycle.State.CREATED);
        initMultiTypeRecyclerView();
        viewModel = ViewModelProviders.of(this).get(MultiTypeViewModel.class);
        viewModel.getImageList().observe(this, new Observer<List<TypeModel>>() {
            @Override
            public void onChanged(@Nullable List<TypeModel> typeModels) {
                mAdapter.setList(typeModels);
            }
        });
        viewModel.getImageListSync();
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

    private void initMultiTypeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MultiTypeAdapter(new ArrayList<TypeModel>(), this);
        mbinding.rvMultiType.setHasFixedSize(true);
        mbinding.rvMultiType.setLayoutManager(layoutManager);
        mbinding.rvMultiType.setAdapter(mAdapter);
    }
}
