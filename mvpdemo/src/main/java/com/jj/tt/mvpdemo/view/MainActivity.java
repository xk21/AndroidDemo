package com.jj.tt.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jj.tt.mvpdemo.R;
import com.jj.tt.mvpdemo.interfaces.IUserBookShowListener;
import com.jj.tt.mvpdemo.mode.UserBookMode;
import com.jj.tt.mvpdemo.mode.data.Book;
import com.jj.tt.mvpdemo.prsenter.UserBookPresenter;

public class MainActivity extends AppCompatActivity implements IUserBookShowListener {

    private UserBookPresenter userBookPresenter;
    private TextView tv_1;
    private Button bt_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userBookPresenter = new UserBookPresenter();
        userBookPresenter.attach(this);
        initView();
    }

    private void initView() {
        final EditText et_1 = findViewById(R.id.et_1);
        bt_1 = findViewById(R.id.bt_1);
        tv_1 = findViewById(R.id.tv_1);




        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(et_1.getText())) {
                    String s = et_1.getText().toString();
                    try {
                        Integer integer = Integer.valueOf(s);
                        userBookPresenter.getUserBook(integer);
                    }catch (Exception e){
                        Toast.makeText(MainActivity.this, "请输入数字",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        userBookPresenter.detach();
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
}
