package edu.mum.cs545.controller;

import cs545.airline.model.Flight;
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

@ManagedBean
@SessionScoped
public class FlightController {

    private List<Flight> flights;
    @Inject
    private FlightService flightService;

    private Logger logger = Logger.getLogger(getClass().getName());

    public FlightController() throws Exception {
        flights = new ArrayList<>();
    }

    public List<Flight> getStudents() {
        return flights;
    }

    public void loadFlights() {

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
