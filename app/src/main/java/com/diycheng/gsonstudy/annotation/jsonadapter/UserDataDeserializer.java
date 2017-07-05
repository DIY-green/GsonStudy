package com.diycheng.gsonstudy.annotation.jsonadapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by liwangcheng on 2017/7/3 09:57.
 */
public class UserDataDeserializer implements JsonDeserializer<UserData> {

    @Override
    public UserData deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        Date date = new Date(
                jsonObject.get("year").getAsInt(),
                jsonObject.get("month").getAsInt(),
                jsonObject.get("day").getAsInt()
        );
        UserData userData = new UserData();
        userData.registerDate = date;
        userData.age = jsonObject.get("age").getAsInt();
        userData.email = jsonObject.get("email").getAsString();
        userData.isDeveloper = jsonObject.get("isDeveloper").getAsBoolean();
        userData.name = jsonObject.get("name").getAsString();
        return userData;
    }
}