package com.diycheng.gsonstudy.typeadapter;

import android.util.Log;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by liwangcheng on 2017/7/6 15:52.
 */

public class IntTypeAdapter extends TypeAdapter<Integer> {

    private static final String TAG = "IntTypeAdapter";

    private int mDefaultValue = -1;

    public IntTypeAdapter(int defaultValue) {
        this.mDefaultValue = defaultValue;
    }

    @Override
    public void write(JsonWriter out, Integer value) throws IOException {
        out.value(String.valueOf(value));
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        String nextStr = in.nextString();
        Log.e(TAG, nextStr);
        try {
            return Integer.parseInt(nextStr);
        } catch (NumberFormatException e) {
            return mDefaultValue;
        }
    }
}
