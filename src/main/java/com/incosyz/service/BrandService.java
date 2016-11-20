package com.incosyz.service;

import com.incosyz.dto.BrandDTO;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
public interface BrandService {
    void add(BrandDTO brandDTO);

    List<BrandDTO> getAllBrands();
}
