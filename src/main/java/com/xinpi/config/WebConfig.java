/**
 * Copyright (c) 2016-2019 信披官网 All rights reserved.
 *
 * https://www.xinpi.io
 *
 * 版权所有，侵权必究！
 */

package com.xinpi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebMvc配置
 * 静态资源映射
 * @author renhao
 *
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${file.upload.path}")
    private   String path;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/statics/**").addResourceLocations("classpath:/statics/");
        registry.addResourceHandler("/file/**").addResourceLocations(path);
   }

}