package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "aerolinea")
public class Airline {

    @Id
    @Column(name = "id_aerolinea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAirline;

    @Column(name = "aerolinea")
    private String airline;

    public Airline() {
    }

    public Airline(String airline) {
        this.airline = airline;
    }

    public Integer getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Integer idAirline) {
        this.idAirline = idAirline;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
