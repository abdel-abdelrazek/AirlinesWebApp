package edu.mum.cs545.controller;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean(name = "FlightCreateController")
@SessionScoped
public class FlightCreateController {

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
    private String originAirport;
    private String arrivalDate;
    private String departureDate;
    private boolean doFilter;

    private Logger logger = Logger.getLogger(getClass().getName());

    public FlightCreateController() throws Exception {
        flights = new ArrayList<>();
        destinations = new ArrayList<>();
        origins = new ArrayList<>();
        originAirport = "";
        destination = "";
        airline = "";
        departureDate = "21 June, 2018";
        arrivalDate = "21 June, 2018";
        doFilter = false;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<String> getDestinations() {
        return destinations;
    }

    public List<String> getOrigins() {
        return origins;
    }

    public String getOrigin() {
        return originAirport;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public void setOrigin(String origin) {
        this.originAirport = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void doFilter() {

        doFilter = true;
    }

    public void showAll() {

        doFilter = false;
    }

    public void doCreate() {
        try {


        } catch (
                Exception exc)

        {
            // send this to server logs
            logger.log(Level.SEVERE, "Error Adding flights", exc);

            // add error message for JSF page
            addErrorMessage(exc);
        }

    }

        public void loadData() {

        airlines = airlineService.findAll();

        logger.info("Loading flights");

        flights.clear();

        try {

            // get all students from database
            flights = flightService.findAll();

            for (Flight tmpFlight : flights) {
                if (!destinations.contains(tmpFlight.getDestination().getName())) {

                    destinations.add(tmpFlight.getDestination().getName());
                }

                if (!origins.contains(tmpFlight.getOrigin().getName())) {

                    origins.add(tmpFlight.getOrigin().getName());
                }

            }

        } catch (
                Exception exc)

        {
            // send this to server logs
            logger.log(Level.SEVERE, "Error Loading Data", exc);

            // add error message for JSF page
            addErrorMessage(exc);
        }

    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
