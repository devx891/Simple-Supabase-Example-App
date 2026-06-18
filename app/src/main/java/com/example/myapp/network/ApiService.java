package com.example.myapp.network;

import com.example.myapp.data.model.User;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("rest/v1/users")
    Call<List<User>> getUsers();
}
