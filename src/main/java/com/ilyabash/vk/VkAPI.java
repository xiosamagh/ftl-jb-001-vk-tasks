package com.ilyabash.vk;

import com.ilyabash.vk.response.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VkAPI {

    @GET("users.get?")
    Call<ProfileInfo> getProfileInfo(
            @Query("user_ids") String user_ids,
            @Query("v") String version,
            @Query("access_token") String access_token
    );

    @GET("users.search?")
    Call<UsersSearchResponse> getUsers(@Query("v") String v, @Query("access_token") String access_token, @Query("q") String q, @Query("count") String count);

    @GET("users.getFollowers?")
    Call<UsersFollowersResponse> getFollowers(@Query("v") String v, @Query("access_token") String access_token, @Query("user_id") String user_id);

    @GET("users.getSubscriptions?")
    Call<UsersSubscriptionsResponse> getSub(@Query("v") String v, @Query("access_token") String access_token, @Query("user_id") String user_id, @Query("extended") String extended);










}
