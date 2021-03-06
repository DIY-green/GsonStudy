package com.diycheng.gsonstudy.deserialize;

import java.util.Date;

public class UserData {
    public String name;
    public String email;
    public boolean isDeveloper;
    public int age;
    public Date registerDate;

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