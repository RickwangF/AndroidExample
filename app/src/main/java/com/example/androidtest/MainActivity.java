package com.example.androidtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.androidtest.Activity.TestFunctionActivity;
import com.example.androidtest.Main.FunctionAdapter;
import com.example.androidtest.Main.FunctionItemClickListener;
import com.example.androidtest.Main.FunctionModel;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements FunctionItemClickListener {

    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;

    RecyclerView.Adapter<FunctionAdapter.ViewHolder> adapter;

    final static String APP_PACKAGE_NAME = "com.example.androidtest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FunctionAdapter(getDataSource(), this);
        recyclerView.setAdapter(adapter);
    }

    private  ArrayList<FunctionModel> getDataSource() {
        ArrayList<FunctionModel> list = new ArrayList<>();
        FunctionModel activityModel = new FunctionModel();
        activityModel.setFunctionName("Activity功能测试");
        activityModel.setClassName(APP_PACKAGE_NAME + ".Activity.TestFunctionActivity");
        list.add(activityModel);
        FunctionModel designModel = new FunctionModel();
        designModel.setFunctionName("Material Design测试");
        designModel.setClassName(APP_PACKAGE_NAME + ".Design.DesignActivity");
        list.add(designModel);
        FunctionModel tabModel = new FunctionModel();
        tabModel.setFunctionName("TabLayout 测试");
        tabModel.setClassName(APP_PACKAGE_NAME + ".Tab.TabActivity");
        list.add(tabModel);
        for (int i = 0; i < 20; i++){
            FunctionModel model = new FunctionModel();
            model.setFunctionName("测试");
            model.setClassName("");
            list.add(model);
        }
        return list;
    }

    @Override
    public void itemClicked(String className) {
        if (className.isEmpty()) {
            Toast.makeText(this,"暂时没有相关功能",Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Class classSelf = Class.forName(className);
            Intent intent = new Intent(this, classSelf);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            System.out.println("没有找到该类");
        }
    }
}
