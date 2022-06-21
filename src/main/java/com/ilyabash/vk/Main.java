package com.ilyabash.vk;

import com.ilyabash.vk.response.*;
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class Main {
    static final String v = "5.124"; // версия вк
    static final String access_token = "vk1.a.ICyII4qDuVrYlPhSoAUJIbFM-FIJths-Fu6fWtYmZnvsgOfVjdLTHsWoeQzBz_xKBSxLItl-76o7EcpmdiV8q4cRTkerFteMaYT9KABhPYsEBMqFxTUV3UJrMx1yeSwJHdKYlzPGSKzbtNUPku74dwp1o8E1YEF7-173jxdSb0C8-pTWPs1ljKlXFyPiElhf"; // токен
    static final String q = "Кирилл Власов"; // Рандомный человек для примера
    public static void main(String[] args) throws IOException {


        System.out.println("Тестовый метод");
        VkAPI api = VkService.getInstance().getVkAPI();
        ProfileInfo profileInfo = api.getProfileInfo("341428583",v,access_token).execute().body();
        System.out.println(profileInfo);


        System.out.println("Реализация методов из заданий");

        System.out.println("users.search");
            api.getUsers(v,access_token,q,"300").enqueue(new Callback<UsersSearchResponse>() {
                @SneakyThrows
                @Override
                public void onResponse(Call<UsersSearchResponse> call, Response<UsersSearchResponse> response) {
                    UsersSearchResponse users = response.body();

                    System.out.println(users);

                    Integer i = 0;
                    Integer count = 0;
                    while (count < 20) {
                        Integer id = users.getIdUser(users.getListUsers(), i);
                        UsersFollowersResponse followers = api.getFollowers(v,access_token, String.valueOf(id)).execute().body();
                        UsersSubscriptionsResponse subs = api.getSub(v,access_token,String.valueOf(id),"1").execute().body();
                        try {
                            System.out.println("ID: " + id + " Followers: " + followers.getCount()  + ", Subs: " + subs.getCount());
                            i++;
                            count++;

                        }
                        catch (IndexOutOfBoundsException in) {
                            i++;
                        }
                        catch (NullPointerException e) {
                            i++;

                        }

                    }


                }

                @Override
                public void onFailure(Call<UsersSearchResponse> call, Throwable throwable) {
                    throwable.printStackTrace();
                }
            });









    }
}
