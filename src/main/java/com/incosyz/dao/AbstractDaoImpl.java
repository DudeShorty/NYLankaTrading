package com.incosyz.dao;

import com.incosyz.dto.BaseModel;
import com.incosyz.dto.MethodResult;
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
public class AbstractDaoImpl implements AbstractDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public MethodResult save(BaseModel baseModel) {
        MethodResult methodResult = new MethodResult();
        Session session = getSession();
        try {
            session.save(baseModel);
            methodResult.setOk(true);
        } catch (Exception e) {
            methodResult.setOk(false);
        }
        return methodResult;
    }
}
