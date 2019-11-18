package com.fangtianxia.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author wyz
 */
@Data
public class User {
    private Long id;
    private String phone;
    private String username;
    private String password;
    private Integer status;
    private Date createTime;
}
