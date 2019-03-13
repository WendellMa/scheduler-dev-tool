package com.abigail.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger api configuration
 *
 * @author myq
 * @since 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    private static final String API_BASE_PACKAGE = "com.abigail.core.action";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(API_BASE_PACKAGE))
//                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .directModelSubstitute(org.joda.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.joda.time.DateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("成都雨诺",
                "http://www.romens.cn/protuct/Product-DM-CRM.html",
                "whj@romenscd.cn");
        return new ApiInfoBuilder()
                .title("scheduler-dev-tool")
                .description("定时器部署工具")
                .contact(contact)
                .version("1.0.0")
                .build();
    }

}
