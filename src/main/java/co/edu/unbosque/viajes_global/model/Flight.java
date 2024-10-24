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

    @ManyToOne
    @JoinColumn(name = "id_lugar_turistico_origen", referencedColumnName = "id_lugar_turistico", nullable = false)
    private TouristPlace touristPlaceOrigin;

    @ManyToOne
    @JoinColumn(name = "id_lugar_turistico_destino", referencedColumnName = "id_lugar_turistico", nullable = false)
    private TouristPlace touristPlaceDestination;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBegin;

    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEnd;

    @Column(name = "numero_pasajeros", nullable = false)
    private Integer passengersNumber;

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

    public Flight() {
    }

    public Flight(FlightType flightType, TouristPlace touristPlaceOrigin, TouristPlace touristPlaceDestination, Date dateBegin, Date dateEnd, Integer passengersNumber, Airline airline, Double baseFee, Double taxes, Double charges, Double total) {
        this.flightType = flightType;
        this.touristPlaceOrigin = touristPlaceOrigin;
        this.touristPlaceDestination = touristPlaceDestination;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.passengersNumber = passengersNumber;
        this.airline = airline;
        this.baseFee = baseFee;
        this.taxes = taxes;
        this.charges = charges;
        this.total = total;
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

    public TouristPlace getTouristPlaceOrigin() {
        return touristPlaceOrigin;
    }

    public void setTouristPlaceOrigin(TouristPlace touristPlaceOrigin) {
        this.touristPlaceOrigin = touristPlaceOrigin;
    }

    public TouristPlace getTouristPlaceDestination() {
        return touristPlaceDestination;
    }

    public void setTouristPlaceDestination(TouristPlace touristPlaceDestination) {
        this.touristPlaceDestination = touristPlaceDestination;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(Integer passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
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
}
