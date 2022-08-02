/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Auto-generated: 2022-08-02 10:12:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Hourly {

    private String status;
    private String description;
    private List<Precipitation> precipitation;
    private List<Temperature> temperature;
    private List<ApparentTemperature> apparent_temperature;
    private List<Wind> windList;
    private List<Humidity> humidity;
    private List<Cloudrate> cloudrate;

    private List<Skycon> skycon;
    private List<Pressure> pressure;
    private List<Visibility> visibility;
    private List<Dswrf> dswrf;
    private Map<String,Object> air_quality;

}