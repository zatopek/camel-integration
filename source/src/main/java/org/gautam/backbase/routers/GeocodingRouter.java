package org.gautam.backbase.routers;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.gautam.backbase.entities.GeocodeResponse;
import org.gautam.backbase.translator.SimplifyGeocodeResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;

@Component
public class GeocodingRouter extends RouteBuilder {

	@Value("${geocoding.endpoint}")
	private String geocodingEndpoint;
	@Value("${geocoding.path}")
	private String geocodingPath;
	@Value("${geocoding.address}")
	private String geocodingAddress;
	@Value("${geocoding.key}")
	private String geocodingKey;

	@Override
	public void configure() throws Exception {
		JacksonXMLDataFormat dataFormat = new JacksonXMLDataFormat(GeocodeResponse.class);
		dataFormat.disableFeature(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		dataFormat.setAllowJmsType(true);

		GsonDataFormat gsonDataFormat = new GsonDataFormat();

		from("activemq:queue:google.geocoding").setHeader(Exchange.HTTP_METHOD, constant("POST"))
				.setHeader(Exchange.HTTP_QUERY, simple(geocodingAddress + "${body}" + "&" + geocodingKey))
				.enrich("ahc:{{geocoding.endpoint}}{{geocoding.path}}").unmarshal(dataFormat).log("${body}").transform()
				.method(SimplifyGeocodeResponse.class, "transform").marshal(gsonDataFormat).log("${body}");

	}
}
