package u.apigateway.isapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IsapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsapigatewayApplication.class, args);
	}

}
