package u.student.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import u.student.cloud.feignclient.AddressFeignClient;
import u.student.response.AddressResponse;

@Service
public class CustomeService {
	Logger logger = LoggerFactory.getLogger(CustomeService.class);
	int count=0;
	
	@Autowired
	AddressFeignClient addressFeignClient;
	
	//Method using Spring WebClient to call Address API 
	//Using Mono from reactor.core.publisher.Mono  still doesn't work  
	//Now using FeignClient
	@CircuitBreaker( name = "addressService" ,
					fallbackMethod = "fallbackGetAddressId")
	public AddressResponse getAddressById (long addressId) {
		count++;
		logger.info("getAddressById count: "+ count);
		//Using FeignClient
		AddressResponse addressResponse = addressFeignClient.getById(addressId);
		return addressResponse;
	}
	
	//fallbackMethod for Internal Server Error -- return empty/null AddressResponse object  
	//Must have same signature with original method
	public AddressResponse fallbackGetAddressId (long addressId, Throwable th) {
		logger.error("Error in getAddressById: "+th);				
		return new AddressResponse();
	}

}
