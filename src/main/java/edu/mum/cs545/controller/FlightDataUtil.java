package edu.mum.cs545.controller;

import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
@ApplicationScoped
public class FlightDataUtil {

    private List<Flight> flights;

    @Inject
    private FlightService flightService;

    public FlightDataUtil() {

        flights = flightService.findAll();
    }


    public List<Flight> getStudents() {
        return flights;
    }
}
