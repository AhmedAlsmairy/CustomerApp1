package com.example.customerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.customerapp.databinding.ActivityOrdersStatusBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class OrdersStatus extends AppCompatActivity {
SharedPreferences preferences;
private String token;
ActivityOrdersStatusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        preferences = getSharedPreferences("saveToken" , MODE_PRIVATE);
        token = preferences.getString("token" , "");

        fragments.add(OrderStatus.newInstance(token , "pending"));
        fragments.add(OrderStatus.newInstance(token,"unCompleted"));
        fragments.add(OrderStatus.newInstance(token,"completed"));
        ViewPagerAdapter adapter = new ViewPagerAdapter( this , fragments);

        binding.viewpager.setAdapter(adapter);


        titles.add("pending");
        titles.add("unCompleted");
        titles.add("completed");

        new TabLayoutMediator(binding.tab, binding.viewpager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        });
    }
}