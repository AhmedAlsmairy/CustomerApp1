package com.example.customerapp.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.customerapp.ApiData.ApiClient;
import com.example.customerapp.Models.CustomerlOGINResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {
    private boolean success;
    private String token;
    public boolean login(String email , String password){
        ApiClient.getInstance().customerLogin(email , password).enqueue(new Callback<CustomerlOGINResponse>() {
            @Override
            public void onResponse(Call<CustomerlOGINResponse> call, Response<CustomerlOGINResponse> response) {
                success = response.isSuccessful();
                if (success){
                    if (response.body() != null) {
                        token = response.body().getData().getToken();
                    }
                }
            }

            @Override
            public void onFailure(Call<CustomerlOGINResponse> call, Throwable t) {

            }
        });
        return success;
    }
    public String getToken(){
        return token;
    }
}
