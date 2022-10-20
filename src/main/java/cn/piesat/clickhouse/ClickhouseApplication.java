package cn.piesat.clickhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description ClickhouseApplication <br>
 * @date 2022-10-19 17:36:16 <br>
 * @author hezhanfeng <br>
 * @version v1.0 <br>
 */
@SpringBootApplication(scanBasePackages = {"cn.piesat"})
public class ClickhouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClickhouseApplication.class, args);
    }

}
