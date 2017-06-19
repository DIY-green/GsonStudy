package com.diycheng.gsonstudy.fieldnamingpolicy;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liwangcheng on 2017/6/19 09:03.
 */

public class UserInfo {
    int _age;
    String FirstName;
    String lastName;
    String nick_name;
    String mPhone;
    String address;
    @SerializedName("emailAddress")
    String email;

    @Override
    public String toString() {
        return "UserInfo{" +
                "_age=" + _age +
                ", FirstName='" + FirstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", mPhone='" + mPhone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
