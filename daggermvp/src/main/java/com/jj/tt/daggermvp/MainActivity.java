package com.jj.tt.daggermvp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jj.tt.daggermvp.Componet.DaggerUserBookComponet;
import com.jj.tt.daggermvp.base.BaseMVPActivity;
import com.jj.tt.daggermvp.interfaces.IUserBookShowListener;
import com.jj.tt.daggermvp.mode.data.Book;
import com.jj.tt.daggermvp.module.UserBookModule;
import com.jj.tt.daggermvp.presenter.UserBookPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseMVPActivity<UserBookPresenter> implements IUserBookShowListener{

    private TextView tv_1;
    private Button bt_1;
    private EditText mEt_1;
    @Inject
    UserBookPresenter mUserBookPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEt_1 = findViewById(R.id.et_1);
        bt_1 = findViewById(R.id.bt_1);
        tv_1 = findViewById(R.id.tv_1);




        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(mEt_1.getText())) {
                    String s = mEt_1.getText().toString();
                    try {
                        Integer integer = Integer.valueOf(s);
                        mUserBookPresenter.getUserBook(integer);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "请输入数字",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    @Override
    public void getUserBookSuccess(final Book book) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_1.setText(book.getName());
            }
        });
    }

    @Override
    public void getUserBookFailed(final String book) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_1.setText(book);
            }
        });
    }

    @Override
    public UserBookPresenter getPresenter() {
        DaggerUserBookComponet.builder().userBookModule(new UserBookModule(this)).build().inject(this);
        return mUserBookPresenter;
    }
}
