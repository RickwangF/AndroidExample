package com.example.androidtest.Design;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.androidtest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DesignActivity extends AppCompatActivity implements DesignListItemClickListener{

    @BindView(R.id.design_scroll)
    NestedScrollView scrollView;

    @BindView(R.id.design_list)
    RecyclerView listView;

    DesignAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design);
        ButterKnife.bind(this);
        initListView();
    }

    private void initListView() {
        List<String> list = new ArrayList<String>();
        list.add("ToolBar");
        for (int i = 0; i < 20; i++) {
            list.add("CoordinatorLayout");
        }
        adapter = new DesignAdapter(list, this);
        listView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        listView.setAdapter(adapter);
    }

    @Override
    public void designItemClicked(int i) {
        switch (i) {
            case 0:
                Intent intent = new Intent(this, ToolBarActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
