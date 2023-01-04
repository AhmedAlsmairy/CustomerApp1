package com.example.customerapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.customerapp.ViewModels.RegisterViewModel;
import com.example.customerapp.databinding.ActivityRegisterBinding;

public class Register extends AppCompatActivity {
ActivityRegisterBinding binding;
String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RegisterViewModel registerViewModel = new RegisterViewModel();

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.fullName.getText().toString();
                String email = binding.email.getText().toString();
                String phone = binding.phone.getText().toString();
                String password = binding.password.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !password.isEmpty()){
                  boolean success = registerViewModel.register(name , email , phone , password);
                  if (success){
                      Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                      new Handler().postDelayed(new Runnable() {
                          @Override
                          public void run() {
                              finish();
                          }
                      } , 1500);

                  }else {
                      Toast.makeText(Register.this, "error!", Toast.LENGTH_SHORT).show();
                  }

                }else {
                    Toast.makeText(Register.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}