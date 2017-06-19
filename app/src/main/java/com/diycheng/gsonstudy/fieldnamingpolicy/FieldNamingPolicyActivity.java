package com.diycheng.gsonstudy.fieldnamingpolicy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.google.gson.FieldNamingPolicy.IDENTITY;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_DASHES;
import static com.google.gson.FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
import static com.google.gson.FieldNamingPolicy.UPPER_CAMEL_CASE;
import static com.google.gson.FieldNamingPolicy.UPPER_CAMEL_CASE_WITH_SPACES;

public class FieldNamingPolicyActivity extends AppCompatActivity {

    private static final String TAG = "NamingPolicy";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_field_naming_policy);

        testIDENTITY();
        testUPPER_CAMEL_CASE();
        testUPPER_CAMEL_CASE_WITH_SPACES();
        testLOWER_CASE_WITH_DASHES();
        testLOWER_CASE_WITH_UNDERSCORES();
        testWithSerializedName();
        testCustomFieldNamingStrategy();
    }

    private void testIDENTITY() {
        Log.e(TAG, "==========testIDENTITY Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(IDENTITY);
        Gson gson = gsonBuilder.create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testIDENTITY End==========");
    }

    private void testUPPER_CAMEL_CASE() {
        Log.e(TAG, "==========testUPPER_CAMEL_CASE Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(UPPER_CAMEL_CASE);
        Gson gson = gsonBuilder.create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testUPPER_CAMEL_CASE End==========");
    }

    private void testUPPER_CAMEL_CASE_WITH_SPACES() {
        Log.e(TAG, "==========testUPPER_CAMEL_CASE_WITH_SPACES Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(UPPER_CAMEL_CASE_WITH_SPACES);
        Gson gson = gsonBuilder.create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testUPPER_CAMEL_CASE_WITH_SPACES End==========");
    }

    private void testLOWER_CASE_WITH_UNDERSCORES() {
        Log.e(TAG, "==========testLOWER_CASE_WITH_UNDERSCORES Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testLOWER_CASE_WITH_UNDERSCORES End==========");
    }

    private void testLOWER_CASE_WITH_DASHES() {
        Log.e(TAG, "==========testLOWER_CASE_WITH_DASHES Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_DASHES);
        Gson gson = gsonBuilder.create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testLOWER_CASE_WITH_DASHES End==========");
    }

    private void testWithSerializedName() {
        Log.e(TAG, "==========testWithSerializedName Start==========");
        UserInfo userInfo = new UserInfo();
        userInfo._age = 37;
        userInfo.nick_name = "Test Gson";
        userInfo.address = "Google Road";
        userInfo.FirstName = "Lee";
        userInfo.lastName = "Ming";
        userInfo.mPhone = "110";
        userInfo.email = "xiaoming@gmail.com";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson;
        String userInfoJson;
        UserInfo userInfo1;
        Log.e(TAG, "1.==>IDENTITY Start");
        gsonBuilder.setFieldNamingPolicy(IDENTITY);
        gson = gsonBuilder.create();
        userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "1.==>IDENTITY End");

        Log.e(TAG, "2.==>UPPER_CAMEL_CASE Start");
        gsonBuilder.setFieldNamingPolicy(UPPER_CAMEL_CASE);
        gson = gsonBuilder.create();
        userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "2.==>UPPER_CAMEL_CASE End");

        Log.e(TAG, "3.==>UPPER_CAMEL_CASE_WITH_SPACES Start");
        gsonBuilder.setFieldNamingPolicy(UPPER_CAMEL_CASE_WITH_SPACES);
        gson = gsonBuilder.create();
        userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "3.==>UPPER_CAMEL_CASE_WITH_SPACES End");

        Log.e(TAG, "4.==>LOWER_CASE_WITH_UNDERSCORES Start");
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_UNDERSCORES);
        gson = gsonBuilder.create();
        userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "4.==>LOWER_CASE_WITH_UNDERSCORES End");

        Log.e(TAG, "5.==>LOWER_CASE_WITH_DASHES Start");
        gsonBuilder.setFieldNamingPolicy(LOWER_CASE_WITH_DASHES);
        gson = gsonBuilder.create();
        userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "5.==>LOWER_CASE_WITH_DASHES End");

        Log.e(TAG, "==========testWithSerializedName End==========");
    }

    private void testCustomFieldNamingStrategy() {
        Log.e(TAG, "==========testUPPER_CAMEL_CASE_WITH_SPACES Start==========");
        UserInfo2 userInfo = new UserInfo2();
        userInfo._age = 37;
        userInfo._nick_name = "Test Gson";
        userInfo._address = "Google Road";
        userInfo._First_Name = "Lee";
        userInfo._last_Name = "Ming";
        userInfo._m_Phone = "110";
        userInfo._email_Address = "xiaoming@gmail.com";
        Log.e(TAG, "目标转换对象：" + userInfo);
        GsonBuilder gsonBuilder = new GsonBuilder();
        CustomFieldNamingStrategy namingStrategy = new CustomFieldNamingStrategy();
        Gson gson = gsonBuilder.setFieldNamingStrategy(namingStrategy).create();
        String userInfoJson = gson.toJson(userInfo);
        Log.e(TAG, "得到的 JSON 串：" + userInfoJson);
        UserInfo userInfo1 = gson.fromJson(userInfoJson, UserInfo.class);
        Log.e(TAG, "==>转出的对象：" + userInfo1);
        Log.e(TAG, "==========testUPPER_CAMEL_CASE_WITH_SPACES End==========");
    }

}
