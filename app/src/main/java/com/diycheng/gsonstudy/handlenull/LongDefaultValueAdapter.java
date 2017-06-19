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

public class LongDefaultValueAdapter implements JsonSerializer<Long>,JsonDeserializer<Long> {

    private static final long LONG_DEFAULT_VALUE = 0L;
    private static final LongDefaultValueAdapter sAdapter = new LongDefaultValueAdapter();

    @Override
    public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if ("".equals(json.getAsString()) || "null".equals(json.getAsString())) {
                // 定义为long类型,如果后台返回""或者null,则返回0
                return LONG_DEFAULT_VALUE;
            } else {
                return json.getAsLong();
            }
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    public static LongDefaultValueAdapter getInstance() {
        return sAdapter;
    }
}
