package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

public class MoreActivity extends AppCompatActivity {

    private ConstraintLayout storagelayout, securitylayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        init();
    }

    private void init() {
        storagelayout = findViewById(R.id.storage_layout);
        securitylayout = findViewById(R.id.lock_layout);

        storagelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(MoreActivity.this, StorageActivity.class);
            }
        });

        securitylayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UIHelper.openActivity(MoreActivity.this, LockScreenActivity.class);
            }
        });
    }
}
