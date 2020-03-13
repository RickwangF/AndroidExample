package com.example.androidtest.databinding;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidtest.R;

import butterknife.BindView;

public class DataActivity extends AppCompatActivity implements DataBindClickListener{

    @BindView(R.id.user_text)
    TextView textView;

    @BindView(R.id.user_name_edit)
    EditText editText;

    @BindView(R.id.recycler_btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data);
        UserSimpleModel userModel = new UserSimpleModel("真的没名字", "没有姓氏");
        binding.setUser(userModel);
        binding.setHandler(this);
    }

    @Override
    public void recyclerBtnClicked(View view) {
        Intent intent = new Intent(this, RecyclerDataActivity.class);
        startActivity(intent);
    }
}
