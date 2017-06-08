package com.diycheng.gsonstudy.handlenull;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by liwangcheng on 2017/6/7 11:36.
 * 处理流中的 null
 */

public class StringNullAdapter extends TypeAdapter<String> {

    private static final StringNullAdapter sInstance = new StringNullAdapter();

    @Override
    public void write(JsonWriter out, String value) throws IOException {
        if (value == null) {
            out.nullValue();
            return;
        }
        out.value(value);
    }

    @Override
    public String read(JsonReader in) throws IOException {
        if (in.peek() == JsonToken.NULL) {
            in.nextNull();
            return "";
        }
        return in.nextString();
    }

    public static StringNullAdapter getInstance() {
        return sInstance;
    }
}
