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
public class Result {

    private Realtime realtime;
    private Minutely minutely;
    private Hourly hourly;
    private Daily daily;
    private int primary;
}