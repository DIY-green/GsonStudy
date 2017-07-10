package com.diycheng.gsonstudy.bestpractice;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by liwangcheng on 2017/7/10 09:46.
 */

public class GsonUtils {

    private static final String TAG = "GsonUtils";

    private static Gson sGson;

    private GsonUtils() {}

    /**
     * 自定义TypeAdapter ,null对象将被解析成空字符串
     */
    public static final TypeAdapter<String> STRING = new TypeAdapter<String>() {
        @Override
        public void write(JsonWriter out, String value) throws IOException {
            try {
                if (value == null) {
                    out.nullValue();
                    return;
                }
                out.value(value);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
        }

        @Override
        public String read(JsonReader in) throws IOException {
            try {
                if (in.peek() == JsonToken.NULL) {
                    in.nextNull();
                    return ""; // 原先是返回 null，这里改为返回空字符串，防止空指针
                }
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
            }
            return "";
        }
    };

    /**
     * 自定义adapter，解决由于数据类型为Int,实际传过来的值为Float，导致解析出错的问题
     * 目前的解决方案为将所有Int类型当成Double解析，再强制转换为Int
     */
    public static final TypeAdapter<Number> INTEGER = new TypeAdapter<Number>() {
        @Override
        public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return 0;
            }
            try {
                double i = in.nextDouble();
                return (int) i;
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }

        @Override
        public void write(JsonWriter out, Number value) throws IOException {
            out.value(value);
        }
    };

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(String.class, STRING); // 所有 String 类型 null 替换为字符串“”
        gsonBuilder.registerTypeAdapter(int.class, INTEGER); // int类型对 float 做兼容
        gsonBuilder.registerTypeAdapter(Integer.class, INTEGER); // int类型对 float 做兼容
        // 通过反射获取instanceCreators属性
        try {
            Class builder = gsonBuilder.getClass();
            Field f = builder.getDeclaredField("instanceCreators");
            f.setAccessible(true);
            // 得到此属性的值
            Map<Type, InstanceCreator<?>> instanceCreators = (Map<Type, InstanceCreator<?>>) f.get(builder);
            // 注册数组的处理器
            gsonBuilder.registerTypeAdapterFactory(new CollectionTypeAdapterFactory(new ConstructorConstructor(instanceCreators)));
        } catch (NoSuchFieldException e) {
            Log.e(TAG, e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, e.getMessage());
        }
        sGson = gsonBuilder.create();
    }

    @Nullable
    public static <T> T toObject(@NonNull String jsonStr, @NonNull Class<T> clazz) {
        T obj = null;
        try {
            obj = sGson.fromJson(jsonStr, clazz);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, e.getMessage());
        }
        return obj;
    }

    @Nullable
    public static <T> T toObject(@NonNull String jsonStr, @NonNull Type type) {
        T obj = null;
        try {
            obj = sGson.fromJson(jsonStr, type);
        } catch (JsonSyntaxException e) {
            Log.e(TAG, e.getMessage());
        }
        return obj;
    }

    public static <T> String toJson(@NonNull Class<T> clazz) {
        String jsonStr = "";
        try {
            jsonStr = sGson.toJson(clazz);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return jsonStr;
    }

    public static <T> String toJson(@NonNull Class<T> clazz, @NonNull Type type) {
        String jsonStr = "";
        try {
            jsonStr = sGson.toJson(clazz, type);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return jsonStr;
    }
}
