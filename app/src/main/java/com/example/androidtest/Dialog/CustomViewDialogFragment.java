package com.example.androidtest.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.androidtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CustomViewDialogFragment extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.dialog_confirm_btn)
    Button confirmBtn;

    @BindView(R.id.dialog_cancel_btn)
    Button cancelBtn;

    public interface CustomViewDialogFragmentClickListener {
        void customViewPositiveBtnClicked();

        void customViewNegativeBtnClicked();
    }

    CustomViewDialogFragmentClickListener clickListener;

    public CustomViewDialogFragment() {
    }

    public static CustomViewDialogFragment newInstance() {
        Bundle args = new Bundle();
        CustomViewDialogFragment fragment = new CustomViewDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clickListener = (CustomViewDialogFragmentClickListener) getActivity();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_custom_view_dialog, null);
        ButterKnife.bind(this, view);
        builder.setView(view);
        confirmBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
        return builder.create();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() ==  R.id.dialog_confirm_btn) {
            clickListener.customViewPositiveBtnClicked();
        } else {
            clickListener.customViewNegativeBtnClicked();
        }
    }
}
