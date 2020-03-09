package com.example.androidtest.Dialog;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.View;

public class SimpleDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {

    public interface SimpleDialogFragmentClickListener {
        void positiveBtnClicked();

        void nagativeBtnClicked();
    }

    SimpleDialogFragmentClickListener clickListener;

    public SimpleDialogFragment() {

    }

    public static SimpleDialogFragment newInstance(SimpleDialogFragmentClickListener listener) {
        Bundle args = new Bundle();
        SimpleDialogFragment fragment = new SimpleDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
        clickListener = (SimpleDialogFragmentClickListener) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("测试对话框").setMessage("对话框内容");
        builder.setPositiveButton("确定", this);
        builder.setNegativeButton("取消", this);
        return  builder.create();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == 0) {
            clickListener.positiveBtnClicked();
        } else {
            clickListener.nagativeBtnClicked();
        }
    }
}
