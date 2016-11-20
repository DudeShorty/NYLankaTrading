package com.incosyz.controller;

import com.incosyz.dto.ItemTankDTO;
import com.incosyz.service.ItemTankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(value = "/get/{tankId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<ItemTankDTO>> getItemTanks(@PathVariable("tankId") Long tankId) {
        return new ResponseEntity<List<ItemTankDTO>>(itemTankService.getItemTank(tankId), HttpStatus.OK);
    }
}
