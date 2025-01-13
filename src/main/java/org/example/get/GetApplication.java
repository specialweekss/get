package org.example.get;

import com.github.jeffreyning.mybatisplus.conf.EnableMPP;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@EnableMPP
@SpringBootApplication
public class GetApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetApplication.class, args);
    }

}
