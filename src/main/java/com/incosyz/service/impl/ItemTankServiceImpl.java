package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.ItemDao;
import com.incosyz.dao.TankDao;
import com.incosyz.dto.ItemTankDTO;
import com.incosyz.entity.Item;
import com.incosyz.entity.ItemTank;
import com.incosyz.entity.Tank;
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
    private TankDao tankDao;

    @Autowired
    private ItemDao itemDao;

    @Override
    public void save(ItemTankDTO itemTankDTO) {
        ItemTank itemTank = generateItemTankDto(itemTankDTO);
        if (itemTank != null) {
            abstractDao.save(itemTank);
        }
    }

    public ItemTank generateItemTankDto(ItemTankDTO itemTankDTO) {
        ItemTank itemTank = new ItemTank();

        Long itemId = itemTankDTO.getItemId();
        if (itemId != null) {
            Item item = itemDao.getItem(itemId);
            itemTank.setItem(item);
        }

        Long tankId = itemTankDTO.getTankId();
        if (tankId != null) {
            Tank tank = tankDao.getTanks(tankId);
            itemTank.setTank(tank);
        }

        itemTank.setQty(itemTankDTO.getQty());
        itemTank.setUnitPrice(itemTankDTO.getUnitPrice());

        return itemTank;
    }
}
