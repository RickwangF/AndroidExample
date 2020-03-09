package com.example.androidtest.Dialog;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidtest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogListActivity extends AppCompatActivity
        implements View.OnClickListener,
        SimpleDialogFragment.SimpleDialogFragmentClickListener,
        CustomViewDialogFragment.CustomViewDialogFragmentClickListener,
        CustomSizeDialogFragment.CustomSizeDialogFragmentClickListener {

    @BindView(R.id.dialog_btn)
    Button dialogBtn;

    @BindView(R.id.custom_dialog)
    Button customDialogBtn;

    @BindView(R.id.custom_size_dialog)
    Button customSizeDialogBtn;

    SimpleDialogFragment dialog;

    CustomViewDialogFragment customDialog;

    CustomSizeDialogFragment customSizeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_list);
        ButterKnife.bind(this);
        dialogBtn.setOnClickListener(this);
        customDialogBtn.setOnClickListener(this);
        customSizeDialogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_btn:
                dialog = new SimpleDialogFragment();
                dialog.show(getSupportFragmentManager(), "simple");
            break;
            case R.id.custom_dialog:
                customDialog = new CustomViewDialogFragment();
                customDialog.show(getSupportFragmentManager(), "custom");
            break;
            case R.id.custom_size_dialog:
                customSizeDialog = new CustomSizeDialogFragment();
                customSizeDialog.show(getSupportFragmentManager(), "customSize");
                break;
            default:
                break;
        }
    }

    @Override
    public void positiveBtnClicked() {
        System.out.println("确定按钮被点击了");
    }

    @Override
    public void nagativeBtnClicked() {
        System.out.println("取消按钮被点击了");
    }

    @Override
    public void customViewPositiveBtnClicked() {
        System.out.println("自定义对话框确定按钮被点击了");
        customDialog.dismiss();
    }

    @Override
    public void customViewNegativeBtnClicked() {
        System.out.println("自定义对话框取消按钮被点击了");
        customDialog.getDialog().cancel();
    }

    @Override
    public void customSizeDialogConfirmBtnClicked() {
        System.out.println("自定义尺寸对话框确定按钮被点击了");
        customSizeDialog.dismiss();
    }

    @Override
    public void customSizeDialogCancelBtnClicked() {
        System.out.println("自定义尺寸对话框取消按钮被点击了");
        customSizeDialog.getDialog().cancel();
    }
}
