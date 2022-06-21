package com.ilyabash.vk;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class VkService {

    private Retrofit retrofit;

    private static VkService instance;

    private static final String BASE_URL = "https://api.vk.com/method/";


    private VkService() {

//        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(5, TimeUnit.SECONDS)
//                .connectTimeout(5, TimeUnit.SECONDS)
//                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static VkService getInstance() {
        if (instance == null) {
            instance = new VkService();
        }
        return instance;
    }

    public VkAPI getVkAPI() {
        return retrofit.create(VkAPI.class);
    }
}
