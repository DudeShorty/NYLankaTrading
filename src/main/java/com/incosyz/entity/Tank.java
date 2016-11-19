package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "TANK_NAME")
    private String tankName;

    @Column(name = "TANK_IDENTIFY_NUMBER")
    private String identifyNumber;

    @Column(columnDefinition = "DATETIME", name = "RECEIVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedDate;

    @Column(name = "STATUS")
    private String status;

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

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
