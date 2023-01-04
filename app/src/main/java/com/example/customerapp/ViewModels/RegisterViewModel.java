package com.example.customerapp.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.customerapp.ApiData.ApiClient;
import com.example.customerapp.Models.CustomerRegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {
   private boolean success;

    public boolean register(String name , String email, String phone , String password){

        ApiClient.getInstance().customerRegister(name, email, phone, password).enqueue(new Callback<CustomerRegisterResponse>() {
            @Override
            public void onResponse(Call<CustomerRegisterResponse> call, Response<CustomerRegisterResponse> response) {
                success = response.isSuccessful();
            }

            @Override
            public void onFailure(Call<CustomerRegisterResponse> call, Throwable t) {

            }
        });
        return success;

    }


}
