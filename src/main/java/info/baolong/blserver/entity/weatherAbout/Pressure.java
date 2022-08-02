/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import java.util.Date;

/**
 * Auto-generated: 2022-08-02 10:12:47
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Pressure {

    private Date datetime;
    private double value;
    public void setDatetime(Date datetime) {
         this.datetime = datetime;
     }
     public Date getDatetime() {
         return datetime;
     }

    public void setValue(double value) {
         this.value = value;
     }
     public double getValue() {
         return value;
     }

}