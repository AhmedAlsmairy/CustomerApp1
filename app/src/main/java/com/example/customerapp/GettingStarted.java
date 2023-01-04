package com.example.customerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customerapp.databinding.FragmentGettingStartedBinding;


public class GettingStarted extends Fragment {
    ChoiceClick choiceClick;
    public GettingStarted() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentGettingStartedBinding binding = FragmentGettingStartedBinding.inflate(inflater, container, false);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choiceClick.click();
            }
        };
        binding.chose1.setOnClickListener(onClickListener);
        binding.chose2.setOnClickListener(onClickListener);
        binding.chose3.setOnClickListener(onClickListener);
        binding.chose4.setOnClickListener(onClickListener);
        binding.chose5.setOnClickListener(onClickListener);
        binding.chose6.setOnClickListener(onClickListener);
        binding.chose7.setOnClickListener(onClickListener);
        binding.chose8.setOnClickListener(onClickListener);
        binding.chose9.setOnClickListener(onClickListener);
        binding.chose10.setOnClickListener(onClickListener);
        binding.chose11.setOnClickListener(onClickListener);
        binding.chose12.setOnClickListener(onClickListener);


        return binding.getRoot();
    }
}