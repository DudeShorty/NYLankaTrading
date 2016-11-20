package com.incosyz.dao.impl;

import com.incosyz.dao.BrandDao;
import com.incosyz.entity.Brand;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Repository
public class BrandDaoImpl implements BrandDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public List<Brand> getAllBrands() {
        Session session = getSession();
        Query query = session.createQuery("SELECT b from Brand b ORDER BY 1 DESC");
        try {
            return (List<Brand>) query.list();
        } catch (Exception ex) {

        }
        return new ArrayList<>();
    }
}
