package com.temperatures.temperatures.model;

import com.temperatures.temperatures.entity.Temperature;
import lombok.Data;

import java.util.Date;

@Data
public class Fahrenheit implements Degree {

    private final String temperatureUnit = "Fahrenheit";
    private Long id;
    private Double temp;
    private Date createDate;
    private Date updateDate;

    @Override
    public Degree addTemp(Temperature t) {
        this.id = t.getId();
        this.temp = (double) t.getTemperature() * 9 / 5 + 32;
        this.createDate = t.getCreateDate();
        this.updateDate = t.getUpdateDate();
        return this;
    }


}
