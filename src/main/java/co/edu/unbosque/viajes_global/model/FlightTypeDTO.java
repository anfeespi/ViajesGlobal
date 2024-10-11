package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class FlightTypeDTO {
    private Integer idFlightType;

    private String flightType;

    public FlightTypeDTO() {
    }

    public FlightTypeDTO(Integer idFlightType, String flightType) {
        this.idFlightType = idFlightType;
        this.flightType = flightType;
    }

    public Integer getIdFlightType() {
        return idFlightType;
    }

    public void setIdFlightType(Integer idFlightType) {
        this.idFlightType = idFlightType;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
}
