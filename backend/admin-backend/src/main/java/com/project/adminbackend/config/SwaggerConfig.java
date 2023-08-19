package com.project.adminbackend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {


    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("标准接口")
                .apiInfo(apiInfo("Spring Boot中使用Swagger2构建RESTful APIs", "1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.project.adminbackend.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //访问地址：http://ip:port/swagger-ui.html
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("")
                .termsOfServiceUrl("")
                .contact(new Contact("", "", ""))
                .version(version)
                .build();
    }


}