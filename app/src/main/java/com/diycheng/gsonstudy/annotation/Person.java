package com.diycheng.gsonstudy.annotation;

import com.google.gson.annotations.Expose;

/**
 * Created by liwangcheng on 2017/6/8 09:49.
 */

public class Person {
    @Expose
    public String IDCardNum;
    @Expose
    public String firstName;
    public String lastName;
    @Expose(deserialize=false)
    public String nickName;
    @Expose(serialize=false)
    public int age;
    transient public String gender;

    @Override
    public String toString() {
        return "Person{" +
                "IDCardNum='" + IDCardNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
