package com.incosyz.dao;

import com.incosyz.entity.User;
import com.incosyz.entity.UserRole;

import java.util.List;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
public interface UserDao {
    public User findByUserName(String username);

    public List<UserRole> findRoleByUserName(String username);

    void save(User user);
}
