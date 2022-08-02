/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;
import java.util.Date;

/**
 * Auto-generated: 2022-08-02 10:18:55
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Wind_08h_20h {

    private Date date;
    private Max max;
    private Min min;
    private Avg avg;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setMax(Max max) {
         this.max = max;
     }
     public Max getMax() {
         return max;
     }

    public void setMin(Min min) {
         this.min = min;
     }
     public Min getMin() {
         return min;
     }

    public void setAvg(Avg avg) {
         this.avg = avg;
     }
     public Avg getAvg() {
         return avg;
     }

}