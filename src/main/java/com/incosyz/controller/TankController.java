package com.incosyz.controller;

import com.incosyz.dto.TankDTO;
import com.incosyz.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Stelan Briyan on 11/19/2016.
 */
@Controller
@RequestMapping(value = "/v1/tank")
public class TankController {

    @Autowired
    private TankService tankService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody TankDTO tankDTO) {
        tankService.add(tankDTO);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<TankDTO> get() {
        return tankService.getTanks();
    }

    @RequestMapping(value = "/get/active", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<TankDTO>> getActiveTanks() {
        return new ResponseEntity<List<TankDTO>>(tankService.getTankActive(), HttpStatus.OK);
    }
}
