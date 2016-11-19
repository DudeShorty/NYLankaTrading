package com.incosyz.controller;

import com.incosyz.dto.ItemDTO;
import com.incosyz.entity.Item;
import com.incosyz.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Controller
@RequestMapping(value = "/v1/item")
public class ItemController {
    private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    @ResponseBody
    public void active() {

    }

    @RequestMapping(value = "/deactive", method = RequestMethod.GET)
    @ResponseBody
    public void deactive() {

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody ItemDTO itemDTO) {
        logger.info("addItem");
        itemService.add(itemDTO);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public List<ItemDTO> get() {
        return itemService.get();
    }
}
