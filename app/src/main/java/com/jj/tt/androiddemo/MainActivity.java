package com.jj.tt.androiddemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jj.tt.androiddemo.base.MVPBaseActivity;
import com.jj.tt.androiddemo.presenter.LoginPresenter;
import com.jj.tt.androiddemo.view.ILoginView;


public class MainActivity extends MVPBaseActivity<ILoginView,LoginPresenter> implements View.OnClickListener ,ILoginView {
    private static final String TAG = "TAG";
    private EditText etName;
    private EditText etPassword;
    private Button btLogin;
    private Button btClear;
    private ProgressBar progressBar;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    @Override
    protected LoginPresenter createPresenter() {
        mPresenter=new LoginPresenter(this);
        return mPresenter;
    }


    private void initView() {
        etName=(EditText)findViewById(R.id.et_name);
        etPassword=(EditText)findViewById(R.id.et_password);
        btLogin=(Button)findViewById(R.id.bt_login);
        btClear=(Button)findViewById(R.id.bt_clear);
        btLogin.setOnClickListener(this);
        btClear.setOnClickListener(this);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_login:
                if(mPresenter!=null){
                    Log.i(TAG, "mPresenter="+mPresenter);
                    mPresenter.login();
                }
                break;
            case R.id.bt_clear:
                etName.setText("");
                etPassword.setText("");
                break;
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public String getName() {
        return etName.getText().toString();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailer() {
        Toast.makeText(getApplicationContext(),"登录失败", Toast.LENGTH_SHORT).show();
    }
}
