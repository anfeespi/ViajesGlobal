package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class TouristPlaceDTO {
    private Integer idTouristPlace;

    private String tourist_place;

    private String description;

    public TouristPlaceDTO() {

    }

    public TouristPlaceDTO(Integer idTouristPlace, String tourist_place, String description) {
        this.idTouristPlace = idTouristPlace;
        this.tourist_place = tourist_place;
        this.description = description;
    }

    public Integer getIdTouristPlace() {
        return idTouristPlace;
    }

    public void setIdTouristPlace(Integer idTouristPlace) {
        this.idTouristPlace = idTouristPlace;
    }

    public String getTourist_place() {
        return tourist_place;
    }

    public void setTourist_place(String tourist_place) {
        this.tourist_place = tourist_place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
