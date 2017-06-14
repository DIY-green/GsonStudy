package com.diycheng.gsonstudy.annotation;

import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

/**
 * Created by liwangcheng on 2017/6/14 09:18.
 */

public class Apple {

    String name;
    String weight;
    String color;
    @Since(4)
    String sinceTest;
    @Until(5)
    String untilTest;
    @Since(3)@Until(5)
    String sinceUntil;

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", weight='" + weight + '\'' +
                ", color='" + color + '\'' +
                ", sinceTest='" + sinceTest + '\'' +
                ", untilTest='" + untilTest + '\'' +
                ", sinceUntil='" + sinceUntil + '\'' +
                '}';
    }
}
