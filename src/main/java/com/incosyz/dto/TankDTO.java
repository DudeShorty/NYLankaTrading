package com.incosyz.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aux-058 on 11/19/2016.
 */
public class TankDTO implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("identify_number")
    private String identifyNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "IST")
    @JsonProperty("received_date")
    private Date receivedDate;

    @JsonProperty("status")
    private String status;

    public TankDTO() {
    }

    public TankDTO(String name, String identifyNumber, Date receivedDate, String status) {
        this.name = name;
        this.identifyNumber = identifyNumber;
        this.receivedDate = receivedDate;
        this.status = status;
    }

    public TankDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
