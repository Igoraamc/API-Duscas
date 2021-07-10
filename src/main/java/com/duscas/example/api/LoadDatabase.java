package com.duscas.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Person("333.444", "Igor", 20, 1, "Aluno")));
            log.info("Preloading " + repository.save(new Person("111.222", "Igor", 20, 1500.00, "Professor")));
        };
    }
}
