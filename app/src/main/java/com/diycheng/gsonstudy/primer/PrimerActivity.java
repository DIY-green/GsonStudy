package com.diycheng.gsonstudy.primer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrimerActivity extends AppCompatActivity {

    private static final String TAG = "PrimerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer);

        testJsonToObj();
        testObjToJson();
        testJsonToArray();
        testJsonToList();
        testJsonToList2();
        testArrayToJson();
        testListToJson();
    }

    private void testJsonToObj() {
        basicJ2Basic();
        simpleJ2O();
        nestJ2O();
        nestJ2O2();
    }

    private void basicJ2Basic() {
        Log.e(TAG, "==========basicJ2Basic Start==========");
        Log.e(TAG, "原始 JSON 串：true, 1, A, 11, 110, 1111111111, 1.77, 9.99");
        Gson gson = new Gson();
        boolean bool = gson.fromJson("true", boolean.class);
        byte byt = gson.fromJson("1", byte.class);
        char ch = gson.fromJson("A", char.class);
        short shor = gson.fromJson("11", short.class);
        int in = gson.fromJson("110", int.class);
        long lon = gson.fromJson("1111111111", long.class);
        float flo = gson.fromJson("1.77", float.class);
        double dou = gson.fromJson("9.99", double.class);
        Log.e(TAG, "转出的基本类型值：boolean bool = " + bool + "\n"
                + "byte byt = " + byt + "\n"
                + "char ch = " + ch  + "\n"
                + "short shor = " + shor  + "\n"
                + "int in = " + in  + "\n"
                + "long lon = " + lon  + "\n"
                + "float flo = " + flo  + "\n"
                + "double dou = " + dou);
        Log.e(TAG, "==========basicJ2Basic End==========");
    }


    private void simpleJ2O() {
        Log.e(TAG, "==========testJsonToObj Start==========");
        String userJson = "{'age':21,'email':'androider@gson.com','isDeveloper':true,'name':'Androider'}";
        Log.e(TAG, "原始 JSON 串：" + userJson);
        Gson gson = new Gson();
        // 注意第二个参数的传递，否则，Gson 不知道将 JSON 转换成什么类型。
        User user = gson.fromJson(userJson, User.class);
        Log.e(TAG, "转出的对象：" + user);
        Log.e(TAG, "==========testJsonToObj End==========");
    }

    private void nestJ2O() {
        Log.e(TAG, "==========testJsonToObj Start==========");
        String userDetailJson = "{\n" +
                "'age': 26,\n" +
                "'phone': '110',\n" +
                "'name': 'Norman',\n" +
                "'address': {\n" +
                "'country': 'China',\n" +
                "'city': 'Beijing',\n" +
                "'street': 'Gson Street',\n" +
                "'houseNumber': '110'\n" +
                "}\n" +
                "}";
        Log.e(TAG, "原始 JSON 串：" + userDetailJson);
        Gson gson = new Gson();
        UserDetail userDetail = gson.fromJson(userDetailJson, UserDetail.class);
        Log.e(TAG, "转出的对象：" + userDetail);
        Log.e(TAG, "==========testJsonToObj End==========");
    }

    private void nestJ2O2() {
        Log.e(TAG, "==========testJsonToObj Start==========");
        String userInnerAddressJson = "{\n" +
                "'age': 26,\n" +
                "'phone': '110',\n" +
                "'name': 'Norman',\n" +
                "'address': {\n" +
                "'country': 'China',\n" +
                "'city': 'Beijing',\n" +
                "'street': 'Gson Street',\n" +
                "'houseNumber': '110'\n" +
                "}\n" +
                "}";
        Log.e(TAG, "原始 JSON 串：" + userInnerAddressJson);
        Gson gson = new Gson();
        UserInnerAddress userInnerAddress = gson.fromJson(userInnerAddressJson, UserInnerAddress.class);
        Log.e(TAG, "转出的对象：" + userInnerAddress);
        Log.e(TAG, "==========testJsonToObj End==========");
    }

    private void testObjToJson() {
        simpleO2J();
        nestO2J();
        nestO2J2();
    }

    private void simpleO2J() {
        Log.e(TAG, "==========testObjToJson Start==========");
        User user = new User();
        user.age = 37;
        user.email = "objtojson@gson.com";
        user.isDeveloper = false;
        user.name = "Test Gson";
        Log.e(TAG, "目标转换对象：" + user);
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        Log.e(TAG, "==========testObjToJson End==========");
    }

    private void nestO2J() {
        Log.e(TAG, "==========testObjToJson Start==========");
        UserDetail userDetail = new UserDetail();
        userDetail.age = 37;
        userDetail.phone = "10086";
        userDetail.name = "Test Gson";
        userDetail.address = new Address();
        userDetail.address.country = "USA";
        userDetail.address.city = "New York";
        userDetail.address.street = "Google Street";
        Log.e(TAG, "目标转换对象：" + userDetail);
        Gson gson = new Gson();
        String userJson = gson.toJson(userDetail);
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        Log.e(TAG, "==========testObjToJson End==========");
    }

    private void nestO2J2() {
        Log.e(TAG, "==========testObjToJson Start==========");
        UserInnerAddress userInnerAddress = new UserInnerAddress();
        userInnerAddress.age = 37;
        userInnerAddress.phone = "10086";
        userInnerAddress.name = "Test Gson";
        userInnerAddress.address = new UserInnerAddress.InnerAddress();
        userInnerAddress.address.country = "USA";
        userInnerAddress.address.city = "New York";
        userInnerAddress.address.street = "Google Street";
        Log.e(TAG, "目标转换对象：" + userInnerAddress);
        Gson gson = new Gson();
        String userJson = gson.toJson(userInnerAddress);
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        Log.e(TAG, "==========testObjToJson End==========");
    }

    private void testJsonToArray() {
        Log.e(TAG, "==========testJsonToArray Start==========");
        String courseArrayJson = "[{'name': 'Java','credit': 3}, {'name': 'C', 'credit': 3}, {'name': 'C++', 'credit': 3}, {'name': 'Android', 'credit': 3}, {'name': 'Swift', 'credit': 1}, {'name': 'Kotlin', 'credit': 2}, {'name': 'JavaScript', 'credit': 2}]";
        Log.e(TAG, "原始 JSON 串：" + courseArrayJson);
        Gson gson = new Gson();
        Course[] courseArr = gson.fromJson(courseArrayJson, Course[].class);
        Log.e(TAG, "转出的对象：" + courseArr);
        Log.e(TAG, "==========testJsonToArray End==========");
    }

    private void testJsonToList() {
        Log.e(TAG, "==========testJsonToList Start==========");
        String courseArrayJson = "[{'name': 'Java','credit': 3}, {'name': 'C', 'credit': 3}, {'name': 'C++', 'credit': 3}, {'name': 'Android', 'credit': 3}, {'name': 'Swift', 'credit': 1}, {'name': 'Kotlin', 'credit': 2}, {'name': 'JavaScript', 'credit': 2}]";
        Log.e(TAG, "原始 JSON 串：" + courseArrayJson);
        Gson gson = new Gson();
        Type CourseListType = new TypeToken<ArrayList<Course>>(){}.getType();
        List<Course> courseList = gson.fromJson(courseArrayJson, CourseListType);
        Log.e(TAG, "转出的对象：" + courseList);
        Log.e(TAG, "==========testJsonToList End==========");
    }

    private void testJsonToList2() {
        Log.e(TAG, "==========testJsonToList2 Start==========");
        String courseArrayJson = "{'name':'小明','age':22,'courses':[{'name': 'Java','credit': 3}, {'name': 'C', 'credit': 3}, {'name': 'C++', 'credit': 3}, {'name': 'Android', 'credit': 3}, {'name': 'Swift', 'credit': 1}, {'name': 'Kotlin', 'credit': 2}, {'name': 'JavaScript', 'credit': 2}]}";
        Log.e(TAG, "原始 JSON 串：" + courseArrayJson);
        Gson gson = new Gson();
        UserDetail xiaoming = gson.fromJson(courseArrayJson, UserDetail.class);
        Log.e(TAG, "转出的对象：" + xiaoming);
        Log.e(TAG, "==========testJsonToList2 End==========");
    }

    private void testArrayToJson() {
        Log.e(TAG, "==========testArrayToJson Start==========");
        User[] userArr = new User[10];
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.name = "Name00" + i;
            user.isDeveloper = i / 2 == 0;
            user.email = "Name00" + i + "@gson.com";
            user.age = 17 + i;
            userArr[i] = user;
        }
        Log.e(TAG, "目标转换对象：" + userArr);
        Gson gson = new Gson();
        String userArrJson = gson.toJson(userArr);
        Log.e(TAG, "得到的 JSON 串：" + userArrJson);
        Log.e(TAG, "==========testArrayToJson End==========");
    }

    private void testListToJson() {
        Log.e(TAG, "==========testListToJson Start==========");
        List<User> userList = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.name = "Name00" + i;
            user.isDeveloper = i / 2 == 0;
            user.email = "Name00" + i + "@gson.com";
            user.age = 17 + i;
            userList.add(user);
        }
        Log.e(TAG, "目标转换对象：" + userList);
        Gson gson = new Gson();
        String userListJson = gson.toJson(userList);
        Log.e(TAG, "得到的 JSON 串：" + userListJson);
        Log.e(TAG, "==========testListToJson End==========");
    }

}
