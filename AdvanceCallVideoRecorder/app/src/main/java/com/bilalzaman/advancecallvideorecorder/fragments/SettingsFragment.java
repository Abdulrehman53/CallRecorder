package com.bilalzaman.advancecallvideorecorder.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.activities.LockScreenActivity;
import com.bilalzaman.advancecallvideorecorder.activities.NotificationActivity;
import com.bilalzaman.advancecallvideorecorder.activities.StorageActivity;
import com.bilalzaman.advancecallvideorecorder.dialogs.RecordDialog;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {

    Unbinder unbinder;
    private Context context;
    private TextView txtTitle;
    //    @BindView(R.id.txtRecord)
//    TextView txtRecord;
//    @BindView(R.id.txtNotification)
//    TextView txtNotification;
//    @BindView(R.id.txtCloud)
//    TextView txtCloud;
//    @BindView(R.id.txtStorage)
//    TextView txtStorage;
//    @BindView(R.id.txtLock)
//    TextView txtSecurity;
//    @BindView(R.id.txtPro)
//    TextView txtPro;
//    @BindView(R.id.txtShare)
//    TextView txtShare;
//    @BindView(R.id.txtRate)
//    TextView txtRate;
    ImageButton imgBack;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        context = container.getContext();
        unbinder = ButterKnife.bind(this, view);
        txtTitle = view.findViewById(R.id.txtTitle);
        imgBack = view.findViewById(R.id.imgBack);
        txtTitle.setText("Setting");
        txtTitle.setVisibility(View.VISIBLE);
        imgBack.setVisibility(View.GONE);

        return view;

    }

    @OnClick({R.id.txtRecord, R.id.record_desc})
    void record() {
        RecordDialog recordFragment = new RecordDialog();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, recordFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @OnClick({R.id.txtNotification, R.id.notification_desc})
    void notification() {
        UIHelper.openActivity(getActivity(), NotificationActivity.class);

    }

    @OnClick(R.id.txtCloud)
    void cloudAccount() {

    }

    @OnClick(R.id.txtStorage)
    void storage() {
        UIHelper.openActivity(getActivity(), StorageActivity.class);
    }


    @OnClick(R.id.txtLock)
    void security() {
        UIHelper.openActivity(getActivity(), LockScreenActivity.class);
    }


    @OnClick(R.id.txtPro)
    void videoPro() {

    }

    @OnClick(R.id.txtShare)
    void shareApplication() {

    }

    @OnClick(R.id.txtRate)
    void rate() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        unbinder.unbind();
    }

}