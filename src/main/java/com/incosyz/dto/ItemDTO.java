package com.incosyz.dto;

import java.io.Serializable;

/**
 * Created by Aux-009 on 10/30/2016.
 */
public class ItemDTO implements Serializable {

    private String name;

    public ItemDTO() {
    }

    public ItemDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
