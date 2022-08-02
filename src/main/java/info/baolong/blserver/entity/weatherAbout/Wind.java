/**
  * Copyright 2022 json.cn 
  */
package info.baolong.blserver.entity.weatherAbout;

import lombok.Data;
import org.apache.shiro.crypto.hash.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Auto-generated: 2022-08-01 21:44:2
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
@Data
public class Wind {

    private double speed;
    private double direction;
    public String getSpeedStr() {
        Map<Double, String> windSpeedMap = new HashMap<>();
        windSpeedMap.put(1d,"0级[无风]");
        windSpeedMap.put(5d,"1级[微风徐徐]");
        windSpeedMap.put(11d,"2级[清风]");
        windSpeedMap.put(19d,"3级[树叶摇摆]");
        windSpeedMap.put(28d,"4级[树枝摇动]");
        windSpeedMap.put(38d,"5级[风力强劲]");
        windSpeedMap.put(49d,"6级[风力强劲]");
        windSpeedMap.put(61d,"7级[风力超强]");
        windSpeedMap.put(74d,"8级[狂风大作]");
        windSpeedMap.put(88d,"9级[狂风呼啸]");
        windSpeedMap.put(102d,"10级[暴风毁树]");
        windSpeedMap.put(117d,"11级[暴风毁树]");
        windSpeedMap.put(133d,"12级[飓风]");
        windSpeedMap.put(149d,"13级[台风]");
        windSpeedMap.put(166d,"14级[强台风]");
        windSpeedMap.put(183d,"15级[强台风]");
        windSpeedMap.put(201d,"16级[超强台风]");
        windSpeedMap.put(220d,"17级[超强台风]");

        for (Double douKey : windSpeedMap.keySet()) {
            if (speed <= douKey)
                return windSpeedMap.get(douKey);
        }
        return "";
    }


    public String getDirectionStr(){
        String[] directionArr = {"北","东北","东","东南","南","西南","西","西北"};

        int a = (int) ((direction+22.5)/45);
        return directionArr[a];
    }

}