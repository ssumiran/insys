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

	
	//Postman
	//After using Gateway API the URL
	//http://localhost:9090/student-service/api/student/getById/1
}
