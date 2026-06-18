package com.example.myapp.network;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Replace with your project URL
    private static final String BASE_URL =
            "XXXXXXXXX";

    // Replace with your anon key
    private static final String API_KEY =
            "XXXXXXXXX";

    private static Retrofit retrofit;

    public static Retrofit getClient() {

        if (retrofit == null) {

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor((Interceptor.Chain chain) -> {

                        Request request = chain.request()
                                .newBuilder()
                                .addHeader("apikey", API_KEY)
                                .addHeader("Authorization",
                                        "Bearer " + API_KEY)
                                .build();

                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
