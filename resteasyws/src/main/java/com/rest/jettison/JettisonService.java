package com.rest.jettison;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/jettison")
public class JettisonService {

	@BadgerFish
	@GET
	@Path("/get")
	@Produces("application/json")
	public Movie getMovieInJson(){
		Movie movie = new Movie();
		movie.setName("Takers");
		movie.setYear(2010);
		return movie;
	}
	
}
