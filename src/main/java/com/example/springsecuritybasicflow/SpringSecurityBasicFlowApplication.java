package com.example.springsecuritybasicflow;

import com.example.springsecuritybasicflow.model.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringSecurityBasicFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBasicFlowApplication.class, args);
    }

}
