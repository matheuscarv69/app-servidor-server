package io.github.matheuscarv69;

import io.github.matheuscarv69.domain.entity.fields.*;
import io.github.matheuscarv69.domain.repository.fieldsRepositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
public class AppServidorApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppServidorApplication.class, args);
    }


}
