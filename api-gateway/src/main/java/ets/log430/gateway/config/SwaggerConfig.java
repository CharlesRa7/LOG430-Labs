//package ets.log430.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteDefinition;
//import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springdoc.core.properties.SwaggerUiConfigParameters;
//import org.springdoc.core.properties.SwaggerUiConfigProperties;
//
//import org.springdoc.core.models.SwaggerUrl;
//import java.util.ArrayList;
//import java.util.List;
//
//@Primary
//@Bean
//public SwaggerUiConfigProperties swaggerUiConfig(RouteDefinitionLocator locator) {
//    SwaggerUiConfigProperties config = new SwaggerUiConfigProperties();
//    List<SwaggerUrl> urls = new ArrayList<>();
//    locator.getRouteDefinitions().subscribe(route -> {
//        String serviceName = route.getId();
//        String url = "/v3/api-docs/" + serviceName;
//        SwaggerUrl swaggerUrl = new SwaggerUrl();
//        swaggerUrl.setName(serviceName);
//        swaggerUrl.setUrl(url);
//        urls.add(swaggerUrl);
//    });
//    config.setUrls(urls);
//    return config;
//}