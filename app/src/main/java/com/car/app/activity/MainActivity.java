package com.car.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.car.app.R;
import com.car.app.fragment.HomeFragment;
import com.car.app.fragment.MyFragment;
import com.car.app.model.CarItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private Fragment mCurrentFragment;

    private HomeFragment homeFragment;
    private MyFragment myFragment;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_menu);

        homeFragment = new HomeFragment();
        myFragment = new MyFragment();
        mCurrentFragment = homeFragment;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, homeFragment)
                .add(R.id.content, myFragment)
                .hide(myFragment)
                .show(mCurrentFragment)
                .commitAllowingStateLoss();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        switchContent(homeFragment);
                        return true;
                    case R.id.menu_my:
                        switchContent(myFragment);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "?????????????????????", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * ????????????????????? ??????????????????
     **/
    public void switchContent(Fragment to) {
        if (mCurrentFragment != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) { // ??????????????????add???
                transaction.hide(mCurrentFragment).add(R.id.content, to).commit(); // ???????????????fragment???add????????????Activity???
            } else {
                transaction.hide(mCurrentFragment).show(to).commitAllowingStateLoss(); // ???????????????fragment??????????????????
            }
            mCurrentFragment = to;
        }
    }
}