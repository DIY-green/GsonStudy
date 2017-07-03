package com.diycheng.gsonstudy.serialize;

import java.util.List;

/**
 * Created by liwangcheng on 2017/7/3 09:57.
 */

public class UserSubscription {
    String name;
    String email;
    int age;
    boolean isDeveloper;

    List<Merchant> merchantList;

    @Override
    public String toString() {
        return "UserSubscription{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                ", merchantList=" + merchantList +
                '}';
    }
}
