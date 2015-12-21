package com.rest;

import java.io.File;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

@Path("/message")
public class MessageService {
	
	@GET
	@Path("/hello/{msg}")
	public Response printMessage(@PathParam("msg") String msg){
		String result = "Hello "+msg;
		return Response.status(200).entity(result).build();
				
	}
	
	@GET
	public Response printMessage(){
		return Response.status(200).entity("Hello how are you").build();
	}
	
	
	@GET
	@Path("/users")
	public Response getUsers(@QueryParam("from") int from,@QueryParam("to") int to,
			@QueryParam("orderby") List<String> orderBy){
		String getUser = "getUsers is called, from : " + from + ", to : " + to
				+ ", orderBy" + orderBy.toString();
		return Response.status(200).entity(getUser).build();
	}
	
	@GET
	@Path("/query")
	public Response getUsers(@Context UriInfo uriInfo){
		String from = uriInfo.getQueryParameters().getFirst("from");
		String to = uriInfo.getQueryParameters().getFirst("to");
		List<String> orderBy = uriInfo.getQueryParameters().get("orderby");
		String getUser = "getUsers  is called, from : " + from + ", to : " + to
				+ ", orderBy" + orderBy.toString();
		return Response.status(200).entity(getUser).build();
		
	}
	
	@GET
	@Path("/books")
	public Response getBooks(@MatrixParam("author") String author,@MatrixParam("country") String country){
		String result = "getBooks is called , author :"+author+" , country :"+country;
		return Response.status(200).entity(result).build();
	}
	
	@POST
	@Path("/add")
	public Response addUser(@FormParam("name") String name,@FormParam("age") int age){
		String result = "addUser is called with name : "+name+" and age :"+age;
		return Response.status(200).entity(result).build();
	}
	
	@GET
	@Path("/getHeader")
	public Response getHeader(@HeaderParam("user-agent") String userAgent){
		return Response.status(200).entity(userAgent).build();
	}
	
	@GET
	@Path("/getHeaderCtx")
	public Response getHeader(@Context HttpHeaders httpHeader){
		return Response.status(200).entity("getHeader is called "+httpHeader.getRequestHeader("user-agent").get(0)).build();
	}
	
	
	@GET
	@Path("/getFile")
	@Produces("text/plain")
	public Response getFile(){
		String FILE_PATH = "c:\\camera.log";
		File file = new File(FILE_PATH);
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=\"file_from_server.log\"");
			return response.build();
	}
	
	
	@GET
	@Path("/getPdfFile")
	@Produces("application/pdf")
	public Response getPdfFile(){
		String path = "C:\\Users\\somesh.kumar\\Downloads\\JEETT.pdf";
		File file = new File(path);
		ResponseBuilder response = Response.ok(file);
		response.header("Content-Disposition", "attachment;filename=\"file_from_server.pdf\"");
		return response.build();
	}
	
	
	
	

}
