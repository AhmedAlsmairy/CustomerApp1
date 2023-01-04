package com.example.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.customerapp.databinding.ActivityOrderDoneBinding;

public class OrderDone extends AppCompatActivity {
ActivityOrderDoneBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDoneBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.goToHomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}