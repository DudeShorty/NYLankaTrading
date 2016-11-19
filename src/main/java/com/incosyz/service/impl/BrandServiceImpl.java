package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dto.BrandDTO;
import com.incosyz.entity.Brand;
import com.incosyz.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private AbstractDao abstractDao;

    @Override
    public void add(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setActive(true);
        brand.setBrandName(brandDTO.getName());
        abstractDao.save(brand);
    }
}
