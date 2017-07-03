package com.diycheng.gsonstudy.deserialize;

import java.util.Date;

public class UserData {
    String name;
    String email;
    boolean isDeveloper;
    int age;
    Date registerDate;

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isDeveloper=" + isDeveloper +
                ", age=" + age +
                ", registerDate=" + registerDate +
                '}';
    }
}