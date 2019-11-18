package com.fangtianxia.dao;

import com.fangtianxia.entity.Role;
import com.fangtianxia.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author User
 */
@Mapper
public interface UserMapper {

    User selectUserById(Integer id);
}
