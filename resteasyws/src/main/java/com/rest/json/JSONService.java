package com.rest.json;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class JSONService {

	@GET
	@Path("/getJson")
	@Produces("application/json")
	public Product getProductInJson(){
		Product prdct = new Product();
		prdct.setName("headphones");
		prdct.setQty(2);
		return prdct;
	}
	
	@POST
	@Path("/createJson")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createProductInJson(Product product){
		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();		
	}
}
