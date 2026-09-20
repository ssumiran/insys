package u.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"u.address.controller", "u.address.service"})
//@EntityScan("u.address.entity")
//@EnableJpaRepositories("com.infybuzz.repository")
public class IsaddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsaddressApplication.class, args);
	}

}
