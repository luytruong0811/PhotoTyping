package com.example.phototyping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.phototyping.user.view.LoginActivity;
import com.example.phototyping.user.view.RegisterActivity;

public class HomePage extends AppCompatActivity {

    private TextView tvLogin, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tvLogin = findViewById(R.id.tv_login_homepage);
        tvRegister = findViewById(R.id.tv_register);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}