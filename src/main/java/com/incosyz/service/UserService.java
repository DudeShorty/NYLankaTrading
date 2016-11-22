package com.incosyz.service;

import com.incosyz.dto.UserDTO;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
public interface UserService {
    void create(UserDTO userDTO);

    UserDTO login(String username, String password);
}
