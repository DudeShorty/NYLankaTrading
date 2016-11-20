package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.TankDao;
import com.incosyz.dto.MethodResult;
import com.incosyz.dto.TankDTO;
import com.incosyz.entity.Tank;
import com.incosyz.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Service
public class TankServiceImpl implements TankService {

    @Autowired
    private AbstractDao abstractDao;

    @Autowired
    private TankDao tankDao;

    @Override
    public void add(TankDTO tankDTO) {
        MethodResult save = abstractDao.save(generateTanks(tankDTO));
    }

    @Override
    public List<TankDTO> getTanks() {
        List<Tank> tanks = tankDao.getTank();
        return generateTankDTOs(tanks);
    }

    @Override
    public List<TankDTO> getTankActive() {
        List<Tank> tanks = tankDao.getTankActive();
        return generateTankDTOs(tanks);
    }

    private Tank generateTanks(TankDTO tankDTO) {
        if (tankDTO != null) {
            Tank tank = new Tank();
            tank.setIdentifyNumber(tankDTO.getIdentifyNumber());
            tank.setReceivedDate(tankDTO.getReceivedDate());
            if(!StringUtils.isEmpty(tankDTO.getStatus())) {
                tank.setStatus(tankDTO.getStatus());
            }
            tank.setTankName(tankDTO.getName());
            tank.setActive(true);
            return tank;
        }
        return null;
    }

    private List<TankDTO> generateTankDTOs(List<Tank> tanks) {
        List<TankDTO> tankDTOs = new ArrayList<>();
        for (Tank tank : tanks) {
            TankDTO tankDTO = new TankDTO();
            tankDTO.setIdentifyNumber(tank.getIdentifyNumber());
            tankDTO.setName(tank.getTankName());
            tankDTO.setReceivedDate(tank.getReceivedDate());
            tankDTO.setStatus(tank.getStatus());
            tankDTO.setId(tank.getId());
            tankDTOs.add(tankDTO);
        }
        return tankDTOs;
    }
}
