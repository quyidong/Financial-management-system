package com.example.financialmanagement.config;

import com.example.financialmanagement.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

//扩展MVC功能
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/signup").setViewName("signup");
        registry.addViewController("/signup.html").setViewName("signup");
        registry.addViewController("/main.html").setViewName("main");
        registry.addViewController("/404.html").setViewName("error");
        registry.addViewController("/classStatic.html").setViewName("classStatic");

    }

    //注册拦截器，除了特定的请求都拦截
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginHandlerInterceptor loginHandlerInterceptor = new LoginHandlerInterceptor();
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/**")
                .excludePathPatterns( "/classStatic",  "/dividePage.**" ,"/static/**" ,"/error**",  "/index.html","/","/index","/signup","/login.action","/test","/*.action","/test.**");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
