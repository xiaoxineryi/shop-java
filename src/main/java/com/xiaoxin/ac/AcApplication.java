package com.xiaoxin.ac;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.xiaoxin.ac.Mapper")
public class AcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcApplication.class, args);
    }

}
