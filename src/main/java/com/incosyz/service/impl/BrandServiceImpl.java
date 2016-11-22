package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.BrandDao;
import com.incosyz.dto.BrandDTO;
import com.incosyz.entity.Brand;
import com.incosyz.entity.User;
import com.incosyz.service.BrandService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Service
public class BrandServiceImpl implements BrandService {

    private final static Log LOGGER = LogFactory.getLog(BrandServiceImpl.class);

    @Autowired
    private AbstractDao abstractDao;

    @Autowired
    private BrandDao brandDao;

    @Override
    public void add(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setActive(true);
        brand.setBrandName(brandDTO.getName());
        abstractDao.save(brand);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<BrandDTO> brandDTOs = generateBrandDTOs(brandDao.getAllBrands());
        LOGGER.info("brand count: " + brandDTOs.size());
        return brandDTOs;
    }

    @Override
    public boolean activeDeactive(Long id) {
        Brand brand = brandDao.getBrand(id);
        if (brand != null) {
            if (brand.isActive()) {
                brand.setActive(false);
            } else {
                brand.setActive(true);
            }
        }
        brandDao.updateActive(brand);
        return false;
    }

    private List<BrandDTO> generateBrandDTOs(List<Brand> brandList) {
        if (brandList == null || brandList.size() == 0) {
            return new ArrayList<>();
        }
        List<BrandDTO> brandDTOs = new ArrayList<>();
        for (Brand brand : brandList) {
            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setId(brand.getId());
            brandDTO.setActive(brand.isActive());
            if (!StringUtils.isEmpty(brand.getBrandName())) {
                brandDTO.setName(brand.getBrandName());
            }
            if (brand.getCreatedDate() != null) {
                brandDTO.setCreatedDate(brand.getCreatedDate());
            }
            brandDTOs.add(brandDTO);

            User createdUser = brand.getCreatedUser();
            if (createdUser != null) {
                brandDTO.setUsername(createdUser.getUsername());
            }
        }
        return brandDTOs;
    }
}
