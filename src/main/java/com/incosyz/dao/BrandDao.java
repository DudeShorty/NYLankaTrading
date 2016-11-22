package com.incosyz.dao;

import com.incosyz.entity.Brand;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
public interface BrandDao {
    List<Brand> getAllBrands();
    List<Brand> getAllBrandsActive();

    Brand getBrand(Long id);

    void updateActive(Brand brand);
}
