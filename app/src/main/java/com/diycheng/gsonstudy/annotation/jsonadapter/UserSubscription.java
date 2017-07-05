package com.diycheng.gsonstudy.annotation.jsonadapter;

import com.google.gson.annotations.JsonAdapter;

import java.util.List;

/**
 * Created by liwangcheng on 2017/7/3 09:57.
 * 演示 @JsonAdapter 序列化使用
 */

public class UserSubscription {
    public String name;
    public String email;
    public int age;
    public boolean isDeveloper;

    @JsonAdapter(MerchantListSerializer.class)
    public List<Merchant> merchantList;

    @Override
    public String toString() {
        return "UserSubscription{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age + '\'' +
                ", isDeveloper=" + isDeveloper + '\n' +
                ", merchantList=" + merchantList +
                '}';
    }
}
