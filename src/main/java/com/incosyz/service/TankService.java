package com.incosyz.service;

import com.incosyz.dto.TankDTO;
import com.incosyz.entity.Tank;

import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
public interface TankService {
    void add(TankDTO tankDTO);
    List<TankDTO> getTanks();
}
