package com.incosyz.dao;

import com.incosyz.entity.ItemTank;
import com.incosyz.entity.Tank;

import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
public interface ItemTankDao {
    List<ItemTank> getItemTank(Long id);
}
