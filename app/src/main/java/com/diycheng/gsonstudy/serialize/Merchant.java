package com.diycheng.gsonstudy.serialize;

public class Merchant {

    int Id;
    String name;

    // 可能还有很多其他属性

    @Override
    public String toString() {
        return "Merchant{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}