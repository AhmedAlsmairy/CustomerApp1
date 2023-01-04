package com.example.customerapp.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.customerapp.ApiData.ApiClient;

public class CreateOrderViewModel extends ViewModel {

    public void createOrder(String work_id ,  String details
            ,  String details_address  ,  String[] photo ,
                            String phone  ,  String lat  ,
                            String longg ){
        ApiClient.getInstance().createOrder(work_id, details, details_address, photo, phone, lat, longg);
    }
}
