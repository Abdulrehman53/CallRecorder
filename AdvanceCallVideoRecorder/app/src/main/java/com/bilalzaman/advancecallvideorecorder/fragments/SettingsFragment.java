package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.activities.MoreActivity;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment implements View.OnClickListener {

    private ConstraintLayout recordLayout, notificationLayout, cloudLayout, moreLayout, proLayout, shareLayout, rateLayout;
    private Context context;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        context = container.getContext();
        recordLayout = view.findViewById(R.id.recorder_layout);
        notificationLayout = view.findViewById(R.id.notification_layout);
        cloudLayout = view.findViewById(R.id.cloud_layout);
        moreLayout = view.findViewById(R.id.more_layout);
        proLayout = view.findViewById(R.id.pRO_layout);
        shareLayout = view.findViewById(R.id.share_layout);
        rateLayout = view.findViewById(R.id.rate_layout);

        recordLayout.setOnClickListener(this);
        notificationLayout.setOnClickListener(this);
        cloudLayout.setOnClickListener(this);
        moreLayout.setOnClickListener(this);
        proLayout.setOnClickListener(this);
        shareLayout.setOnClickListener(this);
        rateLayout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.notification_layout:{

                break;
            }
            case R.id.cloud_layout:{

                break;
            }
            case R.id.more_layout:{

                UIHelper.openActivity(getActivity(),MoreActivity.class);
                break;
            }
            case R.id.pRO_layout:{

                break;
            }case R.id.share_layout:{

                break;
            }
            case R.id.rate_layout:{

                break;
            }

        }
    }
}