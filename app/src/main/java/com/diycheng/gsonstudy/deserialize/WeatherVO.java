package com.diycheng.gsonstudy.deserialize;

import android.text.Html;
import android.text.Spanned;

import com.diycheng.gsonstudy.R;

public class WeatherVO {

    private boolean isSuccess;
    private int weatherInfoIcon;
    private Spanned weatherInfoText;
    private String relativeHumidity; //  "hum": "20%", //相对湿度（%）
    private int temperatureIcon; // "tmp": "32", //温度 温度图标
    private String airPressure; // "pres": "1001", //气压
    private String precipitation; // 降水量
    private String visibility; // "vis": "10", //能见度（km）
    private String windDirectionAngle; // "deg": "10", //风向（360度）
    private String windDirection; // "dir": "北风", //风向
    private String windPower; // "sc": "3级", //风力
    private String windSpeed; // "spd": "15" //风速（kmph）

    public WeatherVO() {}

    public WeatherVO(WeatherTO weatherTO) {
        if (weatherTO == null) return;
        isSuccess = "ok".equals(weatherTO.getStatus());
        int condCode = Integer.parseInt(weatherTO.getNow().getCond().getCode());
        String condCodeColorStr = "";
        if (condCode < 0) {
            weatherInfoIcon = R.mipmap.ic_launcher;
            condCodeColorStr = "#000066";
        } else if (condCode < 60) {
            weatherInfoIcon = R.mipmap.ic_launcher;
            condCodeColorStr = "#009900";
        } else if (condCode < 90) {
            weatherInfoIcon = R.mipmap.ic_launcher;
            condCodeColorStr = "#993300";
        } else {
            weatherInfoIcon = R.mipmap.ic_launcher;
            condCodeColorStr = "#cccc00";
        }
        weatherInfoText = Html.fromHtml("<font color='"+condCodeColorStr+"'>"+weatherTO.getNow().getCond().getTxt()+"</font>");
        relativeHumidity = "相对湿度：" + weatherTO.getNow().getHum();
        int tmpInt = Integer.parseInt(weatherTO.getNow().getTmp());
        if (tmpInt < 15) {
            temperatureIcon = R.mipmap.ic_launcher;
        } else if (tmpInt < 33) {
            temperatureIcon = R.mipmap.ic_launcher;
        } else {
            temperatureIcon = R.mipmap.ic_launcher;
        }
        airPressure = "气压：" + weatherTO.getNow().getPres();
        precipitation = "降水量：" + weatherTO.getNow().getPcpn();
        visibility = "能见度：" + weatherTO.getNow().getVis() + " KM";
        windDirectionAngle = "风向角度：" + weatherTO.getNow().getWind().getDeg();
        windDirection = "风向：" + weatherTO.getNow().getWind().getDir();
        windPower = "风力：" + weatherTO.getNow().getWind().getSc();
        windSpeed = "风速" + weatherTO.getNow().getWind().getSpd();
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getWeatherInfoIcon() {
        return weatherInfoIcon;
    }

    public Spanned getWeatherInfoText() {
        return weatherInfoText;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public int getTemperatureIcon() {
        return temperatureIcon;
    }

    public String getAirPressure() {
        return airPressure;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWindDirectionAngle() {
        return windDirectionAngle;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public String getWindPower() {
        return windPower;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        return "WeatherVO{" +
                "airPressure='" + airPressure + '\n' +
                ", isSuccess=" + isSuccess + '\n' +
                ", weatherInfoIcon=" + weatherInfoIcon + '\n' +
                ", weatherInfoText=" + weatherInfoText + '\n' +
                ", relativeHumidity='" + relativeHumidity + '\n' +
                ", temperatureIcon=" + temperatureIcon + '\n' +
                ", precipitation='" + precipitation + '\n' +
                ", visibility='" + visibility + '\n' +
                ", windDirectionAngle='" + windDirectionAngle + '\n' +
                ", windDirection='" + windDirection + '\n' +
                ", windPower='" + windPower + '\n' +
                ", windSpeed='" + windSpeed + '\n' +
                '}';
    }
}