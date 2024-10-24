package co.edu.unbosque.viajes_global.dto;

public class TouristPlaceDTO {
    private Integer idTouristPlace;

    private String touristPlace;

    private String description;

    public TouristPlaceDTO() {

    }

    public TouristPlaceDTO(Integer idTouristPlace, String touristPlace, String description) {
        this.idTouristPlace = idTouristPlace;
        this.touristPlace = touristPlace;
        this.description = description;
    }

    public Integer getIdTouristPlace() {
        return idTouristPlace;
    }

    public void setIdTouristPlace(Integer idTouristPlace) {
        this.idTouristPlace = idTouristPlace;
    }

    public String gettouristPlace() {
        return touristPlace;
    }

    public void settouristPlace(String touristPlace) {
        this.touristPlace = touristPlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
