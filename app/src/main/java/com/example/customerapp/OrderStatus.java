package com.example.customerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customerapp.ViewModels.OrdersStatusViewModel;
import com.example.customerapp.databinding.FragmentOrderStatusBinding;


public class OrderStatus extends Fragment {

    OrderStatusAdapter adapter;
    OrdersStatusViewModel viewModel = new OrdersStatusViewModel();

    private static final String ARG_PARAM1 = "token";
    private static final String ARG_PARAM2 = "type";

    private String token;
    private String type;



    public OrderStatus() {
        // Required empty public constructor
    }



    public static OrderStatus newInstance(String t , String type) {
        OrderStatus fragment = new OrderStatus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, t);
        args.putString(ARG_PARAM2, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            token = getArguments().getString(ARG_PARAM1);
            type = getArguments().getString(ARG_PARAM2);

            if (type.equals("pending")){
                viewModel.pendingOrderData(token);
                adapter = new OrderStatusAdapter(viewModel.pendingOrderData.getValue());
            }
           else if (type.equals("unCompleted")){
                viewModel.unCompletedOrderData(token);
                adapter = new OrderStatusAdapter(viewModel.unCompletedOrderData.getValue());

            }else if (type.equals("completed")){
                viewModel.completedOrderData(token);
                adapter = new OrderStatusAdapter(viewModel.completedOrderData.getValue());
            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOrderStatusBinding binding = FragmentOrderStatusBinding.inflate(inflater , container , false);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));

        return binding.getRoot();
    }
}