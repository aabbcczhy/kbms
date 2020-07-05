package com.fjnu.kbms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @ProjectName: kbms
 * @Package: com.fjnu.kbms.config
 * @Author: QuanJiaXing
 * @Date: 2020/7/5 12:54
 * @Version: 1.0
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/image/**").addResourceLocations("file:"+"C:/");
        //注意前面要加file,不然是访问不了的
        //注意上传的文件目录要一致
    }
}