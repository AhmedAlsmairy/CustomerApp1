package com.example.customerapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customerapp.Models.OrderData;
import com.example.customerapp.databinding.OrderStatusCardBinding;

import java.util.List;

public class OrderStatusAdapter extends RecyclerView.Adapter<OrderStatusAdapter.MyViewHolder> {

    List<OrderData> data;
    OrderData orderData;

    public OrderStatusAdapter(List<OrderData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderStatusCardBinding binding = OrderStatusCardBinding.inflate(LayoutInflater.from(parent.getContext()) , parent , false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder binding, int position) {
        int pos = position;
        orderData = data.get(pos);

        binding.orderID.setText(String.valueOf(orderData.getUser().getId()));
        binding.orderData.setText(orderData.getCreatedAt());
        binding.serviceType.setText(orderData.getWork().getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView serviceType, orderData, orderID;


        public MyViewHolder(@NonNull OrderStatusCardBinding binding) {
            super(binding.getRoot());
            serviceType = binding.serviceType;
            orderData = binding.orderID;
            orderID = binding.orderID;

        }
    }
}
