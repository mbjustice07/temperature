package com.temperatures.temperatures.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="temperature")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer temperature;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    public Temperature(Integer temperature){
        this.temperature = temperature;
        this.createDate = new Date();
        this.updateDate = new Date();
    }

    public Temperature(){}
}
