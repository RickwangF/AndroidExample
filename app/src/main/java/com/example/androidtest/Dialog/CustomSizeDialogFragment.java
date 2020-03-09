package com.example.androidtest.Dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.androidtest.R;

import java.nio.Buffer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomSizeDialogFragment extends DialogFragment implements View.OnClickListener{

    public interface CustomSizeDialogFragmentClickListener {
        void customSizeDialogConfirmBtnClicked();

        void customSizeDialogCancelBtnClicked();
    }

    @BindView(R.id.custom_size_confirm)
    Button confirmBtn;

    @BindView(R.id.custom_size_cancel)
    Button cancelBtn;

    CustomSizeDialogFragmentClickListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listener = (CustomSizeDialogFragmentClickListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.fragment_custom_size_dialog, container, false);
        ButterKnife.bind(this, view);
        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Window win = getDialog().getWindow();
        // 一定要设置Background，如果不设置，window属性设置无效
        win.setBackgroundDrawable( new ColorDrawable(Color.TRANSPARENT));
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics( dm );
        WindowManager.LayoutParams params = win.getAttributes();
        params.gravity = Gravity.CENTER;
        // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
        params.width =  ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        win.setAttributes(params);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.custom_size_confirm) {
            listener.customSizeDialogConfirmBtnClicked();
        } else {
            listener.customSizeDialogCancelBtnClicked();
        }
    }
}
