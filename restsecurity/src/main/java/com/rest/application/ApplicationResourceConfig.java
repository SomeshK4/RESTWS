package com.rest.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.rest.ws.Message;




@ApplicationPath("/")
public class ApplicationResourceConfig extends ResourceConfig{

	public ApplicationResourceConfig() {
		super(Message.class);
		register(RolesAllowedDynamicFeature.class);
	}

	

}
