package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "descuento_hotel")
public class HotelDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento_hotel")
    private Integer hotelDiscountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    private Hotel hotel;

    @Column(name = "descuento")
    private Double discount;

    @Column(name = "disponible")
    private Boolean available;

    public HotelDiscount() {
    }

    public HotelDiscount(Hotel hotel, Double discount, Boolean available) {
        this.hotel = hotel;
        this.discount = discount;
        this.available = available;
    }

    public Integer getHotelDiscountId() {
        return hotelDiscountId;
    }

    public void setHotelDiscountId(Integer hotelDiscountId) {
        this.hotelDiscountId = hotelDiscountId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
