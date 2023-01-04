package com.example.customerapp.ViewModels;

import androidx.lifecycle.MutableLiveData;

import com.example.customerapp.ApiData.ApiClient;
import com.example.customerapp.Models.OrderData;
import com.example.customerapp.Models.OrdersResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdersStatusViewModel {
    public MutableLiveData<List<OrderData>> pendingOrderData = new MutableLiveData<>();
    public MutableLiveData<List<OrderData>> unCompletedOrderData = new MutableLiveData<>();
    public MutableLiveData<List<OrderData>> completedOrderData = new MutableLiveData<>();

    public void pendingOrderData(String authorization){
        ApiClient.getInstance().pendingOrders(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> data = new ArrayList<>(response.body().getData());
                pendingOrderData.setValue(data);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }

    public void unCompletedOrderData(String authorization){
        ApiClient.getInstance().unCompletedOrders(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> data = new ArrayList<>(response.body().getData());
                unCompletedOrderData.setValue(data);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }

    public void completedOrderData(String authorization){
        ApiClient.getInstance().completedOrders(authorization).enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                List<OrderData> data = new ArrayList<>(response.body().getData());
                completedOrderData.setValue(data);
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {

            }
        });
    }

}
