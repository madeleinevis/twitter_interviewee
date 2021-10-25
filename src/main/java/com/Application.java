package com;

import com.fourjcore.THandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        THandler tHandler = configurableApplicationContext.getBean(THandler.class);
        tHandler.run();
//        SpringApplication.run(Application.class, args);
    }
}
