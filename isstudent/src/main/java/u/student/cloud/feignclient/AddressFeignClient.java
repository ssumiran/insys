package u.student.cloud.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import u.student.response.AddressResponse;

@FeignClient( //url = "${address.service.url}",  //Remove URL because using Eureka Server
			  // value="address-service",         // Name Address Microservice register in Eureka Server
			  // path = "/api/address")          // this path for specific Address API 
				value= "api-gateway")        //Using API-GATEWAY  in Eureka server
public interface AddressFeignClient {
	
	//Create Feign Client Get API (like controller in interface)
	@GetMapping("/address-service/api/address/getById/{id}")   
	public AddressResponse getById (@PathVariable long id);

}
