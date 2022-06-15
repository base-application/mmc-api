package com.wanghuiwen;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.stereotype.Component;
import springfox.documentation.oas.web.OpenApiTransformationContext;
import springfox.documentation.oas.web.WebMvcOpenApiTransformationFilter;
import springfox.documentation.spi.DocumentationType;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Component
public class SpringfoxSwaggerHostResolver implements WebMvcOpenApiTransformationFilter {

    @Override
    public OpenAPI transform(OpenApiTransformationContext<HttpServletRequest> context) {
        OpenAPI swagger = context.getSpecification();
        ArrayList<Server> servers = new ArrayList<>();
        Server server = new Server();
        server.setUrl("http://dev.wanghuiwen.com/mmc/api/");
        servers.add(server);
        Server server1 = new Server();
        server1.setUrl("http://47.107.84.246/mmc/api/");
        servers.add(server1);
        Server server2 = new Server();
        server2.setUrl("http://127.0.0.1:8005/");
        servers.add(server2);
        swagger.setServers(servers);
        return swagger;
    }

    @Override
    public boolean supports(DocumentationType docType) {
        return docType.equals(DocumentationType.OAS_30);
    }
}