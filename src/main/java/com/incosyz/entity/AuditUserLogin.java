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
@Table(name = "AUDIT_USER_LOGIN")
public class AuditUserLogin extends BaseModel {

}
