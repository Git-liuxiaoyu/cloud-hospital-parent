package com.example.physicalexamservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XXX 项目接口文挡")
                .description("XXX Project Swagger2 UserService Interface")
                .termsOfServiceUrl("http://localhost:9001/swagger-ui.html")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 此处自行修改为自己的 Controller 包路径。
                .apis(RequestHandlerSelectors.basePackage("com.example.physicalexamservice.inlet.web.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
