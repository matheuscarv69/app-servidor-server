package io.github.matheuscarv69;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppServidorApplication {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Rodou";
    }

    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }



}
