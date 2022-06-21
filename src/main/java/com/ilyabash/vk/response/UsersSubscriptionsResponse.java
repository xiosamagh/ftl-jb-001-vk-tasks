package com.ilyabash.vk.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
public class UsersSubscriptionsResponse {
    @SerializedName("response")
    @NonNull private ResponseWithSub response;

    public Integer getCount() {
        return response.getCount();
    }


}
@ToString
@Getter
@Setter
class ItemWithSub{
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("screen_name")
    private String screen_name;
    @SerializedName("type")
    private String type;


}
@ToString
@Getter
@Setter
class ResponseWithSub{
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private ArrayList<ItemWithSub> items = new ArrayList<>();
}

