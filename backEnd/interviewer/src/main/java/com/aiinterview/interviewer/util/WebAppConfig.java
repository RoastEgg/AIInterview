package com.aiinterview.interviewer.util;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//上传配置类
//图片放到/F:/fileUpload/后，从磁盘读取的图片数据scr将会变成images/picturename.jpg的格式
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Value("${cbs.videosPath}")
    private String videosPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/interviewee/videos/**")
                //addResourceLocations=图片存放在服务器的真实路径
                .addResourceLocations(videosPath);
    }
}