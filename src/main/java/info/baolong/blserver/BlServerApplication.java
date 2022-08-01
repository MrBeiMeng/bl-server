package info.baolong.blserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("info.baolong.blserver.mapper")
public class BlServerApplication {

    private static final String swaggerUrl = "http://localhost:9527/swagger-ui/index.html";

    public static void main(String[] args) {
        SpringApplication.run(BlServerApplication.class, args);
        System.out.printf("服务成功启动！ 访问：[%s] ",swaggerUrl);
    }

}
