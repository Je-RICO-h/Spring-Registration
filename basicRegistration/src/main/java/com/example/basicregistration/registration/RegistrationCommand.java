package com.example.basicregistration.registration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;

@Configuration
public class RegistrationCommand {
    @Bean
    CommandLineRunner commandLineRunner(RegistrationRepository repository) {
        return args -> {
            RegistrationForm Gyurko = new RegistrationForm(
                    "Gyurko",
                    "gyurko@gmail.com",
                    "123456"
            );

            repository.saveAll(
                    List.of(Gyurko)
            );
        };
    }
}