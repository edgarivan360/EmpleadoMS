package com.wombats.empleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.wombats.empleado")
@EnableJpaRepositories({"com.wombats.empleado.persistence.repository"})
@EntityScan({"com.wombats.empleado.model"})
public class EmpleadoMs extends SpringBootServletInitializer {

    public static void main( String[] args ) {
        SpringApplication.run(EmpleadoMs.class, args);
    }
}
