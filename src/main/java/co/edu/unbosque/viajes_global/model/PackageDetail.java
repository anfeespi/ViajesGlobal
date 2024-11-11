package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "detalle_compra")
public class PackageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_compra")
    private Integer packageDetailId;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "detalle_compra_hotel",
            joinColumns = @JoinColumn(name = "id_detalle_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_detalle_hotel")
    )
    private Set<HotelDetail> hotelDetail;

    @ManyToMany
    @JoinTable(
            name = "detalle_compra_vuelo",
            joinColumns = @JoinColumn(name = "id_detalle_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_detalle_vuelo")
    )
    private Set<FlightDetail> flightDetail;

    @ManyToMany
    @JoinTable(
            name = "detalle_compra_excursion",
            joinColumns = @JoinColumn(name = "id_detalle_compra"),
            inverseJoinColumns = @JoinColumn(name = "id_detalle_excursion")
    )
    private Set<ExcursionDetail> excursionDetail;

    @Column(name = "precio_total")
    private Double totalPrice;

    public PackageDetail(User user) {
        this.user = user;
        hotelDetail = new HashSet<HotelDetail>();
        flightDetail = new HashSet<FlightDetail>();
        excursionDetail = new HashSet<ExcursionDetail>();
    }

    public PackageDetail() {
        
    }

    public Integer getPackageDetailId() {
        return packageDetailId;
    }

    public void setPackageDetailId(Integer packageDetailId) {
        this.packageDetailId = packageDetailId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<HotelDetail> getHotelDetail() {
        return hotelDetail;
    }

    public void setHotelDetail(Set<HotelDetail> hotelDetail) {
        this.hotelDetail = hotelDetail;
    }

    public Set<FlightDetail> getFlightDetail() {
        return flightDetail;
    }

    public void setFlightDetail(Set<FlightDetail> flightDetail) {
        this.flightDetail = flightDetail;
    }

    public Set<ExcursionDetail> getExcursionDetail() {
        return excursionDetail;
    }

    public void setExcursionDetail(Set<ExcursionDetail> excursionDetail) {
        this.excursionDetail = excursionDetail;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
