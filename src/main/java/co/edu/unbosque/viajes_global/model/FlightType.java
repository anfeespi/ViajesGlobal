package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_vuelo")
public class FlightType {

    @Id
    @Column(name = "id_tipo_vuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFlightType;

    @Column(name = "tipo_vuelo")
    private String flightType;

    public FlightType() {
    }

    public FlightType(String flightType) {
        this.flightType = flightType;
    }

    public Integer getIdFlightType() {
        return idFlightType;
    }

    public void setIdFlightType(Integer idFlightType) {
        this.idFlightType = idFlightType;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }
}
