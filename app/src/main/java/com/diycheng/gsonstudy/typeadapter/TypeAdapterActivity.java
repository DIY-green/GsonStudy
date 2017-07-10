package com.diycheng.gsonstudy.typeadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class TypeAdapterActivity extends AppCompatActivity {

    private static final String TAG = "TypeAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_adapter);

        testUserTypeAdapter();
        testIntTypeAdapter();
        testRuntimeTypeAdapterFactory();
    }

    private void testUserTypeAdapter() {
        Log.e(TAG, "==========testUserTypeAdapter Start==========");
        User user = new User();
        user.age = 18;
        user.email = "XiaoMing@gmail.com";
        user.name = "XiaoMing";
        Log.e(TAG, "目标转换对象：" + user);
        Gson gson = new GsonBuilder()
                    .registerTypeAdapter(User.class, new UserTypeAdapter())
                    .create();
        String userJson = gson.toJson(user);
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        Log.e(TAG, "==========testUserTypeAdapter End==========");
    }

    private void testIntTypeAdapter() {
        Log.e(TAG, "==========testIntTypeAdapter Start==========");
        String userJson =  "{\"name\":\"XiaoMing\",\"age\":\"\",\"email\":\"Student@126.com\"}";
        Log.e(TAG, "原始 JSON 串：" + userJson);
        Gson gson = new GsonBuilder()
                    .registerTypeAdapter(int.class, new IntTypeAdapter(-1))
                    .registerTypeAdapter(Integer.class, new IntTypeAdapter(-1))
                    .create();
        User user = gson.fromJson(userJson, User.class);
        Log.e(TAG, "转出的对象：" + user);
        Log.e(TAG, "==========testIntTypeAdapter End==========");
    }

    private void testRuntimeTypeAdapterFactory() {
        Log.e(TAG, "==========testRuntimeTypeAdapterFactory Start==========");
        String animalJson = "[" + "\n" + "{'type':'bird','name':'麻雀','fly':'fly in the sky'}," + "\n" + "{'type':'dog','name':'哈士奇','playsCatch':true}," + "\n" + "{'type':'cat','name':'波斯猫','chasesRedLaserDot':true}]";
        Log.e(TAG, "原始 JSON 串：" + animalJson);
        RuntimeTypeAdapterFactory<Animal> adapterFactory = RuntimeTypeAdapterFactory
                .of(Animal.class, "type")  // Here you specify which is the parent class and what field particularizes the child class.
                .registerSubtype(Bird.class, "bird") // if the flag equals the class name, you can skip the second parameter. This is only necessary, when the "type" field does not equal the class name.
                .registerSubtype(Cat.class, "cat")
                .registerSubtype(Dog.class, "dog");
        Type animalListType = new TypeToken<List<Animal>>(){}.getType();
        Gson gson = new GsonBuilder().registerTypeAdapterFactory(adapterFactory).create();
        List<Animal> animalList = gson.fromJson(animalJson, animalListType);
        Log.e(TAG, "转出的对象：" + animalList);
        Log.e(TAG, "==========testRuntimeTypeAdapterFactory End==========");
    }

}
