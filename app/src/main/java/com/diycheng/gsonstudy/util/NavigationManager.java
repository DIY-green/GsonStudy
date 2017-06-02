package com.diycheng.gsonstudy.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;

/**
 * Created by liwangcheng on 2017/5/26 06:26.
 */

public class NavigationManager {

    public static final void overlay(Context context, Class<? extends Activity> clazz) {
        if (context instanceof Application) return;
        Intent intent = new Intent(context, clazz);
        context.startActivity(intent);
    }

}
