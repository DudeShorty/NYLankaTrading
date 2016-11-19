package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.*;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Entity
@Table(name = "MASTER_TANK")
public class Tank extends BaseModel {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(name = "ITEM_NAME")
    private String tankName;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }
}
