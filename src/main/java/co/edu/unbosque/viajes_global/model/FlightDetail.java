package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_vuelo")
public class FlightDetail {
    @Id
    @Column(name = "id_detalle_vuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightDetailId;

    @ManyToOne
    @JoinColumn(name = "id_vuelo", referencedColumnName = "id_vuelo")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pasajero", referencedColumnName = "id_tipo_pasajero")
    private PassengerType passengerType;

    @ManyToOne
    @JoinColumn(name = "id_tipo_equipaje", referencedColumnName = "id_tipo_equipaje")
    private BaggageType baggageType;

    @ManyToOne
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento")
    private Seat seat;

    public FlightDetail() {
    }

    public FlightDetail(Flight flight, PassengerType passengerType, BaggageType baggageType, Seat seat) {
        this.flight = flight;
        this.passengerType = passengerType;
        this.baggageType = baggageType;
        this.seat = seat;
    }

    public Integer getFlightDetailId() {
        return flightDetailId;
    }

    public void setFlightDetailId(Integer flightDetailId) {
        this.flightDetailId = flightDetailId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public BaggageType getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
