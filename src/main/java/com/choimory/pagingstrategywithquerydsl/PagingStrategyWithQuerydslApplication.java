package com.choimory.pagingstrategywithquerydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PagingStrategyWithQuerydslApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagingStrategyWithQuerydslApplication.class, args);
    }

}
