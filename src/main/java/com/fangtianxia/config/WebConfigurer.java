package com.fangtianxia.config;

import com.fangtianxia.interceptor.SystemInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author wyz
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private SystemInterceptor systemInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截Controller层
        registry.addInterceptor(systemInterceptor)
                .addPathPatterns("/system/**")
                .excludePathPatterns("/system/sysUser/doLogin", "/system/sysUser/logout");
                /*.excludePathPatterns("/system/sysUser/doLogin", "/system/sysUser/logout", "/system/sysUser/getAuthorityList"); 用上面的替换这一行，业务的需要*/
    }
}
