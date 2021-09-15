package org.perscholas.extrememotorsports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ExtremeMotorsportsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExtremeMotorsportsApplication.class, args);
    }

}
