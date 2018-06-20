package edu.mum.cs545.controller;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import java.util.ArrayList;
import java.util.Date;
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
    private String airline;
    private List<Airline> airlines;
    private List<String> destinations;
    private List<String> origins;
    private String destination;
    private String origin;



    private Logger logger = Logger.getLogger(getClass().getName());

    public FlightController() throws Exception {
        flights = new ArrayList<>();
        destinations = new ArrayList<>();
        origins = new ArrayList<>();
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public List<String> getOrigins() {
        return origins;
    }
    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public String getAirline() {
        return airline;
    }

    public void loadFlights() {


        airlines = airlineService.findAll();


        logger.info("Loading flights");

        flights.clear();

        try {

            // get all students from database
            flights = flightService.findAll();

            for (Flight flight : flights)
            {
                if(!destinations.contains(flight.getDestination().getName())){

                    destinations.add(flight.getDestination().getName());
                }

                if(!origins.contains(flight.getOrigin().getName())){

                    origins.add(flight.getOrigin().getName());
                }
            }

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
