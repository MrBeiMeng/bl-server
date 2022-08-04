package info.baolong.blserver;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class BlServerApplicationTests {

    @Test
    void contextLoads() {
        Logger test1 = LoggerFactory.getLogger("test");
        Logger test2 = LoggerFactory.getLogger("test");

        System.out.println("test1 == test2 " + (test2 == test1));
    }

}
