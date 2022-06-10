package com.car.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.car.app.R;
import com.car.app.adapter.DetailImageAdapter;
import com.car.app.model.CarItem;

import org.litepal.LitePal;

/**
 * author: wenjie
 * date: 2022-06-09 16:25
 * descption:
 */
public class CarDetailActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private TextView tv_gearbox;
    private TextView tv_location;
    private TextView tv_level;
    private TextView tv_mileage;
    private TextView tv_struct;
    private TextView tv_drive;
    private TextView tv_color;
    private TextView tv_flue;
    private TextView tv_engine;
    private TextView tv_youhao;
    private TextView tv_price;
    private TextView tv_name;
    private TextView tv_owner;
    private TextView tv_phone;
    private Button btn_show;

    private TextView tv_position;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("车辆详情");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_car_detail);

        int id = getIntent().getIntExtra("id", 0);


        CarItem carItem = LitePal.find(CarItem.class, id);

        if (carItem == null) {
            finish();
            return;
        }

        viewPager2 = findViewById(R.id.viewpager);
        tv_owner = findViewById(R.id.tv_owner);
        tv_phone = findViewById(R.id.tv_phone);
        btn_show = findViewById(R.id.btn_show);
        tv_position = findViewById(R.id.tv_position);
        tv_gearbox = findViewById(R.id.tv_gearbox);
        tv_location = findViewById(R.id.tv_location);
        tv_level = findViewById(R.id.tv_level);
        tv_mileage = findViewById(R.id.tv_mileage);
        tv_struct = findViewById(R.id.tv_struct);
        tv_drive = findViewById(R.id.tv_drive);
        tv_color = findViewById(R.id.tv_color);
        tv_flue = findViewById(R.id.tv_flue);
        tv_engine = findViewById(R.id.tv_engine);
        tv_youhao = findViewById(R.id.tv_youhao);
        tv_name = findViewById(R.id.tv_name);
        tv_price = findViewById(R.id.tv_price);

        DetailImageAdapter detailImageAdapter = new DetailImageAdapter();
        viewPager2.setAdapter(detailImageAdapter);

        detailImageAdapter.setNewData(carItem.getImages());

        tv_position.setText(1 + "/" + carItem.getImages().size());

        tv_name.setText(carItem.getName());
        tv_price.setText(carItem.getPrice() + "万");
        tv_gearbox.setText(carItem.getGearbox());
        tv_location.setText(carItem.getLocation());
        tv_level.setText(carItem.getLevel());
        tv_mileage.setText(carItem.getMileage() + "公里");
        tv_struct.setText(carItem.getStruct());
        tv_drive.setText(carItem.getDrive());
        tv_color.setText(carItem.getColor());
        tv_flue.setText(carItem.getFuel());
        tv_engine.setText(carItem.getEngine());
        tv_youhao.setText(carItem.getFuelConsumption() + "升");

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tv_position.setText((position + 1) + "/" + carItem.getImages().size());
            }
        });

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarDetailActivity.this, OwnerActivity.class);
                intent.putExtra("owner", carItem.getCarOwner());
                intent.putExtra("phone", carItem.getPhoneNumber());
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
