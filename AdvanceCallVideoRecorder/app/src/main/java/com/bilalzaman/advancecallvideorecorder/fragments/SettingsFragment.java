package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.activities.StorageActivity;
import com.bilalzaman.advancecallvideorecorder.activities.MoreActivity;
import com.bilalzaman.advancecallvideorecorder.activities.NotificationActivity;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    private ConstraintLayout recordLayout, notificationLayout, cloudLayout, moreLayout, proLayout, shareLayout, rateLayout;
    private Context context;
    private Switch switchRecord;
    private TextView txtTitle;
    private ImageButton imgBack;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        context = container.getContext();
        txtTitle = view.findViewById(R.id.txtTitle);
        imgBack = view.findViewById(R.id.imgBack);

        txtTitle.setText("Setting");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);
        recordLayout = view.findViewById(R.id.recorder_layout);
        notificationLayout = view.findViewById(R.id.notification_layout);
        cloudLayout = view.findViewById(R.id.cloud_layout);
        moreLayout = view.findViewById(R.id.more_layout);
        proLayout = view.findViewById(R.id.pRO_layout);
        shareLayout = view.findViewById(R.id.share_layout);
        rateLayout = view.findViewById(R.id.rate_layout);
        switchRecord = view.findViewById(R.id.switchRecord);

        recordLayout.setOnClickListener(this);
        notificationLayout.setOnClickListener(this);
        cloudLayout.setOnClickListener(this);
        moreLayout.setOnClickListener(this);
        proLayout.setOnClickListener(this);
        shareLayout.setOnClickListener(this);
        rateLayout.setOnClickListener(this);

        switchRecord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, "is on", Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.notification_layout: {
                UIHelper.openActivity(getActivity(), NotificationActivity.class);
                break;
            }
            case R.id.cloud_layout: {
                UIHelper.openActivity(getActivity(), StorageActivity.class);
                break;
            }
            case R.id.more_layout: {
                UIHelper.openActivity(getActivity(), MoreActivity.class);
                break;
            }
            case R.id.pRO_layout: {

                break;
            }
            case R.id.share_layout: {
                Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check our App on Playstore " +
                        "google.com");
                context.startActivity(Intent.createChooser(shareIntent, context.getResources().getString(R.string.share_using)));
                break;
            }
            case R.id.rate_layout: {

                break;
            }
        }
    }
}