package com.car.app.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.car.app.R;

/**
 * author: wenjie
 * date: 2022-06-09 16:28
 * descption:
 */
public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("意见反馈");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_report);

        EditText editText = findViewById(R.id.edit);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    Toast.makeText(ReportActivity.this, "请输入你要提交的反馈", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReportActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
