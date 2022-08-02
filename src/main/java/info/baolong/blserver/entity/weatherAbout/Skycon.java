/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;

/**
 * Auto-generated: 2022-08-02 10:12:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Skycon {

    private Date datetime;
    private String value;

    public String toChinese(){
        return getString(value);
    }

    static String getString(String value) {
        HashMap<String, String> map = new HashMap<>();
        map.put("CLEAR_DAY","晴");
        map.put("CLEAR_NIGHT","晴");
        map.put("PARTLY_CLOUDY_DAY","多云");
        map.put("PARTLY_CLOUDY_NIGHT","多云");
        map.put("CLOUDY","阴");
        map.put("LIGHT_HAZE","轻度雾霾");
        map.put("MODERATE_HAZE","中度雾霾");
        map.put("HEAVY_HAZE","重度雾霾");
        map.put("LIGHT_RAIN","小雨");
        map.put("MODERATE_RAIN","中雨");
        map.put("HEAVY_RAIN","大雨");
        map.put("STORM_RAIN","暴雨");
        map.put("FOG","雾");
        map.put("LIGHT_SNOW","小雪");
        map.put("MODERATE_SNOW","中雪");
        map.put("HEAVY_SNOW","大雪");
        map.put("STORM_SNOW","暴雪");
        map.put("DUST","浮尘");
        map.put("SAND","沙尘");
        map.put("WIND","大风");

        return map.get(value);
    }
}