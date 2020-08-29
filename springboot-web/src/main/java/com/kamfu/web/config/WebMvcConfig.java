package com.kamfu.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kamfu.web.util.AuthInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthInterceptor authInterceptor;
    /**
     * 添加拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPa-thPatterns 用于添加拦截规则
        //excludePathPatterns 用于排除拦截
        /*要执行的拦截器*/
        registry.addInterceptor(authInterceptor).
                addPathPatterns("/**").//拦截所有
                excludePathPatterns("/**/login", "/**/esProductinfo/**", "/**/test/**");//过滤login
    }

    /**
     * 解决跨域问题
     * 源（origin）就是协议、域名和端口号。
     * URL由协议、域名、端口和路径组成，如果两个URL的协议、域名和端口全部相同，
     * 则表示他们同源。否则，只要协议、域名、端口有任何一个不同，就是跨域
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT", "PATCH")
                .maxAge(3600);
    }


}