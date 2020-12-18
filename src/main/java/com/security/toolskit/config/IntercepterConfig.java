package com.security.toolskit.config;

import com.security.toolskit.component.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class IntercepterConfig extends WebMvcConfigurationSupport {
    private TokenInterceptor tokenInterceptor;


//    构造方法
    public IntercepterConfig(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }


//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        List<String> excludePath = new ArrayList<>();
//        excludePath.add("/user/register");
//        excludePath.add("/user/login");
//        excludePath.add("/logout");
//        excludePath.add("/swagger-ui.html");
//        excludePath.add("/swagger-ui.html/**");
//        excludePath.add("/swagger-resources/**");
//        excludePath.add("/webjars/**");
//        excludePath.add("/v2/**");
//        excludePath.add("/api");
//        excludePath.add("/api-docs");
//        excludePath.add("/api-docs/**");
//        excludePath.add("/*.js");
//        excludePath.add("/*.css");
//        excludePath.add("*.html");
//        excludePath.add("*.ttf");
//        excludePath.add("/actuator/**");
//        excludePath.add("/druid/**");
//        registry.addInterceptor(tokenInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns(excludePath)
//                .excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
//        super.addInterceptors(registry);
//    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器要声明拦截器对象和要拦截的请求
        registry.addInterceptor(tokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login","/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**");
    }
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
