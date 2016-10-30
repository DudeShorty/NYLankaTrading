package com.incosyz.dao;

import com.incosyz.entity.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Repository
public class ItemDaoImpl implements ItemDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void active(Item item) {
        Session em = getSession();
        Query query = em.createQuery("UPDATE Item o SET o.active = true WHERE o.id = :id ");

    }
}
