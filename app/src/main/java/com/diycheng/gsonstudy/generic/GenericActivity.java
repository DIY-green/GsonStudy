package com.diycheng.gsonstudy.generic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.diycheng.gsonstudy.R;
import com.diycheng.gsonstudy.primer.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * 主要介绍泛型和Type
 */
public class GenericActivity extends AppCompatActivity {

    private static final String TAG = "GenericActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic);

        testType();
        testBaseMessage();
        testResult1();
        testResult2();
        testResultTypeUtil1();
        testResultTypeUtil2();
        testResultTypeUtil3();
        testResultTypeUtil4();
        testResultTypeUtil5();
    }

    private void testType() {
        TypeTest typeTest = new TypeTest();
        try {
            typeTest.testParameterizedType();
            typeTest.testTypeVariable();
            typeTest.testGenericArrayType();
            typeTest.testWildcardType();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void testBaseMessage() {
        String dataJson = "{'code':0,'msg':'success','data':{'name':'xiaoming'}}";
        JSONObject jsonObj = null;
        try {
            jsonObj = new JSONObject(dataJson);
            int code = jsonObj.getInt("code");
            String msg = jsonObj.getString("msg");
            String data = jsonObj.getString("data");
            BaseMessage baseMessage = new BaseMessage();
            baseMessage.code = code;
            baseMessage.msg = msg;
            baseMessage.data = data;
            Log.e(TAG, baseMessage.toString());

            Gson gson = new Gson();
            User user = gson.fromJson(baseMessage.data, User.class);
            Log.e(TAG, "最终解析出来的 User 对象：" + user);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void testResult1() {
        Log.e(TAG, "==========testResult1 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':{'name':'xiaoming'}}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Type resultType = new TypeToken<Result<User>>(){}.getType();
        Gson gson = new Gson();
        Result<User> userResult = gson.fromJson(jsonStr, resultType);
        Log.e(TAG, "转出的对象：" + userResult);
        Log.e(TAG, "==========testResult1 End==========");
    }

    private void testResult2() {
        Log.e(TAG, "==========testResult2 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':['Java','Android','C','PHP','JavaScript','OC','Swift','Python']}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Type resultType = new TypeToken<Result<List<String>>>(){}.getType();
        Gson gson = new Gson();
        Result<List<String>> paramsList = gson.fromJson(jsonStr, resultType);
        Log.e(TAG, "转出的对象：" + paramsList);
        Log.e(TAG, "==========testResult2 End==========");
    }

    private void testResultTypeUtil1() {
        Log.e(TAG, "==========testResultTypeUtil1 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':{'name':'xiaoming'}}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Result<User> userResult = ResultTypeUtil.fromJsonObject(jsonStr, User.class);
        Log.e(TAG, "转出的对象：" + userResult);
        Log.e(TAG, "==========testResultTypeUtil1 End==========");
    }

    private void testResultTypeUtil2() {
        Log.e(TAG, "==========testResultTypeUtil2 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':['Java','Android','C','PHP','JavaScript','OC','Swift','Python']}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Result<List<String>> paramsList = ResultTypeUtil.fromJsonList(jsonStr, String.class);
        Log.e(TAG, "转出的对象：" + paramsList);
        Log.e(TAG, "==========testResultTypeUtil2 End==========");
    }

    private void testResultTypeUtil3() {
        Log.e(TAG, "==========testResultTypeUtil3 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':[{'name':'Java'},{'name':'Android'},{'name':'C'},{'name':'PHP'},{'name':'JavaScript'},{'name':'OC'},{'name':'Swift'},{'name':'Python'}]}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Type resultType = new TypeToken<Result<List<User>>>(){}.getType();
        Result<List<User>> paramsList1 = new Gson().fromJson(jsonStr, resultType);
        Log.e(TAG, "转出的对象：" + paramsList1);
        Result<List<User>> paramsList2 = ResultTypeUtil.fromJsonList(jsonStr, User.class);
        Log.e(TAG, "转出的对象：" + paramsList2);
        Log.e(TAG, "==========testResultTypeUtil3 End==========");
    }

    private void testResultTypeUtil4() {
        Log.e(TAG, "==========testResultTypeUtil4 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':{'name':'xiaoming'}}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Result<User> userResult = ResultTypeUtil.fromJsonObject2(jsonStr, User.class);
        Log.e(TAG, "转出的对象：" + userResult);
        Log.e(TAG, "==========testResultTypeUtil4 End==========");
    }

    private void testResultTypeUtil5() {
        Log.e(TAG, "==========testResultTypeUtil5 Start==========");
        String jsonStr = "{'code':0,'msg':'success','data':[{'name':'Java'},{'name':'Android'},{'name':'C'},{'name':'PHP'},{'name':'JavaScript'},{'name':'OC'},{'name':'Swift'},{'name':'Python'}]}";
        Log.e(TAG, "原始 JSON 串：" + jsonStr);
        Type resultType = new TypeToken<Result<List<User>>>(){}.getType();
        Result<List<User>> paramsList1 = new Gson().fromJson(jsonStr, resultType);
        Log.e(TAG, "转出的对象：" + paramsList1);
        Result<List<User>> paramsList2 = ResultTypeUtil.fromJsonList2(jsonStr, User.class);
        Log.e(TAG, "转出的对象：" + paramsList2);
        Log.e(TAG, "==========testResultTypeUtil5 End==========");
    }

}
