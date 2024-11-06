package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_excursion")
public class ExcursionDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_excursion")
    private Integer excursionDetailId;

    @ManyToOne
    @JoinColumn(name = "id_excursion", referencedColumnName = "id_excursion")
    private Excursion excursion;

    @Column(name = "numero_personas")
    private Integer guestNumber;

    @Column(name = "valor_total_excursion")
    private Double totalValue;

    public ExcursionDetail() {
    }

    public ExcursionDetail(Excursion excursion, Integer guestNumber, Double totalValue) {
        this.excursion = excursion;
        this.guestNumber = guestNumber;
        this.totalValue = totalValue;
    }

    public Integer getExcursionDetailId() {
        return excursionDetailId;
    }

    public void setExcursionDetailId(Integer excursionDetailId) {
        this.excursionDetailId = excursionDetailId;
    }

    public Excursion getExcursion() {
        return excursion;
    }

    public void setExcursion(Excursion excursion) {
        this.excursion = excursion;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getGuestNumber() {
        return guestNumber;
    }

    public void setGuestNumber(Integer guestNumber) {
        this.guestNumber = guestNumber;
    }
}
