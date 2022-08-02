/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Auto-generated: 2022-08-02 10:18:55
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Daily {

    private String status;
    private List<Astro> astro;
    private List<Precipitation_08h_20h> precipitation_08h_20h;
    private List<Precipitation_20h_32h> precipitation_20h_32h;
    private List<Precipitation> precipitation;
    private List<Temperature> temperature;
    private List<Temperature_08h_20h> temperature_08h_20h;
    private List<Temperature_20h_32h> temperature_20h_32h;
    private List<Wind> wind;
    private List<Wind_08h_20h> wind_08h_20h;
    private List<Wind_20h_32h> wind_20h_32h;
    private List<Humidity> humidity;
    private List<Cloudrate> cloudrate;
    private List<Pressure> pressure;
    private List<Visibility> visibility;
    private List<Dswrf> dswrf;
    private Map<String, Object> air_quality;
    private List<Skycon> skycon;
    private List<Skycon_08h_20h> skycon_08h_20h;
    private List<Skycon_20h_32h> skycon_20h_32h;
    private LifeIndexIn life_index;




    /**
     * Auto-generated: 2022-08-02 12:44:1
     *
     * @author json.cn (i@json.cn)
     * @website http://www.json.cn/java2pojo/
     */
}
