package com.temperatures.temperatures.model;

import com.temperatures.temperatures.entity.Temperature;
import lombok.Data;

import java.util.Date;

@Data
public class Celsius implements  Degree {

    private final String temperatureUnit = "Celsius";
    private Long id;
    private Integer temp;
    private Date createDate;
    private Date updateDate;

    @Override
    public Degree addTemp(Temperature t) {
        this.id = t.getId();
        this.temp = t.getTemperature();
        this.createDate = t.getCreateDate();
        this.updateDate = t.getUpdateDate();
        return this;
    }
}
