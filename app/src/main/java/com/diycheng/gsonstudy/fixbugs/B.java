package com.diycheng.gsonstudy.fixbugs;

/**
 * Created by liwangcheng on 2017/6/29 12:59.
 */

public class B {
    
    String name;
    int num;
    float value;
    boolean flag;
    transient A a;
    B b;

    @Override
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", value=" + value +
                ", flag=" + flag +
                '}';
    }
}
