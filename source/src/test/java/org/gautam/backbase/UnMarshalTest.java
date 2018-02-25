package org.gautam.backbase;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.gautam.backbase.entities.GeocodeResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;

@RunWith(CamelSpringBootRunner.class)
public class UnMarshalTest extends CamelSpringTestSupport {

	@Test
	public void test() throws InterruptedException {
		MockEndpoint mock = getMockEndpoint("mock:reversePojo");
		mock.expectedMessageCount(1);
		mock.message(0).body().isInstanceOf(GeocodeResponse.class);

		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "<GeocodeResponse>" + " <status>OK</status>"
				+ " <result>" + "  <type>premise</type>"
				+ "  <formatted_address>5251 Mill Run Dr, Marietta, GA 30068, USA</formatted_address>"
				+ "  <address_component>" + "   <long_name>5251</long_name>" + "   <short_name>5251</short_name>"
				+ "   <type>street_number</type>" + "  </address_component>" + "  <address_component>"
				+ "   <long_name>Mill Run Drive</long_name>" + "   <short_name>Mill Run Dr</short_name>"
				+ "   <type>route</type>" + "  </address_component>" + "  <address_component>"
				+ "   <long_name>Marietta</long_name>" + "   <short_name>Marietta</short_name>"
				+ "   <type>locality</type>" + "   <type>political</type>" + "  </address_component>"
				+ "  <address_component>" + "   <long_name>Cobb County</long_name>"
				+ "   <short_name>Cobb County</short_name>" + "   <type>administrative_area_level_2</type>"
				+ "   <type>political</type>" + "  </address_component>" + "  <address_component>"
				+ "   <long_name>Georgia</long_name>" + "   <short_name>GA</short_name>"
				+ "   <type>administrative_area_level_1</type>" + "   <type>political</type>" + "  </address_component>"
				+ "  <address_component>" + "   <long_name>United States</long_name>" + "   <short_name>US</short_name>"
				+ "   <type>country</type>" + "   <type>political</type>" + "  </address_component>"
				+ "  <address_component>" + "   <long_name>30068</long_name>" + "   <short_name>30068</short_name>"
				+ "   <type>postal_code</type>" + "  </address_component>" + "  <address_component>"
				+ "   <long_name>2860</long_name>" + "   <short_name>2860</short_name>"
				+ "   <type>postal_code_suffix</type>" + "  </address_component>" + "  <geometry>" + "   <location>"
				+ "    <lat>33.9744392</lat>" + "    <lng>-84.3921075</lng>" + "   </location>"
				+ "   <location_type>ROOFTOP</location_type>" + "   <viewport>" + "    <southwest>"
				+ "     <lat>33.9731287</lat>" + "     <lng>-84.3934091</lng>" + "    </southwest>" + "    <northeast>"
				+ "     <lat>33.9758266</lat>" + "     <lng>-84.3907111</lng>" + "    </northeast>" + "   </viewport>"
				+ "   <bounds>" + "    <southwest>" + "     <lat>33.9743825</lat>" + "     <lng>-84.3921642</lng>"
				+ "    </southwest>" + "    <northeast>" + "     <lat>33.9745728</lat>" + "     <lng>-84.3919560</lng>"
				+ "    </northeast>" + "   </bounds>" + "  </geometry>"
				+ "  <place_id>ChIJ6xu561MM9YgRRLexn80HZ4Y</place_id>" + " </result>" + "</GeocodeResponse>" + "";

		template.sendBody("direct:backPojo", xml);

		assertMockEndpointsSatisfied();

		GeocodeResponse response = mock.getReceivedExchanges().get(0).getIn().getBody(GeocodeResponse.class);
		assertEquals("OK", response.getStatus());
		assertEquals("5251 Mill Run Dr, Marietta, GA 30068, USA", response.getResult().getFormatted_address());
		assertEquals("33.9744392", response.getResult().getGeometry().getLocation().getLat());
		assertEquals("-84.3921075", response.getResult().getGeometry().getLocation().getLng());
		assertEquals("5251", response.getResult().getAddress_component().get(0).getLong_name());
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {

		return new ClassPathXmlApplicationContext("UnmarshallTest.xml");
	}

}
