package com;

import com.core.Handler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Application.class, args);
        Handler handler = configurableApplicationContext.getBean(Handler.class);
        handler.run();
//        SpringApplication.run(Application.class, args);
    }
}
