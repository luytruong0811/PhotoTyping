package com.example.phototyping.user.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.phototyping.HomePage;
import com.example.phototyping.R;
import com.example.phototyping.discover.DiscoverActivity;
import com.example.phototyping.user.viewModel.LoginViewModel;
import com.example.phototyping.user.viewModel.UserViewModelFactory;

public class LoginActivity extends AppCompatActivity implements LoginViewModel.LoginListener{

    private LoginViewModel loginViewModel;
    private EditText etEmailLogin, etPasswordLogin;
    private TextView tvLogin;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmailLogin = findViewById(R.id.et_email_login);
        etPasswordLogin = findViewById(R.id.et_pass_word_login);
        tvLogin = findViewById(R.id.tv_login);
        loginViewModel = new ViewModelProvider(this, new UserViewModelFactory(getApplication())).get(LoginViewModel.class);
        loginViewModel.setLoginListener(this);
        ivBack = findViewById(R.id.iv_back);


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });
        tvLogin .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginViewModel.login();
            }
        });

        etEmailLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.onChangeUserName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPasswordLogin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                loginViewModel.onChangePassWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void loginError(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(LoginActivity.this, DiscoverActivity.class);
        startActivity(intent);
        finish();
    }
}