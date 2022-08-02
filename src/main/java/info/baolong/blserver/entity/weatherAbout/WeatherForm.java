/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * Auto-generated: 2022-08-01 21:44:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
@ToString
public class WeatherForm {

    private String status;
    private String api_version;
    private String api_status;
    private String lang;
    private String unit;
    private int tzshift;
    private String timezone;
    private long server_time;
    private List<Double> location;
    private Result result;

}