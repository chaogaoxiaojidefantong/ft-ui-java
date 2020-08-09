package com.ftui.userService.fifter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<FilterOne> filterOne() {
        FilterRegistrationBean<FilterOne> filter = new FilterRegistrationBean<>();
        filter.setName("filterOne");
        filter.setFilter(new FilterOne());
        filter.setOrder(1);
        return filter;
    }

    @Bean
    public FilterRegistrationBean<FilterTwo> filterTwo() {
        FilterRegistrationBean<FilterTwo> filter = new FilterRegistrationBean<>();
        filter.setName("filterTwo");
        filter.setFilter(new FilterTwo());
        filter.setOrder(2);
        return filter;
    }
}
