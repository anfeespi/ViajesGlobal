package co.edu.unbosque.viajes_global.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vuelo")
public class Flight {

    @Id
    @Column(name = "id_vuelo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFlight;

    @ManyToOne
    @JoinColumn(name = "id_tipo_vuelo", referencedColumnName = "id_tipo_vuelo")
    private FlightType flightType;

    @Column(name = "id_lugar_turistico_origen", nullable = false)
    private Integer touristPlaceOrigin;

    @Column(name = "id_lugar_turistico_destino", nullable = false)
    private Integer touristPlaceDestination;

    @Column(name = "fecha_inicio", nullable = false)
    private Date dateBegin;

    @Column(name = "fecha_fin", nullable = false)
    private Date dateEnd;

    @ManyToOne
    @JoinColumn(name = "id_tipo_equipaje", referencedColumnName = "id_tipo_equipaje")
    private BaggageType baggageType;

    @Column(name = "numero_pasajeros", nullable = false)
    private Integer passengersNumber;

    @ManyToOne
    @JoinColumn(name = "id_asiento", referencedColumnName = "id_asiento")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "id_aerolinea", referencedColumnName = "id_aerolinea")
    private Airline airline;

    @Column(name = "tarifa_base", nullable = false)
    private Double baseFee;

    @Column(name = "impuestos", nullable = false)
    private Double taxes;

    @Column(name = "cargos", nullable = false)
    private Double charges;

    @Column(name = "total_tarifa", nullable = false)
    private Double total;

    @Column(name = "escala", nullable = false)
    private Integer scales;

    public Flight() {
    }

    public Flight(FlightType flightType, Integer touristPlaceOrigin, Integer touristPlaceDestination, Date dateBegin, Date dateEnd, BaggageType baggageType, Integer passengersNumber, Seat seat, Airline airline, Double baseFee, Double taxes, Double charges, Double total, Integer scales) {
        this.flightType = flightType;
        this.touristPlaceOrigin = touristPlaceOrigin;
        this.touristPlaceDestination = touristPlaceDestination;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.baggageType = baggageType;
        this.passengersNumber = passengersNumber;
        this.seat = seat;
        this.airline = airline;
        this.baseFee = baseFee;
        this.taxes = taxes;
        this.charges = charges;
        this.total = total;
        this.scales = scales;
    }

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public Integer getTouristPlaceOrigin() {
        return touristPlaceOrigin;
    }

    public void setTouristPlaceOrigin(Integer touristPlaceOrigin) {
        this.touristPlaceOrigin = touristPlaceOrigin;
    }

    public Integer getTouristPlaceDestination() {
        return touristPlaceDestination;
    }

    public void setTouristPlaceDestination(Integer touristPlaceDestination) {
        this.touristPlaceDestination = touristPlaceDestination;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public BaggageType getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(BaggageType baggageType) {
        this.baggageType = baggageType;
    }

    public Integer getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(Integer passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public Double getBaseFee() {
        return baseFee;
    }

    public void setBaseFee(Double baseFee) {
        this.baseFee = baseFee;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getScales() {
        return scales;
    }

    public void setScales(Integer scales) {
        this.scales = scales;
    }
}
