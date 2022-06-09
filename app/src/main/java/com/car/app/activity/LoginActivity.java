package com.car.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.widget.Toolbar;

import com.car.app.R;
import com.car.app.model.User;
import com.car.app.utils.SpUtils;

import org.litepal.LitePal;

import java.util.List;

/**
 * author: wenjie
 * date: 2022-06-08 21:51
 * descption:
 */
public class LoginActivity extends AppCompatActivity {


    private Button btnRegister;
    private Button btnLogin;
    private EditText editTextName;
    private EditText editTextPwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("登录");
        setContentView(R.layout.activity_login);

        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);
        editTextName = findViewById(R.id.et_username);
        editTextPwd = findViewById(R.id.et_password);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString().trim();
                String pwd = editTextPwd.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(getApplicationContext(), "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                login(name, pwd);
            }
        });


    }


    private void login(String name, String pwd) {
        List<User> users = LitePal.select("name", "password").where("password=?", name).where("password=?", pwd).find(User.class);
        if (!users.isEmpty()) {
            SpUtils.getInstance().loginSuccess(users.get(0).getName());
            finish();
        } else {
            Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
