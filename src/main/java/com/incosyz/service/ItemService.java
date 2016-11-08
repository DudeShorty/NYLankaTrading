package com.incosyz.service;

import com.incosyz.dto.ItemDTO;
import com.incosyz.entity.Item;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
public interface ItemService {
    void add(ItemDTO itemDTO);

    List<Item> get();

}
