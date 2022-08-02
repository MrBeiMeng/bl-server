package info.baolong.blserver.service.impl;

import info.baolong.blserver.entity.weatherAbout.WeatherForm;
import info.baolong.blserver.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherServiceImplTest {

    @Autowired
    private WeatherServiceImpl weatherService;

    @Test
    public void test(){
        System.out.println(weatherService.weatherNowSimple());
        System.out.println("----------------");
        System.out.println(weatherService.weatherHourlySimple(10));
        System.out.println("----------------");
        System.out.println(weatherService.weatherMinutelySimple());
        System.out.println("----------------");
        System.out.println(weatherService.weatherDaySimple(0));
        System.out.println("----------------");
        System.out.println(weatherService.weatherDaySimple(1));
//        WeatherForm weatherForm = weatherService.getWeatherNow("KMBovk91k4lNkZZg", 113.883f, 22.5537f);
//        System.out.println("weatherForm = " + weatherForm);

    }
}