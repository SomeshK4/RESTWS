package com.jersey.ws;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/message")
public class MessageService {
	
	@GET
	@Path("/getMsg")
	public Response getMessage(@DefaultValue("Nothing to say") @QueryParam("value") String value){
			String output = "Hello from: " + " : " + value;
			return Response.status(200).entity(output).build();
		
	}

}
