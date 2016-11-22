
package com.incosyz.dao.impl;

import com.incosyz.dao.UserDao;
import com.incosyz.entity.User;
import com.incosyz.entity.UserRole;
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
 * Created by Stelan Briyan on 11/20/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class.getName());

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    public User findByUserName(String username) {
        Session em = getSession();
        User user = null;
        try {
            Query query = em.createQuery("SELECT o FROM User o WHERE o.username = :username");
            query.setParameter("username", username);
            user = (User) query.uniqueResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserRole> findRoleByUserName(String username) {
        List<UserRole> userRoles = new ArrayList<>();
        Session em = getSession();
        try {
            Query query = em.createQuery("SELECT o.userRole FROM UserRoleDetails o WHERE o.user.username = :username");
            query.setParameter("username", username);
            userRoles = (List<UserRole>) query.list();
        } catch (NoResultException e) {

        }
        return userRoles;
    }

    @Override
    public void save(User user) {
        getSession().saveOrUpdate(user);
    }
}
