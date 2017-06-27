package com.diycheng.gsonstudy.enumtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;

public class EnumTestActivity extends AppCompatActivity {

    private static final String TAG = "EnumTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum_test);

        testEnum1();
        testEnum2();
        testEnum3();
        testEnum4();
    }

    private void testEnum1() {
        Fruit fruit = new Fruit();
        fruit.name = "Apple";
        fruit.price = 11.5f;
        fruit.weight = 1.5f;
        fruit.color = Color.BLUE;
        fruit.season = Season.FALL;
        Log.e(TAG, "==========testEnum1 Start==========");
        Log.e(TAG, "待转换的对象：" + fruit);
        Gson gson = new Gson();
        String fruitJson = gson.toJson(fruit);
        Log.e(TAG, "得到的 JSON 串：" + fruitJson);
        Fruit apple = gson.fromJson(fruitJson, Fruit.class);
        Log.e(TAG, "==>转出的对象：" + apple);
        Log.e(TAG, "==========testEnum1 End==========");
    }

    private void testEnum2() {
        Log.e(TAG, "==========testEnum2 Start==========");
        String fruitJson = "{'color':0,'name':'Apple','price':11.5,'season':0,'weight':1.5}";
        Log.e(TAG, "原始 JSON 串：" + fruitJson);
        Fruit fruit = new Gson().fromJson(fruitJson, Fruit.class);
        Log.e(TAG, "转出的对象：" + fruit);
        Log.e(TAG, "==========testEnum2 End==========");
    }

    private void testEnum3() {
        Log.e(TAG, "==========testEnum3 Start==========");
        String fruitJson = "{'color':'0','name':'Apple','price':11.5,'season':'0','weight':1.5}";
        Log.e(TAG, "原始 JSON 串：" + fruitJson);
        Fruit fruit = new Gson().fromJson(fruitJson, Fruit.class);
        Log.e(TAG, "转出的对象：" + fruit);
        Log.e(TAG, "==========testEnum3 End==========");
    }

    private void testEnum4() {
        Log.e(TAG, "==========testEnum4 Start==========");
        String fruitJson = "{'color':'YELLOW','name':'Apple','price':11.5,'season':'WINTER','weight':1.5}";
        Log.e(TAG, "原始 JSON 串：" + fruitJson);
        Fruit fruit = new Gson().fromJson(fruitJson, Fruit.class);
        Log.e(TAG, "转出的对象：" + fruit);
        Log.e(TAG, "==========testEnum4 End==========");
    }
}
