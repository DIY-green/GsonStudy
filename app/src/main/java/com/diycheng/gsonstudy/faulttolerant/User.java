package com.diycheng.gsonstudy.faulttolerant;

/**
 * Created by liwangcheng on 2017/6/23 18:53.
 */

public class User implements Cloneable {

    String name;
    String phone;
    String qq;
    float weight;
    char badge; // 徽章
    boolean isNew;
    int age;
    String birthday;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", weight=" + weight +
                ", badge=" + badge +
                ", isNew=" + isNew +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                '}';
    }

    @Override
    protected User clone()  {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            User user = new User();
            user.weight = this.weight;
            user.qq = this.qq;
            user.phone = this.phone;
            user.name = this.name;
            user.age = this.age;
            user.badge = this.badge;
            user.birthday = this.birthday;
            user.isNew = this.isNew;
            return user;
        }
    }
}
