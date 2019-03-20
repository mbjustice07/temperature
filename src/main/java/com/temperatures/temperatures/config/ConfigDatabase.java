package com.temperatures.temperatures.config;

import com.temperatures.temperatures.entity.Temperature;
import com.temperatures.temperatures.repo.TemperatureRepo;
import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class ConfigDatabase {

    @Bean
    public CommandLineRunner makeDatabase(TemperatureRepo repo) {
        return (args) -> {
            repo.save(new Temperature(0));
            repo.save(new Temperature(-160));

            for (Temperature temp : repo.findAll()) {
                log.info(temp.toString());
            }
        };
    };
}
