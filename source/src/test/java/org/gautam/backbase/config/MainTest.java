package org.gautam.backbase.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.gautam.backbase.entities.GeocodeResponse;
import org.springframework.stereotype.Component;

@Component
public class MainTest extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		JacksonXMLDataFormat dataFormat = new JacksonXMLDataFormat();
		dataFormat.setUnmarshalType(GeocodeResponse.class);
		
		from("direct:backPojo").unmarshal(dataFormat).to("mock:reversePojo");
	}

}
