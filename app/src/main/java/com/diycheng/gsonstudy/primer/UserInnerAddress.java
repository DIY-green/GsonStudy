package com.diycheng.gsonstudy.primer;

/**
 * Created by liwangcheng on 2017/5/26 07:54.
 */

public class UserInnerAddress {
    int age;
    String name;
    String phone;
    InnerAddress address;

    public static class InnerAddress {
        String country;
        String city;
        String street;
        String houseNumber;
    }
}
