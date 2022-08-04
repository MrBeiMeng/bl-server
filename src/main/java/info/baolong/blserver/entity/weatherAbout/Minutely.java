/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import lombok.Data;

import java.util.List;

/**
 * Auto-generated: 2022-08-02 10:2:38
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Minutely {
    private String status;
    private String datasource;
    private List<Double> precipitation_2h;
    private List<Double> precipitation;
    private List<Double> probability;
    private String description;
}