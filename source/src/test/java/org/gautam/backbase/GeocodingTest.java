package org.gautam.backbase;

import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(CamelSpringBootRunner.class)
@SpringBootTest(classes = Main.class)
public class GeocodingTest {
	
	@Produce(uri = "activemq:queue:google.geocoding")
	protected ProducerTemplate template;

	@Test
	public void triggerStart() throws Exception {

		template.sendBody("5251 Mill Run Dr");
	}
}
