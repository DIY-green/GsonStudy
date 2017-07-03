package com.diycheng.gsonstudy.serialize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SerializerActivity extends AppCompatActivity {

    private static final String TAG = "Serializer";

    private Gson mDefaultGson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serializer);

        testRegisterTypeAdapter1();
        testRegisterTypeAdapter2();
        testRegisterTypeAdapter3();
        testRegisterTypeAdapter4();
    }

    /**
     * 自定义序列化对象
     */
    private void testRegisterTypeAdapter1() {
        Log.e(TAG, "==========testRegisterTypeAdapter1 Start==========");
        UserSubscription subscription = new UserSubscription();
        subscription.age = 18;
        subscription.email = "xiaoming@gmail.com";
        subscription.isDeveloper = false;
        subscription.name = "xiaoming";
        List<Merchant> merchantList = new ArrayList<>();
        Merchant m1 = new Merchant();
        m1.Id = 11;
        m1.name = "KFC";
        merchantList.add(m1);
        Merchant m2 = new Merchant();
        m2.Id = 22;
        m2.name = "Coffee Shop";
        merchantList.add(m2);
        subscription.merchantList = merchantList;
        Log.e(TAG, "目标转换对象：" + subscription);
        String userSubJson = mDefaultGson.toJson(subscription);
        Log.e(TAG, "使用默认Gson得到的 JSON 串：" + "\n" + userSubJson);
        JsonSerializer<Merchant> serializer = new JsonSerializer<Merchant>() {
            @Override
            public JsonElement serialize(Merchant src, Type typeOfSrc, JsonSerializationContext context) {
                JsonObject jsonMerchant = new JsonObject();
                jsonMerchant.addProperty("Id", src.Id);
                return jsonMerchant;
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Merchant.class, serializer);
        Gson gson = gsonBuilder.create();
        String userSubJson2 = gson.toJson(subscription);
        Log.e(TAG, "使用registerTypeAdapter自定义序列化对象生成的Gson得到的 JSON 串：" + "\n" + userSubJson2);
        Log.e(TAG, "==========testRegisterTypeAdapter1 End==========");
    }

    /**
     * 简化自定义序列化 List 对象
     */
    private void testRegisterTypeAdapter2() {
        Log.e(TAG, "==========testRegisterTypeAdapter2 Start==========");
        UserSubscription subscription = new UserSubscription();
        subscription.age = 18;
        subscription.email = "xiaoming@gmail.com";
        subscription.isDeveloper = false;
        subscription.name = "xiaoming";
        List<Merchant> merchantList = new ArrayList<>();
        final Merchant m1 = new Merchant();
        m1.Id = 11;
        m1.name = "KFC";
        merchantList.add(m1);
        Merchant m2 = new Merchant();
        m2.Id = 22;
        m2.name = "Coffee Shop";
        merchantList.add(m2);
        subscription.merchantList = merchantList;
        Log.e(TAG, "目标转换对象：" + subscription);
        String userSubJson = mDefaultGson.toJson(subscription);
        Log.e(TAG, "使用默认Gson得到的 JSON 串：" + "\n" + userSubJson);
        Type merchantListType = new TypeToken<List<Merchant>>(){}.getType();
        JsonSerializer<List<Merchant>> serializer = new JsonSerializer<List<Merchant>>() {
            @Override
            public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
                JsonObject jsonMerchant = new JsonObject();
                List<String> merchantIds = new ArrayList<>(src.size());
                for (Merchant merchant : src) {
                    merchantIds.add("" + merchant.Id);
                }
                String merchantIdsAsString = TextUtils.join(",", merchantIds);
                jsonMerchant.addProperty("Ids", merchantIdsAsString);
                return jsonMerchant;
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(merchantListType, serializer);
        Gson gson = gsonBuilder.create();
        String userSubJson2 = gson.toJson(subscription);
        Log.e(TAG, "使用registerTypeAdapter自定义序列化List对象生成的Gson得到的 JSON 串：" + "\n" + userSubJson2);
        Log.e(TAG, "==========testRegisterTypeAdapter2 End==========");
    }

    /**
     * 简化自定义序列化 List 为数组
     */
    private void testRegisterTypeAdapter3() {
        Log.e(TAG, "==========testRegisterTypeAdapter3 Start==========");
        UserSubscription subscription = new UserSubscription();
        subscription.age = 18;
        subscription.email = "xiaoming@gmail.com";
        subscription.isDeveloper = false;
        subscription.name = "xiaoming";
        List<Merchant> merchantList = new ArrayList<>();
        final Merchant m1 = new Merchant();
        m1.Id = 11;
        m1.name = "KFC";
        merchantList.add(m1);
        Merchant m2 = new Merchant();
        m2.Id = 22;
        m2.name = "Coffee Shop";
        merchantList.add(m2);
        subscription.merchantList = merchantList;
        Log.e(TAG, "目标转换对象：" + subscription);
        String userSubJson = mDefaultGson.toJson(subscription);
        Log.e(TAG, "使用默认Gson得到的 JSON 串：" + "\n" + userSubJson);
        Type merchantListType = new TypeToken<List<Merchant>>(){}.getType();
        JsonSerializer<List<Merchant>> serializer = new JsonSerializer<List<Merchant>>() {
            @Override
            public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
                JsonArray jsonMerchant = new JsonArray();
                for (Merchant merchant : src) {
                    jsonMerchant.add("" + merchant.Id);
                }
                return jsonMerchant;
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(merchantListType, serializer);
        Gson gson = gsonBuilder.create();
        String userSubJson2 = gson.toJson(subscription);
        Log.e(TAG, "使用registerTypeAdapter自定义序列化List对象生成的Gson得到的 JSON 串：" + "\n" + userSubJson2);
        Log.e(TAG, "==========testRegisterTypeAdapter3 End==========");
    }

    /**
     * 多次注册序列化解析器测试
     */
    private void testRegisterTypeAdapter4() {
        Log.e(TAG, "==========testRegisterTypeAdapter4 Start==========");
        UserSubscription subscription = new UserSubscription();
        subscription.age = 18;
        subscription.email = "xiaoming@gmail.com";
        subscription.isDeveloper = false;
        subscription.name = "xiaoming";
        List<Merchant> merchantList = new ArrayList<>();
        final Merchant m1 = new Merchant();
        m1.Id = 11;
        m1.name = "KFC";
        merchantList.add(m1);
        Merchant m2 = new Merchant();
        m2.Id = 22;
        m2.name = "Coffee Shop";
        merchantList.add(m2);
        subscription.merchantList = merchantList;
        Log.e(TAG, "目标转换对象：" + subscription);
        String userSubJson = mDefaultGson.toJson(subscription);
        Log.e(TAG, "使用默认Gson得到的 JSON 串：" + "\n" + userSubJson);
        Type type1 = new TypeToken<List<Merchant>>(){}.getType();
        JsonSerializer<List<Merchant>> serializer1 = new JsonSerializer<List<Merchant>>() {
            @Override
            public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
                JsonArray jsonMerchant = new JsonArray();
                for (Merchant merchant : src) {
                    jsonMerchant.add("" + merchant.Id);
                }
                return jsonMerchant;
            }
        };
        Type type2 = new TypeToken<List<Merchant>>(){}.getType();
        JsonSerializer<List<Merchant>> serializer2 = new JsonSerializer<List<Merchant>>() {
            @Override
            public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
                JsonArray jsonMerchant = new JsonArray();
                for (Merchant merchant : src) {
                    jsonMerchant.add("" + merchant.Id);
                }
                return jsonMerchant;
            }
        };
        Type type3 = new TypeToken<List<Merchant>>(){}.getType();
        JsonSerializer<List<Merchant>> serializer3 = new JsonSerializer<List<Merchant>>() {
            @Override
            public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
                JsonObject jsonMerchant = new JsonObject();
                List<String> merchantIds = new ArrayList<>(src.size());
                for (Merchant merchant : src) {
                    merchantIds.add("" + merchant.Id);
                }
                String merchantIdsAsString = TextUtils.join(",", merchantIds);
                jsonMerchant.addProperty("Ids", merchantIdsAsString);
                return jsonMerchant;
            }
        };
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(type1, serializer1);
        gsonBuilder.registerTypeAdapter(type2, serializer2);
        gsonBuilder.registerTypeAdapter(type3, serializer3);
        Gson gson = gsonBuilder.create();
        String userSubJson2 = gson.toJson(subscription);
        Log.e(TAG, "多次注册序列化解析器生成的Gson得到的 JSON 串：" + "\n" + userSubJson2);
        Log.e(TAG, "==========testRegisterTypeAdapter4 End==========");
    }
}
