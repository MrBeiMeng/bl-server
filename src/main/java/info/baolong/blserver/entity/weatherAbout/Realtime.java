/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;

import lombok.Data;

import java.util.HashMap;

import static info.baolong.blserver.entity.weatherAbout.Skycon.getString;

/**
 * Auto-generated: 2022-08-01 21:44:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Realtime {

    private String status;
    private double temperature;
    private double humidity;
    private double cloudrate;
    private String skycon;
    private double visibility;
    private double dswrf;
    private Wind wind;
    private double pressure;
    private double apparent_temperature;
    private Precipitation precipitation;
    private AirQuality air_quality;
    private LifeIndex life_index;

    public String feelOfApparentTemperature(){
        if (apparent_temperature >= 39)
            return "❗❗❗❗❗极热";
        else if (apparent_temperature >= 35) {
            return "🥵太热";
        } else if (apparent_temperature >= 33) {
            return "😵过热";
        } else if (apparent_temperature >= 27) {
            return "😵‍💫热";
        } else if (apparent_temperature >= 25) {
            return "🥰淑服";
        }else if (apparent_temperature >= 20){
            return "😬微冷";
        } else {
            return "🥶非常冷";
        }
    }

    public String now(){
        return getString(skycon);
    }
}