package info.baolong.blserver.controller;

import info.baolong.blserver.service.WeatherService;
import info.baolong.blserver.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bl_server/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

//    @GetMapping("weather-advise")
//    public R weatherAdvise(){
    // todo
//    }

    @GetMapping("weather_now")
    public String weatherNow(){
        return weatherService.weatherNowSimple();
    }

    @GetMapping("weather_minutely")
    public String weatherMinutely(){
        return weatherService.weatherNowSimple();
    }

    @GetMapping("weather_today")
    public String weatherToday(){
        return weatherService.weatherNowSimple();
    }

    @GetMapping("weather_tomorrow")
    public String weatherTomorrow(){
        return weatherService.weatherNowSimple();
    }

    @GetMapping("weather_changing")
    public String weatherChanging(){
        return weatherService.weatherNowSimple();
    }

}
