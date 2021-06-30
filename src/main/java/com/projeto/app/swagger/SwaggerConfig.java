package com.projeto.app.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;

//Link do Swagger : localhost : PORTA / swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket galpao() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                // .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build().apiInfo(metaInfo()).ignoredParameterTypes();
        // .globalOperationParameters(Arrays.asList(
        // new ParameterBuilder()
        // .name("Authorization")
        // .description("Header para usar TOKEN")
        /// .modelRef(new ModelRef("string"))
        // .parameterType("header")
        // .required(false)
        // .build()
        // ));
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo("eQysell - Compasso Uol", "Pensando em agilidade na sua relação com o cliente",
                "Versão Alpha", "Terms",
                new Contact("Desenvolvedores",
                        "https://www.linkedin.com/feed/update/urn:li:activity:6811671818735374337/", null),
                "Apache License", "https://www.apache.org/licenses/LICENSE-2.0.txt", new ArrayList<VendorExtension>());
        return apiInfo;
    }
}
