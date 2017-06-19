package com.diycheng.gsonstudy.fieldnamingpolicy;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * Created by liwangcheng on 2017/6/19 11:25.
 */

public class CustomFieldNamingStrategy implements FieldNamingStrategy {

    @Override
    public String translateName(Field f) {
        return f.getName().replaceAll("_", "");
    }
}
