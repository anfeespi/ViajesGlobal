package co.edu.unbosque.viajes_global.dto;

public class FlightDTO {
    private Integer idFlight;

    private Integer flightType;

    private Integer touristPlaceOrigin;

    private Integer touristPlaceDestination;

    private String dateBegin;

    private String dateEnd;

    private Integer passengersNumber;

    private Integer airline;

    private Double baseFee;

    private Double taxes;

    private Double charges;

    private Double total;

    public FlightDTO(Integer idFlight, Integer flightType, Integer touristPlaceOrigin, Integer touristPlaceDestination, String dateBegin, String dateEnd, Integer passengersNumber, Integer airline, Double baseFee, Double taxes, Double charges, Double total) {
        this.idFlight = idFlight;
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

    public String getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(String dateBegin) {
        this.dateBegin = dateBegin;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getAirline() {
        return airline;
    }

    public void setAirline(Integer airline) {
        this.airline = airline;
    }

    public Integer getPassengersNumber() {
        return passengersNumber;
    }

    public void setPassengersNumber(Integer passengersNumber) {
        this.passengersNumber = passengersNumber;
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
