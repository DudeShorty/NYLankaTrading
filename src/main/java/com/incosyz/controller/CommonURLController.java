package com.incosyz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonURLController {

	private final static Logger logger = LoggerFactory.getLogger(CommonURLController.class);
//
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String welcome() {
//		return "index";
//	}

	@RequestMapping(value = "/item", method = RequestMethod.GET)
	public String item() {
		return "item";
	}

}