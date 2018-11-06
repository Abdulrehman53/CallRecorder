package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;

public class StorageActivity extends AppCompatActivity {

    private ConstraintLayout inboxLayout, sizeLayout;
    private TextView cancelBtn, txtTitle;
    private ImageButton imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        init();

    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        imgBack = findViewById(R.id.imgBack);

        txtTitle.setText("Storage Settings");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        inboxLayout = findViewById(R.id.inbox_layout);
        sizeLayout = findViewById(R.id.sizeSettingLayout);
        cancelBtn = findViewById(R.id.txtCancel);

        inboxLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadein_animation);
                sizeLayout.startAnimation(startAnimation);
                sizeLayout.setVisibility(View.VISIBLE);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fadeout_animation);
                sizeLayout.startAnimation(startAnimation);
                sizeLayout.setVisibility(View.GONE);
            }
        });
    }
}
