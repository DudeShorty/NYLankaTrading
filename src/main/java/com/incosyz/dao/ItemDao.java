package com.incosyz.dao;

import com.incosyz.entity.Item;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
public interface ItemDao {
    public void active(Item item);

    List<Item> getItem();

    public List<Item> getItemActive();

    public Item getItem(Long id);

}
