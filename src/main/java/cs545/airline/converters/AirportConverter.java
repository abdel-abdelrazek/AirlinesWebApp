package cs545.airline.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cs545.airline.model.Airport;

@FacesConverter("airportConverter")
public class AirportConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Airport airport = (Airport) value;
		return airport.getAirportcode() + " - " + airport.getName();
	}

}
