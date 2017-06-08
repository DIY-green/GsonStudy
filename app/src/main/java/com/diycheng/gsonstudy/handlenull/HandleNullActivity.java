package com.diycheng.gsonstudy.handlenull;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HandleNullActivity extends AppCompatActivity {

    private static final String TAG = "HandleNull";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_null);

        testFieldPartial();
        testPartUnValuation();
        testSerializeNulls();
        testTypeAdapterFactory1();
        testTypeAdapterFactory2();
    }

    private void testFieldPartial() {
        Log.e(TAG, "==========testFieldPartial Start==========");
        String jsonStr = "{\"stuNum\":\"111222\",\"name\":\"xiaoming\",\"age\":18,\"school\":\"酱油小学\"}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Gson gson = new Gson();
        Student student = gson.fromJson(jsonStr, Student.class);
        Log.e(TAG, "转出的对象：" + student);
        Log.e(TAG, "==========testFieldPartial End==========");
    }

    private void testPartUnValuation() {
        Log.e(TAG, "==========testPartUnValuation Start==========");
        Student student = new Student();
        student.age = 37;
        student.name = "Test Gson";
        Log.e(TAG, "目标转换对象：" + student);
        Gson gson = new Gson();
        String studentJson = gson.toJson(student);
        Log.e(TAG, "得到的 JSON 串：" + studentJson);
        Log.e(TAG, "==========testPartUnValuation End==========");
    }

    private void testSerializeNulls() {
        Log.e(TAG, "==========testSerializeNulls Start==========");
        Student student = new Student();
        student.age = 37;
        student.name = "Test Gson";
        Log.e(TAG, "目标转换对象：" + student);
        Gson gson = new GsonBuilder().serializeNulls().create();
        String studentJson = gson.toJson(student);
        Log.e(TAG, "得到的 JSON 串：" + studentJson);
        Log.e(TAG, "==========testSerializeNulls End==========");
    }

    private void testTypeAdapterFactory1() {
        Log.e(TAG, "==========testTypeAdapterFactory1 Start==========");
        String jsonStr = "{\"stuNum\":\"111222\",\"name\":\"xiaoming\",\"age\":18,\"school\":\"酱油小学\",\"college\":\"null\"}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        Student student = gson.fromJson(jsonStr, Student.class);
        Log.e(TAG, "转出的对象：" + student);
        Log.e(TAG, "==========testTypeAdapterFactory1 End==========");

    }

    private void testTypeAdapterFactory2() {
        Log.e(TAG, "==========testTypeAdapterFactory2 Start==========");
        Student student = new Student();
        student.age = 37;
        student.name = "Test Gson";
        Log.e(TAG, "目标转换对象：" + student);
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
        String studentJson = gson.toJson(student);
        Log.e(TAG, "得到的 JSON 串：" + studentJson);
        Log.e(TAG, "==========testTypeAdapterFactory2 End==========");

    }

}
