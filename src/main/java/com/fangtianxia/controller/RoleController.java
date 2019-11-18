package com.fangtianxia.controller;

import com.fangtianxia.common.AuthorityAnnotation;
import com.fangtianxia.entity.Role;
import com.fangtianxia.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author User
 */
@RequestMapping("system")
@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @AuthorityAnnotation(name = "ROLE_SUPER")
    @RequestMapping("selectRoleById")
    public Role selectRoleById(Long id){
        Role role = roleService.selectRoleById(id);
        return role;
    }
}
