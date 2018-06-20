package edu.mum.cs545.controller;

import cs545.airline.model.Airline;
import cs545.airline.model.Airplane;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirplaneService;
import cs545.airline.service.AirportService;
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
    @Inject
    private AirportService airportService;
    @Inject
    private AirplaneService airplaneService;

    private String originCode;
    private List<Airplane> airplanes;
    private List<Airline> airlines;
    private List<Airport> airports;
    private String destinationCode;
    private String arrivalDate;
    private String departureDate;
    private boolean doFilter;
    private String flightNum;
    private String arrivalTime;
    private String departureTime;
    private String airlineName;
    private String airplaneSrNum;

    private Logger logger = Logger.getLogger(getClass().getName());

    public FlightCreateController() throws Exception {
        flights = new ArrayList<>();
        airplanes = new ArrayList<>();
        airports = new ArrayList<>();

        originCode = "";
        destinationCode = "";
        departureDate = "21 June, 2018";
        arrivalDate = "21 June, 2018";
        doFilter = false;
        flightNum = "";
        arrivalTime = "7:03:47 AM";
        departureTime = "7:03:47 AM";
        airplaneSrNum = "";
        airlineName = "";
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Airplane> getAirplanes() {
        return airplanes;
    }

    public List<Airline> getAirlines() {
        return airlines;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }


    public String getAirplaneSrNum() {
        return airplaneSrNum;
    }

    public void setAirplaneSrNum(String airplaneSrNum) {
        this.airplaneSrNum = airplaneSrNum;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public void doCreate() {
        try {

            Flight flight = new Flight();

            flight.setFlightnr(flightNum);
            //flight.setId(5215253);
            flight.setDepartureDate(departureDate);
            flight.setDepartureTime(departureTime);
            flight.setArrivalTime(arrivalTime);
            flight.setArrivalDate(departureDate);
           List<Airport> origin = airportService.findByName(destinationCode);
            List<Airport> destination = airportService.findByName(originCode);
            flight.setDestination(origin.get(0));
            flight.setOrigin(destination.get(0));

            Airline airline = airlineService.findByName(airlineName);
            flight.setAirline(airline);

//          Airplane airplane = airplaneService.findBySrlnr(airplaneSrNum);
//          flight.setAirplane(airplane);

            List<Airplane> airplane = airplaneService.findByModel(airplaneSrNum);
            flight.setAirplane(airplane.get(0));

            flightService.create(flight);

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
        airports = airportService.findAll();
        airplanes = airplaneService.findAll();

    }

    private void addErrorMessage(Exception exc) {
        FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
