package com.car.app.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.car.app.R;
import com.car.app.fragment.HomeFragment;
import com.car.app.fragment.MyFragment;
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
        mCurrentFragment = homeFragment;
        switchContent(homeFragment);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        switchContent(homeFragment);
                        return true;
                    case R.id.menu_my:
                        if (myFragment == null) {
                            myFragment = new MyFragment();
                        }
                        switchContent(myFragment);
                        return true;
                }
                return false;
            }
        });
    }


    /**
     * 修改显示的内容 不会重新加载
     **/
    public void switchContent(Fragment to) {
        if (mCurrentFragment != to) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                transaction.hide(mCurrentFragment).add(R.id.content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(mCurrentFragment).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
            mCurrentFragment = to;
        }
    }
}