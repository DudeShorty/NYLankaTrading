package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
@Entity
@Table(name = "DETAIL_USER_ROLE")
public class UserRoleDetails extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "fk_USER_ROLE")
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "fk_USER")
    private User user;

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
