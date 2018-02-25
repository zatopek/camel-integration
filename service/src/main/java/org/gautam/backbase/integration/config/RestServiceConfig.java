package org.gautam.backbase.integration.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.http.Http;
import org.springframework.integration.dsl.jms.Jms;
import org.springframework.integration.dsl.support.Transformers;
import org.springframework.messaging.MessageChannel;

@Configuration
public class RestServiceConfig {

	@Bean
	public MessageChannel httpRequest() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel httpReply() {
		return new DirectChannel();
	}

	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		return activeMQConnectionFactory;
	}

	@Bean
	public IntegrationFlow inputFLow() {
		return IntegrationFlows
				.from(Http.inboundGateway("/address").requestMapping(m -> m.methods(HttpMethod.POST))
						.requestPayloadType(String.class))
				.transform(Transformers.toJson())
				.publishSubscribeChannel(subscribers -> subscribers.subscribe(
						f -> f.handle(Jms.outboundGateway(connectionFactory()).requestDestination("google.geocoding"))))
				.get();
	}
}
