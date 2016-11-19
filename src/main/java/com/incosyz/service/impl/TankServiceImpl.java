package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dto.MethodResult;
import com.incosyz.entity.Tank;
import com.incosyz.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Service
public class TankServiceImpl implements TankService {
    @Autowired
    private AbstractDao abstractDao;

    public void add(Tank tank) {
        MethodResult save = abstractDao.save(tank);
    }
}
