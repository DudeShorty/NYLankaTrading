package com.incosyz.dao.impl;

import com.incosyz.dao.TankDao;
import com.incosyz.entity.Tank;
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
 * Created by Stelan Briyan on 11/19/2016.
 */
@Repository
public class TankDaoImpl implements TankDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Tank> getTank() {
        Session session = getSession();
        List<Tank> list = new ArrayList<>();
        try {
            Query query = session.createQuery("SELECT o FROM Tank o ");
            list = (List<Tank>) query.list();
        } catch (Exception e) {

        }
        return list;
    }

    @Override
    public List<Tank> getTankActive() {
        Session session = getSession();
        List<Tank> list = new ArrayList<>();
        try {
            Query query = session.createQuery("SELECT o FROM Tank o WHERE o.active = true ");
            list = (List<Tank>) query.list();
        } catch (Exception e) {

        }
        return list;
    }


    public Tank getTanks(Long id) {
        try {
            Session em = getSession();
            Query query = em.createQuery("SELECT o FROM Tank o WHERE o.Id = :id ");
            query.setParameter("id", id);
            return (Tank) query.uniqueResult();
        } catch (NoResultException e) {

        }
        return null;
    }
}
