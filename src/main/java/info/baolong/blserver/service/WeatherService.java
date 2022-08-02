package info.baolong.blserver.service;

public interface WeatherService {

    /**
     * 修改经纬度
     * @param jd 经度
     * @param wd 纬度
     */
    void changeJWD(float jd,float wd);

    // 今天天气

    // 明天天气

    // --- base api
    // 天级别天气
    String weatherDaySimple(int day);

    // 小时级别天气
    String weatherHourlySimple(int hours);

    // 分钟级别天气
    String weatherMinutelySimple();

    // 天气实况
    String weatherNowSimple();

    // 天气预警 . 每个api带alert=true

}
