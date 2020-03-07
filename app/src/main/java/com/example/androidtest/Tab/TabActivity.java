package com.example.androidtest.Tab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidtest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TabActivity extends AppCompatActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<Fragment> mfragments;

    private TabFragmentPager tabFragmentPager;

    private String[] tabArray = new String[]{ "one", "two", "three"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        ButterKnife.bind(this);
        initView();
    }

    void initTabFragments() {
        mfragments = new ArrayList<>();
        for (int i = 0; i < tabArray.length; i++) {
            switch (i) {
                case 0:
                    mfragments.add(new TabOneFragment());
                    break;
                case 1:
                    mfragments.add(new TabTwoFragment());
                    break;
                case 2:
                    mfragments.add(new TabThreeFragment());
                    break;
                default:
                    break;
            }
            tabLayout.addTab(tabLayout.newTab());
        }
    }

    void initView() {
        initTabFragments();
        tabFragmentPager = new TabFragmentPager(getSupportFragmentManager(), mfragments);
        tabLayout.setupWithViewPager(viewPager, false);
        viewPager.setAdapter(tabFragmentPager);

        for (int i = 0; i < tabArray.length; i++) {
            tabLayout.getTabAt(i).setText(tabArray[i]);
        }
    }
}
