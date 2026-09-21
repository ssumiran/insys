package u.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@ComponentScan({"u.address.controller", "u.address.service"})
//@EntityScan("u.address.entity")
//@EnableJpaRepositories("u.address.repository")
@EnableDiscoveryClient
public class IsaddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaddressApplication.class, args);
	}

}
