package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2  //开启swagger2
public class SwaggerConfig {
    /**
     * 配置了Swagger 的Docket的bean实例,扫描接口的位置
     * .apis
     *   RequestHandlerSelectors 配置swagger扫描接口的方式
     *      basePackage() 指定要扫描哪些包
     *      any() 全部都扫描
     *      none() 全部不扫描
     *      withClassAnnotation() 扫描类上的注解 参数是一个注解的反射对象
     *      withMethodAnnotation() 扫描包上的注解
     * .paths
     *   PathSelectors 路径扫描接口
     *      ant 配置以xxx 开头的路径
     * @return
     */
    @Bean
    public Docket docket( ){

        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("A-Salty-Fish")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                //.paths(PathSelectors.ant("/hello/**"))
                .build();//构建者模式
    }
    /**
     * 配置Swagger信息 apiinfo
     * @return
     */
    private ApiInfo apiInfo(){
        //配置作者信息
        Contact DEFAULT_CONTACT = new Contact("A-Salty-Fish", "https://github.com/A-Salty-Fish/", "A_Salty_Fish@126.com");
        return  new ApiInfo(
                "A-Salty-Fish 的 Swagger API文档",
                "软件架构作业",
                "v1.0",
                "https://github.com/A-Salty-Fish/",
                DEFAULT_CONTACT,
                "MIT",
                "https://mit-license.org/",
                new ArrayList());
    }
}
