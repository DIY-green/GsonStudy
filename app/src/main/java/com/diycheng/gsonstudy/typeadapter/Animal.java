package com.diycheng.gsonstudy.typeadapter;

public class Animal {
    String name;
    String type; // this specifies which animal it is

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}