package com.diycheng.gsonstudy.annotation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AnnotationActivity extends AppCompatActivity {

    private static final String TAG = "Annotation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_expose:
                testExpose1();
                testExpose2();
                testExpose3();
                break;
            case R.id.btn_serializedname:
                testSerializedName1();
                testSerializedName2();
                testSerializedName3();
                break;
            case R.id.btn_sinceuntil:
                testSince();
                testUntil();
                testSinceUntil();
                break;
        }
    }

    private void testExpose1() {
        // 序列化
        Log.e(TAG, "==========testExpose1 序列化 Start==========");
        Person person = new Person();
        person.age = 11;
        person.firstName = "xiaoming";
        person.IDCardNum = "110";
        person.lastName = "XXX";
        person.nickName = "XM";
        Log.e(TAG, "目标转换对象：" + person);
        Gson gson = new Gson();
        String personStr = gson.toJson(person);
        Log.e(TAG, "得到的 JSON 串：" + personStr);
        Log.e(TAG, "==========testExpose1 序列化 End==========");
        // 反序列化
        Log.e(TAG, "==========testExpose1 反序列化 Start==========");
        String jsonStr = personStr;
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Person person1 = gson.fromJson(jsonStr, Person.class);
        Log.e(TAG, "转出的对象：" + person1);
        Log.e(TAG, "==========testExpose1 反序列化 End==========");
    }

    private void testExpose2() {
        // 序列化
        Log.e(TAG, "==========testExpose2 序列化 Start==========");
        Person person = new Person();
        person.age = 11;
        person.firstName = "xiaoming";
        person.IDCardNum = "110";
        person.lastName = "XXX";
        person.nickName = "XM";
        Log.e(TAG, "目标转换对象：" + person);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String personStr = gson.toJson(person);
        Log.e(TAG, "得到的 JSON 串：" + personStr);
        Log.e(TAG, "==========testExpose2 序列化 End==========");
        // 反序列化
        Log.e(TAG, "==========testExpose2 反序列化 Start==========");
        String jsonStr = new Gson().toJson(person);
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Person person1 = gson.fromJson(jsonStr, Person.class);
        Log.e(TAG, "转出的对象：" + person1);
        Log.e(TAG, "==========testExpose2 反序列化 End==========");
    }

    private void testExpose3() {
        // 序列化
        Log.e(TAG, "==========testExpose3 序列化 Start==========");
        Person person = new Person();
        person.age = 11;
        person.firstName = "xiaoming";
        person.IDCardNum = "110";
        person.lastName = "XXX";
        person.nickName = "XM";
        person.gender = "MAN";
        Log.e(TAG, "目标转换对象：" + person);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String personStr = gson.toJson(person);
        Log.e(TAG, "得到的 JSON 串：" + personStr);
        Log.e(TAG, "==========testExpose3 序列化 End==========");
        // 反序列化
        Log.e(TAG, "==========testExpose3 反序列化 Start==========");
        String jsonStr = new Gson().toJson(person);
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Person person1 = gson.fromJson(jsonStr, Person.class);
        Log.e(TAG, "转出的对象：" + person1);
        Log.e(TAG, "==========testExpose3 反序列化 End==========");
    }

    private void testSerializedName1() {
        Log.e(TAG, "==========testSerializedName1 Start==========");
        String jsonStr = "{'age':26,'email':'xiaoming@jiangyou.com','first_name':'Zhang','second_name':'Xiaoming','nick_name':'XM','address':'Google Road','working_age':11}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Gson gson = new Gson();
        Teacher teacher = gson.fromJson(jsonStr, Teacher.class);
        Log.e(TAG, "转出的对象：" + teacher);
        Log.e(TAG, "==========testSerializedName1 End==========");
    }

    private void testSerializedName2() {
        Log.e(TAG, "==========testSerializedName2 Start==========");
        String jsonStr1 = "{'age':26,'email':'xiaoming01@jiangyou.com','first_name':'Zhang','second_name':'Xiaoming','nick_name':'XM','address':'Google Road','working_age':11}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr1);
        Gson gson = new Gson();
        Teacher teacher1 = gson.fromJson(jsonStr1, Teacher.class);
        Log.e(TAG, "转出的对象：" + teacher1);
        String jsonStr2 = "{'age':26,'emailAddress':'xiaoming02@jiangyou.com','first_name':'Zhang','second_name':'Xiaoming','nick_name':'XM','address':'Google Road','working_age':11}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr2);
        Teacher teacher2 = gson.fromJson(jsonStr2, Teacher.class);
        Log.e(TAG, "转出的对象：" + teacher2);
        String jsonStr3 = "{'age':26,'email_address':'xiaoming03@jiangyou.com','first_name':'Zhang','second_name':'Xiaoming','nick_name':'XM','address':'Google Road','working_age':11}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr3);
        Teacher teacher3 = gson.fromJson(jsonStr3, Teacher.class);
        Log.e(TAG, "转出的对象：" + teacher3);
        Log.e(TAG, "==========testSerializedName2 End==========");
    }

    private void testSerializedName3() {
        Log.e(TAG, "==========testSerializedName3 Start==========");
        String jsonStr = "{'age':26,\n'email':'xiaoming@jiangyou.com',\n'emailAddress':'xiaoming02@jiangyou.com',\n'email_address':'xiaoming03@jiangyou.com',\n'first_name':'Zhang',\n'second_name':'Xiaoming',\n'nick_name':'XM',\n'address':'Google Road',\n'working_age':11}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Gson gson = new Gson();
        Teacher teacher = gson.fromJson(jsonStr, Teacher.class);
        Log.e(TAG, "转出的对象：" + teacher);
        Log.e(TAG, "==========testSerializedName3 End==========");
    }

    private void testSince() {
        Log.e(TAG, "==========testSince Start==========");
        Apple apple = new Apple();
        apple.color = "RED";
        apple.name = "红富士";
        apple.weight = "500g";
        apple.sinceTest = "@Since(4)";
        Log.e(TAG, "目标转换对象：" + apple);
        GsonBuilder gsonBuilder = new GsonBuilder();
        String apple1JsonStr = gsonBuilder.setVersion(2).create().toJson(apple);
        Log.e(TAG, "setVersion(2) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(4).create().toJson(apple);
        Log.e(TAG, "setVersion(4) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(6).create().toJson(apple);
        Log.e(TAG, "setVersion(6) 时 得到的 JSON 串：\n" + apple1JsonStr);
        Log.e(TAG, "==========testSince End==========");
    }

    private void testUntil() {
        Log.e(TAG, "==========testUntil Start==========");
        Apple apple = new Apple();
        apple.color = "Green";
        apple.name = "红富士";
        apple.weight = "500g";
        apple.untilTest = "@Until(5)";
        Log.e(TAG, "目标转换对象：" + apple);
        GsonBuilder gsonBuilder = new GsonBuilder();
        String apple1JsonStr = gsonBuilder.setVersion(2).create().toJson(apple);
        Log.e(TAG, "setVersion(2) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(4).create().toJson(apple);
        Log.e(TAG, "setVersion(4) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(6).create().toJson(apple);
        Log.e(TAG, "setVersion(6) 时 得到的 JSON 串：\n" + apple1JsonStr);
        Log.e(TAG, "==========testUntil End==========");
    }

    private void testSinceUntil() {
        Log.e(TAG, "==========testSinceUntil Start==========");
        Apple apple = new Apple();
        apple.color = "Yellow";
        apple.name = "红富士";
        apple.weight = "500g";
        apple.sinceUntil = "@Since(3)@Until(5)";
        Log.e(TAG, "目标转换对象：" + apple);
        GsonBuilder gsonBuilder = new GsonBuilder();
        String apple1JsonStr = gsonBuilder.setVersion(2).create().toJson(apple);
        Log.e(TAG, "setVersion(2) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(4).create().toJson(apple);
        Log.e(TAG, "setVersion(4) 时 得到的 JSON 串：\n" + apple1JsonStr);
        apple1JsonStr = gsonBuilder.setVersion(6).create().toJson(apple);
        Log.e(TAG, "setVersion(6) 时 得到的 JSON 串：\n" + apple1JsonStr);
        Log.e(TAG, "==========testSinceUntil End==========");
    }

}
