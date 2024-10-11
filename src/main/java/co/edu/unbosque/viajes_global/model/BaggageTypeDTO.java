package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class BaggageTypeDTO {
    private Integer idBaggageType;

    private String baggageType;

    public BaggageTypeDTO() {
    }

    public BaggageTypeDTO(Integer idBaggageType, String baggageType) {
        this.idBaggageType = idBaggageType;
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
