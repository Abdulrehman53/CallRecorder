package com.bilalzaman.advancecallvideorecorder.activities;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordingDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout playerLayout;
    private TextView txtTitle;
    private ImageButton imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_detail);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        txtTitle = findViewById(R.id.txtTitle);
        imgBack = findViewById(R.id.imgBack);

        txtTitle.setText("Player Name Detail");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
