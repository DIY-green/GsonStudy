package com.diycheng.gsonstudy.typeadapter;

public class Dog extends Animal {
    boolean playsCatch;

    @Override
    public String toString() {
        return "Dog{\n" +
                super.toString() + "\n" +
                "playsCatch=" + playsCatch + "\n" +
                '}';
    }
}