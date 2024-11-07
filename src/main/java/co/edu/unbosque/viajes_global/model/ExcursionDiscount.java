package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "descuento_excursion")
public class ExcursionDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_descuento_vuelo")
    private Integer excursionDiscountId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_excursion", referencedColumnName = "id_excursion")
    private Excursion excursion;

    @Column(name = "descuento")
    private Double discount;

    @Column(name = "disponible")
    private Boolean available;

    public ExcursionDiscount() {

    }

    public ExcursionDiscount(Excursion excursion, Double discount, Boolean available) {
        this.excursion = excursion;
        this.discount = discount;
        this.available = available;
    }

    public Integer getExcursionDiscountId() {
        return excursionDiscountId;
    }

    public void setExcursionDiscountId(Integer excursionDiscountId) {
        this.excursionDiscountId = excursionDiscountId;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
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
