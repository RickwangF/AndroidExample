package com.example.androidtest.databinding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.example.androidtest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerDataActivity extends AppCompatActivity {

    @BindView(R.id.recycler_binding)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_data);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    void initRecyclerView() {
        List<UserSimpleModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            UserSimpleModel model = new UserSimpleModel();
            model.UserName.set("名字" + i);
            list.add(model);
        }

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        DataItemAdapter adapter = new DataItemAdapter(this, list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
