package com.diycheng.gsonstudy.fieldnamingpolicy;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liwangcheng on 2017/6/19 09:03.
 */

public class UserInfo2 {
    int _age;
    String _First_Name;
    String _last_Name;
    String _nick_name;
    String _m_Phone;
    String _address;
    @SerializedName("emailAddress")
    String _email_Address;

    @Override
    public String toString() {
        return "UserInfo2{" +
                "_age=" + _age +
                ", _First_Name='" + _First_Name + '\'' +
                ", _last_Name='" + _last_Name + '\'' +
                ", _nick_name='" + _nick_name + '\'' +
                ", _m_Phone='" + _m_Phone + '\'' +
                ", _address='" + _address + '\'' +
                ", _email_Address='" + _email_Address + '\'' +
                '}';
    }
}
