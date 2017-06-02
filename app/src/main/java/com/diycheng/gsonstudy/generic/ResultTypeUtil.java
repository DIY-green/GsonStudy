package com.diycheng.gsonstudy.generic;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liwangcheng on 2017/6/2 11:20.
 */

public class ResultTypeUtil {

    // data 为 Object 的情况

    /**
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     * @see #fromJsonObject2(String , Class<T> )
     */
    @Deprecated
    public static <T> Result<T> fromJsonObject(String jsonStr, Class<T> clazz) {
        Type type = new TypeToken<Result<T>>(){}.getType();
        return new Gson().fromJson(jsonStr, type);
    }

    // data 为 List 的情况

    /**
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     * @see #fromJsonList2(String , Class<T> )
     */
    @Deprecated
    public static <T> Result<List<T>> fromJsonList(String jsonStr, Class<T> clazz){
        Type type = new TypeToken<Result<List<T>>>(){}.getType();
        return new Gson().fromJson(jsonStr, type);
    }

    // data 为 Object 的情况
    public static <T> Result<T> fromJsonObject2(String jsonStr, Class<T> clazz) {
        Type type = new ParameterizedTypeImpl(Result.class, new Class[]{clazz});
        return new Gson().fromJson(jsonStr, type);
    }

    // data 为 List 的情况
    public static <T> Result<List<T>> fromJsonList2(String jsonStr, Class<T> clazz) {
        // 生成 List<T> 中的 List<T>
        Type listType = new ParameterizedTypeImpl(List.class, new Class[]{clazz});
        // 根据 List<T> 生成完整的 Result<List<T>>
        Type type = new ParameterizedTypeImpl(Result.class, new Type[]{listType});
        return new Gson().fromJson(jsonStr, type);
    }
}
