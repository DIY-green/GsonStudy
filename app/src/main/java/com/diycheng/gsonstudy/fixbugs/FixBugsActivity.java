package com.diycheng.gsonstudy.fixbugs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.diycheng.gsonstudy.R;
import com.google.gson.Gson;

public class FixBugsActivity extends AppCompatActivity {

    private static final String TAG = "FixBugs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_bugs);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_retain_cycle:
                testRetainCycle();
                break;
//            case R.id.btn_retain_cycle:
//
//                break;
        }
    }

    private void testRetainCycle() {
        Log.e(TAG, "==========testRetainCycle Start==========");
        A a = new A();
        B b = new B();
        a.name = "-A-";
        a.flag = false;
        a.num = 1;
        a.value = 11.1f;
        a.a = a;
        a.b = b;
        b.name = "-B-";
        b.flag = false;
        b.num = 2;
        b.value = 22.2f;
        b.a = a;
        b.b = b;
        Log.e(TAG, "目标转换对象：" + "\n" + a + "\n" + b);
        Gson gson = new Gson();
        String aStr = gson.toJson(a);
        String bStr = gson.toJson(b);
        Log.e(TAG, "得到的 JSON 串：" + "\n" + aStr + "\n" + bStr);
        A a1 = gson.fromJson(aStr, A.class);
        B b1 = gson.fromJson(bStr, B.class);
        Log.e(TAG, "==>转出的对象：" + "\n" + a1 + "\n" + b1);
        Log.e(TAG, "==========testRetainCycle End==========");
    }
}
