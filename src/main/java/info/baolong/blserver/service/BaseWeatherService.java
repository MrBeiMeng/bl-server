package info.baolong.blserver.service;

import com.google.gson.Gson;
import info.baolong.blserver.entity.weatherAbout.WeatherForm;
import info.baolong.blserver.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.Objects;

public class BaseWeatherService {

    // 天级别天气
    public WeatherForm getWeatherDaily(String token, float jd, float wd,int daySteps) {
        String url = String.format("https://api.caiyunapp.com/v2.6/%s/%f,%f/daily", token,jd,wd);
        HashMap<String, String> map = new HashMap<>();
        map.put("dailysteps",""+daySteps);
        map.put("alert","true");
        return toWeatherForm(HttpClientUtils.doGet(url, map));
    }

    // 小时级别天气
    public WeatherForm getWeatherHourly(String token, float jd, float wd,int hourSteps){
        String url = String.format("https://api.caiyunapp.com/v2.6/%s/%f,%f/hourly", token,jd,wd);
        HashMap<String, String> map = new HashMap<>();
        map.put("hourlysteps",""+hourSteps);
        map.put("alert","true");
        return toWeatherForm(HttpClientUtils.doGet(url, map));
    }

    // 分钟级别天气
    public WeatherForm getWeatherMinutely(String token, float jd, float wd){
        String url = String.format("https://api.caiyunapp.com/v2.6/%s/%f,%f/minutely?alert=true", token,jd,wd);
        return toWeatherForm(HttpClientUtils.doGet(url, null));
    }

    // 天气实况
    public WeatherForm getWeatherNow(String token, float jd, float wd){
        String url = String.format("https://api.caiyunapp.com/v2.6/%s/%f,%f/realtime?alert=true", token,jd,wd);
        return toWeatherForm(HttpClientUtils.doGet(url, null));
    }

    private WeatherForm toWeatherForm(String json){
        return complexJsonToObj(json, WeatherForm.class);
    }

    /**
     * 复杂Json转对象
     *
     * @param json
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T complexJsonToObj(String json, Class<T> cls) {
        Gson gson = new Gson();
        if (Objects.isNull(json)) return null;
        T obj = gson.fromJson(json, cls);
        if (Objects.isNull(obj)) {
            return null;
        } else {
            return obj;
        }
    }
}
