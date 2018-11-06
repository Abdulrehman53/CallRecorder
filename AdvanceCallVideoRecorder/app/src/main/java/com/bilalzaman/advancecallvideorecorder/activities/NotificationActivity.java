package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;

public class NotificationActivity extends AppCompatActivity {

    private TextView txtTitle;
    private ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        init();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        imgBack = findViewById(R.id.imgBack);

        txtTitle.setText("Notifications");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
