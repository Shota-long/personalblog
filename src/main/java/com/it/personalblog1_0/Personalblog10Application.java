package com.it.personalblog1_0;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @MapperScan 批量扫描Mapper类@MapperScan(value = "com.it.personalblog1_0.mappers")
 *
 *
 * */

@SpringBootApplication
public class Personalblog10Application {

    public static void main(String[] args) {
        SpringApplication.run(Personalblog10Application.class, args);
    }

}
