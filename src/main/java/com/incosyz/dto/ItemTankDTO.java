package com.incosyz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
public class ItemTankDTO implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("tank_id")
    private Long tankId;

    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("qty")
    private int qty;

    @JsonProperty("unit_price")
    private double unitPrice;

    private TankDTO tankDTO;

    private ItemDTO itemDTO;

    private boolean categorized;

    public ItemTankDTO() {
    }

    public ItemTankDTO(Long id, Long tankId, Long itemId, int qty, double unitPrice) {
        this.id = id;
        this.tankId = tankId;
        this.itemId = itemId;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTankId() {
        return tankId;
    }

    public void setTankId(Long tankId) {
        this.tankId = tankId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
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

    public TankDTO getTankDTO() {
        return tankDTO;
    }

    public void setTankDTO(TankDTO tankDTO) {
        this.tankDTO = tankDTO;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public boolean isCategorized() {
        return categorized;
    }

    public void setCategorized(boolean categorized) {
        this.categorized = categorized;
    }
}
