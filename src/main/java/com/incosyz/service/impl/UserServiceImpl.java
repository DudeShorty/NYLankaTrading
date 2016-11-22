package com.incosyz.service.impl;

import com.incosyz.dao.AbstractDao;
import com.incosyz.dao.UserDao;
import com.incosyz.dto.UserDTO;
import com.incosyz.entity.User;
import com.incosyz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Stelan Briyan on 11/20/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void create(UserDTO userDTO) {
        User user = generateUser(userDTO);
        user.setActive(true);
        userDao.save(user);
    }

    @Override
    public UserDTO login(String username, String password) {
        User user = userDao.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User couldn't be found");
        }
        if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return generateUserDTO(user);
        }
        return null;
    }

    private UserDTO generateUserDTO(User user) {
        if (user == null) {
            return new UserDTO();
        }
        UserDTO userDTO = new UserDTO();
        if (user.getCreatedDate() != null) {
            userDTO.setCreatedDate(user.getCreatedDate());
        }
        userDTO.setActive(user.getActive());
        if (!StringUtils.isEmpty(user.getEmail())) {
            userDTO.setEmail(user.getEmail());
        }
        if (!StringUtils.isEmpty(user.getFirstName())) {
            userDTO.setFirstName(user.getFirstName());
        }
        if (!StringUtils.isEmpty(user.getLastName())) {
            userDTO.setLastName(user.getLastName());
        }
        if (!StringUtils.isEmpty(user.getUsername())) {
            userDTO.setUsername(user.getUsername());
        }
        if (!StringUtils.isEmpty(user.getMobileNo())) {
            userDTO.setMobileNo(user.getMobileNo());
        }
        return userDTO;
    }

    private User generateUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobileNo(userDTO.getMobileNo());
        user.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        return user;
    }

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
