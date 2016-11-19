package com.incosyz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Aux-009 on 10/30/2016.
 */
public class ItemDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    public ItemDTO() {
    }

    public ItemDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
