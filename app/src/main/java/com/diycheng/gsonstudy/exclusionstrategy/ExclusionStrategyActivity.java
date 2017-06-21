package com.diycheng.gsonstudy.exclusionstrategy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.lang.reflect.Modifier;
import java.util.Date;

public class ExclusionStrategyActivity extends AppCompatActivity {

    private static final String TAG = "ExclusionStrategy";
    private User mUser;
    private User2 mUser2;
    private Gson mDefaultGson;
    private String mDefaultUserJson;
    private String mDefaultUser2Json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusion_strategy);

        initData();
        testExclusionChar();
        testExclusionInt();
        testExclusionBoolean();
        testExclusionFloat();
        testExclusionString();
        testExclusionDate();
        testExclusion_Field();
        testExclusionFieldWithExpose();
        testSerializationExclusionStrategy();
        testDeserializationExclusionStrategy();
        testModifierPublic();
        testModifierPrivate();
        testModifierProtected();
        testModifierFinal();
        testModifierVolatile();
        testModifierTransient();
        testModifierMixture();
    }

    private void initData() {
        mUser = new User();
        mUser._badge = 'A';
        mUser._qq = "151000000";
        mUser.phone_num = "151000000";
        mUser.age = 27;
        mUser.birthday = new Date();
        mUser.isNew = true;
        mUser.name = "xiaoming";
        mUser.weight = 120;
        mDefaultGson = new Gson();
        mDefaultUserJson = mDefaultGson.toJson(mUser);

        mUser2 = new User2();
        mUser2.volatileEmail = "xiaoming@gmail.com";
        mUser2.protectedLastName = "Ming";
        mUser2.setPrivateFirstName("Xiao");
        mUser2.publicName = "LeeMing";
        mUser2.transientPhoneNum = "110";
        mUser2.weight = 60.6f;
        mDefaultUser2Json = mDefaultGson.toJson(mUser2);
    }

    private void testExclusionChar() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == char.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionChar Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionChar End==========");
    }

    private void testExclusionInt() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == int.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionInt Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionInt End==========");
    }

    private void testExclusionBoolean() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == boolean.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionBoolean Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionBoolean End==========");
    }

    private void testExclusionFloat() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == float.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionFloat Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionFloat End==========");
    }

    private void testExclusionString() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == String.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionString Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionString End==========");
    }

    private void testExclusionDate() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == Date.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionDate Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionDate End==========");
    }

    private void testExclusion_Field() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().contains("_");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusion_Field Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusion_Field End==========");
    }

    private void testExclusionFieldWithExpose() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                Expose expose = f.getAnnotation(Expose.class);
                // 排除不包含下划线并且没有 @Expose 注解的字段
                return !f.getName().contains("_") && expose == null;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testExclusionFieldWithExpose Start==========");
        Log.e(TAG, "得到的 JSON 串：" + userJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>转出的对象：" + user);
        Log.e(TAG, "==========testExclusionFieldWithExpose End==========");
    }

    private void testSerializationExclusionStrategy() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().contains("_");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == int.class || clazz == char.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);

        Log.e(TAG, "==========testSerializationExclusionStrategy Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUserJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUserJson, User.class));
        Log.e(TAG, "==========testSerializationExclusionStrategy End==========");
    }

    private void testDeserializationExclusionStrategy() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.addDeserializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getName().contains("_");
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == int.class || clazz == char.class;
            }
        });
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser);
        Log.e(TAG, "==========testDeserializationExclusionStrategy Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUserJson);
        User user = gson.fromJson(mDefaultUserJson, User.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUserJson, User.class));
        Log.e(TAG, "==========testDeserializationExclusionStrategy End==========");
    }

    private void testModifierPublic() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PUBLIC);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierPublic Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierPublic End==========");
    }

    private void testModifierPrivate() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PRIVATE);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierPrivate Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierPrivate End==========");
    }

    private void testModifierProtected() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierProtected Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierProtected End==========");
    }

    private void testModifierFinal() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.FINAL);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierFinal Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierFinal End==========");
    }

    private void testModifierVolatile() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.VOLATILE);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierVolatile Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierVolatile End==========");
    }

    private void testModifierTransient() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierTransient Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierTransient End==========");
    }

    private void testModifierMixture() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithModifiers(
                Modifier.PUBLIC,
                Modifier.PRIVATE,
                Modifier.PROTECTED,
                Modifier.FINAL,
                Modifier.VOLATILE,
                Modifier.TRANSIENT
                );
        Gson gson = gsonBuilder.create();
        String userJson = gson.toJson(mUser2);
        Log.e(TAG, "==========testModifierMixture Start==========");
        Log.e(TAG, "使用策略得到的 JSON 串：" + userJson);
        Log.e(TAG, "不使用策略得到的 JSON 串：" + mDefaultUser2Json);
        User2 user = gson.fromJson(mDefaultUser2Json, User2.class);
        Log.e(TAG, "==>使用策略转出的对象：" + user);
        Log.e(TAG, "==>不使用策略转出的对象：" + mDefaultGson.fromJson(mDefaultUser2Json, User2.class));
        Log.e(TAG, "==========testModifierMixture End==========");
    }

}
