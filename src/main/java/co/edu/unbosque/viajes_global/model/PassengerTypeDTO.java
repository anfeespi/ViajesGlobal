package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class PassengerTypeDTO {
    private Integer idPassengerType;

    private String passengerType;

    public PassengerTypeDTO() {

    }

    public PassengerTypeDTO(Integer idPassengerType, String passengerType) {
        this.idPassengerType = idPassengerType;
        this.passengerType = passengerType;
    }

    public Integer getIdPassengerType() {
        return idPassengerType;
    }

    public void setIdPassengerType(Integer idPassengerType) {
        this.idPassengerType = idPassengerType;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}
