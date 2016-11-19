package com.incosyz.dao;

import com.incosyz.dto.BaseModel;
import com.incosyz.dto.MethodResult;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
public interface AbstractDao {
    public MethodResult save(BaseModel baseModel);
}
