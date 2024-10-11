package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "genero")
public class Gender {
    @Id
    @Column(name = "id_genero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGender;

    @Column(name = "genero")
    private String gender;

    public Gender() {

    }

    public Gender(Integer idGender, String gender) {
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
