package com.diycheng.gsonstudy.enumtest;

/**
 * Created by liwangcheng on 2017/6/27 14:05.
 */

public class Fruit {
    String name;
    float weight;
    float price;

    Color color;
    Season season;

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                ", color=" + color +
                ", season=" + season +
                '}';
    }
}
