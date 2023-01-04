package com.example.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.customerapp.ViewModels.CreateOrderViewModel;
import com.example.customerapp.databinding.ActivityLocationBinding;

public class Location extends AppCompatActivity {
ActivityLocationBinding binding;
String Url;
String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String[] photos = new String[1];

        Intent intent = getIntent();
      Url = intent.getStringExtra("url");
      text = intent.getStringExtra("text");
      photos[0] = Url;
        CreateOrderViewModel viewModel = new CreateOrderViewModel();

      binding.addOrderBtn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String location_details = binding.locationDetails.getText().toString();
              String phone = binding.phoneNumber.getText().toString();
              if (!location_details.isEmpty() && !phone.isEmpty()){
                  viewModel.createOrder("1" , text , location_details , photos , phone , "500" , "400" );
                  startActivity(new Intent(getBaseContext() , OrderDone.class));
                  finish();
              }else {
                  Toast.makeText(Location.this, "enter all details", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }
}