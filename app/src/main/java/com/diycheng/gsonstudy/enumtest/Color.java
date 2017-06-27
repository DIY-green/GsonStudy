package com.diycheng.gsonstudy.enumtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liwangcheng on 2017/6/27 14:07.
 */

public enum Color {
    // 赤橙黄绿青蓝紫
    @SerializedName(value = "0", alternate = "RED")
    RED,
    @SerializedName(value = "1", alternate = "ORANGE")
    ORANGE,
    @SerializedName(value = "2", alternate = "YELLOW")
    YELLOW,
    @SerializedName(value = "3", alternate = "GREEN")
    GREEN,
    @SerializedName(value = "4", alternate = "CYAN")
    CYAN,
    @SerializedName(value = "5", alternate = "BLUE")
    BLUE,
    @SerializedName(value = "6", alternate = "PURPLE")
    PURPLE;

}
