package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.*;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Entity
@Table(name = "DETAIL_ITEM_TANK")
public class ItemTank extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "fk_TANK")
    private Tank tank;

    @ManyToOne
    @JoinColumn(name = "fk_ITEM")
    private Item item;

    @Column(name = "QTY")
    private int qty;

    @Column(name = "UNIT_PRICE")
    private double unitPrice;

    @Column(name = "ACTIVE")
    private boolean active;

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
