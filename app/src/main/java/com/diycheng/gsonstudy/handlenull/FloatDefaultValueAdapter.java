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

public class FloatDefaultValueAdapter implements JsonSerializer<Float>,JsonDeserializer<Float> {

    private static final float FLOAT_DEFAULT_VALUE = 0.00f;
    private static final FloatDefaultValueAdapter sAdapter = new FloatDefaultValueAdapter();

    @Override
    public Float deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if ("".equals(json.getAsString()) || "null".equals(json.getAsString())) {
                // 定义为double类型,如果后台返回""或者null,则返回0
                return FLOAT_DEFAULT_VALUE;
            } else {
                return json.getAsFloat();
            }
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Float src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    public static FloatDefaultValueAdapter getInstance() {
        return sAdapter;
    }
}
