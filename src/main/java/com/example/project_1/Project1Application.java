package com.example.project_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
@EnableConfigurationProperties
public class Project1Application {

    public static void main(String[] args) {
        SpringApplication.run(Project1Application.class, args);
        System.out.println("Welcome again to learn sprig boot");

    }


}
