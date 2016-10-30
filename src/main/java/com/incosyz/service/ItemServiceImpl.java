package com.incosyz.service;

import com.incosyz.dao.ItemDao;
import com.incosyz.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    public void add(Item item) {
        itemDao.add(item);
    }
}
