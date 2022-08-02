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
public class Astro {

    private Date date;
    private Sunrise sunrise;
    private Sunset sunset;
    public void setDate(Date date) {
         this.date = date;
     }
     public Date getDate() {
         return date;
     }

    public void setSunrise(Sunrise sunrise) {
         this.sunrise = sunrise;
     }
     public Sunrise getSunrise() {
         return sunrise;
     }

    public void setSunset(Sunset sunset) {
         this.sunset = sunset;
     }
     public Sunset getSunset() {
         return sunset;
     }

}