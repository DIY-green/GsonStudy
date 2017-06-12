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
}
