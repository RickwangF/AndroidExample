package com.example.androidtest.Design;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.androidtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ToolBarActivity extends AppCompatActivity {

    @BindView(R.id.tool_bar_text)
    TextView textView;

    @BindView(R.id.tool_bar)
    Toolbar toolbar;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        ButterKnife.bind(this);

        textView.setText("012345678911121231242918714978129017823897123977826817234");
        toolbar.setLogo(R.mipmap.ic_weixin);
        toolbar.setTitle("ToolBar");
        toolbar.setTitleTextColor(R.color.colorWhite);
        setSupportActionBar(toolbar);
    }
}
