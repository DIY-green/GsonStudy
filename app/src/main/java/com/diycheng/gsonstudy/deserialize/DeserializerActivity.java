package com.diycheng.gsonstudy.deserialize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

public class DeserializerActivity extends AppCompatActivity {

    private static final String TAG = "Deserializer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deserializer);

        testTO2VO();
        testRegisterTypeAdapter1();
        testRegisterTypeAdapter2();
    }

    private void testTO2VO() {
        Log.e(TAG, "==========testTO2VO Start==========");
        String weatherJson = "{'status': 'ok','now': \n {'cond':  \n {'code': '100','txt': '晴'}, \n 'fl': '30','hum': '20%','pcpn': '0.0','pres': '1001','tmp': '32','vis': '10','wind':  \n {'deg': '10','dir': '北风','sc': '3级','spd': '15'}}}";
        Log.e(TAG, "原始 JSON 串：\n" + weatherJson);
        Gson gson = new Gson();
        WeatherTO weatherTO = gson.fromJson(weatherJson, WeatherTO.class);
        WeatherVO weatherVO = new WeatherVO(weatherTO);
        Log.e(TAG, "转出的TO对象：\n" + weatherTO);
        Log.e(TAG, "转出的VO对象：\n" + weatherVO);
        Log.e(TAG, "==========testTO2VO End==========");
    }

    private void testRegisterTypeAdapter1() {
        Log.e(TAG, "==========testRegisterTypeAdapter1 Start==========");
        String userDataJson = "{'year': 117,'month': 6,'day': 2,'age': 18,'email': 'xiaoming@gmail.com','isDeveloper': true,'name': 'XiaoMing'}";
        Log.e(TAG, "原始 JSON 串：" + userDataJson);
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonDeserializer<UserData> deserializer = new JsonDeserializer<UserData>() {
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
        };
        gsonBuilder.registerTypeAdapter(UserData.class, deserializer);
        Gson gson = gsonBuilder.create();
        UserData userData = gson.fromJson(userDataJson, UserData.class);
        Log.e(TAG, "转出的对象：" + userData);
        Log.e(TAG, "==========testRegisterTypeAdapter1 End==========");
    }

    private void testRegisterTypeAdapter2() {
        Log.e(TAG, "==========testRegisterTypeAdapter2 Start==========");
        UserContext userContext = new UserContext(getApplicationContext());
        userContext.age = 18;
        userContext.email = "XiaoMing@gmail.com";
        userContext.isDeveloper = false;
        userContext.name = "XiaoMing";
        Gson gson = new Gson();
        String userContextJson = gson.toJson(userContext);
        Log.e(TAG, "原始 JSON 串：\n" + userContextJson);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(UserContext.class, new UserContextInstanceCreator(getApplicationContext()));
        Gson customGson = gsonBuilder.create();
        UserContext customUserContext = customGson.fromJson(userContextJson, UserContext.class);
        Log.e(TAG, "转出的对象：\n" + customUserContext);
        Log.e(TAG, "==========testRegisterTypeAdapter2 End==========");
    }
}
