package com.polaris.service.impl;

import com.polaris.mapper.UserMapper;
import com.polaris.model.User;
import com.polaris.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }
}
