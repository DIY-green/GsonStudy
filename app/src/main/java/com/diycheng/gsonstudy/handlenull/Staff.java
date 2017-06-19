package com.diycheng.gsonstudy.handlenull;

/**
 * Created by liwangcheng on 2017/6/19 14:41.
 */

public class Staff {
    int age;
    float salary;
    char title;
    boolean isDevelop;
    String name;

    @Override
    public String toString() {
        return "Staff{" +
                "age=" + age +
                ", salary=" + salary +
                ", title=" + title +
                ", isDevelop=" + isDevelop +
                ", name='" + name + '\'' +
                '}';
    }
}
