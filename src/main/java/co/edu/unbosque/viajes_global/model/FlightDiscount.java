package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "descuento_vuelo")
public class FlightDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento_vuelo")
    private Integer flightDiscountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    private Flight flight;

    @Column(name = "descuento")
    private Double discount;

    @Column(name = "disponible")
    private Boolean available;

    public FlightDiscount(Flight flight, Double discount, Boolean available) {
        this.flight = flight;
        this.discount = discount;
        this.available = available;
    }

    public FlightDiscount() {
    }

    public Integer getFlightDiscountId() {
        return flightDiscountId;
    }

    public void setFlightDiscountId(Integer flightDiscountId) {
        this.flightDiscountId = flightDiscountId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
