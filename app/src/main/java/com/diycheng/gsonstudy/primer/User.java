package com.diycheng.gsonstudy.primer;

/**
 * Created by liwangcheng on 2017/5/25 18:16.
 */

public class User {
    String name;
    String email;
    int age;
    boolean isDeveloper;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isDeveloper=" + isDeveloper +
                '}';
    }
}
