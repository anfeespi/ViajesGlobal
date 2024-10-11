package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class ExcursionDTO {
    private Integer idExcursion;

    private Integer touristPlace;

    private String nameExcursion;

    private String descriptionExcursion;

    private Double passengerPrice;

    public ExcursionDTO() {
    }

    public ExcursionDTO(Integer touristPlace, String nameExcursion, String descriptionExcursion, Double passengerPrice) {
        this.touristPlace = touristPlace;
        this.nameExcursion = nameExcursion;
        this.descriptionExcursion = descriptionExcursion;
        this.passengerPrice = passengerPrice;
    }

    public Integer getIdExcursion() {
        return idExcursion;
    }

    public void setIdExcursion(Integer idExcursion) {
        this.idExcursion = idExcursion;
    }

    public Integer getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(Integer touristPlace) {
        this.touristPlace = touristPlace;
    }

    public String getNameExcursion() {
        return nameExcursion;
    }

    public void setNameExcursion(String nameExcursion) {
        this.nameExcursion = nameExcursion;
    }

    public String getDescriptionExcursion() {
        return descriptionExcursion;
    }

    public void setDescriptionExcursion(String descriptionExcursion) {
        this.descriptionExcursion = descriptionExcursion;
    }

    public Double getPassengerPrice() {
        return passengerPrice;
    }

    public void setPassengerPrice(Double passengerPrice) {
        this.passengerPrice = passengerPrice;
    }
}
