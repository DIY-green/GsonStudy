package com.diycheng.gsonstudy.handlenull;

/**
 * Created by liwangcheng on 2017/6/7 09:54.
 */

public class Student {
    public String stuNum;
    public String name;
    public int age;
    public String school;
    public String college;
    public String major;
    public String grade;
    public int gender;

    @Override
    public String toString() {
        return "Student{" +
                "stuNum='" + stuNum + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", school='" + school + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", gender=" + gender +
                '}';
    }
}
