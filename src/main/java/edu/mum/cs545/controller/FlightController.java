package edu.mum.cs545.controller;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ManagedBean(name = "FlightController")
@SessionScoped
public class FlightController {

    private List<Flight> flights;
    @Inject
    private FlightService flightService;
    @Inject
    private AirlineService airlineService;


    private Logger logger = Logger.getLogger(getClass().getName());

    public FlightController() throws Exception {
        flights = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void loadFlights() {


//      List<  Airline> airline=   airlineService.findAll();
//        for (Integer x=0;x< airline.size();x++) {
//            airlineService.delete(airline.get(x));
//        }


// Airline airline = new Airline();
//
//        airline.setId(552325);
//        airline.setName("A32merican Ai2rlineee");
//
//        Flight flight = new Flight();
//        flight.setFlightnr("312223");
//        flight.setId(525253);
//        flight.setDepartureDate("Tuesday, June 30, 2009");
//        flight.setDepartureTime("7:03:47 AM PDT");
//        flight.setArrivalTime("7:03:47 AM PDT");
//        flight.setArrivalDate("Tuesday, June 30, 2009");
//        Airport airport = new Airport();
//        airport.setId(5522453);
//        airport.setName("Chi232cag2ode");
//        airport.setAirportcode("O3R22Dde");
//        Airport airport2 = new Airport();
//        airport2.setId(525235);
//        airport2.setName("Ci232da2rdee");
//        airport2.setAirportcode("C3I2D2de");
//        flight.setDestination(airport);
//        flight.setOrigin(airport);
//        airline.addFlight(flight);
//        Airplane airplane =new Airplane();
//        airplane.setModel("X2F3");
//        airplane.setCapacity(10);
//        airplane.setId(12213);
//        flight.setAirplane(airplane);
//        airlineService.create(airline);


        logger.info("Loading flights");

        flights.clear();

        try {

            // get all students from database
            flights = flightService.findAll();

        } catch (Exception exc) {
            // send this to server logs
            logger.log(Level.SEVERE, "Error loading flights", exc);

            // add error message for JSF page
            addErrorMessage(exc);
        }
    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
