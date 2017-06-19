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

public class CharDefaultValueAdapter implements JsonSerializer<Character>,JsonDeserializer<Character> {

    private static final char CHAR_DEFAULT_VALUE = 'A';
    private static final CharDefaultValueAdapter sAdapter = new CharDefaultValueAdapter();

    @Override
    public Character deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if ("".equals(json.getAsString()) || "null".equals(json.getAsString())) {
                // 定义为char类型,如果后台返回""或者null,则返回0
                return CHAR_DEFAULT_VALUE;
            } else {
                return json.getAsCharacter();
            }
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Character src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }

    public static CharDefaultValueAdapter getInstance() {
        return sAdapter;
    }
}
