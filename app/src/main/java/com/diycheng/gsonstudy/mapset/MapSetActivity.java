package com.diycheng.gsonstudy.mapset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapSetActivity extends AppCompatActivity {

    private static final String TAG = "MapSetActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_set);

        testMapJsonToObj();
        testJsonToMap();
        testJsonToMap2();
        testMapToJson();
        testMapToJson2();
        testSetJsonToList();
        testJsonToSet();
        testJsonToSet2();
        testSetToJson();
        testSetToJson2();
    }

    private void testMapJsonToObj() {
        Log.e(TAG, "==========testMapJsonToObj Start==========");
        String mapJson = "{'dish1': {'name': '西红柿鸡蛋','price': 21},'dish2': {'name': '辣椒炒肉','price': 23},'dish3': {'name': '你的最爱','price': 31}}";
        Log.e(TAG, "原始 JSON 串：" + mapJson);
        Gson gson = new Gson();
        Dishes dishes = gson.fromJson(mapJson, Dishes.class);
        Log.e(TAG, "转出的对象：" + dishes);
        Log.e(TAG, "==========testMapJsonToObj End==========");
    }

    private void testJsonToMap() {
        Log.e(TAG, "==========testJsonToMap Start==========");
        String mapJson = "{'dish1': {'name': '西红柿鸡蛋','price': 21},'dish2': {'name': '辣椒炒肉','price': 23},'dish3': {'name': '你的最爱','price': 31}}";
        Log.e(TAG, "原始 JSON 串：" + mapJson);
        Gson gson = new Gson();
        Type dishMapType = new TypeToken<HashMap<String, Dish>>(){}.getType();
        HashMap<String, Dish> dishMap = gson.fromJson(mapJson, dishMapType);
        Log.e(TAG, "转出的对象：" + dishMap);
        Log.e(TAG, "==========testJsonToMap End==========");
    }

    private void testJsonToMap2() {
        Log.e(TAG, "==========testJsonToMap2 Start==========");
        String mapJson = "{'menu': {'dish1': {'name': '西红柿鸡蛋','price': 21},'dish2': {'name': '辣椒炒肉','price': 23},'dish3': {'name': '你的最爱','price': 31}}}";
        Log.e(TAG, "原始 JSON 串：" + mapJson);
        Gson gson = new Gson();
        Menu menu = gson.fromJson(mapJson, Menu.class);
        Log.e(TAG, "转出的对象：" + menu);
        Log.e(TAG, "==========testJsonToMap2 End==========");
    }

    private void testMapToJson() {
        Log.e(TAG, "==========testMapToJson Start==========");
        HashMap<String, Dish> dishHashMap = new HashMap<>(3);
        for (int i = 0; i < 3; i++) {
            Dish dish = new Dish();
            dish.name = "Dish-" + i;
            dish.price = 10 + i;
            dishHashMap.put(dish.name, dish);
        }
        Log.e(TAG, "目标转换对象：" + dishHashMap);
        Gson gson = new Gson();
        String dishMapJson = gson.toJson(dishHashMap);
        Log.e(TAG, "得到的 JSON 串：" + dishMapJson);
        Log.e(TAG, "==========testMapToJson End==========");
    }

    private void testMapToJson2() {
        Log.e(TAG, "==========testMapToJson2 Start==========");
        HashMap<String, Dish> dishHashMap = new HashMap<>(3);
        for (int i = 0; i < 3; i++) {
            Dish dish = new Dish();
            dish.name = "Dish-" + i;
            dish.price = 10 + i;
            dishHashMap.put(dish.name, dish);
        }
        Menu menu = new Menu();
        menu.menu = dishHashMap;
        Log.e(TAG, "目标转换对象：" + menu);
        Gson gson = new Gson();
        String menuJson = gson.toJson(menu);
        Log.e(TAG, "得到的 JSON 串：" + menuJson);
        Log.e(TAG, "==========testMapToJson2 End==========");
    }

    private void testSetJsonToList() {
        Log.e(TAG, "==========testSetJsonToList Start==========");
        String setJson = "['Java','Android','C','C++','C#','OC','Swift','PHP','JavaScript','Python','VB','.Net','Go']";
        Log.e(TAG, "原始 JSON 串：" + setJson);
        Gson gson = new Gson();
        Type programListType = new TypeToken<ArrayList<String>>(){}.getType();
        List<String> programList = gson.fromJson(setJson, programListType);
        Log.e(TAG, "转出的对象：" + programList);
        Log.e(TAG, "==========testSetJsonToList End==========");
    }

    private void testJsonToSet() {
        Log.e(TAG, "==========testJsonToSet Start==========");
        String setJson = "['Java','Android','C','C++','C#','OC','Swift','PHP','JavaScript','Python','VB','.Net','Go']";
        Log.e(TAG, "原始 JSON 串：" + setJson);
        Gson gson = new Gson();
        Type programSetType = new TypeToken<HashSet<String>>(){}.getType();
        Set<String> programSet = gson.fromJson(setJson, programSetType);
        Log.e(TAG, "转出的对象：" + programSet);
        Log.e(TAG, "==========testJsonToSet End==========");
    }

    private void testJsonToSet2() {
        Log.e(TAG, "==========testJsonToSet2 Start==========");
        String setJson = "{program:['Java','Android','C','C++','C#','OC','Swift','PHP','JavaScript','Python','VB','.Net','Go']}";
        Log.e(TAG, "原始 JSON 串：" + setJson);
        Gson gson = new Gson();
        Program program = gson.fromJson(setJson, Program.class);
        Log.e(TAG, "转出的对象：" + program);
        Log.e(TAG, "==========testJsonToSet2 End==========");
    }

    private void testSetToJson() {
        Log.e(TAG, "==========testSetToJson Start==========");
        HashSet<String> programHashSet = new HashSet<>(5);
        for (int i = 0; i < 5; i++) {
            String name = "Program-" + i;
            programHashSet.add(name);
        }
        Log.e(TAG, "目标转换对象：" + programHashSet);
        Gson gson = new Gson();
        String programSetJson = gson.toJson(programHashSet);
        Log.e(TAG, "得到的 JSON 串：" + programSetJson);
        Log.e(TAG, "==========testSetToJson End==========");
    }

    private void testSetToJson2() {
        Log.e(TAG, "==========testSetToJson2 Start==========");
        HashSet<String> programHashSet = new HashSet<>(5);
        for (int i = 0; i < 5; i++) {
            String name = "Program-" + i;
            programHashSet.add(name);
        }
        Program program = new Program();
        program.program = programHashSet;
        Log.e(TAG, "目标转换对象：" + program);
        Gson gson = new Gson();
        String programJson = gson.toJson(program);
        Log.e(TAG, "得到的 JSON 串：" + programJson);
        Log.e(TAG, "==========testSetToJson2 End==========");
    }

}
