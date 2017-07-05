package com.diycheng.gsonstudy.annotation;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liwangcheng on 2017/6/12 09:35.
 * 演示 SerializedName
 */

public class Teacher {

    int age;
    @SerializedName(value = "email", alternate = {"emailAddress", "email_address"})
    String email;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("second_name")
    String secondName;
    @SerializedName("nick_name")
    String nickName;
    String address;
    @SerializedName("working_age")
    int workingAge;

    @Override
    public String toString() {
        return "Teacher{" +
                "age=" + age +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", address='" + address + '\'' +
                ", workingAge=" + workingAge +
                '}';
    }
}
