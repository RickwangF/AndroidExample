package com.example.androidtest.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidtest.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressLint("ValidFragment")
public class OneFragment extends Fragment implements View.OnClickListener {

    Button closeBtn;
    Button showTwoBtn;

    IFragmentOne mfragmentOne;


    public OneFragment(IFragmentOne fragmentOne) {
        this.mfragmentOne = fragmentOne;
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        closeBtn = view.findViewById(R.id.close_btn);
        closeBtn.setOnClickListener(this);
        showTwoBtn = view.findViewById(R.id.show_two);
        showTwoBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close_btn:
                mfragmentOne.fragmentOneCloseBtnClicked();
                break;
            case R.id.show_two:
                mfragmentOne.fragmentOneShowTwoBtnClicked();
            default:
                break;
        }
    }
}
