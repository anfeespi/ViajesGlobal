package co.edu.unbosque.viajes_global.dto;

import java.util.Date;

public class FlightDTO {
    private Integer idFlight;

    private Integer flightType;

    private Integer touristPlaceOrigin;

    private Integer touristPlaceDestination;

    private Date dateBegin;

    private Date dateEnd;

    private Integer baggageType;

    private Integer passengersNumber;

    private Integer seat;

    private Integer airline;

    private Double baseFee;

    private Double taxes;

    private Double charges;

    private Double total;

    private Integer scales;

    public FlightDTO() {
    }

    public FlightDTO(Integer flightType, Integer touristPlaceOrigin, Integer touristPlaceDestination, Date dateBegin, Date dateEnd, Integer baggageType, Integer passengersNumber, Integer seat, Integer airline, Double baseFee, Double taxes, Double charges, Double total, Integer scales) {
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

    public Integer getFlightType() {
        return flightType;
    }

    public void setFlightType(Integer flightType) {
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

    public Integer getBaggageType() {
        return baggageType;
    }

    public void setBaggageType(Integer baggageType) {
        this.baggageType = baggageType;
    }

    public Integer getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(Integer passengersNumber) {
        this.passengersNumber = passengersNumber;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getAirline() {
        return airline;
    }

    public void setAirline(Integer airline) {
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
