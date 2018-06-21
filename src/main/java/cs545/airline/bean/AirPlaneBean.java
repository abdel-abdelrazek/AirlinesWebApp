package cs545.airline.bean;

import cs545.airline.model.Airplane;
import cs545.airline.service.AirplaneService;

import javax.faces.bean.ManagedBean;
import javax.faces.flow.FlowScoped;
import javax.inject.Inject;
import java.io.Serializable;


@ManagedBean(name = "AirPlaneBean")
@FlowScoped("airplane")
public class AirPlaneBean implements Serializable {

    @Inject
    private AirplaneService airplaneService;

    private String serialnr;
    private String model;
    private int capacity;

    public void AirplaneService() {
        capacity = 100;

    }

    public String getSerialnr() {
        return serialnr;
    }

    public void setSerialnr(String serialnr) {
        this.serialnr = serialnr;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    public String getReturnValue() {

        Airplane airplane = new Airplane();
        airplane.setCapacity(capacity);
        airplane.setModel(model);
        airplane.setSerialnr(serialnr);
        airplaneService.create(airplane);

        return "/home";
    }

}
