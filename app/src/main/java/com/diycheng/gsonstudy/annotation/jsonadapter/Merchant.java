package com.diycheng.gsonstudy.annotation.jsonadapter;
/**
 * Created by liwangcheng on 2017/7/3 09:57.
 */
public class Merchant {

    public int Id;
    public String name;

    // 可能还有很多其他属性

    @Override
    public String toString() {
        return "Merchant{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}