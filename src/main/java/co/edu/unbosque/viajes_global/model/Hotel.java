package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @Column(name = "id_hotel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHotel;

    @OneToOne
    @JoinColumn(name = "id_lugar_turistico", referencedColumnName = "id_lugar_turistico")
    private TouristPlace touristPlace;

    @Column(name = "nombre_hotel", nullable = false)
    private String hotelName;

    @Column(name = "numero_huespedes", nullable = false)
    private Integer guestsNumber;

    @Column(name = "valor_total", nullable = false)
    private Double totalValue;

    @Column(name = "detalles_hotel")
    private String details;

    public Hotel() {
    }

    public Hotel(TouristPlace touristPlace, String hotelName, Integer guestsNumber, Double totalValue, String details) {
        this.touristPlace = touristPlace;
        this.hotelName = hotelName;
        this.guestsNumber = guestsNumber;
        this.totalValue = totalValue;
        this.details = details;
    }

    public Integer getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Integer idHotel) {
        this.idHotel = idHotel;
    }

    public TouristPlace getTouristPlace() {
        return touristPlace;
    }

    public void setTouristPlace(TouristPlace touristPlace) {
        this.touristPlace = touristPlace;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getGuestsNumber() {
        return guestsNumber;
    }

    public void setGuestsNumber(Integer guestsNumber) {
        this.guestsNumber = guestsNumber;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
