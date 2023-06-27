package es.jcyl.eclap.api.colapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
public class ColAppDeroApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ColAppDeroApiApplication.class, args);
    }

}


