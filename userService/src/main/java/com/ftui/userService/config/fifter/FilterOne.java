package com.ftui.userService.config.fifter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class FilterOne implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("url={}, params={}", req.getRequestURI(), JSON.toJSONString(req.getParameterMap()));
        chain.doFilter(req, response);
    }
}
