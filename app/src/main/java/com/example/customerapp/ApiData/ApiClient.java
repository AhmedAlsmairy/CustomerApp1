package com.example.customerapp.ApiData;

import com.example.customerapp.Models.CustomerRegisterResponse;
import com.example.customerapp.Models.CustomerlOGINResponse;
import com.example.customerapp.Models.OrdersResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class ApiClient {

    public static final String BaseULR = "https://studentucas.awamr.com/api/";
    DataInterface dataInterface;
    private static ApiClient Instance;

    private ApiClient(){
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory
                        (GsonConverterFactory.create())
                .baseUrl(BaseULR)
                .build();
        dataInterface = retrofit.create(DataInterface.class);

    }

    public static ApiClient getInstance() {
        if (Instance == null){
            Instance = new ApiClient();
        }
        return Instance;
    }
    public Call<CustomerlOGINResponse>  customerLogin(String email , String password){
        return dataInterface.customerLogin(email , password);
    }

    public Call<CustomerRegisterResponse> customerRegister(String name , String email
            , String phone , String password ){
        return dataInterface.customerRegister(name, email,  phone , password);
    }
    public void createOrder(String authorization , String work_id ,  String details
            ,  String details_address  ,  String[] photo ,
                             String phone  ,  String lat  ,
                             String longg ){
        dataInterface.createOrder( authorization , work_id, details, details_address, photo, phone, lat, longg);
    }

    public Call<OrdersResponse> pendingOrders(String authorization){
        return dataInterface.pendingOrders(authorization);
    }

    public Call<OrdersResponse> unCompletedOrders(String authorization){
        return dataInterface.unCompletedOrders(authorization);
    }

    public Call<OrdersResponse> completedOrders(String authorization){
        return dataInterface.completedOrders(authorization);
    }


}
