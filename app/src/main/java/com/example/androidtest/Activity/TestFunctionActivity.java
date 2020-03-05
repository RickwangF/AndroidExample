package com.example.androidtest.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.androidtest.R;

public class TestFunctionActivity extends AppCompatActivity implements View.OnClickListener, IFragmentInteraction{

    Button functionBtn;

    FragmentManager fragmentManager;

    OneFragment oneFragment;

    TwoFragment twoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_function);

        functionBtn = findViewById(R.id.func_btn);
        functionBtn.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.func_btn:
                showOneFragment();
                break;
            default:
                break;
        }
    }

    private void showOneFragment() {
        oneFragment = new OneFragment(this);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.function_layout, oneFragment);
        transaction.addToBackStack("one");
        System.out.println("back stack count is " + fragmentManager.getBackStackEntryCount());
        transaction.commit();
    }

    private void showTwoFragment() {
        twoFragment = new TwoFragment(this);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.function_layout, twoFragment);
        transaction.addToBackStack("two");
        System.out.println("back stack count is " + fragmentManager.getBackStackEntryCount());
        transaction.commit();
    }

    @Override
    public void fragmentOneCloseBtnClicked() {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.remove(oneFragment);
        transaction.commit();
    }

    @Override
    public void fragmentOneShowTwoBtnClicked() {
        showTwoFragment();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fragmentManager.popBackStack();
    }

    @Override
    public void fragmentTwoCloseAllBtnClicked() {
        fragmentManager.popBackStackImmediate(null, 1);
    }
}
