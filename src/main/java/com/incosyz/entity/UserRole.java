package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRole extends BaseModel {
    @Column(name="ROLE")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
