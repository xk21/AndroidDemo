package com.jj.tt.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    User mUser;

    @Inject
    Book mBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv_1);
        DaggerTestMainComponent.create().inject(this);

        textView.setText(mUser.getName()+ mBook.getName());
    }
}
