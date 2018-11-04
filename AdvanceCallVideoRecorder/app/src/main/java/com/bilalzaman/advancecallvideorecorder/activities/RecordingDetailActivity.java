package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

public class RecordingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout playerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_detail);

        init();
    }

    private void init() {
        playerLayout = findViewById(R.id.player_const);

        playerLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.player_const:{
                UIHelper.openActivity(this, PlayerActivity.class);
                break;
            }
        }
    }
}
