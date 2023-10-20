package taffah.sid.Gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes().
				route((r)->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE")).
				route((r)->r.path("/products/**").uri("lb://INVENTORY-SERVICE")).
				route((r)->r.path("/bills/**").uri("lb://BILL-SERVICE")).
				build();
	}
}
