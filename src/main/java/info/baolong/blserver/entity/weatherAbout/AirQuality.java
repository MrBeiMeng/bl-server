/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;

import lombok.Data;

/**
 * Auto-generated: 2022-08-01 21:44:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class AirQuality {

    private double pm25;
    private double pm10;
    private double o3;
    private double so2;
    private double no2;
    private double co;
    private Aqi aqi;
    private Description description;

}