package com.temperatures.temperatures.service;

import com.temperatures.temperatures.entity.Temperature;
import com.temperatures.temperatures.exceptions.TemperatureException;
import com.temperatures.temperatures.model.Celsius;
import com.temperatures.temperatures.model.Degree;
import com.temperatures.temperatures.model.Fahrenheit;
import com.temperatures.temperatures.repo.TemperatureRepo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Log
@Service
public class TemperatureService {

    @Value("${absolute.zero}")
    private Integer absoluteZero;

    @Value("$temperature.exception")
    private String message;

    private TemperatureRepo temperatureRepo;

    public TemperatureService (@Autowired TemperatureRepo tr){
        this.temperatureRepo = tr;
    }

    public List<Degree> getTemps(){

        List<Degree> degreeList = new ArrayList<>();

        List<Temperature> tempList = temperatureRepo.findAll();

        for(Temperature t : tempList){
            Fahrenheit f = new Fahrenheit();
            Celsius c = new Celsius();
            degreeList.add(f.addTemp(t));
            degreeList.add(c.addTemp(t));
        }

        return degreeList;
    }

    public void addTemp(Integer temp) throws TemperatureException {

        if (temp < absoluteZero ) {
            log.info("Temp is below absolute zero");
            throw new TemperatureException(message);
        }

        temperatureRepo.save(new Temperature(temp));
    }

    public Temperature updateTemperature(Long id, Integer temperature) throws TemperatureException{

        if ( temperature < absoluteZero )
            throw new TemperatureException(message);

        Temperature t = new Temperature(temperature);

        return temperatureRepo.findById(id).map(temp -> {
            temp.setTemperature(temperature);
            temp.setUpdateDate(new Date());
            log.info("Updated Temperature id: "+ id.toString());
            return temperatureRepo.save(temp);
        }).orElseGet(() -> {
            log.info("Id already exisited " + id.toString());
            t.setId(id);
            return temperatureRepo.save(t);
        });
    }

    public void deleteTemperatureRecord(Long id){
        temperatureRepo.deleteById(id);
        log.info("Deleted record with id " + id.toString());
    }

}
