package com.wj5633.pms;

import com.wj5633.pms.event.MyApplicationEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@ServletComponentScan
@SpringBootApplication
public class PmsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PmsApplication.class);

//        app.addInitializers(new MyApplicationContextInitializer());
//        app.addListeners(new MyApplicationListener());
        ConfigurableApplicationContext context = app.run(args);


        context.publishEvent(new MyApplicationEvent(new Object()));

        context.stop();
    }
}
