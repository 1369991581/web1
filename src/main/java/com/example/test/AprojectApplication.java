package com.example.test;

import com.example.test.repository.impl.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class AprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AprojectApplication.class, args);
        }

    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
