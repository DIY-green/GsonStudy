package com.diycheng.gsonstudy.typeadapter;

public class Cat extends Animal {
    boolean chasesRedLaserDot;

    @Override
    public String toString() {
        return "Cat{\n" +
                super.toString() + "\n" +
                "chasesRedLaserDot=" + chasesRedLaserDot + "\n" +
                '}';
    }
}