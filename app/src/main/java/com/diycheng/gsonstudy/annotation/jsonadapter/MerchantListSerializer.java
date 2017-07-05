package com.diycheng.gsonstudy.annotation.jsonadapter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by liwangcheng on 2017/7/3 09:57.
 */
public class MerchantListSerializer implements JsonSerializer<List<Merchant>> {

    @Override
    public JsonElement serialize(List<Merchant> src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray jsonMerchant = new JsonArray();

        for (Merchant merchant : src) {
            jsonMerchant.add("" + merchant.Id);
        }

        return jsonMerchant;
    }
}