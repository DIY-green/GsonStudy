package com.diycheng.gsonstudy.deserialize;

import android.content.Context;

public class UserContext {  
    
    String name;
    String email;
    boolean isDeveloper;
    int age;

    transient Context context;

    public UserContext(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "UserContext{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", isDeveloper=" + isDeveloper +
                ", age=" + age +
                ", context=" + context +
                '}';
    }
}