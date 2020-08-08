package com.ftui.articleService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class AdminConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.ftui.articleService.mapper");
        Properties properties=new Properties();
        properties.setProperty("mappers","tk.mybatis.mapper.common.Mapper");
        mapperScannerConfigurer.setProperties(properties);
        return  mapperScannerConfigurer;
    }
}
