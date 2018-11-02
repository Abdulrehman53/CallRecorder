package com.bilalzaman.advancecallvideorecorder.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.bilalzaman.advancecallvideorecorder.R;
import com.bilalzaman.advancecallvideorecorder.fragments.FavouriteFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.InboxFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.SettingsFragment;
import com.bilalzaman.advancecallvideorecorder.fragments.TrashFragment;
import com.bilalzaman.advancecallvideorecorder.helpers.BottomNavigationViewHelper;

public class HomeActivity extends AppCompatActivity {

    private static int mLastNavigationSelectedItem;
    private BottomNavigationView mBottomNavigationView;
    private TextView mTextMessage;

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

        loadHomeFragment();

    }

    private void loadHomeFragment() {
        InboxFragment inboxFragment = new InboxFragment();
        replaceFragment(inboxFragment, R.id.navigation_home);

        mBottomNavigationView = findViewById(R.id.navigation);
        mBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
    }


}
