package com.diycheng.gsonstudy.faulttolerant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FaultTolerantActivity extends AppCompatActivity {

    private static final String TAG = "FaultTolerant";
    private User mUser;
    private Gson mDefaultGson;
    private String mDefaultUserJson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fault_tolerant);

        initData();
        testOpenLenient1();
        testSpecialFloat1();
        testSpecialFloat2();
        testSpecialFloat3();
    }

    private void initData() {
        mDefaultGson = new Gson();
        mUser = new User();
        mUser.age = 18;
        mUser.badge = 'B';
        mUser.birthday = "1990-01-01";
        mUser.isNew = true;
        mUser.name = "XiaoMing";
        mUser.phone = "110";
        mUser.qq = "10000";
        mUser.weight = 55.0f;
        mDefaultUserJson = mDefaultGson.toJson(mUser);
        Log.e(TAG, mDefaultUserJson);
        // {"age":18,"badge":"B","birthday":"1990-01-01","isNew":true,"name":"XiaoMing","phone":"110","qq":"10000","weight":55.0}
    }

    private void testOpenLenient1() {
        Log.e(TAG, "==========testOpenLenient1 Start==========");
        Log.e(TAG, "规范 JSON 串：" + mDefaultUserJson);
        User user = mDefaultGson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "转出的对象：" + user);
        String badUserJson = "{age='18';'badge':'B','birthday':'1990-01-01','isNew':true,'name':'XiaoMing','phone':'110','qq':'10000','weight':55.0}";
        Log.e(TAG, "不规范 JSON 串：" + mDefaultUserJson);
        try {
            user = mDefaultGson.fromJson(badUserJson, User.class);
        } catch (Exception e) {
            Log.e(TAG, "不规范 JSON 串导致异常\n" + e.getMessage());
        }
        if (user != null) {
            Log.e(TAG, user.toString());
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson = gsonBuilder.create();
        user = gson.fromJson(badUserJson, User.class);
        Log.e(TAG, "==>开启Lenient后转出的对象：" + user);
        Log.e(TAG, "==========testOpenLenient1 End==========");
    }

    private void testSpecialFloat1() {
        User user = mUser.clone();
        user.weight = Float.POSITIVE_INFINITY;
        Log.e(TAG, "==========testSpecialFloat1 Start==========");
        Log.e(TAG, "设置了不符合 JSON 标准的值\n直接使用默认 Gson 对象序列化");
        Log.e(TAG, "目标转换对象：" + user);
        String userJsonStr = "";
        try {
            userJsonStr = mDefaultGson.toJson(user);
            Log.e(TAG, "使用默认 Gson 得到的 JSON 串：" + userJsonStr);
        } catch (Exception e) {
            Log.e(TAG, "不符合 JSON 标准序列化导致异常\n" + e.getMessage());
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .serializeSpecialFloatingPointValues()
                .create();
        userJsonStr = gson.toJson(user);
        Log.e(TAG, "通过 GsonBuilder 设置 serializeSpecialFloatingPointValues() 方法\n");
        Log.e(TAG, "得到的 JSON 串：" + userJsonStr);
        user = gson.fromJson(userJsonStr, User.class);
        Log.e(TAG, "==>默认 Gson 转出的对象：\n" + mDefaultGson.fromJson(userJsonStr, User.class));
        Log.e(TAG, "==>GsonBuilder 设置 serializeSpecialFloatingPointValues 生成的 Gson 转出的对象：\n" + user);
        Log.e(TAG, "==========testSpecialFloat1 End==========");
    }

    private void testSpecialFloat2() {
        User user = mUser.clone();
        user.weight = Float.NEGATIVE_INFINITY;
        Log.e(TAG, "==========testSpecialFloat2 Start==========");
        Log.e(TAG, "设置了不符合 JSON 标准的值\n直接使用默认 Gson 对象序列化");
        Log.e(TAG, "目标转换对象：" + user);
        String userJsonStr = "";
        try {
            userJsonStr = mDefaultGson.toJson(user);
            Log.e(TAG, "使用默认 Gson 得到的 JSON 串：" + userJsonStr);
        } catch (Exception e) {
            Log.e(TAG, "不符合 JSON 标准序列化导致异常\n" + e.getMessage());
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .serializeSpecialFloatingPointValues()
                .create();
        userJsonStr = gson.toJson(user);
        Log.e(TAG, "通过 GsonBuilder 设置 serializeSpecialFloatingPointValues() 方法\n");
        Log.e(TAG, "得到的 JSON 串：" + userJsonStr);
        user = gson.fromJson(userJsonStr, User.class);
        Log.e(TAG, "==>默认 Gson 转出的对象：\n" + mDefaultGson.fromJson(userJsonStr, User.class));
        Log.e(TAG, "==>GsonBuilder 设置 serializeSpecialFloatingPointValues 生成的 Gson 转出的对象：\n" + user);
        Log.e(TAG, "==========testSpecialFloat2 End==========");
    }

    private void testSpecialFloat3() {
        User user = mUser.clone();
        user.weight = Float.NaN;
        Log.e(TAG, "==========testSpecialFloat3 Start==========");
        Log.e(TAG, "设置了不符合 JSON 标准的值\n直接使用默认 Gson 对象序列化");
        Log.e(TAG, "目标转换对象：" + user);
        String userJsonStr = "";
        try {
            userJsonStr = mDefaultGson.toJson(user);
            Log.e(TAG, "使用默认 Gson 得到的 JSON 串：" + userJsonStr);
        } catch (Exception e) {
            Log.e(TAG, "不符合 JSON 标准序列化导致异常\n" + e.getMessage());
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .serializeSpecialFloatingPointValues()
                .create();
        userJsonStr = gson.toJson(user);
        Log.e(TAG, "通过 GsonBuilder 设置 serializeSpecialFloatingPointValues() 方法\n");
        Log.e(TAG, "得到的 JSON 串：" + userJsonStr);
        user = gson.fromJson(userJsonStr, User.class);
        Log.e(TAG, "==>默认 Gson 转出的对象：\n" + mDefaultGson.fromJson(userJsonStr, User.class));
        Log.e(TAG, "==>GsonBuilder 设置 serializeSpecialFloatingPointValues 生成的 Gson 转出的对象：\n" + user);
        Log.e(TAG, "==========testSpecialFloat3 End==========");
    }

}
