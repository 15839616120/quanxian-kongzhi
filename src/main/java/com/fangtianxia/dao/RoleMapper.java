package com.fangtianxia.dao;

import com.fangtianxia.entity.Role;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author User
 */
@Mapper
public interface RoleMapper {

    Role selectRoleById(Long id);


}
