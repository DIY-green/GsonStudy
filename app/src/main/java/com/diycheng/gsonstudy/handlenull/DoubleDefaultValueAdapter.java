package com.diycheng.gsonstudy.handlenull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by liwangcheng on 2017/6/19 15:24.
 */

public class DoubleDefaultValueAdapter implements JsonSerializer<Double>,JsonDeserializer<Double> {

    private static final double DOUBLE_DEFAULT_VALUE = 0.00;
    private static final DoubleDefaultValueAdapter sAdapter = new DoubleDefaultValueAdapter();

    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if ("".equals(json.getAsString()) || "null".equals(json.getAsString())) {
                // 定义为double类型,如果后台返回""或者null,则返回0
                return DOUBLE_DEFAULT_VALUE;
            } else {
                return json.getAsDouble();
            }
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    public static DoubleDefaultValueAdapter getInstance() {
        return sAdapter;
    }
}
