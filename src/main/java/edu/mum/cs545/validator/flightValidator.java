package edu.mum.cs545.validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "flightValidator")
public class flightValidator {

    public void validateFlightNumber(FacesContext context,
                                      UIComponent component,
                                      Object value) throws ValidatorException {

        if (value == null) {
            return;
        }

        String data = value.toString();

        // Course code must start with FL ... if not, throw exception
        if (!data.startsWith("FL")) {

            FacesMessage message = new FacesMessage("Course code must start with FL");

            throw new ValidatorException(message);
        }
    }
}
