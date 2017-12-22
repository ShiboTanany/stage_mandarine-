package com.ntgclarity.mandarine.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.google.common.base.Predicates.*;
import static springfox.documentation.builders.PathSelectors.*;



@SpringBootApplication
@EnableSwagger2
@ComponentScan("hello")
public class SwaggerConfig {
    
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		
                //.groupName("greetings")
                .apiInfo(apiInfo())
                .select().paths(regex("/api/v1/.*"))
                .build();
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .contact("Test")
                .license("License")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}