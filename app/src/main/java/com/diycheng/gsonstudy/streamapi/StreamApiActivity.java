package com.diycheng.gsonstudy.streamapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.text.DateFormat;

public class StreamApiActivity extends AppCompatActivity {

    private static final String TAG = "StreamApi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream_api);

        testJsonReader();
        testToJson();
        testOther();
    }

    private void testJsonReader() {
        Log.e(TAG, "==========testJsonReader Start==========");
        String userJson =  "{\"name\":\"XiaoMing\",\"age\":\"18\",\"profession\":\"Student\"}";
        Log.e(TAG, "原始 JSON 串：" + userJson);
        User user = new User();
        JsonReader reader = new JsonReader(new StringReader(userJson));
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String s = reader.nextName();
                switch (s) {
                    case "name":
                        user.name = reader.nextString();
                        break;
                    case "age":
                        user.age = reader.nextInt(); //自动转换
                        break;
                    case "profession":
                        user.profession = reader.nextString();
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.endObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Log.e(TAG, "转出的对象：" + user);
        Log.e(TAG, "==========testJsonReader End==========");
    }

    private void testToJson() {
        Log.e(TAG, "==========testToJson Start==========");
        Gson gson = new Gson();
        User user = new User("LiMing", 24, "Teacher");
        Log.e(TAG, "目标转换对象：" + user);
        gson.toJson(user, System.err); // 写到控制台
        System.err.println();
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
        try {
            writer.beginObject()
                .name("name").value("XiaoMing")
                .name("age").value(17)
                .name("profession").nullValue()
//                .name("profession").value("Student")
                .endObject();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Log.e(TAG, "得到的 JSON 串：" + userJson);
        Log.e(TAG, "==========testToJson End==========");
    }

    private void testOther() {
        User user = new User("LiMing", 24, "Teacher");
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .setDateFormat(DateFormat.LONG)
                .disableInnerClassSerialization()
                .generateNonExecutableJson()
                .disableHtmlEscaping()
                .setPrettyPrinting()
                .create();
        String userJson = gson.toJson(user);
        Log.e(TAG, userJson);
    }

}
