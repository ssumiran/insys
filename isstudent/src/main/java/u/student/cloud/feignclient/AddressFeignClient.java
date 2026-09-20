package u.student.cloud.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import u.student.response.AddressResponse;

@FeignClient( url = "${address.service.url}", 
				value="address-feignclient",
				path = "/api/address")
public interface AddressFeignClient {
	
	//Create Feign Client Get API (like controller in interface)
	@GetMapping("/getById/{id}")   
	public AddressResponse getById (@PathVariable long id);

}
