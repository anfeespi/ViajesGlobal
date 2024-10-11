package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lugar_turistico")
public class TouristPlace {
    @Id
    @Column(name = "id_lugar_turistico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTouristPlace;

    @Column(name = "lugar_turistico")
    private String touristPlace;

    @Column(name = "descripcion_lugar_turistico")
    private String description;

    public TouristPlace() {

    }

    public TouristPlace(String touristPlace, String description) {
        this.touristPlace = touristPlace;
        this.description = description;
    }

    public Integer getIdTouristPlace() {
        return idTouristPlace;
    }

    public void setIdTouristPlace(Integer idTouristPlace) {
        this.idTouristPlace = idTouristPlace;
    }

    public String getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(String tourist_place) {
        this.touristPlace = tourist_place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
