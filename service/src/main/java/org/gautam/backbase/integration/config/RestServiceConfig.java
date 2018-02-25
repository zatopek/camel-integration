package org.gautam.backbase.integration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.http.Http;
import org.springframework.integration.dsl.jms.Jms;
import org.springframework.integration.dsl.support.Transformers;

/**
 * Configuration class that decribes the only route in this application.
 * 
 * @author Gautam Velpula
 *
 */

@Configuration
public class RestServiceConfig {

	/**
	 * Connection factory return. Default Implementation supporting ActiveMQ
	 * 
	 * @return
	 */
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		return activeMQConnectionFactory;
	}

	/**
	 * Route decribed waits for a request via HTTP, and from this GET request parses
	 * the query parameter "query". Forwards the value which is expected to be an
	 * address to a queue called "google.geocoding" on activeMQ. The response from
	 * this queue is converted into JSON and returned to the HTTP requester
	 * 
	 * @return IntegrationFlow decribing the route
	 */
	@Bean
	public IntegrationFlow inputFLow() {
		return IntegrationFlows
				.from(Http.inboundGateway("/address").requestMapping(m -> m.methods(HttpMethod.GET))
						.requestPayloadType(String.class).payloadExpression("#requestParams['query']"))
				.transform(Transformers.toJson())
				.publishSubscribeChannel(subscribers -> subscribers.subscribe(
						f -> f.handle(Jms.outboundGateway(connectionFactory()).requestDestination("google.geocoding"))))
				.get();
	}
}
