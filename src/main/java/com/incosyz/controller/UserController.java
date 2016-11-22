package com.incosyz.controller;

import com.incosyz.dto.UserDTO;
import com.incosyz.service.UserService;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */

@Controller
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<UserDTO>(userService
                .login(userDTO.getUsername(), userDTO.getPassword()), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> create(@RequestBody UserDTO userDTO) {
        userService.create(userDTO);
        return new ResponseEntity("User successfully created.", HttpStatus.OK);
    }
}
