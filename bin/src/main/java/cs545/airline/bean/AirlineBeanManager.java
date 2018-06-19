package cs545.airline.beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.FlightService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("airlineBeanManager")
@SessionScoped
public class AirlineBeanManager implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AirlineService airlineService;
	
	@Inject
	private FlightService flightService;

	private Airline airline;

	private String name;

	public String create() {
		if (airline != null && airline.getId() > 0) {
			airline.setName(name);
			this.airlineService.update(airline);
		} else {
			airline = new Airline();
			airline.setName(name);
			this.airlineService.create(airline);
		}
		
		return "airlineList";
	}

	public List<Airline> getAirlines() {
		return airlineService.findAll();
	}

	public String editAirline(long id) {
		airline = new Airline();
		airline.setId(id);
		airline = airlineService.find(airline);
		this.name = airline.getName();
		return "edit";
	}
	
	public String deleteAirline(long id) {
		airline = new Airline();
		airline.setId(id);
		airline = airlineService.find(airline);
		if(airline.getFlights().isEmpty()) {
			airlineService.delete(airline);
			return "delete";
		}
		return "airlineList";
		
		
	}
	
	public String createForm() {
		this.airline = null;
		this.name = "";
		return "editForm";
	}

	public Airline getAirline() {
		return airline;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Flight> getAllFlights() {
		if (airline != null) {
			return flightService.findByAirline(airline);
		}
		return new ArrayList<>();
	}

}
