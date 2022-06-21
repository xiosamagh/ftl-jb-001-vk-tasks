package com.ilyabash.vk.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@ToString
@Getter
@Setter
public class ProfileInfo {
    @SerializedName("response")
    private ArrayList<ResponseProfile> response = new ArrayList<ResponseProfile>();

}
@ToString
@Getter
@Setter
class ResponseProfile {

    @SerializedName("id")
    private Integer id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;



}
