package com.fangtianxia.dao;

import com.fangtianxia.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author wyz
 */
@Mapper
public interface UserMapper {

    User selectUserById(Integer id);
}
