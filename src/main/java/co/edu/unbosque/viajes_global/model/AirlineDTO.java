package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class AirlineDTO {
    private Integer idAirline;

    private String airline;

    public AirlineDTO() {
    }

    public AirlineDTO(Integer idAirline, String airline) {
        this.idAirline = idAirline;
        this.airline = airline;
    }

    public Integer getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Integer idAirline) {
        this.idAirline = idAirline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
