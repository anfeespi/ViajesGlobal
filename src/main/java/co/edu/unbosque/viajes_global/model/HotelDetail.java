package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "detalle_hotel")
public class HotelDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_hotel")
    private Integer hotelDetailId;

    @ManyToOne
    @JoinColumn(name = "id_hotel", referencedColumnName = "id_hotel")
    private Hotel hotel;

    @Column(name = "fecha_entrada")
    private Date beginDate;

    @Column(name = "fecha_salida")
    private Date endDate;

    @Column(name = "numero_visitantes")
    private Integer guestNumber;

    @Column(name = "valor_total")
    private Double totalValue;

    public HotelDetail() {
    }

    public HotelDetail(Hotel hotel, Date endDate, Date beginDate, Integer guestNumber, Double totalValue) {
        this.hotel = hotel;
        this.endDate = endDate;
        this.beginDate = beginDate;
        this.guestNumber = guestNumber;
        this.totalValue = totalValue;
    }

    public Integer getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(Integer hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }
}
