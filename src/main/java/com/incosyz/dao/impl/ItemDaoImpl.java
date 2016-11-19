package com.incosyz.dao.impl;

import com.incosyz.dao.ItemDao;
import com.incosyz.entity.Item;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Item> getItem() {
        List<Item> items = new ArrayList<>();
        try {
            Session em = getSession();
            Query query = em.createQuery("SELECT o FROM Item o order by 1 desc");
            items = (List<Item>) query.list();
        }catch (NoResultException e){

        }
        return items;
    }

    @Override
    public List<Item> getItemActive() {
        List<Item> items = new ArrayList<>();
        try {
            Session em = getSession();
            Query query = em.createQuery("SELECT o FROM Item o WHERE o.active = true order by 1 desc");
            items = (List<Item>) query.list();
        }catch (NoResultException e){

        }
        return items;
    }
}
