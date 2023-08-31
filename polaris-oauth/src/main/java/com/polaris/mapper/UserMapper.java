package com.polaris.mapper;

import com.polaris.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    User selectByUserName(String username);
}
