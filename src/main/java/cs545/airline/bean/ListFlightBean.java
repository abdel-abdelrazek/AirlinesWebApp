package cs545.airline.beans;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import cs545.airline.model.Airline;
import cs545.airline.model.Airport;
import cs545.airline.model.Flight;
import cs545.airline.service.AirlineService;
import cs545.airline.service.AirportService;
import cs545.airline.service.FlightService;

@Named("listFlightBean")
@SessionScoped
public class ListFlightBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
			Locale.US);
	private static DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
			Locale.US);
	
	private long airlineId;
	
	private Date departureDate;
	private Date departureTime;
	
	private long destinationId;
	
	private List<Flight> flights;
	
	@Inject
	private FlightService flightService;
	
	@Inject
	private AirportService airportService;
	
	@Inject
	private AirlineService airlineService;
	
	public void getAllFlights() {
		flights = flightService.findAll();
	}
	
	public List<Airline> getAirlines() {
		List<Airline> all = airlineService.findAll();
		Airline searchAll = new Airline();
		searchAll.setId(-1);
		searchAll.setName("All");
		all.add(searchAll);
		return all;
	}
	
	public List<Airport> getAirports() {
		List<Airport> all = airportService.findAll();
		Airport searchAll = new Airport();
		searchAll.setId(-1);
		searchAll.setName("All");
		all.add(searchAll);
		return all;
	}

	public long getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(long airlineId) {
		this.airlineId = airlineId;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(long destinationId) {
		this.destinationId = destinationId;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	public void search() {
		this.getAllFlights();
		if (this.airlineId != -1) {
			this.flights = flights.stream().filter(f -> f.getAirline().getId() == this.airlineId).collect(Collectors.toList());
		}
		if (this.destinationId != -1) {
			this.flights = flights.stream().filter(f -> f.getDestination().getId() == this.destinationId).collect(Collectors.toList());
		}
		if (this.departureDate != null) {
			this.flights = flights.stream().filter(f -> f.getDepartureDate().equals(df.format(this.departureDate))).collect(Collectors.toList());
		}
		if (this.departureTime != null) {
			this.flights = flights.stream().filter(f -> f.getDepartureTime().equals(tf.format(this.departureTime))).collect(Collectors.toList());
		}
	}
	
	public void clear() {
		System.out.println("ListFlightBean.clear()");
		this.airlineId = -1;
		this.destinationId = -1;
		this.departureDate = null;
		this.departureTime = null;
		this.getAllFlights();
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
}
