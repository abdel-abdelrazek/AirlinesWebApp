package cs545.airline.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"airportcode"}))
public class Airport {
	@Id
	@GeneratedValue
	private long id;
	private String airportcode;
	private String name;
	private String city;
	private String country;
	@OneToMany(mappedBy = "destination", cascade= CascadeType.ALL)
	@OrderBy("arrivalDate, arrivalTime")
	private List<Flight> arrivals = new ArrayList<>();
	@OneToMany(mappedBy = "origin", cascade= CascadeType.ALL)
	@OrderBy("departureDate, departureTime")
	private List<Flight> departures = new ArrayList<>();

	/* Constructors */
	public Airport() {
	}

	public Airport(String airportcode, String name, String city, String country) {
		this.airportcode = airportcode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	/* Getters & Setters */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAirportcode() {
		return airportcode;
	}

	public void setAirportcode(String airportcode) {
		this.airportcode = airportcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Flight> getArrivals() {
		return Collections.unmodifiableList(arrivals);
	}

	public List<Flight> getDepartures() {
		return Collections.unmodifiableList(departures);
	}

	/* Collection methods */
	public boolean addArrival(Flight flight) {
		boolean success =  (!arrivals.contains(flight)) && (arrivals.add(flight));
		if (success) {
			flight.setDestination(this);
		}
		return success;
	}

	public boolean removeArrival(Flight flight) {
		boolean success = false;
		if (arrivals.remove(flight)) {
			flight.setDestination(null);
			success = true;
		}
		return success;
	}

	public boolean addDeparture(Flight flight) {
		boolean success =  (!departures.contains(flight)) && (departures.add(flight));
		if (success) {
			flight.setOrigin(this);
		}
		return success;
	}

	public boolean removeDeparture(Flight flight) {
		boolean success = false;
		if (departures.remove(flight)) {
			flight.setOrigin(null);
			success = true;
		}
		return success;
	}
}
