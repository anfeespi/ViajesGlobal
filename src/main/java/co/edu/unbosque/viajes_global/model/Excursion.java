package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "excursion")
public class Excursion {

    @Id
    @Column(name = "id_excursion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExcursion;

    @OneToOne
    @JoinColumn(name = "id_lugar_turistico", referencedColumnName = "id_lugar_turistico")
    private TouristPlace touristPlace;

    @Column(name = "nombre_excursion")
    private String nameExcursion;

    @Column(name = "descrpcion_excursion")
    private String descriptionExcursion;

    @Column(name = "precio_pasajero")
    private Double passengerPrice;

    public Excursion() {
    }

    public Excursion(TouristPlace touristPlace, String nameExcursion, String descriptionExcursion, Double passengerPrice) {
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

    public TouristPlace getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(TouristPlace touristPlace) {
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
