package com.example.androidtest.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidtest.R;
import com.example.androidtest.network.CommonHttpService;
import com.example.androidtest.network.HttpCallBack;
import com.example.androidtest.network.HttpResponse;
import com.example.androidtest.user.LoginModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.phone_input)
    EditText phoneInput;

    @BindView(R.id.code_input)
    EditText codeInput;

    @BindView(R.id.login_btn)
    Button loginBtn;

    private LoginService mloginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginBtn.setOnClickListener(this);
        mloginService = CommonHttpService.getInstance().create(LoginService.class);
    }

    private void requestLogin() {
        String phone = phoneInput.getText().toString();
        String code = codeInput.getText().toString();

        if (phone.isEmpty() || code.isEmpty()) {
            Toast.makeText(this, "请输入手机号或验证码", Toast.LENGTH_SHORT);
            return;
        }

        Call<HttpResponse<LoginModel>> call = mloginService.phoneLogin(phone, code, "86");
        call.enqueue(new HttpCallBack<LoginModel>(this, false) {
            @Override
            public void onSuccess(LoginModel loginModel) {
                System.out.println("请求成功");
            }

            @Override
            public void onFailMessage(String msg, int code) {
                System.out.println("请求失败，" + msg);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.login_btn) {
            requestLogin();
        }
    }
}
