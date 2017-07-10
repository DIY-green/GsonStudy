package com.diycheng.gsonstudy.typeadapter;

/**
 * Created by liwangcheng on 2017/7/10 10:36.
 */

public class Bird extends Animal {
    String fly;

    @Override
    public String toString() {
        return "Bird{\n" +
                super.toString() + "\n" +
                "fly='" + fly+ '\'' + "\n" +
                '}';
    }
}
