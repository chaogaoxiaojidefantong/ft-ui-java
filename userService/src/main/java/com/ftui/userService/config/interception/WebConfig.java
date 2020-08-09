package com.ftui.userService.config.interception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptionFifter interceptionFifter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptionFifter)
                .addPathPatterns("/**"); //匹配要过滤的路径
               // .excludePathPatterns("/User/**"); //匹配不过滤的路径。密码还要修改呢，所以这个路径不能拦截
//                .excludePathPatterns("/api/passwordStateValid") //密码状态验证也不能拦截
//                .excludePathPatterns("/api/getManagerVersion");//版本信息同样不能拦截
    }
}
