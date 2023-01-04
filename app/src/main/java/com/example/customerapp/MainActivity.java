package com.example.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.customerapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements ChoiceClick {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().add(R.id.fram , new GettingStarted()).commit();

        binding.orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , OrdersStatus.class));
            }
        });

    }

    @Override
    public void click() {
        startActivity(new Intent(getBaseContext() , OrderDetails.class));
    }
}