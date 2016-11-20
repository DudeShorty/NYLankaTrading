package com.incosyz.entity;

import com.incosyz.dto.BaseModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
@Entity
@Table(name = "MASTER_BRANCH")
public class Branch implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long Id;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(columnDefinition = "DATETIME", name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
}
