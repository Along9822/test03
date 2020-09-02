package com.along.jpa_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class JpaUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaUserApplication.class, args);
    }
    
}
