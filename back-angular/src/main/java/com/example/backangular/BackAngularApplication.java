package com.example.backangular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// Creer une classe de configuration dans les modules
@ComponentScan({"com.mproduits","com.*"})
@EnableFeignClients("com.mproduits")
//@EnableEurekaClient
public class BackAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackAngularApplication.class, args);
    }

}

