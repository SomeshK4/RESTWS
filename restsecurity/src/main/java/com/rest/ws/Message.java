package com.rest.ws;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/message")
public class Message {
	
	@GET
	@Path("/unsecured")
	@Produces("text/plain")
	@PermitAll
	public String getUnSecured(){
		return "Message for all roles";
	}
	
	
	@GET
	@Path("/secured")
	@Produces("text/plain")
	@RolesAllowed("secured")
	public String getSecured(){
			return "Message for user with secured role";
	}
	
	@GET
	@Produces("text/plain")
	@RolesAllowed("jersey")
	@Path("/securedAdmin")
	public String getSecuredAdmin(){
		return "Message for user with role admin";
	}

}
