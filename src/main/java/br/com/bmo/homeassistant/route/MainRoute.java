package br.com.bmo.homeassistant.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import br.com.bmo.homeassistant.model.Device;

@Component
public class MainRoute extends RouteBuilder {
	
	@Autowired
	private Environment env;
	
	@Value("${camel.component.servlet.mapping.context-path}")
	private String contextPath;

	@Override
	public void configure() throws Exception {
		restConfiguration()
			.bindingMode(RestBindingMode.json)
			.dataFormatProperty("prettyPrint", "true")
			.enableCORS(true)
			.port(env.getProperty("server.port", "8080"))
			.contextPath(contextPath);
		
		rest("/devices").description("Home Assistant Devices REST Service")
			.consumes("application/json")
			.produces("application/json")
			
			.get().description("Get All Devices")
				.outType(Device.class)
				.responseMessage().code(200)
				.message("ALl Devices successfully returned")
				.endResponseMessage()
			.to("bean:deviceService?method=getAllDevices");
	}

}
