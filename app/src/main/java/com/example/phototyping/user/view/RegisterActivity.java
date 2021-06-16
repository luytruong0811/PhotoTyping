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
import com.example.phototyping.user.viewModel.RegisterViewModel;
import com.example.phototyping.user.viewModel.UserViewModelFactory;

public class RegisterActivity extends AppCompatActivity implements RegisterViewModel.RegisterListener {

    private RegisterViewModel registerViewModel;
    private EditText etEmailRegister, etPasswordRegister, etConfigPasswordRegister;
    private TextView tvNext;
    private ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmailRegister = findViewById(R.id.et_email_register);
        etPasswordRegister = findViewById(R.id.et_pass_word_register);
        etConfigPasswordRegister = findViewById(R.id.et_config_pass_word_register);
        tvNext = findViewById(R.id.tv_next);
        ivBack = findViewById(R.id.iv_back);

        registerViewModel = new ViewModelProvider(this, new UserViewModelFactory(getApplication())).get(RegisterViewModel.class);
        registerViewModel.setRegisterListener((RegisterViewModel.RegisterListener) this);

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerViewModel.register();
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, HomePage.class);
                startActivity(intent);
                finish();
            }
        });

        etEmailRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registerViewModel.onChangeUserName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPasswordRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registerViewModel.onChangePassWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etConfigPasswordRegister.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                registerViewModel.onChangeConfigPassWord(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void registerError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void registerSuccess() {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
        finish();
    }
}