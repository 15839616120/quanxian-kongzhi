package com.fangtianxia.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author User
 */
@Mapper
public interface UserAndRoleMapper {
    List<Long> selectUserAndRoleById(Long id);

}
