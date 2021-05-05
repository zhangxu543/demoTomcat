package com.csi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 静态资源处理器
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler：配置请求路径
        //addResourceLocations:配置物理映射路径
        registry.addResourceHandler("/asserts/**").addResourceLocations("classpath:/asserts/") ;
    }

    /**
     * 该视图控制转换器，需要引入thymeleaf
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
        * addViewController("/index"):设置请求的Controller
        *setViewName：设置controller对应的跳转的视图名称
        * */
        registry.addViewController("/index").setViewName("index");
    }

    /**
     * 日期格式转换
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new Formatter<Date>() {
            @Override
            public String print(Date date, Locale locale) {
                return null;
            }

            @Override
            public Date parse(String s, Locale locale) throws ParseException {
                return new SimpleDateFormat("yyyy-MM-dd").parse(s);
            }
        });
    }
}
