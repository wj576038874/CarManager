package com.car.app.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.car.app.R;
import com.car.app.adapter.CarImageAdapter;
import com.car.app.model.CarItem;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.LinkedList;
import java.util.List;

/**
 * author: wenjie
 * date: 2022-06-09 09:27
 * descption:
 */
public class AddCarActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGearbox;
    private Button btnLevel;
    private Button btnStruct;
    private Button btnDrive;
    private Button btnColor;
    private Button btnFule;
    private Button btnEngine;
    private Button btnAdd;

    private EditText editTextName;
    private EditText editTextLocation;
    private EditText editTextMileage;
    private EditText editTextConsumption;
    private EditText etPrice;

    private RecyclerView recyclerView;
    private CarImageAdapter carImageAdapter;

    private CarItem carItem;

    private final String[] gearboxs = new String[]{"AMT自动变速箱", "AT自动变速箱", "CVT无级变速箱", "DCT双离合变速箱"};
    private final String[] levels = new String[]{"S级", "A级", "B级", "C级"};
    private final String[] structs = new String[]{"四门五座", "四门七座"};
    private final String[] drives = new String[]{"两驱", "四驱"};
    private final String[] fules = new String[]{"汽油", "柴油"};
    private final String[] colors = new String[]{"白色", "褐色", "黑色", "蓝色", "银色", "红色"};
    private final String[] engines = new String[]{"1.2", "1.4", "1.8", "2.0", "2.4", "3.0"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("添加车辆");
        setContentView(R.layout.activity_add_car);

        recyclerView = findViewById(R.id.rv_image);
        carImageAdapter = new CarImageAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(carImageAdapter);
        carImageAdapter.addData("add");

        editTextName = findViewById(R.id.et_name);
        etPrice = findViewById(R.id.et_price);
        editTextLocation = findViewById(R.id.et_location);
        editTextMileage = findViewById(R.id.et_mileage);
        editTextConsumption = findViewById(R.id.et_fuelConsumption);

        btnGearbox = findViewById(R.id.btn_gearbox);
        btnLevel = findViewById(R.id.btn_level);
        btnStruct = findViewById(R.id.btn_struct);
        btnDrive = findViewById(R.id.btn_drive);
        btnColor = findViewById(R.id.btn_color);
        btnFule = findViewById(R.id.btn_fule);
        btnEngine = findViewById(R.id.btn_engine);
        btnAdd = findViewById(R.id.btn_add);


        btnGearbox.setOnClickListener(this);
        btnLevel.setOnClickListener(this);
        btnStruct.setOnClickListener(this);
        btnDrive.setOnClickListener(this);
        btnColor.setOnClickListener(this);
        btnFule.setOnClickListener(this);
        btnEngine.setOnClickListener(this);
        btnAdd.setOnClickListener(this);

        carImageAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (carImageAdapter.getItem(position).equals("add")) {
                    Intent pickIntent = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    pickIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                    startActivityForResult(pickIntent, 100);
                }
            }
        });


        carItem = new CarItem();


        carItem.setGearbox(gearboxs[0]);
        carItem.setLevel(levels[0]);
        carItem.setStruct(structs[0]);
        carItem.setDrive(drives[0]);
        carItem.setColor(colors[0]);
        carItem.setFuel(fules[0]);
        carItem.setEngine(engines[0]);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gearbox:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(gearboxs, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setGearbox(gearboxs[which]);
                                btnGearbox.setText(gearboxs[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_level:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(levels, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setLevel(levels[which]);
                                btnLevel.setText(levels[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_struct:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(structs, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setStruct(structs[which]);
                                btnStruct.setText(structs[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_drive:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(drives, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setDrive(drives[which]);
                                btnDrive.setText(drives[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_color:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(colors, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setColor(colors[which]);
                                btnColor.setText(colors[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_fule:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(fules, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setFuel(fules[which]);
                                btnFule.setText(fules[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_engine:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(engines, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                carItem.setEngine(engines[which]);
                                btnEngine.setText(engines[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_add:
                String name = editTextName.getText().toString().trim();
                String location = editTextLocation.getText().toString().trim();
                int mileage = Integer.parseInt(editTextMileage.getText().toString().trim());
                int consumption = Integer.parseInt(editTextConsumption.getText().toString().trim());
                float price = Float.parseFloat(etPrice.getText().toString().trim());
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(location)) {
                    Toast.makeText(this, "请输入名字和地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mileage <= 0) {
                    Toast.makeText(this, "请输入里程", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (consumption <= 0) {
                    Toast.makeText(this, "请输入油耗", Toast.LENGTH_SHORT).show();
                    return;
                }
                carItem.setName(name);
                carItem.setLocation(location);
                carItem.setMileage(mileage);
                carItem.setPrice(price);

                if (TextUtils.isEmpty(carItem.getGearbox())) {
                    Toast.makeText(this, "请选择变速箱", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getLevel())) {
                    Toast.makeText(this, "请选择级别", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getStruct())) {
                    Toast.makeText(this, "请选择结构", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getDrive())) {
                    Toast.makeText(this, "请选择驱动", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getColor())) {
                    Toast.makeText(this, "请选择颜色", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getFuel())) {
                    Toast.makeText(this, "请选择燃料", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(carItem.getEngine())) {
                    Toast.makeText(this, "请选择发动机", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (carImageAdapter.getData().isEmpty()) {
                    Toast.makeText(this, "请添加照片", Toast.LENGTH_SHORT).show();
                    return;
                }
                List<String> images = new LinkedList<>();
                for (int i = 0; i < carImageAdapter.getData().size(); i++) {
                    if (!carImageAdapter.getData().get(i).equals("add")) {
                        images.add(carImageAdapter.getData().get(i));
                    }
                }
                carItem.setImages(images);
                carItem.save();
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK || data == null || requestCode != 100) {
            return;
        }
        carImageAdapter.addData(0, data.getData().toString());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
