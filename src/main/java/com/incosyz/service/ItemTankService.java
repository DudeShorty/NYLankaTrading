package com.incosyz.service;

import com.incosyz.dto.ItemTankDTO;

import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
public interface ItemTankService {
    void save(ItemTankDTO itemTankDTO);

    public List<ItemTankDTO> getItemTank(Long id);
}
