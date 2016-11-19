package com.incosyz.controller;

import com.incosyz.dto.ItemDTO;
import com.incosyz.dto.TankDTO;
import com.incosyz.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Controller
@RequestMapping(name = "/v1/tank")
public class TankController {

    @Autowired
    private TankService tankService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody TankDTO tankDTO) {
        tankService.add(tankDTO);
    }
}
