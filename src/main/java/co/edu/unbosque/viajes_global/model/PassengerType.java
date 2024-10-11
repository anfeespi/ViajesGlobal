package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_pasajero")
public class PassengerType {
    @Id
    @Column(name = "id_tipo_pasajero")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassengerType;

    @Column(name = "tipo_pasajero")
    private String passengerType;

    public PassengerType() {

    }

    public PassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public Integer getIdPassengerType() {
        return idPassengerType;
    }

    public void setIdPassengerType(Integer idPassengerType) {
        this.idPassengerType = idPassengerType;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }
}
