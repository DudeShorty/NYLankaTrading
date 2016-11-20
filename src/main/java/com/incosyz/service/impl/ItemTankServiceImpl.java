package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.ItemDao;
import com.incosyz.dao.ItemTankDao;
import com.incosyz.dao.TankDao;
import com.incosyz.dto.ItemDTO;
import com.incosyz.dto.ItemTankDTO;
import com.incosyz.dto.TankDTO;
import com.incosyz.entity.Item;
import com.incosyz.entity.ItemTank;
import com.incosyz.entity.Tank;
import com.incosyz.service.ItemTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private ItemTankDao itemTankDao;

    @Override
    public void save(ItemTankDTO itemTankDTO) {
        ItemTank itemTank = generateItemTankDto(itemTankDTO);
        if (itemTank != null) {
            abstractDao.save(itemTank);
        }
    }

    public List<ItemTankDTO> getItemTank(Long id) {
        return generateItemTankDTOs(itemTankDao.getItemTank(id));
    }

    private ItemTank generateItemTankDto(ItemTankDTO itemTankDTO) {
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

    private List<ItemTankDTO> generateItemTankDTOs(List<ItemTank> itemTanks) {
        List<ItemTankDTO> itemTankDTOs = new ArrayList<>();
        for (ItemTank itemTank : itemTanks) {
            ItemTankDTO itemTankDTO = new ItemTankDTO();
            itemTankDTO.setUnitPrice(itemTank.getUnitPrice());
            itemTankDTO.setQty(itemTank.getQty());
            itemTankDTO.setId(itemTank.getId());

            Item item = itemTank.getItem();
            if (item != null) {
                ItemDTO itemDTO = generateItemDTO(item);
                itemTankDTO.setItemDTO(itemDTO);
            }

            Tank tank = itemTank.getTank();
            if (tank != null) {
                TankDTO tankDTO = generateTankDTO(tank);
                itemTankDTO.setTankDTO(tankDTO);
            }
        }
        return itemTankDTOs;
    }

    private ItemDTO generateItemDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        if (!StringUtils.isEmpty(item.getItemName())) {
            itemDTO.setName(item.getItemName());
        }
        return itemDTO;
    }

    private TankDTO generateTankDTO(Tank tank) {
        TankDTO tankDTO = new TankDTO();
        tankDTO.setId(tank.getId());
        if (!StringUtils.isEmpty(tank.getTankName())) {
            tankDTO.setName(tank.getTankName());
        }
        tankDTO.setStatus(tank.getStatus());
        tankDTO.setReceivedDate(tank.getReceivedDate());
        tankDTO.setIdentifyNumber(tank.getIdentifyNumber());
        return tankDTO;
    }

}
