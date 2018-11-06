package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;

public class LockScreenActivity extends AppCompatActivity {

    private TextView txtTitle;
    private ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);

        init();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        imgBack = findViewById(R.id.imgBack);

        txtTitle.setText("Set a Password");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
