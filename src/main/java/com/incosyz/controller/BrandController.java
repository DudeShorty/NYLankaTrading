package com.incosyz.controller;

import com.incosyz.dto.BrandDTO;
import com.incosyz.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Controller
@RequestMapping(value = "/v1/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody BrandDTO brandDTO) {
        brandService.add(brandDTO);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<BrandDTO>> getAll() {
        List<BrandDTO> allBrands = brandService.getAllBrands();
        return new ResponseEntity<List<BrandDTO>>(allBrands, HttpStatus.OK);
    }

    @RequestMapping(value = "/deactivate/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Long> deactivate(@PathVariable("brandId") Long id) {
        boolean status = brandService.activeDeactive(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}
