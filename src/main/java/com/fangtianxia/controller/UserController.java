package com.fangtianxia.controller;

import com.fangtianxia.common.AuthorityAnnotation;
import com.fangtianxia.entity.Role;
import com.fangtianxia.entity.User;
import com.fangtianxia.service.RoleService;
import com.fangtianxia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wyz
 */
@RequestMapping("system")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @AuthorityAnnotation(name = "ROLE_SUPER")
    @RequestMapping("selectUserById")
    public User selectUserById(Integer id){
        User user = userService.selectUserById(id);
        return user;
    }
}
