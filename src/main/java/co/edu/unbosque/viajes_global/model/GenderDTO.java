package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.Column;

public class GenderDTO {
    private Integer idGender;

    private String gender;

    public GenderDTO() {

    }

    public GenderDTO(Integer idGender, String gender) {
        this.idGender = idGender;
        this.gender = gender;
    }

    public Integer getIdGender() {
        return idGender;

    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
