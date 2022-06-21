package com.ilyabash.vk.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class UsersFollowersResponse {
    @SerializedName("response")
    @NonNull private ResponseWithFollowers response;

    public Integer getCount() {
        return response.getCount();
    }
}
@Getter
@Setter
@ToString
class ResponseWithFollowers{
    @SerializedName("count")
    private Integer count;
    @SerializedName("items")
    private ArrayList<Integer> items = new ArrayList<>();
}


