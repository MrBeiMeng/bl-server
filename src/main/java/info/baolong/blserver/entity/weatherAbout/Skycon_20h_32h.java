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
public class Skycon_20h_32h {

    private Date date;
    private String value;

    public String toChinese(){
       return Skycon.getString(value);
    }
}