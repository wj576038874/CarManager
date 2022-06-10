package com.car.app.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.car.app.R;

/**
 * author: wenjie
 * date: 2022-06-10 14:41
 * descption:
 */
public class OwnerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("车主信息");
        setContentView(R.layout.activity_owner);

        String owner = getIntent().getStringExtra("owner");
        String phone = getIntent().getStringExtra("phone");

        TextView tv_owner =findViewById(R.id.tv_owner);
        TextView tv_phone =findViewById(R.id.tv_phone);

        tv_owner.setText("姓名：" + owner);
        tv_phone.setText("电话：" + phone);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
