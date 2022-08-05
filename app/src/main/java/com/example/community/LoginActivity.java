package com.example.community;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.community.databinding.FragmentLoginBinding;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    FragmentLoginBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        binding = FragmentLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnLogin.setOnClickListener(this);
        binding.btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_register:
                Intent intent = new Intent(getApplicationContext(), Fragment_Join.class);
                startActivity(intent);
                break;

            case R.id.btn_login:
                String et_id = binding.editTextId.toString();
                String et_password = binding.editTextPassword.toString();
                login(et_id,et_password,this);
        }

    }

    private void login(String et_id, String et_password, LoginActivity loginActivity) {
        //firebase연결

    }
}
