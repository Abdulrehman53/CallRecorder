package com.bilalzaman.advancecallvideorecorder.activities;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.constants.Constants;
import com.bilalzaman.advancecallvideorecorder.fragments.FavouriteFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.InboxFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.SettingsFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.TrashFragment;
import com.bilalzaman.advancecallvideorecorder.helpers.BottomNavigationViewHelper;
import com.bilalzaman.advancecallvideorecorder.helpers.PreferenceHelper;
import com.bilalzaman.advancecallvideorecorder.helpers.UIHelper;

import java.io.IOException;

import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class HomeActivity extends AppCompatActivity {

    private static int mLastNavigationSelectedItem;
    private BottomNavigationView mBottomNavigationView;
    private TextView mTextMessage;
    private static final int REQUEST_WRITE_PERMISSION = 1;
    public static final int RequestPermissionCode = 1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    InboxFragment inboxFragment = new InboxFragment();
                    replaceFragment(inboxFragment, R.id.navigation_home);
                    return true;
                case R.id.navigation_favourite:
                    FavouriteFragment favouriteFragment = new FavouriteFragment();
                    replaceFragment(favouriteFragment, R.id.navigation_favourite);
                    return true;
                case R.id.navigation_trash:
                    TrashFragment trashFragment = new TrashFragment();
                    replaceFragment(trashFragment, R.id.navigation_trash);
                    return true;
                case R.id.navigation_setting:
                    SettingsFragment settingFragment = new SettingsFragment();
                    replaceFragment(settingFragment, R.id.navigation_setting);
                    return true;
            }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment, int lastNavigationSelectedItem) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

        mLastNavigationSelectedItem = lastNavigationSelectedItem;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        PreferenceHelper.getInstance().init(this);

        init();


    }

    private void loadHomeFragment() {
        InboxFragment inboxFragment = new InboxFragment();
        replaceFragment(inboxFragment, R.id.navigation_home);

        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
    }

    private void init() {
//
//        if (PreferenceHelper.getInstance().getString(Constants.ISVARIFIED, "").equalsIgnoreCase(Constants.ISVARIFIED)) {
//            checkPermission();
//            loadHomeFragment();
        if (checkPermission()) {
            loadHomeFragment();
        } else {
            requestPermission();
           // permissionProceed();

        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(HomeActivity.this, new String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean StoragePermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(HomeActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                        loadHomeFragment();
                    } else {
                        Toast.makeText(HomeActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(), RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;
    }

//    public void permissionProceed() {
//        if (ContextCompat.checkSelfPermission(HomeActivity.this,
//                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//            loadHomeFragment();
//
//        } else {
//            requestStorePermission();
//        }
//    }
//
//    private void requestStorePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//            new AlertDialog.Builder(this)
//                    .setTitle("Permission Denied")
//                    .setMessage("Media & Storage" + "Allowing Motivation Quotes to access your gallery and files permission you to store images")
//                    .setPositiveButton("Give Permission", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
//
//                        }
//                    })
//                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            UIHelper.showLongToastInCenter(HomeActivity.this, "The Permission was denied");
//                            finish();
//                        }
//                    }).create().show();
//
//        } else {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_WRITE_PERMISSION);
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        if (requestCode == REQUEST_WRITE_PERMISSION) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//                loadHomeFragment();
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        }
//    }
}
