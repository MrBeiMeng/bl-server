package info.baolong.blserver.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.baolong.blserver.entity.weatherAbout.*;
import info.baolong.blserver.service.BaseWeatherService;
import info.baolong.blserver.service.WeatherService;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class WeatherServiceImpl extends BaseWeatherService implements WeatherService{

    private float jd = 113.883f;

    private float wd = 22.5537f;

    private final String weatherToken = "KMBovk91k4lNkZZg";

    NumberFormat ddf1= NumberFormat.getNumberInstance() ;

    private String weatherWarning(){
        // todo 切面编程
        return "";
    }


    @Override
    public void changeJWD(float jd, float wd) {
        this.jd = jd;
        this.wd = wd;
    }

    @Override
    public String weatherDaySimple(int day) {
        if (day >= 7){
            return "day最大为6";
        }
        ddf1.setMaximumFractionDigits(2);
        WeatherForm weatherForm = getWeatherDaily(weatherToken, jd, wd, 7);
        Daily daily = weatherForm.getResult().getDaily();
        List<Skycon_08h_20h> skycon_08h_20h = daily.getSkycon_08h_20h();
        List<Skycon_20h_32h> skycon_20h_32h = daily.getSkycon_20h_32h();
        Temperature_08h_20h temperature_08h_20h = daily.getTemperature_08h_20h().get(day);
        Temperature_20h_32h temperature_20h_32h = daily.getTemperature_20h_32h().get(day);


        String date = new SimpleDateFormat("MM月dd日").format(skycon_08h_20h.get(day).getDate());
        String day_skycon = skycon_08h_20h.get(day).toChinese();
        String night_skycon = skycon_20h_32h.get(day).toChinese();
        double dayMax = temperature_08h_20h.getMax();
        double dayMin = temperature_08h_20h.getMin();
        double nightMax = temperature_20h_32h.getMax();
        double ninghtMin = temperature_20h_32h.getMin();

        LifeIndexIn life_index = daily.getLife_index();
        String zwxDesc = life_index.getUltraviolet().get(day).getDesc(); // 紫外线描述
        String cyDesc = life_index.getDressing().get(day).getDesc(); // 穿衣指数

        // 哪天，日间/夜间天气现象[最高气温，最低气温]，紫外线指数，穿衣指数

        return String.format("%s 日间%s[%s℃-%s℃] 夜间%s[%s℃-%s℃] 紫外线%s |体感%s", date,day_skycon,ddf1.format(dayMax),ddf1.format(dayMin),night_skycon,ddf1.format(nightMax),ddf1.format(ninghtMin),zwxDesc,cyDesc);
    }

    /**
     * 只打印天气变化
     * @param hours 未来几小时天气变化预报
     * @return
     */
    @Override
    public String weatherHourlySimple(int hours) {
        WeatherForm weatherForm = getWeatherHourly(weatherToken, jd, wd,hours);
        Hourly hourly = weatherForm.getResult().getHourly();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("未来%s小时天气变化", hours));
        String lastValue = "";
        for (Skycon skycon : hourly.getSkycon()) {
            if (!Objects.equals(lastValue, skycon.getValue())){
                String strDateFormat = "HH:mm";
                SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                if (lastValue.length() != 0){
                    stringBuilder.append(String.format("%s转%s |", sdf.format(new Date()),skycon.toChinese()));
                }else {
                    stringBuilder.append(String.format("%s%s|", sdf.format(new Date()),skycon.toChinese()));
                }
                lastValue = skycon.getValue();
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 分钟级别预警，只打印预警信息。
     * @return 预警信息
     */
    @Override
    public String weatherMinutelySimple() {
        WeatherForm weatherForm = getWeatherMinutely(weatherToken,jd,wd);
        Minutely minutely = weatherForm.getResult().getMinutely();

        return minutely.getDescription();
    }

    /**
     * 实时天气，返回字符串
     * @return 字符串
     */
    @Override
    public String weatherNowSimple() {
        WeatherForm weatherForm = getWeatherNow(weatherToken, jd, wd);
        Realtime realtime = weatherForm.getResult().getRealtime();

        ddf1.setMaximumFractionDigits(2);
        String temperature = ddf1.format(realtime.getTemperature());
        String apparent_temperature = ddf1.format(realtime.getApparent_temperature());
        String feel = realtime.feelOfApparentTemperature();

        Wind wind = realtime.getWind();
        String direction = wind.getDirectionStr() + "风";
        String speedStr = wind.getSpeedStr();

        String now = realtime.now();
        AirQuality air_quality = realtime.getAir_quality();
        String chn = air_quality.getDescription().getChn();

        String visibility = realtime.getVisibility() + "公里";

        String pressure = realtime.getPressure() + "帕";

        String answer = String.format("%s℃|体感%s℃[%s]|%s %s|%s\n" +
                "空气质量:%s|能见度:%s|地面气压:%s", temperature,apparent_temperature,feel,direction,speedStr,now,chn,visibility,pressure);

        return answer;
    }
}
