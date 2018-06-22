package edu.mum.cs545.Converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@FacesConverter("flightConverter")
public class flightConverter implements Converter {

    public Object getAsObject(FacesContext context,
                                      UIComponent component,
                                      String input) throws ConverterException {
       return  input+" Passengers";
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        return o.toString()+" Passengers";
    }
}
