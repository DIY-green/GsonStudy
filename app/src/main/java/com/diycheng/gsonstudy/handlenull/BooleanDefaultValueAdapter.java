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

public class BooleanDefaultValueAdapter implements JsonSerializer<Boolean>,JsonDeserializer<Boolean> {

    private static final boolean BOOLEAN_DEFAULT_VALUE = false;
    private static final BooleanDefaultValueAdapter sAdapter = new BooleanDefaultValueAdapter();

    @Override
    public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if ("".equals(json.getAsString()) || "null".equals(json.getAsString())) {
                // 定义为boolean类型,如果后台返回""或者null,则返回false
                return BOOLEAN_DEFAULT_VALUE;
            } else {
                return json.getAsBoolean();
            }
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    public static BooleanDefaultValueAdapter getInstance() {
        return sAdapter;
    }
}
