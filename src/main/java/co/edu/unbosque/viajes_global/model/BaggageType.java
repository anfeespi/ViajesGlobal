package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_equipaje")
public class BaggageType {

    @Id
    @Column(name = "id_tipo_equipaje")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBaggageType;

    @Column(name = "tipo_equipaje")
    private String baggageType;

    public BaggageType() {
    }

    public BaggageType(String baggageType) {
        this.baggageType = baggageType;
    }

    public Integer getIdBaggageType() {
        return idBaggageType;
    }

    public void setIdBaggageType(Integer idBaggageType) {
        this.idBaggageType = idBaggageType;
    }

    public String getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(String baggageType) {
        this.baggageType = baggageType;
    }
}
