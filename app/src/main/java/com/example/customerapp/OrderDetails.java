package com.example.customerapp;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.customerapp.databinding.ActivityOrderDetailsBinding;

public class OrderDetails extends AppCompatActivity {
ActivityOrderDetailsBinding binding;
String Url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ActivityResultLauncher<String> arl = registerForActivityResult(
                new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null){
                            Url = result.toString();

                        }

                    }
                }
        );

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.detailsText.getText().toString();
                if (!Url.isEmpty() && !text.isEmpty()){
                    Intent intent = new Intent(getBaseContext() , Location.class);
                    intent.putExtra("url" , Url );
                    intent.putExtra("text" , text );
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(OrderDetails.this, "enter all details", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arl.launch("image/*");
            }
        });
    }
}