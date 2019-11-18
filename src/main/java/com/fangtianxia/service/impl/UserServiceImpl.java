package com.fangtianxia.service.impl;

import com.fangtianxia.dao.RoleMapper;
import com.fangtianxia.dao.UserMapper;
import com.fangtianxia.entity.Role;
import com.fangtianxia.entity.User;
import com.fangtianxia.service.RoleService;
import com.fangtianxia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author User
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectUserById(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }
}
