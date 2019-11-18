package com.fangtianxia.service.impl;

import com.fangtianxia.dao.RoleMapper;
import com.fangtianxia.entity.Role;
import com.fangtianxia.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author User
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Role selectRoleById(Long id) {
        Role role = roleMapper.selectRoleById(id);
        return role;
    }
}
