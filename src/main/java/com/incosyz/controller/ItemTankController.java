package com.incosyz.controller;

import com.incosyz.dto.ItemTankDTO;
import com.incosyz.service.ItemTankService;
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
@RequestMapping(value = "/v1/itemTank")
public class ItemTankController {

    @Autowired
    private ItemTankService itemTankService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void addItemToTank(@RequestBody ItemTankDTO itemTankDTO){
        itemTankService.save(itemTankDTO);
    }
}
