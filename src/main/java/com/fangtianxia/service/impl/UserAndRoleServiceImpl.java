package com.fangtianxia.service.impl;

import com.fangtianxia.dao.UserAndRoleMapper;
import com.fangtianxia.service.UserAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author User
 */
@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {

    @Autowired
    private UserAndRoleMapper userAndRoleMapper;
    @Override
    public List<Long> selectUserAndRoleById(Long id) {
        List<Long> longs = userAndRoleMapper.selectUserAndRoleById(id);
        return longs;
    }
}
