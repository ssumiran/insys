package u.apigateway.isapigateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Configuration
public class CustomFilter implements GlobalFilter {

	Logger logger = LoggerFactory.getLogger(CustomFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		ServerHttpRequest request = exchange.getRequest();
		
		//This If condition is to specify the log for ONLY url coming from /api/student/ 
		if(request.getURI().toString().contains("/api/student/")) {
			logger.info("Authorization = " + request.getHeaders().getFirst("Authorization"));
		}
		
				
		//Creating the Pre and Post Filters
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			ServerHttpResponse res = exchange.getResponse();
			
			logger.info("Post Filter= "+ res.getStatusCode());
		}));
	}
	
}
