//package edu.mum.cs545.ws;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import cs545.airline.model.Airline;
//import cs545.airline.model.Airplane;
//import cs545.airline.model.Airport;
//import cs545.airline.model.Flight;
//import cs545.airline.service.FlightService;
//
//@Named
//@Path("flight")
//public class FlightRest {
//
//	@Inject
//	private FlightService flightService;
//	ObjectMapper myPapper = new ObjectMapper();
//
//	SimpleDateFormat sf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//
//	@GET
//	public String helloWorld(@DefaultValue("Fight service") @QueryParam("name") String name) {
//		return "Hello " + name + "!";
//	}
//
//	@Path("update")
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String update(Flight flight) {
////		return 	flightService.update(flight);
//		try {
//			return myPapper.writeValueAsString(flightService.update(flight));
//		} catch (JsonProcessingException e) {
//			return e.getMessage();
//		}
//	}
//
//	@Path("find")
//	@POST
//	public Flight find(Flight flight) {
//		return flightService.find(flight);
//	}
//
//	@Path("findByNumber")
//	@GET
//	public List<Flight> findByNumber(@QueryParam("flightnr") String flightnr) {
//		return flightService.findByNumber(flightnr);
//	}
//
//	@Path("findByAirline")
//	@POST
//	public List<Flight> findByAirline(Airline airline) {
//		return flightService.findByAirline(airline);
//	}
//
//	@Path("findByOrigin")
//	@POST
//	public List<Flight> findByOrigin(Airport airport) {
//		return flightService.findByOrigin(airport);
//	}
//
//	@Path("findByDestination")
//	@POST
//	public List<Flight> findByDestination(Airport airport) {
//		return flightService.findByDestination(airport);
//	}
//
//	@Path("findByAirplane")
//	@POST
//	public List<Flight> findByAirplane(Airplane airplane) {
//		return flightService.findByAirplane(airplane);
//	}
//
//	@Path("findByArrival")
//	@GET
//	public List<Flight> findByArrival(@QueryParam("datetime") String sDatetime) throws ParseException {
//		Date datetime = sf.parse(sDatetime);
//		return flightService.findByArrival(datetime);
//	}
//
//	@Path("findByArrivalBetween")
//	@GET
//	public List<Flight> findByArrivalBetween(@QueryParam("datetimeFrom") String sDatetimeFrom, @QueryParam("datetimeTo") String sDatetimeTo) throws ParseException {
//		Date datetimeFrom = sf.parse(sDatetimeFrom);
//		Date datetimeTo = sf.parse(sDatetimeTo);
//		return flightService.findByArrivalBetween(datetimeFrom, datetimeTo);
//	}
//
//	@Path("findByDeparture")
//	@GET
//	public List<Flight> findByDeparture(@QueryParam("datetime") String sDatetime) throws ParseException {
//		Date datetime = sf.parse(sDatetime);
//		return flightService.findByDeparture(datetime);
//	}
//
//	@Path("findByDepartureBetween")
//	@GET
//	public List<Flight> findByDepartureBetween(@QueryParam("datetimeFrom") String sDatetimeFrom, @QueryParam("datetimeTo") String sDatetimeTo) throws ParseException {
//		Date datetimeFrom = sf.parse(sDatetimeFrom);
//		Date datetimeTo = sf.parse(sDatetimeTo);
//		return flightService.findByDepartureBetween(datetimeFrom, datetimeTo);
//	}
//
//	@Path("findAll")
//	@GET
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String findAll() {
//		try {
//			return myPapper.writeValueAsString(flightService.findAll());
//		} catch (JsonProcessingException e) {
//			return e.getMessage();
//		}
//	}
//
//}
