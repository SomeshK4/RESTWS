package com.rest.xml;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/xml")
public class XMLService {
	
	
	@GET
	@Path("/getXml")
	@Produces("application/xml")
	public User getUserXml(){
		User user = new User();
		user.setPassword("test");
		user.setUserName("somesh");
		user.setPin(123);
		return user;
	}

}
