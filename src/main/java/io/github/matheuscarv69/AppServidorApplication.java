package io.github.matheuscarv69;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppServidorApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }


}
