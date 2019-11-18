package com.fangtianxia.interceptor;

import com.fangtianxia.common.AuthorityAnnotation;
import com.fangtianxia.entity.Role;
import com.fangtianxia.service.RoleService;
import com.fangtianxia.service.UserAndRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author User
 */
@Component
public class SystemInterceptor implements HandlerInterceptor {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserAndRoleService userAndRoleService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 查看被请求的方法上面是否有@AuthorityAnnotation注解
        AuthorityAnnotation annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthorityAnnotation.class);
        if (annotation == null) {
            // 如果方法上没有注解做限制，说明接口不做权限控制
            return true;
        }
        //如果有，判断是否是指定的角色

        // 查询当前用户的所有角色
        String userId = request.getHeader("accessToken");
        List<Long> roleIds = userAndRoleService.selectUserAndRoleById((Long.parseLong(userId)));
        List<String> roleNames = new ArrayList<>();
        for (Long roleId:roleIds) {
            Role role = roleService.selectRoleById(roleId);
            roleNames.add(role.getRoleName());
        }
        // 如果roleNameList中包含ROLE_SUPER，说明当前用户是超级管理员，拥有所有接口的执行权限，直接return true
      if (roleNames.contains("ROLE_SUPER")) {
            return true;
        }
        String name = annotation.name();
        // 如果当前用户拥有的角色集合包含name, 说明当前用户有权限执行此方法
        if (roleNames.contains(name)) {
            return true;
        }
        // 否则表示没有权限，不允许执行
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }

}
