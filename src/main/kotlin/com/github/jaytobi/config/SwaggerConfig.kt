package com.github.jaytobi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Configuration of Swagger API documentation.
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())  //would also return the default error controller
//                .paths(PathSelectors.any())
                //define the package to look for APIs and the mapping paths (with ant syntax so wildcard is **)
                .apis(RequestHandlerSelectors.basePackage("com.github.jaytobi.controller"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
    }
}