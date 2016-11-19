package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.*;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Entity
@Table(name = "MASTER_ITEM")
public class Item extends BaseModel {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(name = "ITEM_NAME")
    private String itemName;

    @Column(name = "ACTIVE")
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
