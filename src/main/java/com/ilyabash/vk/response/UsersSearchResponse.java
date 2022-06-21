package com.ilyabash.vk.response;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class UsersSearchResponse {
    @SerializedName("response")
    private Response response;

    public List<Item> getListUsers() {
        return response.getItems();
    }

    public Integer getIdUser(List<Item> list, Integer n) {
        return list.get(n).getId();
    }

    public Integer getCount() {
        return response.getCount();
    }



}
@ToString
@Getter
@Setter
class Item{
    @SerializedName("track_code")
    private String track_code;
    @SerializedName("id")
    private Integer id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
}
@ToString
@Getter
@Setter
class Response{

    public Response() {

    }
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private ArrayList<Item> items = new ArrayList<>();
}




