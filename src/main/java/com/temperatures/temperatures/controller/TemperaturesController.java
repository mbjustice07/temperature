package com.temperatures.temperatures.controller;

import com.temperatures.temperatures.entity.Temperature;
import com.temperatures.temperatures.exceptions.TemperatureException;
import com.temperatures.temperatures.model.Degree;
import com.temperatures.temperatures.service.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TemperaturesController {

    private TemperatureService temperatureService;

    public TemperaturesController(@Autowired TemperatureService ts){
        this.temperatureService = ts;
    }

    @GetMapping("/list")
    public List<Degree> getTempCelciusList(){
        return temperatureService.getTemps();
    }

    @PostMapping("/addTemp/{temp}")
    public HttpStatus addTempCelcius(@PathVariable Integer temp){

        try {
            temperatureService.addTemp(temp);
        }catch (TemperatureException e){
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.CREATED;
    }

    @PutMapping("/updateTemp/{id}/{temperature}")
    public Temperature updateTempCelcius(@PathVariable Long id, @PathVariable Integer temperature){

        Temperature t;
        try{
            t = temperatureService.updateTemperature(id, temperature);
        }catch (TemperatureException e){
            t = new Temperature();
        }

        return t;
    }

    @DeleteMapping(value = "/removeTemp/{id}")
    public HttpStatus deleteTempCelcius(@PathVariable Long id){
         temperatureService.deleteTemperatureRecord(id);
         return HttpStatus.ACCEPTED;
    }

}
