package edu.mum.cs545.ws;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

@Named
@Path("airline")
public class AirlineService {
    @Inject
    private cs545.airline.service.AirlineService airlineService;

    ObjectMapper myPapper = new ObjectMapper();
    @GET
    public String helloWorld(@DefaultValue("Airline Service !!!") @QueryParam("name") String name) {
        System.out.println("test on service");
        return "Hello " + name + "!";
    }

    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public void create(Airline airline) {
        System.out.println("airline created"+airline.getName());
            airlineService.create(airline);
    }

    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("delete")
    public void delete(Airline airport) {
        airlineService.delete(airport);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("delete")
    public void deletePost(Airline airport) {
        airlineService.delete(airport);
    }

    @POST
    @Path("/update")
    public Airline update(Airline airport) {
        return airlineService.update(airport);
    }

    @POST
    @Path("/find")
    public Airline find(Airline airport) {
        return airlineService.find(airport);
    }

    @GET
    @Path("/findByName")
    public Airline findByName(@QueryParam("name") String name) {
        return airlineService.findByName(name);
    }

    @POST
    @Path("/findByFlight")
    public List<Airline> findByFlight(Flight flight) {
        return airlineService.findByFlight(flight);
    }

    @GET
    @Path("findAll")
    public String findAll() {
        try {
            return myPapper.writeValueAsString(airlineService.findAll());
        } catch (JsonProcessingException e) {
            return e.getMessage();
        }
    }
}
