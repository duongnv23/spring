package com.duongnv.spring.aop;

import com.duongnv.spring.aop.service.HelloService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
@Log4j2
public class AopApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AopApplication.class, args);


        HelloService helloService = context.getBean(HelloService.class);
        helloService.execute();

        try {
            log.info("hit enter to exit");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
