/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;

import java.util.Date;

/**
 * Auto-generated: 2022-08-02 10:18:55
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Precipitation_08h_20h {

    private Date date;
    private double max;
    private double min;
    private double avg;
    private double probability;

}