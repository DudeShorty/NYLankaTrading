package com.incosyz.dao.impl;

import com.incosyz.dao.ItemTankDao;
import com.incosyz.entity.ItemTank;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Repository
public class ItemTankDaoImpl implements ItemTankDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<ItemTank> getItemTank(Long id) {
        Session em = getSession();
        List<ItemTank> itemTanks = new ArrayList<>();
        try {
            Query query = em.createQuery("SELECT o FROM ItemTank o WHERE o.active = true ");
            itemTanks = (List<ItemTank>) query.list();
        } catch (Exception e) {
        }
        return itemTanks;
    }
}
