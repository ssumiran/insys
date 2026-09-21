package u.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
//@ComponentScan({"u.student.controller", "u.student.service"})
//@EntityScan("u.student.entity")
//@EnableJpaRepositories("u.student.repository")
@EnableFeignClients("u.student.cloud.feignclient")
@EnableDiscoveryClient
public class IsstudentApplication {

	@Value("${address.service.url}")
	private String addressServiceUrl;
	
	public static void main(String[] args) {
		SpringApplication.run(IsstudentApplication.class, args);
	}
	@Bean
	WebClient webClient () {
		WebClient webClient =WebClient.builder()
				.baseUrl(addressServiceUrl)
				.build();
		
		return webClient;
	}
}
