//package edu.mum.cs545.ws;
//
//import cs545.airline.model.Airline;
//import cs545.airline.service.AirlineService;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//
//@Named
//@Path("airline")
//public class AirportRest {
//
//	@Inject
//	private AirlineService airlineService;
//
////	@POST
////	@Path("/create")
////	@Consumes(MediaType.APPLICATION_JSON)
////	@Produces(MediaType.APPLICATION_JSON)
////	public Response postStudentRecord(Airline airline){
////
////		airlineService.create(airline);
////		String result = "Record entered: "+ airline;
////
////		return Response.status(201).entity(result).build();
////
////	}
//
//
//
////	@Path("/allAirLines")
////	@GET
////	@Produces(MediaType.APPLICATION_JSON)
////	public List<Airline> getAllAirLines() {
////
////		return airlineService.findAll();
////	}
//
//}
