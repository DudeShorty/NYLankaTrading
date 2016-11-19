package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.service.ItemService;
import com.incosyz.service.ItemTankService;
import com.incosyz.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Service
public class ItemTankServiceImpl implements ItemTankService {
    @Autowired
    private AbstractDao abstractDao;

    @Autowired
    private TankService tankService;

    @Autowired
    private ItemService itemService;

}
