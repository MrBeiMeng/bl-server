package info.baolong.blserver.utils;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data /*生成get set*/
@ApiModel("标准结果返回类")
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "操作结果代码 : 成功： 2000, 失败 2001")
    private Integer code;

    @ApiModelProperty(value = "返回的message")
    private String message;

    @ApiModelProperty(value = "返回的数据")
    private Map<String,Object> data = new HashMap<>();

    /*把构造方法私有*/
    private R(){}

    /*成功静态方法*/
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(2000);
        r.setMessage("成功");
        return r;
    }
    /*失败静态方法*/
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(2001);
        r.setMessage("失败");
        return r;
    }

    /*返回自身可以做到链式编程*/
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
/*
 *
 * @author Mr.Bao
 * @date 2021/7/20 14:41
 */