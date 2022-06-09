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

    private final String[] gearboxs = new String[]{"AMT", "AT", "CVT", "DCT"};
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


//        carItem.setGearbox(gearboxs[0]);
//        carItem.setLevel(levels[0]);
//        carItem.setStruct(structs[0]);
//        carItem.setDrive(drives[0]);
//        carItem.setColor(colors[0]);
//        carItem.setFuel(fules[0]);
//        carItem.setEngine(engines[0]);
    }

    private int selectedGearboxIndex = -1;
    private int selectedLevelIndex = -1;
    private int selectedStructIndex = -1;
    private int selectedDriveIndex = -1;
    private int selectedColorIndex = -1;
    private int selectedFuleIndex = -1;
    private int selectedEnginesIndex = -1;

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_gearbox:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(gearboxs, selectedGearboxIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedGearboxIndex = which;
                                btnGearbox.setText(gearboxs[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_level:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(levels, selectedLevelIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedLevelIndex = which;
                                btnLevel.setText(levels[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_struct:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(structs, selectedStructIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedStructIndex = which;
                                btnStruct.setText(structs[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_drive:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(drives, selectedDriveIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedDriveIndex = which;
                                btnDrive.setText(drives[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_color:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(colors, selectedColorIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedColorIndex = which;
                                btnColor.setText(colors[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_fule:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(fules, selectedFuleIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedFuleIndex = which;
                                btnFule.setText(fules[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_engine:
                new AlertDialog.Builder(this)
                        .setSingleChoiceItems(engines, selectedEnginesIndex, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedEnginesIndex = which;
                                btnEngine.setText(engines[which]);
                                dialog.cancel();
                            }
                        })
                        .create().show();
                break;
            case R.id.btn_add:
                String name = editTextName.getText().toString().trim();
                String location = editTextLocation.getText().toString().trim();
                String mileage = editTextMileage.getText().toString().trim();
                String consumption = editTextConsumption.getText().toString().trim();
                String price = etPrice.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(location)) {
                    Toast.makeText(this, "请输入名字和地址", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mileage) || Integer.parseInt(mileage) <= 0) {
                    Toast.makeText(this, "请输入里程", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(consumption) || Double.parseDouble(consumption) <= 0) {
                    Toast.makeText(this, "请输入油耗", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(price) || Float.parseFloat(price) <= 0) {
                    Toast.makeText(this, "请输入价格", Toast.LENGTH_SHORT).show();
                    return;
                }
                carItem.setName(name);
                carItem.setLocation(location);
                carItem.setMileage(Integer.parseInt(mileage));
                carItem.setPrice(Float.parseFloat(price));
                carItem.setFuelConsumption(Double.parseDouble(consumption));

                if (selectedGearboxIndex >= 0) {
                    carItem.setGearbox(gearboxs[selectedGearboxIndex]);
                } else {
                    Toast.makeText(this, "请选择变速箱", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedLevelIndex >= 0) {
                    carItem.setLevel(levels[selectedLevelIndex]);
                } else {
                    Toast.makeText(this, "请选择级别", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedStructIndex >= 0) {
                    carItem.setStruct(structs[selectedStructIndex]);
                } else {
                    Toast.makeText(this, "请选择结构", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedDriveIndex >= 0) {
                    carItem.setDrive(drives[selectedDriveIndex]);
                } else {
                    Toast.makeText(this, "请选择驱动", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (selectedColorIndex >= 0) {
                    carItem.setColor(colors[selectedColorIndex]);
                } else {
                    Toast.makeText(this, "请选择颜色", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedFuleIndex >= 0) {
                    carItem.setFuel(fules[selectedFuleIndex]);
                } else {
                    Toast.makeText(this, "请选择燃料", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (selectedEnginesIndex >= 0) {
                    carItem.setEngine(engines[selectedEnginesIndex]);
                } else {
                    Toast.makeText(this, "请选择发动机", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<String> images = new LinkedList<>();
                for (int i = 0; i < carImageAdapter.getData().size(); i++) {
                    if (!carImageAdapter.getData().get(i).equals("add")) {
                        images.add(carImageAdapter.getData().get(i));
                    }
                }
                if (images.isEmpty()) {
                    Toast.makeText(this, "请添加照片", Toast.LENGTH_SHORT).show();
                    return;
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
