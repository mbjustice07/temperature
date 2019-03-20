package com.temperatures.temperatures.repo;

import com.temperatures.temperatures.entity.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepo extends JpaRepository<Temperature, Long> {

}
