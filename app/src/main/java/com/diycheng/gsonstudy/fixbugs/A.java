package com.diycheng.gsonstudy.fixbugs;

/**
 * Created by liwangcheng on 2017/6/29 12:59.
 */

public class A {
    
    String name;
    int num;
    float value;
    boolean flag;
    A a;
    transient B b;

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", value=" + value +
                ", flag=" + flag +
                '}';
    }
}
