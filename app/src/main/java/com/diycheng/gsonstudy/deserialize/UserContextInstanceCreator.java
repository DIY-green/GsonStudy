package com.diycheng.gsonstudy.deserialize;

import android.content.Context;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

/**
 * Created by liwangcheng on 2017/7/5 09:53.
 */

public class UserContextInstanceCreator implements InstanceCreator<UserContext> {

    private Context mContext;

    public UserContextInstanceCreator(Context context) {
        this.mContext = context;
    }

    @Override
    public UserContext createInstance(Type type) {
        return new UserContext(mContext);
    }

}
