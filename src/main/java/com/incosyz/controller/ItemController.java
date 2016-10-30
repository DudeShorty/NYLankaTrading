package com.incosyz.controller;

import com.incosyz.entity.Item;
import com.incosyz.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Stelan Briyan on 10/30/2016.
 */
@Controller
@RequestMapping(value = "/data/v1")
public class ItemController {
    private final static Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public void add(ModelMap model) {
        Item item = new Item();
        item.setItemName("A");
        itemService.add(item);
    }

    @RequestMapping(value = "/active", method = RequestMethod.GET)
    @ResponseBody
    public void active(){

    }

    @RequestMapping(value = "/deactive", method = RequestMethod.GET)
    @ResponseBody
    public void deactive(){

    }
}
