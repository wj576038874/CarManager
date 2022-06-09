package com.car.app.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.car.app.R;
import com.car.app.model.User;

import org.litepal.LitePal;

import java.util.List;

/**
 * author: wenjie
 * date: 2022-06-08 21:51
 * descption:
 */
public class RegisterActivity extends AppCompatActivity {


    private Button btnRegister;
    private EditText editTextName;
    private EditText editTextPwd;
    private EditText editTextPwd2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("注册");
        setContentView(R.layout.activity_register);

        btnRegister = findViewById(R.id.btn_register);
        editTextName = findViewById(R.id.et_username);
        editTextPwd = findViewById(R.id.et_password);
        editTextPwd2 = findViewById(R.id.et_password2);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String pwd = editTextPwd.getText().toString().trim();
                String pwd2 = editTextPwd2.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwd2)) {
                    Toast.makeText(getApplicationContext(), "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!pwd.equals(pwd2)) {
                    Toast.makeText(getApplicationContext(), "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<User> users = LitePal.select("name").where("name=?", name).find(User.class);
                if (!users.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "用户已经注册", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = new User();
                user.setName(name);
                user.setPassword(pwd);
                user.save();
                Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
