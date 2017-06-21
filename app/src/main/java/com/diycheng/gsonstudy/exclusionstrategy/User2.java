package com.diycheng.gsonstudy.exclusionstrategy;

/**
 * Created by liwangcheng on 2017/6/20 16:09.
 */

public class User2 {

    public String publicName;
    private String privateFirstName;
    protected String protectedLastName;

    final int finalAge = 18;
    volatile String volatileEmail;
    transient String transientPhoneNum;

    float weight;

    public String getPrivateFirstName() {
        return privateFirstName;
    }

    public void setPrivateFirstName(String privateFirstName) {
        this.privateFirstName = privateFirstName;
    }

    @Override
    public String toString() {
        return "User2{" +
                "publicName='" + publicName + '\'' +
                ", privateFirstName='" + privateFirstName + '\'' +
                ", protectedLastName='" + protectedLastName + '\'' +
                ", finalAge=" + finalAge +
                ", volatileEmail='" + volatileEmail + '\'' +
                ", transientPhoneNum='" + transientPhoneNum + '\'' +
                ", weight=" + weight +
                '}';
    }
}
