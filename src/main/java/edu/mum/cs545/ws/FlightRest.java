package edu.mum.cs545.ws;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.FlightService;

@Named
@Path("flight")
public class FlightRest {

	@Inject
	private FlightService flightService;
	ObjectMapper myPapper = new ObjectMapper();

	@GET
	public String helloWorld(@DefaultValue("Fight service") @QueryParam("name") String name) {
		return "Hello " + name + "!";
	}

	@Path("update")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update(Flight flight) {
		try {
			return myPapper.writeValueAsString(flightService.update(flight));
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}

	@Path("create")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String create(Flight flight) {
		try{
			flightService.create(flight);
			return  myPapper.writeValueAsString("Created Successfully");
		} catch (JsonProcessingException e){
			return  e.getMessage();
		}
	}

	@Path("delete")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String delete(Flight flight) {
		try{
			flightService.delete(flight);
			return  myPapper.writeValueAsString("Deleted Successfully");
		} catch (JsonProcessingException e){
			return  e.getMessage();
		}
	}

	@Path("findAll")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {
		try {
			return myPapper.writeValueAsString(flightService.findAll());
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}
}
